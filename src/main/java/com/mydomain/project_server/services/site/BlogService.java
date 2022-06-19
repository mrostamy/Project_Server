package com.mydomain.project_server.services.site;

import com.mydomain.project_server.models.MainDB.blog.Blog;
import com.mydomain.project_server.repositories.MainDB.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository repo;

    public Blog getBlog(String id) {

        return repo.findById(id).get();
    }

    public List<Blog> getBlogs(String id) {

        return repo.findAllByUser_Id(id, PageRequest.of(0, 2)).toList();
    }

    public PageImpl<Blog> getBlogsPaginate(String id) {

        return repo.findAllByUser_Id(id, PageRequest.of(0, 2));
    }

    public Blog getBlogsByTitle(String title) {

        return repo.findByTitle(title);
    }


    public Blog insert(Blog blog) {

        return repo.save(blog);
    }

    public void delete(Blog blog) {
        repo.delete(blog);
    }
}
