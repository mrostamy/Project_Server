package com.mydomain.project_server.repositories.MainDB;

import com.mydomain.project_server.models.MainDB.blog.Blog;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, String> {

   // List<Blog> findAllByUser_Id(String id);

    Blog findByTitle(String title);

    PageImpl<Blog> findAllByUser_Id(String userId, Pageable pageable);
}
