package com.sahaya.sahayaservices.service;

import com.sahaya.sahayaservices.entity.Ticket;
import com.sahaya.sahayaservices.enums.TicketStatus;
import com.sahaya.sahayaservices.enums.TicketSeverity;
import com.sahaya.sahayaservices.models.*;
import com.sahaya.sahayaservices.repository.TicketRepository;
import com.sahaya.sahayaservices.enums.Status;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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



    public CommonResponse updateTicketRequest(TicketRequest updateTicket) {
        Ticket loTicket = ticketRepo.findTicketByTicketId(updateTicket.getTicketId());
        if (null != loTicket) {
            loTicket.setEmployeeId(updateTicket.getEmployeeId());
            loTicket.setTicketId(updateTicket.getTicketId());
            loTicket.setEmployeeName(updateTicket.getEmployeeName());
            loTicket.setTicketStatus(updateTicket.getTicketStatus());
            loTicket.setSeverity(updateTicket.getTicketSeverity());
            loTicket.setMessageToUser(updateTicket.getMessageToUser());
            ticketRepo.save(loTicket);
            return new CommonResponse(Status.UPDATED, "Details updated");
        }
        else {
            return new CommonResponse(Status.NOTFOUND, "Details cannot be updated");
        }
    }

    public List<Ticket> getListOfTicketsNotClosed() {
        List<Ticket> openTickets = ticketRepo.findTicketsByTicketStatusIsNot(TicketStatus.CLOSED);
        return openTickets;
    }

//    public List<Ticket> getTicketByUserName (String username) {
//        List<Ticket> openUserTicket = (List<Ticket>) ticketRepo.findTicketByUserName(username);
//        return openUserTicket;
//    }

//    public List<Ticket> fetchAllOpenIpos(){
//        List<Ticket> allIpoList = ticketRepo.findAll();
//        List<Ticket> openIpoList = new ArrayList<>();
//        for (Ticket ipo : allIpoList) {
//            openIpoList.add(ipo);
//            System.out.println("trial "+openIpoList);
//        }
//        return openIpoList;
//    }

//    public TicketResponse getTicketByUserName(GetUserName username) {
//        List<Ticket> tckt =ticketRepo.findAll();
//        if (null != tckt) {
//            return new TicketResponse(tckt.getTicketId(), tckt.getUserName(), tckt.getIssue(), tckt.getDescription(), tckt.getEmployeeName(),tckt.getTicketStatus(), tckt.getMessageToUser());
//        }
//        else
//        {
//            return null;
//        }
//        List<Ticket> fetchTicket = ticketRepo.findTicketByUserName(userName);
//        return loTicket;
//    }


//    public List<Ticket> getTicketByUserName(String userName) {
//        List<Ticket> fetchTicket = ticketRepo.findAll();
//        System.out.println("Ticket "+fetchTicket.toString() );
//        List<TicketResponse> listOfTickets = new ArrayList<>();
//        for (Ticket tckt : fetchTicket) {
//            if (tckt.getUserName() == userName) {
//                TicketResponse tr = new TicketResponse(tckt.getTicketId(), tckt.getUserName(), tckt.getIssue(), tckt.getDescription(), tckt.getEmployeeName(), tckt.getTicketStatus(), tckt.getMessageToUser());
//                listOfTickets.add(tr);
//            }
//        }
//        return fetchTicket;
//
//    }


}


