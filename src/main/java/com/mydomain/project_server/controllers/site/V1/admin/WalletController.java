package com.mydomain.project_server.controllers.site.V1.admin;

import com.mydomain.project_server.models.MainDB.user.Wallet;
import com.mydomain.project_server.services.site.admin.WalletService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

public class WalletController {

    final
    WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }


    @GetMapping("{id}")
    public ResponseEntity<Object> getAllWallets(@PathVariable String id) {

        List<Wallet> wallets =
                service.
                        getAllWallets(w -> Objects.equals
                                (w.getUser().getId(), id), Sort.by(Sort.Direction.ASC, "isMain,asc")
                                .and(
                                        Sort.by(Sort.Direction.DESC, "isSms")));

        return new ResponseEntity<>(wallets, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<Object> getWallet(@PathVariable String id) {

        var wallet = service.getWalletById(id);

        if (wallet != null) {
            return new ResponseEntity<>(wallet, HttpStatus.OK);
        }

        return new ResponseEntity<>("no wallet found", HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Object> addWallet(@RequestBody Wallet wallet) {

        if (service.checkInventory(1500, wallet.getId())) {
            var dec_result = service.decreaseInventory(1500, wallet.getId());
            if (dec_result) {
                var w = service.insertWallet(wallet);
                if (w == null) {
                    return new ResponseEntity<>(wallet, HttpStatus.OK);
                } else {
                    var inc_result = service.increaseInventory(1500, wallet.getId());
                    if (inc_result) {
                        return new ResponseEntity<>("error in database", HttpStatus.BAD_REQUEST);
                    } else {
                        return new ResponseEntity<>("error in database,if decreased call support", HttpStatus.BAD_REQUEST);
                    }
                }

            } else {
                return new ResponseEntity<>("error in decrease", HttpStatus.BAD_REQUEST);
            }
        }
        service.insertWallet(wallet);
        return new ResponseEntity<>("save successfull", HttpStatus.OK);


    }
}
