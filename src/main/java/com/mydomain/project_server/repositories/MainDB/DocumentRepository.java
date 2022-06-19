package com.mydomain.project_server.repositories.MainDB;

import com.mydomain.project_server.models.MainDB.user.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {

//    Document findDocumentBy(Predicate<Document> predicate);//test shavad

}
