package com.mydomain.project_server.services.site.admin;

import com.cloudinary.Cloudinary;
import com.cloudinary.EagerTransformation;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.mydomain.project_server.dto.service.FileUploadDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Service
public class UploadService {


    @Value("${cloudinary.cloud_name}")
    String cloudinary_name;

    @Value("${cloudinary.api_key}")
    String api_key;

    @Value("${cloudinary.api_secret}")
    String secret_key;


    public void uploadToCloudinary(MultipartFile file) throws IOException {

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudinary_name,
                "api_key", api_key,
                "api_secret", secret_key,
                "secure", true));

        File upload_file = new File(file.getName());

        try (OutputStream os = new FileOutputStream(upload_file)) {
            os.write(file.getBytes());
        }

        EagerTransformation transformation = new EagerTransformation();
        EagerTransformation transformation2 = new EagerTransformation();

        transformation.width(150).height(150).crop("fill").gravity("face");
        transformation.width(200).height(150).crop("fill").gravity("face");


        var uploadResult = cloudinary.uploader().
                upload(upload_file,
                        ObjectUtils.asMap("public_id",
                                file.getOriginalFilename() + new Random().nextInt(),
                                "eager", Arrays.asList(transformation, transformation2),
                                "eager_async", true
                        ));


        //FileUploadDto fileUploadDto = new FileUploadDto();

//        if (!file.isEmpty()) {
//
//
//            var transformation = new Transformation();
//
//            transformation.width(150).height(150).gravity("face");
//
//            var params = ObjectUtils.asMap(
//                    "api_key", api_key,
//                    "api_secret", secret_key,
//                    "cloud_name", cloudinary_name,
//                    "public_id", file.getOriginalFilename(),
//                    "overwrite", true,
//                    "resource_type", "auto"
//                    //"eager", List.of(transformation)
//            );


//            fileUploadDto.setUrl(uploadResult.get("url").toString());
//            fileUploadDto.setPublicId(uploadResult.get("public_id").toString());
//            fileUploadDto.setMessage("file uploaded successfully");
//            fileUploadDto.setStatus(true);


        // return fileUploadDto;
    }

    public void uploadToLocal(MultipartFile file) throws IOException {


        if (!file.isEmpty()) {
            file.transferTo(new File("src/resources/" + file.getOriginalFilename()));
        }


    }


    //return new FileUploadDto(false, "invalid file", "", "");

}

