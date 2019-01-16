package com.fq2git.providerticket.controller;

import com.fq2git.providerticket.model.Ticket;
import com.fq2git.providerticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @RequestMapping("/getticket")
    public String getticket(){
       return ticketService.getTicket();
    }

    @GetMapping("/gettickets")
    public List<Ticket> gettickets(HttpServletRequest request){
        return ticketService.gettickets();
    }
}
