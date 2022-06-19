package com.mydomain.project_server.controllers.site.V1.accountant;

import com.mydomain.project_server.models.MainDB.user.Wallet;
import com.mydomain.project_server.services.site.BlogService;
import com.mydomain.project_server.services.site.admin.BankCardService;
import com.mydomain.project_server.services.site.admin.UserService;
import com.mydomain.project_server.services.site.admin.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("api/v1/accountant/users")
public class AccountantUsers {

    UserService userService;

    BlogService blogService;

    WalletService walletService;

    final
    BankCardService bankCardService;

    final
    ModelMapper mapper;

    public AccountantUsers(UserService userService, BlogService blogService, WalletService walletService, ModelMapper mapper, BankCardService bankCardService) {
        this.userService = userService;
        this.blogService = blogService;
        this.walletService = walletService;
        this.mapper = mapper;
        this.bankCardService = bankCardService;
    }

//    //Role Accountant
//    @GetMapping(ApiV1Routes.Accountant.getInventories)
//    public ResponseEntity<List<?>> getInventories(String id, PaginationDto paginationDto) {
//
//        List<User> users = userService.getAllUsers(paginationDto);
//
//        List<UserForAccountantDto> detailedUsers = new ArrayList<>();
//
//        for (User item : users) {
//
//            detailedUsers.add(mapper.map(item, UserForAccountantDto.class));
//        }
//
//        return ResponseEntity.ok(detailedUsers);
//
//    }
//
//    //Role Accountant
//    @GetMapping(ApiV1Routes.Accountant.getInventories)
//    public ResponseEntity<List<?>> getInventoryWallets(String user_id) {
//
//        List<Wallet> wallets = walletService.getAllWallets()
//                .stream().filter(w -> Objects.equals(w.getUser().getId(), user_id)).collect(Collectors.toList());
//
//
//        List<WalletForReturnDto> returnWallets = new ArrayList<>();
//
//        for (Wallet item : wallets) {
//
//            returnWallets.add(mapper.map(item, WalletForReturnDto.class));
//        }
//
//        return ResponseEntity.ok(returnWallets);
//
//    }
//
//    //Role Accountant
//    @GetMapping(ApiV1Routes.Accountant.getInventories)
//    public ResponseEntity<List<?>> getInventoryCardBanks(String user_id) {
//
//        List<BankCard> bankCards = bankCardService.getAllCards()
//                .stream().filter(b -> Objects.equals(b.getUser().getId(), user_id)).collect(Collectors.toList());
//
//
//        List<BankCardReturnDto> returnBankCards = new ArrayList<>();
//
//        mapper.map(bankCards, returnBankCards);
//
//        returnBankCards = MapperUtils.mapAll(bankCards, BankCardReturnDto.class);
//
//        return ResponseEntity.ok(returnBankCards);
//
//    }
//
//    //Role Accountant
//    @PatchMapping(ApiV1Routes.Accountant.getInventories)
//    public ResponseEntity<?> blockInventoryBlock(String wallet_id, WalletBlockDto walletBlockDto) {
//
//        Wallet wallet = walletService.getWalletById(wallet_id);
//
//        wallet.setBlock(walletBlockDto.isBlock());
//
//        walletService.insertWallet(wallet);
//
//        return ResponseEntity.noContent().build();
//
//    }
//
//    //Role Accountant
//    @PatchMapping(ApiV1Routes.Accountant.approveInventoryWallet)
//    public ResponseEntity<?> approveInventoryWallet(@PathVariable String bankCard_id, BankCardApproveDto bankCardApproveDto) {
//
//        BankCard bankCard = bankCardService.getCardById(bankCard_id);
//
//        bankCard.setApprove(bankCardApproveDto.isApprove());
//
//        bankCardService.insertBankCard(bankCard);
//
//        return ResponseEntity.noContent().build();
//
//    }
//
//    @GetMapping
//    public ResponseEntity<Object> getAllBankCard() {
//
//        String id = "";
//        List<BankCard> cardList = bankCardService.getAllCardsById(id);
//
//        return new ResponseEntity<>(cardList, HttpStatus.OK);
//    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getAllWallets(@PathVariable String id) {

        List<Wallet> wallets =
                walletService.
                        getAllWallets(w -> Objects.equals
                                (w.getUser().getId(), id), Sort.by(Sort.Direction.ASC, "isMain,asc")
                                .and(
                                        Sort.by(Sort.Direction.DESC, "isSms")));

        return new ResponseEntity<>(wallets, HttpStatus.OK);
    }


}
