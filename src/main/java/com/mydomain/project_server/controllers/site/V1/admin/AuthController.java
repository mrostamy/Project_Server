package com.mydomain.project_server.controllers.site.V1.admin;

import com.mydomain.project_server.dto.common.token.TokenResponseDto;
import com.mydomain.project_server.dto.site.panel.auth.LoginResponseDto;
import com.mydomain.project_server.helpers.TokenHelper;
import com.mydomain.project_server.models.ReturnMessage;
import com.mydomain.project_server.models.MainDB.User;
import com.mydomain.project_server.dto.common.token.TokenRequestDto;
import com.mydomain.project_server.dto.site.panel.user.UserRegiaterDto;
import com.mydomain.project_server.services.site.admin.AuthService;
import com.mydomain.project_server.services.site.admin.UserService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "api/V1/site/admin/auth")
public class AuthController {
    final
    AuthService auth_service;

    @Value("${jwt.secret}")
    private String secret;

    final
    UserService user_service;

    public AuthController(AuthService auth_service, UserService user_service) {
        this.auth_service = auth_service;
        this.user_service = user_service;
    }


    @PostMapping("register")
    public ResponseEntity<Object> register(@RequestBody @Valid UserRegiaterDto userdto) {

        userdto.setUsername(userdto.getUsername().toLowerCase());

        if (user_service.userExist(userdto.getUsername())) {

            return new ResponseEntity<>(new ReturnMessage(false, "error", "username is duplicate"), HttpStatus.BAD_REQUEST);

        }

        User user = new User();

        user.setUsername(userdto.getUsername());
        user.setCity("tehran");
        user.setDateOfBirth(LocalDateTime.now());
        user.setGender(true);
        user.setAddress("baharestan");
        user.setName(userdto.getName());
        user.setPhoneNumber(userdto.getPhone_number());
        user.setStatus(true);
        user.setActive(true);


        auth_service.register(user, userdto.getPassword());

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody TokenRequestDto tokenDto) {

        switch (tokenDto.getGrantType()) {

            case "password": {
                TokenResponseDto responseDto = TokenHelper.getInstance().generateNewToken(tokenDto);
                if (responseDto.isStatus()) {

                    User user = new User();
                    //UserReturnDto userReturnDto=new ModelMapper().map(user);
                    return ResponseEntity.ok(new LoginResponseDto(
                            responseDto.getToken(),
                            responseDto.getRefreshToken(),
                            user
                    ));

                } else {
                    ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid user or password");
                }
            }
            case "refresh_token":
                TokenResponseDto responseDto = TokenHelper.getInstance().refreshAccessToken(tokenDto);
                if (responseDto.isStatus()) {

                    return ResponseEntity.ok(responseDto);

                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("error in authentication, try again");
                }
            default:
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("error in authentication");
        }
    }


    public ResponseEntity<Object> auth(TokenRequestDto requestDto) {


        switch (requestDto.getGrantType()) {
            case "password":
                var result = TokenHelper.getInstance().generateNewToken(requestDto);
                if (result.isStatus()) {
                    return new ResponseEntity<>(requestDto, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(result.getMessage(), HttpStatus.UNAUTHORIZED);
                }
            case "refreshToken":
                var res = TokenHelper.getInstance().refreshAccessToken(requestDto);
                if (res.isStatus()) {
                    return new ResponseEntity<>(requestDto, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(res.getMessage(), HttpStatus.UNAUTHORIZED);
                }

            default:
                return new ResponseEntity<>("error in authorization", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(value = "user")
    public User test() {
        return user_service.getUser();
    }

}
