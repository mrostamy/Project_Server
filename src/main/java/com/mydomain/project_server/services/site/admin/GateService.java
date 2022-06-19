package com.mydomain.project_server.services.site.admin;

import com.mydomain.project_server.repositories.MainDB.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GateService {

    @Autowired
    GateRepository repo;
}
