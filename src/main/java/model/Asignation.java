package model;

import lombok.Data;

import java.util.Date;

@Data
public class Asignation {

    private int projectId;
    private int employeeId;
    private Date asignationDate;

}
