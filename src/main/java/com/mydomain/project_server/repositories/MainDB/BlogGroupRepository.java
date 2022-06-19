package com.mydomain.project_server.repositories.MainDB;

import com.mydomain.project_server.models.MainDB.blog.BlogGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogGroupRepository extends JpaRepository<BlogGroup,String> {
}
