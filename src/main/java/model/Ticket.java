package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.Date;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket {

    private int idTicket;
    private float total;
    private Date date;
}
