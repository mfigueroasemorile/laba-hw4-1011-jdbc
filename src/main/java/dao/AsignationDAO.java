package dao;

import jdbc.JDBCConectivity;
import model.Asignation;
import model.Contract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AsignationDAO implements IDao<Asignation> {

    private JDBCConectivity connection;

    public AsignationDAO(){
        this.connection = new JDBCConectivity();
    }

    @Override
    public Asignation getElement(int employeeId) {
        Asignation asignation = new Asignation();
        String query = "SELECT * FROM Asignation WHERE Employee_id_employee = \"" + employeeId + "\"";

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            if(resultSet.next()){
                asignation.setProjectId(resultSet.getInt("Project_id_project"));
                asignation.setEmployeeId(resultSet.getInt("Employee_id_employee"));
                asignation.setAsignationDate(resultSet.getDate("asignation_date"));

            } else {
                System.out.println("The id provided does not exist");
            }


        } catch (SQLException e) {
            System.out.println("Error getting element: " + e.getMessage());
        }

        return asignation;
    }

    @Override
    public List<Asignation> getAllElements(){
        List<Asignation> asignationList = new ArrayList<>();

        return asignationList;
    }

    @Override
    public void insertElement(Asignation asignation){

        String query = "INSERT INTO Asignation () VALUES ()";
        System.out.println(query);

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }



    @Override
    public void updateElement(Asignation asignation){

    }

    @Override
    public void deleteElement(int employeeId){

    }
}
