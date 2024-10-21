package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @JsonProperty("id_employee")
    private int idEmployee;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String Address;
    @JsonProperty("id_role")
    private int roleId;
    @JsonProperty("id_contract")
    private int contractId;
    @JsonProperty("gender")
    private String gender;
}
