package com.mydomain.project_server.repositories.MainDB;

import com.mydomain.project_server.models.MainDB.Ticket;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    List<Ticket> findAllByClosed(boolean status, Sort sort);

//    List<Ticket> findAll(Pageable pageable, Sort sort);
//
//    Ticket findByIdAndUser_Id(String id, String userId);
//
//    Ticket findByTitleAndUser_Id(String title, String userId);


    @Modifying
    @Transactional
    @Query("update  Ticket t set t.closed=:closed")
    boolean setTicketStatus(@RequestParam boolean closed);


}
