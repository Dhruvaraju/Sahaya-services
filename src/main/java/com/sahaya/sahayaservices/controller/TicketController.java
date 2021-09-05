package com.sahaya.sahayaservices.controller;


import com.sahaya.sahayaservices.entity.Ticket;
import com.sahaya.sahayaservices.models.*;
import com.sahaya.sahayaservices.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/ticket")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/registerTicket", method = RequestMethod.POST)
    public CommonResponse ticketCreation( @RequestBody PrimeRequest request){
        return ticketService.addTicket(request);
    }

    @RequestMapping(value = "/updateTicketRequest", method = RequestMethod.POST)
    public  CommonResponse updateTicket(@RequestBody TicketRequest ticket) {
        return ticketService.updateTicketRequest(ticket);
    }

    @RequestMapping(value = "/fetchOpenTickets", method = RequestMethod.GET)
    public List<Ticket> fetchOpenTickets() {
        return ticketService.getListOfTicketsNotClosed();
    }

//    @RequestMapping(value = "/{userName}",method = RequestMethod.GET)
//    public List<TicketResponse> getListOfUserTicket(@PathVariable String userName){
//        return ticketService.getTicketByUserName(userName);
//    }
//
//    @RequestMapping(value = "/open",method = RequestMethod.GET)
//    public List<Ticket> fetchTicket(){
//        return ticketService.fetchAllOpenIpos();
//    }
//    @RequestMapping(value = "/getListOfUserTicket", method = RequestMethod.POST)
//    public TicketResponse getListOfUserTicket(@RequestBody GetUserName username) {
//        return ticketService.getTicketByUserName(username);
//    }

}
