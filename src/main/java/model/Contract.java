package model;

import lombok.Data;

import java.util.Date;

@Data
public class Contract {

    private int idContract;
    private Date startDate;
    private float salary;
    private int hoursPerWeek;
}
