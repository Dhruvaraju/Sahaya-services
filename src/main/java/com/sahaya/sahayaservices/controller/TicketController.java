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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResponse ticketCreation( @RequestBody PrimeRequest request){
        return ticketService.addTicket(request);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public  CommonResponse updateTicket(@RequestBody TicketRequest ticket) {
        return ticketService.updateTicket(ticket);
    }

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public List<Ticket> fetchOpenTickets() {
        return ticketService.fetchListOfTicketsNotClosed();
    }

   @RequestMapping(value = "/user/{userName}",method = RequestMethod.GET)
    public List<Ticket> fetchListOfUserTicket(@PathVariable String userName){
        return ticketService.ticketsOpenedByUser(userName);
   }

    @RequestMapping(value = "/emp/{empId}",method = RequestMethod.GET)
    public List<Ticket> fetchListOfEmployeeTickets(@PathVariable Long empId){
        return ticketService.employeeTicketNotClosed(empId);
    }


}
