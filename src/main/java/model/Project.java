package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {


    @JsonProperty("id_project")
    private int idProject;
    @JsonProperty("manager_name")
    private String managerName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("project_type")
    private int projectTypeId;
    @JsonProperty("client_id")
    private int clientId;
    @JsonProperty("estimated_duration")
    private int estimatedDuration;
    @JsonProperty("tasks")
    private List<Task> tasks;


    public Project (String managerName, String address, int projectTypeId, int clientId){
        this.managerName = managerName;
        this.address = address;
        this.projectTypeId = projectTypeId;
        this.clientId = clientId;
    }
    public Project(){

    }

}
