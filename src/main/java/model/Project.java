package model;

import lombok.Data;

@Data
public class Project {

    private int idProject;
    private String managerName;
    private String address;
    private int projectTypeId;
    private int clientId;
}
