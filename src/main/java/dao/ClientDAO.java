package dao;

import jdbc.JDBCConectivity;
import model.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements IDao<Client>{

    private JDBCConectivity connection;

    public ClientDAO(){
        this.connection = new JDBCConectivity();
    }

    @Override
    public Client getElement(int clientId) {
        Client client = new Client();
        String query = "SELECT * FROM Client WHERE id_client = \"" + clientId + "\"";

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            if(resultSet.next()){
                client.setIdClient(resultSet.getInt("id_client"));
                client.setName(resultSet.getString("name"));

            } else {
                System.out.println("The id provided does not exist");
            }


        } catch (SQLException e) {
            System.out.println("Error getting element: " + e.getMessage());
        }

        return client;
    }

    @Override
    public List<Client> getAllElements(){
        List<Client> clientList = new ArrayList<>();

        return clientList;
    }

    @Override
    public void insertElement(Client client){

        String query = "INSERT INTO Client () VALUES ()";
        System.out.println(query);

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }



    @Override
    public void updateElement(Client client){

    }

    @Override
    public void deleteElement(int idClient){

    }
}
