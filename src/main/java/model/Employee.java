package model;

import lombok.Data;

@Data
public class Employee {

    private int idEmployee;
    private String name;
    private String Address;
    private int roleId;
    private int contractId;
    private String gender;
}
