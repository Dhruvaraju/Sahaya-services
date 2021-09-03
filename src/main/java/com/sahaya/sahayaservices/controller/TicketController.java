package com.sahaya.sahayaservices.controller;


import com.sahaya.sahayaservices.entity.Ticket;
import com.sahaya.sahayaservices.models.CommonResponse;
import com.sahaya.sahayaservices.models.PrimeRequest;
import com.sahaya.sahayaservices.service.TicketService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
