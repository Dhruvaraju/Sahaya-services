package com.sahaya.sahayaservices.service;

import com.sahaya.sahayaservices.entity.Ticket;
import com.sahaya.sahayaservices.enums.TicketStatus;
import com.sahaya.sahayaservices.enums.TicketSeverity;
import com.sahaya.sahayaservices.models.*;
import com.sahaya.sahayaservices.repository.TicketRepository;
import com.sahaya.sahayaservices.enums.Status;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepo;

    public TicketService(TicketRepository ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public CommonResponse addTicket(PrimeRequest primeRequest) {
        Ticket loTicket = new Ticket(null, primeRequest.getUserName(), null, null, LocalDate.now(), primeRequest.getIssue(), primeRequest.getDescription(), TicketSeverity.LOW, TicketStatus.NEW, null, null);
        Ticket updatedTicket = ticketRepo.save(loTicket);
        updatedTicket.setTicketId(100000 + loTicket.getId());
        ticketRepo.save(updatedTicket);
        return new CommonResponse(Status.ADDED, updatedTicket.getTicketId().toString());
    }


    public CommonResponse updateTicket(TicketRequest updateTicket) {
        Ticket loTicket = ticketRepo.findTicketByTicketId(updateTicket.getTicketId());
        if (null != loTicket) {
            if (null != updateTicket.getEmployeeId()) {
                loTicket.setEmployeeId(updateTicket.getEmployeeId());
            }
            if (null != updateTicket.getEmployeeName()) {
                loTicket.setEmployeeName(updateTicket.getEmployeeName());
            }
            if (null != updateTicket.getTicketStatus()) {
                loTicket.setTicketStatus(updateTicket.getTicketStatus());
            }
            if (null != updateTicket.getTicketSeverity()) {
                loTicket.setSeverity(updateTicket.getTicketSeverity());
            }
            if (null != updateTicket.getMessageToUser()) {
                loTicket.setMessageToUser(updateTicket.getMessageToUser());
            }
            ticketRepo.save(loTicket);
            return new CommonResponse(Status.UPDATED, "Details updated");
        } else {
            return new CommonResponse(Status.NOTFOUND, "Details cannot be updated");
        }
    }

    public List<Ticket> getListOfTicketsNotClosed() {
        return ticketRepo.findTicketsByTicketStatusIsNot(TicketStatus.CLOSED);
    }

    public List<Ticket> ticketsOpenedByUser(String username) {
        return ticketRepo.findTicketByUserName(username);
    }

    public List<Ticket> employeeTicketNotClosed(Long employeeId) {
        return ticketRepo.findTicketByEmployeeIdAndTicketStatusIsNot(employeeId, TicketStatus.CLOSED);
    }

}


