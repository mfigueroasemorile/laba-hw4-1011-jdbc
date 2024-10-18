package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

    private int idProject;
    private String managerName;
    private String address;
    private int projectTypeId;
    private int clientId;
    private int estimatedDuration;
}
