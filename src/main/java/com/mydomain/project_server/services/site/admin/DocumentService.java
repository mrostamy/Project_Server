package com.mydomain.project_server.services.site.admin;

import com.mydomain.project_server.models.MainDB.user.Document;
import com.mydomain.project_server.repositories.MainDB.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository repo;

    public List<Document> getAllDocs() {
        return repo.findAll();
    }

    public Document save(Document document) {

        return null;//repo.save(document);
    }

    public Document getDocumentByPredicate(Predicate<Document> predicate) {
        return null;//repo.findDocument(predicate);
    }

    public Document getDocumentById(String id) {

        return repo.findById(id).get();
    }
}
