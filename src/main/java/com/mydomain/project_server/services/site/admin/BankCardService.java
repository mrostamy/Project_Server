package com.mydomain.project_server.services.site.admin;

import com.mydomain.project_server.models.MainDB.user.BankCard;
import com.mydomain.project_server.repositories.MainDB.BankCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankCardService {

    final BankCardRepository repo;

    public BankCardService(BankCardRepository repo) {
        this.repo = repo;
    }


    public List<BankCard> getAllCards() {
        return repo.findAll();
    }

    public List<BankCard> getAllCardsById(String id) {
        return repo.findAllByUserId(id);
    }

    public BankCard getCardById(String id) {
        return repo.findById(id).get();
    }

    public BankCard getCardByNumber(String number) {
        return repo.findBankCardByCardNumber(number);
    }

    public BankCard insertBankCard(BankCard bankCard) {
        return repo.save(bankCard);
    }


    public void deleteCardById(String id) {
        repo.deleteById(id);
    }

    public int bankCardCount(String userId) {
        return repo.findAllByUserId(userId).size();
    }

}
