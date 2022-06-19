package com.mydomain.project_server.controllers.site.V1.admin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;

@RestController
@RequestMapping("api/V1/site/admin/temp")
public class TempController {


    final
    ServletContext servletContext;

    public TempController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @PostMapping("/test")
    public String test(@RequestBody MultipartFile file) throws IOException {

        //region file upload
//        String context = servletContext.getRealPath("/");
//        String C = "C://test/test2//test3//";
//        Path path = Paths.get(Objects.requireNonNull(file.getOriginalFilename())).normalize().toAbsolutePath();
//        try (InputStream input = file.getInputStream()) {
//            Files.copy(input, path, StandardCopyOption.REPLACE_EXISTING);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        //endregion
//        userDetails.
        return "";


    }


}
