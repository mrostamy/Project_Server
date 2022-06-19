package com.mydomain.project_server.controllers.site.V1.accountant;

import com.mydomain.project_server.dto.site.panel.entry.ChangeEntryState;
import com.mydomain.project_server.models.FinancialDB.accountant.Entry;
import com.mydomain.project_server.routes.V1.ApiV1Routes;
import com.mydomain.project_server.services.site.admin.FinancialService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.net.http.HttpClient;

@RestController
@RequestMapping("api/V1/site/admin/entry")
public class EntryController {

    final
    FinancialService financialService;

    public EntryController(FinancialService financialService) {
        this.financialService = financialService;
    }

    @GetMapping(ApiV1Routes.Entry.getEntries)
    public ResponseEntity<Object> getAllEntries() {


        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(ApiV1Routes.Entry.getEntry)
    public ResponseEntity<Object> getEntry(@PathVariable String entry_id) {

        financialService.getEntryById(entry_id);

//        if (bankCard != null) {
//            return new ResponseEntity<>(bankCard, HttpStatus.OK);
//        }

        return new ResponseEntity<>("no bank card", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(ApiV1Routes.Entry.updateEntry)
    public ResponseEntity<Object> updateEntry(@PathVariable String entry_id, Entry entry) {

        Entry entry1 = financialService.getEntryById(entry_id);

        if (entry1 != null) {
            entry1.setText(entry.getText());
            if (financialService.insert(entry1) != null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("error in update entry", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("no bank card", HttpStatus.BAD_REQUEST);
    }

    @PatchMapping(ApiV1Routes.Entry.approveEntry)
    public ResponseEntity<Object> approveEntry(@PathVariable String entry_id, ChangeEntryState entry) {


        Entry entry1 = financialService.getEntryById(entry_id);

        if (entry1 != null) {
            if (!entry.isPardakht() && !entry.isReject()) {

                entry1.setApproved(entry.isApprove());
                if (financialService.insert(entry1) != null) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                } else {
                    return new ResponseEntity<>("error in approve entry", HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>("is not possible to approve entry for  rejected or pardakht entries", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("no bank card", HttpStatus.BAD_REQUEST);
    }

//    @PatchMapping(ApiV1Routes.Entry.pardakhtEntry)
//    public ResponseEntity<Object> pardakhtEntry(@PathVariable String entry_id, ChangeEntryState entry) {
//
//
//        Entry entry1 = financialService.getEntryById(entry_id);
//
//        if (entry1 != null) {
//            if (entry.isApprove() && !entry.isReject()) {
//                entry1.setPardakht(entry.isPardakht());
//                if (financialService.insert(entry1) != null) {
//                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//                } else {
//                    return new ResponseEntity<>("error in approve pardakht entry", HttpStatus.BAD_REQUEST);
//                }
//            } else {
//                return new ResponseEntity<>("is not possible to pardakt entry for  rejected or not approved entries", HttpStatus.BAD_REQUEST);
//            }
//        }
//        return new ResponseEntity<>("no bank card", HttpStatus.BAD_REQUEST);
//    }

//    @PatchMapping(ApiV1Routes.Entry.rejectEntry)
//    public ResponseEntity<Object> rejectEntry(@PathVariable String entry_id, ChangeEntryState entry) {
//
//
//        Entry entry1 = financialService.getEntryById(entry_id);
//
//        if (entry1 != null) {
//            if (!entry.isPardakht()) {
//                entry1.setRegected(entry.isReject());
//                if (financialService.insert(entry1) != null) {
//                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//                } else {
//                    return new ResponseEntity<>("error in pardakht entry", HttpStatus.BAD_REQUEST);
//                }
//            } else {
//                return new ResponseEntity<>("is not possible to reject entry for  pardakht entries", HttpStatus.BAD_REQUEST);
//            }
//        }
//        return new ResponseEntity<>("no bank card", HttpStatus.BAD_REQUEST);
//    }

    @DeleteMapping(ApiV1Routes.Entry.deleteEntry)
    public ResponseEntity<Object> deleteEntry(@PathVariable String entry_id, Entry entry) {

        Entry entry1 = financialService.getEntryById(entry_id);

        if (entry1 != null) {
            entry1.setText(entry.getText());
            if (financialService.insert(entry1) != null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("error in update entry", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("no bank card", HttpStatus.BAD_REQUEST);
    }

}
