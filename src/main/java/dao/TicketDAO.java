package dao;

import jdbc.JDBCConectivity;
import model.Product;
import model.Ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO implements IDao<Ticket>{

    private JDBCConectivity connection;

    public TicketDAO(){
        this.connection = new JDBCConectivity();
    }

    @Override
    public Ticket getElement(int ticketId) {
        Ticket ticket = new Ticket();
        String query = "SELECT * FROM Ticket WHERE id_product = " + ticketId;

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            if(resultSet.next()){
                ticket.setIdTicket(resultSet.getInt("id_ticket"));
                ticket.setDate(resultSet.getDate("date"));
                ticket.setTotal(resultSet.getFloat("total"));

            } else {
                System.out.println("The id provided does not exist");
            }


        } catch (SQLException e) {
            System.out.println("Error getting element: " + e.getMessage());
        }

        return ticket;
    }

    @Override
    public List<Ticket> getAllElements(){
        List<Ticket> ticketList = new ArrayList<>();

        return ticketList;
    }

    @Override
    public void insertElement(Ticket ticket){

        String query = "INSERT INTO Ticket () VALUES ()";
        System.out.println(query);

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }



    @Override
    public void updateElement(Ticket ticket){

    }

    @Override
    public void deleteElement(int ticketId){

    }
}
