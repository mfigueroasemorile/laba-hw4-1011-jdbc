package model;

import lombok.Data;

@Data
public class Product {

    private int idProduct;
    private String description;
    private float price;
    private int supplierId;
}
