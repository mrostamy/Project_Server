package com.mydomain.project_server.controllers.site.V1.admin;

import com.mydomain.project_server.models.MainDB.user.Document;
import com.mydomain.project_server.services.site.admin.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/V1/site/admin/document")
public class DocumentController {

    @Autowired
    DocumentService service;

    @GetMapping
    public ResponseEntity<Object> getAllDocument() {

        String s="${userId}";

        List<Document> docs = service.getAllDocs();

        return new ResponseEntity<>(docs, HttpStatus.OK);

    }

//    @GetMapping
//    public ResponseEntity<Object> getDocument(String userId,String documentId) {
//
//        String s="${userId}";
//
////        List<Document> docs = service.getDocumentById(userId);
//
//        return new ResponseEntity<>( HttpStatus.OK);
//
//    }


    @PostMapping
    public ResponseEntity<Object> addDocument(String userId, Document document) {

//        var result=service.save(document);

        Document doc = service.getDocumentByPredicate(d -> d.getApprove() == 2);

        System.out.println(doc);
        if (doc == null) {
            doc = service.getDocumentByPredicate(d -> d.getApprove() == 1);
            if (doc == null) {
                return new ResponseEntity<>("document is in  Pending", HttpStatus.BAD_REQUEST);
            } else {
                service.save(document);
                return new ResponseEntity<>(doc, HttpStatus.OK);
            }

        } else {
            return new ResponseEntity<>("document exist", HttpStatus.BAD_REQUEST);
        }

    }


}
