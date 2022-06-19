package com.mydomain.project_server.controllers.site.V1.admin.blogAdmin;

import com.mydomain.project_server.services.site.admin.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/V1/site/admin/photo")
public class PhotoController {

    final
    UploadService uploadService;

    public PhotoController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Object> savePhoto(@RequestBody MultipartFile file) throws IOException {

        System.out.println(file.getOriginalFilename());

        uploadService.uploadToCloudinary(file);

        return new ResponseEntity<>(file.getOriginalFilename(), HttpStatus.OK);
    }


}
