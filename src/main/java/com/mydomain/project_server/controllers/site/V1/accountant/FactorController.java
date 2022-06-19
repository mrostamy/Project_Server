package com.mydomain.project_server.controllers.site.V1.accountant;

import com.mydomain.project_server.dto.site.panel.factor.FactorStatusDto;
import com.mydomain.project_server.models.FinancialDB.accountant.Factor;
import com.mydomain.project_server.routes.V1.ApiV1Routes;
import com.mydomain.project_server.services.site.admin.FinancialService;
import com.mydomain.project_server.services.site.admin.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/V1/site/admin/entry")
public class FactorController {

    final
    FinancialService financialService;

    final
    WalletService walletService;

    public FactorController(FinancialService financialService, WalletService walletService) {
        this.financialService = financialService;
        this.walletService = walletService;
    }

    @GetMapping(ApiV1Routes.Factor.getFactors)
    public ResponseEntity<Object> getAllEntries() {

        List<Factor> factors = financialService.getAllFactors();

        return new ResponseEntity<>(factors, HttpStatus.OK);
    }

    @GetMapping(ApiV1Routes.Factor.getFactor)
    public ResponseEntity<Object> getFactor(@PathVariable String factor_id) {

        Factor factor = financialService.getFactorById(factor_id);

        if (factor != null) {
            return new ResponseEntity<>(factor, HttpStatus.OK);
        }

        return new ResponseEntity<>("no factor", HttpStatus.BAD_REQUEST);
    }

    @PatchMapping(ApiV1Routes.Factor.statusFactor)
    public ResponseEntity<Object> changeFactorStatus(@PathVariable String factor_id, FactorStatusDto statusDto) {


        //implement from last 22 and 23 section status must be reviewed
        Factor factor = financialService.getFactorById(factor_id);

        if (factor != null) {
            factor.setStatus(statusDto.isStatus());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("no factor", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping(ApiV1Routes.Factor.delete)
    public ResponseEntity<Object> deleteFactor(@PathVariable String factor_id) {

        Factor factor = financialService.getFactorById(factor_id);

        if (factor != null) {
            financialService.deleteFactor(factor);
        }
        return new ResponseEntity<>("no factor", HttpStatus.BAD_REQUEST);
    }
}
