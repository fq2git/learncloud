package com.fq2git.providerticket.controller;

import com.fq2git.providerticket.model.Ticket;
import com.fq2git.providerticket.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Api(tags = {"电影票接口"})
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @ApiOperation(value = "获取一个电影票")
    @GetMapping("/getticket")
    public String getticket(){
       return ticketService.getTicket();
    }

    @ApiOperation(value = "获取多个电影票")
    @GetMapping("/gettickets")
    public List<Ticket> gettickets(HttpServletRequest request){
        return ticketService.gettickets();
    }
}
