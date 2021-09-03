package com.sahaya.sahayaservices.repository;

import com.sahaya.sahayaservices.entity.Ticket;
import com.sahaya.sahayaservices.enums.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findTicketsByTicketStatusIsNot(TicketStatus status);
//    List<Ticket>  findTicketByUserName(String userName);
    Ticket findTicketByTicketId(Long ticketId);
    Ticket findTicketByUserName(String userName);


}
