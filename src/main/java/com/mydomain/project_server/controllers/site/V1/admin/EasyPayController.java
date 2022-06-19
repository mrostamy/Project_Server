package com.mydomain.project_server.controllers.site.V1.admin;

import com.mydomain.project_server.routes.V1.ApiV1Routes;
import com.mydomain.project_server.services.site.admin.EasyPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/V1/site/admin/easyPay")
public class EasyPayController {

    @Autowired
    EasyPayService easyPayService;

    @GetMapping(ApiV1Routes.EasyPay.getEasyPays)
    public ResponseEntity<Object> getEasyPays(@PathVariable String userId) {

        return new ResponseEntity<>("cardList", HttpStatus.OK);
    }


    @GetMapping(ApiV1Routes.EasyPay.getEasyPay)
    public ResponseEntity<Object> getEasyPay(@PathVariable String id, @PathVariable String userId) {


        return new ResponseEntity<>("no bank easyPay", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(ApiV1Routes.EasyPay.addEasyPay)
    public ResponseEntity<Object> addBankCard(@PathVariable String userId) {

        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(ApiV1Routes.EasyPay.updateEasyPay)
    public ResponseEntity<Object> updateEasyPay(@PathVariable String id, @PathVariable String userId) {

        return new ResponseEntity<>("no easyPay", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(ApiV1Routes.EasyPay.deleteEasyPay)
    public ResponseEntity<Object> deleteEasyPay(@PathVariable String id, @PathVariable String userId) {


        return new ResponseEntity<>("no easyPay", HttpStatus.BAD_REQUEST);
    }

}
