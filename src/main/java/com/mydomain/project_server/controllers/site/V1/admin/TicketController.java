package com.mydomain.project_server.controllers.site.V1.admin;

import com.mydomain.project_server.models.MainDB.Ticket;
import com.mydomain.project_server.dto.site.panel.ticket.TicketContentForCreateDto;
import com.mydomain.project_server.services.site.admin.TicketService;
import com.mydomain.project_server.services.site.admin.UploadService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/V1/site/admin/ticket")
public class TicketController {

    final
    TicketService ticket_service;

    final
    UploadService upload_service;


    public TicketController(TicketService ticket_service, UploadService upload_service) {
        this.ticket_service = ticket_service;
        this.upload_service = upload_service;
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getAllTickets(@PathVariable String id) {

        List<Ticket> tickets = ticket_service.getAllTickets(id);

        ticket_service.getAllTickets(id, PageRequest.of(0, 5), Sort.by(Sort.Direction.DESC, "title"));

        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
//
//    @PostMapping
//    public ResponseEntity<Object> AddTicket(@PathVariable String userId, TicketForCreateDto dto) {
//
//        //check for duplicate title
//
//        Ticket ticket = new Ticket();
//
//        new ModelMapper().map(dto, ticket);
//
//        ticket_service.insertTicket(ticket);
//
//        return new ResponseEntity<>(ticket, HttpStatus.OK);
//    }

    @PostMapping("{userId}")
    public ResponseEntity<Object> AddTicketContent(@PathVariable String userId, TicketContentForCreateDto dto) {

//        if (dto.getFile().getSize() > 0) {
//
//
//            upload_service
//                    .uploadToLocal(dto.getFile(), userId);
//
//        }

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Object> CloseTicket(String id,@PathVariable String userId,boolean close) {

        //check for duplicate title

        Ticket ticket = new Ticket();

       // new ModelMapper().map(dto, ticket);

        ticket_service.insertTicket(ticket);

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }


}
