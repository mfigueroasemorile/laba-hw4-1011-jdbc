package dao;


import jdbc.JDBCConectivity;
import model.ProjectType;
import model.Supplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO implements IDao<Supplier>{

    private JDBCConectivity connection;

    public SupplierDAO(){
        this.connection = new JDBCConectivity();
    }

    @Override
    public Supplier getElement(int supplierId) {
        Supplier supplier = new Supplier();
        String query = "SELECT * FROM supplier WHERE id_supplier = " + supplierId;

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            if(resultSet.next()){
                supplier.setIdSupplier(resultSet.getInt("id_supplier"));
                supplier.setName(resultSet.getString("name"));
                supplier.setDescription(resultSet.getString("description"));

            } else {
                System.out.println("The id provided does not exist");
            }


        } catch (SQLException e) {
            System.out.println("Error getting element: " + e.getMessage());
        }

        return supplier;
    }

    @Override
    public List<Supplier> getAllElements(){
        List<Supplier>supplierList = new ArrayList<>();

        return supplierList;
    }

    @Override
    public void insertElement(Supplier supplier){

        String query = "INSERT INTO supplier (name, description) VALUES ('"
                + supplier.getName() + "', '"
                + supplier.getDescription() + "')";

        System.out.println(query);

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }



    @Override
    public void updateElement(Supplier supplier){

    }

    @Override
    public void deleteElement(int supplierId){

    }
}
