package com.mydomain.project_server.repositories.MainDB;

import com.mydomain.project_server.models.MainDB.user.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

    //List<Wallet> findAll(Predicate<Wallet> predicate, Sort sort);

}
