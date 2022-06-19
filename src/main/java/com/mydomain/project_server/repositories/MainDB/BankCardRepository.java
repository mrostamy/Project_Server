package com.mydomain.project_server.repositories.MainDB;

import com.mydomain.project_server.models.MainDB.user.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, String> {

    BankCard findBankCardByCardNumber(String cardNumber);

    List<BankCard> findAllByUserId(String id);

}
