package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

    @JsonProperty("id_product")
    private int idProduct;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private float price;
    @JsonProperty("id_supplier")
    private int supplierId;


    public Product(String description, float price, int supplierId) {
        this.description = description;
        this.price = price;
        this.supplierId = supplierId;
    }

    public Product() {
    }
}
