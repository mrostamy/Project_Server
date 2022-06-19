package com.mydomain.project_server.controllers.site.V1.admin;

import com.mydomain.project_server.dto.site.panel.gate.ActiveDirectGateDto;
import com.mydomain.project_server.routes.V1.ApiV1Routes;
import com.mydomain.project_server.services.site.admin.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/V1/site/panel/gate")
public class GateController {

    @Autowired
    GateService gateService;

    @GetMapping(value = ApiV1Routes.Gate.getGates, name = "GetGates")
    public ResponseEntity<Object> getAllGates(@PathVariable String userId) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = ApiV1Routes.Gate.getGate, name = "GetGate")
    public ResponseEntity<Object> getGate(@PathVariable String id, @PathVariable String userId) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = ApiV1Routes.Gate.addGate)
    public ResponseEntity<Object> addGate(@PathVariable String userId) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = ApiV1Routes.Gate.updateGate)
    public ResponseEntity<Object> updateGate(@PathVariable String userId, @PathVariable String id) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = ApiV1Routes.Gate.activeDirectGate)
    public ResponseEntity<Object> activeDirectGate(@PathVariable String userId, @PathVariable String id,ActiveDirectGateDto dto) {

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
