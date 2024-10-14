package dao;

import jdbc.JDBCConectivity;
import model.ProjectType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectTypeDAO implements IDao<ProjectType>{

    private JDBCConectivity connection;

    public ProjectTypeDAO(){
        this.connection = new JDBCConectivity();
    }

    @Override
    public ProjectType getElement(int projectTypeId) {
        ProjectType projectType = new ProjectType();
        String query = "SELECT * FROM ProjectType WHERE id_type = \"" + projectTypeId + "\"";

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            if(resultSet.next()){
                projectType.setId_type(resultSet.getInt("id_type"));
                projectType.setDescription(resultSet.getString("description"));

            } else {
                System.out.println("The id provided does not exist");
            }


        } catch (SQLException e) {
            System.out.println("Error getting element: " + e.getMessage());
        }

        return projectType;
    }

    @Override
    public List<ProjectType> getAllElements(){
        List<ProjectType> projectTypeList = new ArrayList<>();

        return projectTypeList;
    }

    @Override
    public void insertElement(ProjectType projectType){

        String query = "INSERT INTO ProjectType () VALUES ()";
        System.out.println(query);

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }



    @Override
    public void updateElement(ProjectType projectType){

    }

    @Override
    public void deleteElement(int projectTypeId){

    }
}
