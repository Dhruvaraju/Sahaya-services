package com.sahaya.sahayaservices.service;

import com.sahaya.sahayaservices.entity.Ticket;
import com.sahaya.sahayaservices.enums.TicketStatus;
import com.sahaya.sahayaservices.enums.TicketSeverity;
import com.sahaya.sahayaservices.models.CommonResponse;
import com.sahaya.sahayaservices.models.PrimeRequest;
import com.sahaya.sahayaservices.repository.TicketRepository;
import com.sahaya.sahayaservices.enums.Status;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class TicketService {
    private final TicketRepository ticketRepo;

    public TicketService(TicketRepository ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public CommonResponse addTicket(PrimeRequest primeRequest) {
        Ticket loticket = new Ticket(null, null, null, null, null, null, null, null, null, null, null);
        loticket.setUserName(primeRequest.getUserName());
        loticket.setEmployeeId(null);
        loticket.setDescription(primeRequest.getDescription());
        loticket.setEmployeeName(null);
        loticket.setIssue(primeRequest.getIssue());
        loticket.setRegisteredDate(LocalDate.now());
        loticket.setTicketStatus(TicketStatus.NEW);
        loticket.setSeverity(TicketSeverity.LOW);
        loticket.setMessageToUser(null);
        Ticket updatedTicket = ticketRepo.save(loticket);
        updatedTicket.setTicketId(100000 + loticket.getId());
        ticketRepo.save(updatedTicket);
        return new CommonResponse(Status.ADDED, updatedTicket.getTicketId().toString());
    }


}


