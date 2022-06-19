package com.mydomain.project_server.services.site.admin;

import com.mydomain.project_server.models.MainDB.User;
import com.mydomain.project_server.repositories.MainDB.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository repo;

    public User register(User user, String password) {

        user.setPassword(password);
        return repo.save(user);
    }

    public User login(String username, String password) {

        return repo.findByUsernameAndPassword(username, password);
    }


}
