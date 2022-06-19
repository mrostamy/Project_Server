package com.mydomain.project_server.controllers.site.V1.admin;

import com.mydomain.project_server.models.MainDB.user.BankCard;
import com.mydomain.project_server.services.site.admin.BankCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/V1/site/admin/bankCard")
public class BankCardController {

    final
    BankCardService service;

    public BankCardController(BankCardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getAllBankCard() {

        String id="";
        List<BankCard> cardList = service.getAllCardsById(id);

        return new ResponseEntity<>(cardList, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<Object> getBankCard(@PathVariable String id) {

        var bankCard = service.getCardById(id);

        if (bankCard != null) {
            return new ResponseEntity<>(bankCard, HttpStatus.OK);
        }

        return new ResponseEntity<>("no bank card", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateBankCard(@PathVariable String id) {

        var bankCard = service.getCardById(id);

        if (bankCard != null) {
            return new ResponseEntity<>(bankCard, HttpStatus.OK);
        }

        return new ResponseEntity<>("no bank card", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteBankCard(@PathVariable String id) {

        service.deleteCardById(id);

        return new ResponseEntity<>("no bank card", HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Object> addBankCard(@RequestBody BankCard bankCard) {

        String userId = "08d1189c-465c-4b82-a5e5-ea0b36284349";//fake UserId
        var _bankCard = service.getCardByNumber(bankCard.getCardNumber());
        var count = service.bankCardCount(userId);

        if (count > 10) {
            return new ResponseEntity<>("max cards count must be 10", HttpStatus.BAD_REQUEST);
        }

        if (_bankCard == null) {


            service.insertBankCard(bankCard);
            return new ResponseEntity<>("save successfull", HttpStatus.OK);
        }

        return new ResponseEntity<>("duplicate bank card", HttpStatus.BAD_REQUEST);
    }
}
