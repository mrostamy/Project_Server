package com.mydomain.project_server.services.site.admin;

import com.mydomain.project_server.dto.site.PaginationDto;
import com.mydomain.project_server.models.MainDB.User;
import com.mydomain.project_server.repositories.MainDB.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final
    UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public boolean userExist(String username) {

        return repo.existsUserByUsername(username);
    }

    public void updateToken(String token, String username) {

        repo.updateToken(token, username);

    }

    public User getUserByToken(String token) {

        return null;//repo.findUserByToken(token);
    }

    public List<User> getAllUsers() {

        return repo.findAll();

    }

    public List<User> getAllUsers(PaginationDto paginationDto) {

        return
                repo.
                        findAll(PageRequest.of
                                (paginationDto.getPageNumber(),
                                        paginationDto.getPageSize(),
                                        Sort.by(paginationDto.getSortHeader(),
                                                paginationDto.getSortDirection()))).toList();

    }

    public User getUser() {
        String id = "08d1189c-465c-4b82-a5e5-ea0b36284349";
        return repo.findById(id).get();
    }

    public User getUserByUsername(String username) {
        return repo.findByUsername(username);
    }

    public User getUser(String id) {
        return repo.findById(id).get();
    }
}
