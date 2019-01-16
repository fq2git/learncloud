package com.fq2git.providerticket.service;

import com.fq2git.providerticket.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    public String getTicket(){
        System.out.println("8082");
        return "服务端数据";
    }

    public List<Ticket> gettickets(){
        List<Ticket> list = new ArrayList<>();
        Ticket ticket1 = new Ticket(1,"电影票1","是个不错的电影");
        Ticket ticket2 = new Ticket(2,"电影票2","是个不错的电影");
        Ticket ticket3 = new Ticket(3,"电影票3","是个不错的电影");
        Ticket ticket4 = new Ticket(4,"电影票4","是个不错的电影");
        list.add(ticket1);
        list.add(ticket2);
        list.add(ticket3);
        list.add(ticket4);
        return list;
    }
}
