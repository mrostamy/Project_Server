package com.mydomain.project_server.controllers.site.V1.admin.blogAdmin;

import com.mydomain.project_server.dto.site.panel.blog.ApproveSelectDto;
import com.mydomain.project_server.dto.site.panel.blog.BlogCreateUpdateDto;
import com.mydomain.project_server.models.MainDB.blog.Blog;
import com.mydomain.project_server.routes.V1.ApiV1Routes;
import com.mydomain.project_server.services.site.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    AuthenticationManager principal;

    @GetMapping(ApiV1Routes.Blog.getBlogs)
    public ResponseEntity<Object> getBlogs(@PathVariable String userId) {

        List<Blog> blogs = blogService.getBlogs(userId);

        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


    @GetMapping(ApiV1Routes.Blog.getBlog)
    public ResponseEntity<Object> getBlog(@PathVariable String id, @PathVariable String userId) {

        Blog blog = blogService.getBlog(id);

        if (blog != null) {

            return new ResponseEntity<>(blog, HttpStatus.OK);

        }


        return new ResponseEntity<>("no Blog found", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(ApiV1Routes.Blog.addBlog)
    public ResponseEntity<Object> addBlog(@PathVariable String userId, BlogCreateUpdateDto dto) {

        Blog blog = blogService.getBlogsByTitle(dto.getTitle());

        if (blog != null) {

            blogService.insert(blog);
            return new ResponseEntity<>(blog, HttpStatus.BAD_REQUEST);


        }
        return new ResponseEntity<>("blog not found", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(ApiV1Routes.Blog.updateBlog)
    public ResponseEntity<Object> updateBlog(@PathVariable String id, BlogCreateUpdateDto dto) {


        Blog blog = blogService.getBlogsByTitle(dto.getTitle());

        if (blog != null) {

            blogService.insert(blog);
            return new ResponseEntity<>(blog, HttpStatus.BAD_REQUEST);


        }

        return new ResponseEntity<>("no Blog", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(ApiV1Routes.Blog.deleteBlog)
    public ResponseEntity<Object> deleteBlog(@PathVariable String id, @PathVariable String userId) {
        Blog blog = blogService.getBlog(id);

        if (blog != null) {

            blogService.delete(blog);
            return new ResponseEntity<>(blog, HttpStatus.BAD_REQUEST);


        }


        return new ResponseEntity<>("no Blog", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(ApiV1Routes.Blog.approveBlog)
    public ResponseEntity<Object> approveBlog(@PathVariable String id, @PathVariable String userId, ApproveSelectDto approved) {
        Blog blog = blogService.getBlog(id);

        if (blog != null) {

            blogService.insert(blog);
            return new ResponseEntity<>(blog, HttpStatus.BAD_REQUEST);


        }


        return new ResponseEntity<>("no Blog", HttpStatus.BAD_REQUEST);
    }


    @PutMapping(ApiV1Routes.Blog.selectBlog)
    public ResponseEntity<Object> selectBlog(@PathVariable String id, @PathVariable String userId,ApproveSelectDto dto) {


        Blog blog = blogService.getBlog(id);

        if (blog != null) {

            blogService.insert(blog);
            return new ResponseEntity<>(blog, HttpStatus.BAD_REQUEST);


        }


        return new ResponseEntity<>("no Blog", HttpStatus.BAD_REQUEST);
    }
}
