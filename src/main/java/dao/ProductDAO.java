package dao;

import jdbc.JDBCConectivity;
import model.Product;
import model.ProjectType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IDao<Product>{

    private JDBCConectivity connection;

    public ProductDAO(){
        this.connection = new JDBCConectivity();
    }

    @Override
    public Product getElement(int productId) {
        Product product = new Product();
        String query = "SELECT * FROM Product WHERE id_product = " + productId;

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            if(resultSet.next()){
                product.setIdProduct(resultSet.getInt("id_product"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getFloat("price"));
                product.setSupplierId(resultSet.getInt("supplier_id_supplier"));

            } else {
                System.out.println("The id provided does not exist");
            }


        } catch (SQLException e) {
            System.out.println("Error getting element: " + e.getMessage());
        }

        return product;
    }

    @Override
    public List<Product> getAllElements(){
        List<Product> productList = new ArrayList<>();

        return productList;
    }

    @Override
    public void insertElement(Product product){

        String query = "INSERT INTO Product (description, price, supplier_id_supplier) VALUES ('"
                + product.getDescription() + "', "
                + product.getPrice() + ", "
                + product.getSupplierId() + ")";

        System.out.println(query);

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }



    @Override
    public void updateElement(Product product){

    }

    @Override
    public void deleteElement(int productId){

    }

}
