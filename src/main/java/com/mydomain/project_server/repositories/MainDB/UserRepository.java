package com.mydomain.project_server.repositories.MainDB;

import com.mydomain.project_server.models.MainDB.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


    boolean existsUserByUsername(String username);

    User findByUsername(String username);

//    User findUserByTokens(String token);

    User findByUsernameAndPassword(String username, String password);

    @Transactional
    @Modifying
    @Query(value = "update User set token=:token  where username=:username", nativeQuery = true)
    void updateToken(@Param(value = "token") String token, @Param(value = "username") String username);

}
