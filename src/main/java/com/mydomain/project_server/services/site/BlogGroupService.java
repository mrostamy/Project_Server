package com.mydomain.project_server.services.site;

import com.mydomain.project_server.repositories.MainDB.BlogGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogGroupService {

    @Autowired
    BlogGroupRepository repo;
}
