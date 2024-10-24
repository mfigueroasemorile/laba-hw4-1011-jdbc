package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.Date;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket {

    @JsonProperty("id_ticket")
    private int idTicket;
    @JsonProperty("total")
    private float total;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    public Ticket (float total, Date date){
        this.total = total;
        this.date = date;
    }

    public Ticket (){

    }
}
