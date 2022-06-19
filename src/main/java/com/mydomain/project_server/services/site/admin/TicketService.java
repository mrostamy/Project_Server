package com.mydomain.project_server.services.site.admin;

import com.mydomain.project_server.models.MainDB.Ticket;
import com.mydomain.project_server.repositories.MainDB.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository repo;


    public List<Ticket> getAllTickets(String userId) {

        return repo.findAll();
    }

    public List<Ticket> getAllTickets(String userId, Pageable pageable, Sort sort) {

        return repo.findAll();
    }


    public List<Ticket> getAllTicketsByStatus(boolean closed, Sort sort) {

        return repo.findAllByClosed(closed, sort);
    }

//    public Ticket getByTitleAndUserId(String title, String userId) {
//
//        return repo.findByTitleAndUser_Id(title, userId);
//    }
//
//    public Ticket getByIdAndUserId(String id, String userId) {
//
//        return repo.findByIdAndUser_Id(id, userId);
//    }

    public Ticket insertTicket(Ticket ticket) {

        return repo.save(ticket);
    }
}
