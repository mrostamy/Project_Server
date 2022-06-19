package com.mydomain.project_server.services.site.admin;

import com.mydomain.project_server.models.MainDB.user.Wallet;
import com.mydomain.project_server.repositories.MainDB.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class WalletService {

    @Autowired
    WalletRepository repo;


    public Wallet insertWallet(Wallet wallet) {

        return repo.save(wallet);
    }

    public Wallet getWalletById(String id) {

        return repo.findById(id).get();
    }

    public List<Wallet> getAllWallets(Predicate<Wallet> predicate, Sort sort) {

        return null;//repo.findAll(predicate, sort);
    }

    public List<Wallet> getAllWallets() {

        return repo.findAll();
    }

    public boolean decreaseInventory(int cost, String id) {

        Optional<Wallet> wallet = repo.findById(id);
        if (wallet.isPresent()) {
            int tempCost = wallet.get().getInventory();
            wallet.get().setInventory(tempCost + cost);
            repo.save(wallet.get());
            return true;
        } else {
            return false;
        }
    }

    public boolean increaseInventory(int cost, String id) {
        Optional<Wallet> wallet = repo.findById(id);
        if (wallet.isPresent()) {
            if (wallet.get().getInventory() >= hashCode()) {
                int temp = wallet.get().getInventory();
                wallet.get().setInventory(temp - cost);
                repo.save(wallet.get());
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public boolean checkInventory(int cost, String id) {

        Optional<Wallet> wallet = repo.findById(id);
        if (wallet.isPresent()) {
            return wallet.get().getInventory() >= cost;
        } else {
            return false;
        }
    }
}
