package dao;

import jdbc.JDBCConectivity;
import model.Supplier;
import model.Ticket;
import model.TicketDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDetailDAO implements IDao<TicketDetail>{

    private JDBCConectivity connection;

    public TicketDetailDAO(){
        this.connection = new JDBCConectivity();
    }

    @Override
    public TicketDetail getElement(int supplierId) {
        TicketDetail ticketDetail = new TicketDetail();
        String query = "SELECT * FROM TicketDetail WHERE id_supplier = " + supplierId;

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            if(resultSet.next()){
                ticketDetail.setTicketId(resultSet.getInt("Ticket_id_ticket"));
                ticketDetail.setProductId(resultSet.getInt("Product_id_ticket"));

            } else {
                System.out.println("The id provided does not exist");
            }


        } catch (SQLException e) {
            System.out.println("Error getting element: " + e.getMessage());
        }

        return ticketDetail;
    }

    @Override
    public List<TicketDetail> getAllElements(){
        List<TicketDetail> ticketDetailList = new ArrayList<>();

        return ticketDetailList;
    }

    @Override
    public void insertElement(TicketDetail ticketDetail){

        String query = "INSERT INTO TicketDetail () VALUES ()";
        System.out.println(query);

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }



    @Override
    public void updateElement(TicketDetail ticketDetail){

    }

    @Override
    public void deleteElement(int ticketDetailId){

    }
}
