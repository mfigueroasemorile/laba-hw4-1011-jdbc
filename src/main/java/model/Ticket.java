package model;

import lombok.Data;

import java.util.Date;

@Data
public class Ticket {

    private int idTicket;
    private float total;
    private Date date;
}
