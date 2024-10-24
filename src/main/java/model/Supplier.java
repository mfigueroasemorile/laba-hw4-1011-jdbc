package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Supplier {

    @JsonProperty("id_supplier")
    private int idSupplier;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
}
