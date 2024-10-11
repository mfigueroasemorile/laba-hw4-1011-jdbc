package dao;

import jdbc.JDBCConectivity;
import model.Project;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO implements IDao<Project>{

    private JDBCConectivity connection;

    public ProjectDAO(){
        this.connection = new JDBCConectivity();
    }

    @Override
    public Project getElement(int projectId) {
        Project project = new Project();

        String query = "SELECT * FROM Project WHERE id = " + projectId;

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

        } catch (SQLException e) {
            System.out.println("Error getting projetct: " + e.getMessage());
        }

        return project;
    }

    @Override
    public List<Project> getAllElements(){
        List<Project> projectList = new ArrayList<>();

        return projectList;
    }

    @Override
    public void insertElement(Project project){

        String query = "INSERT INTO Project (manager_name, address, ProjectType_id_type, Client_id_client) " +
                "VALUES (\"" + project.getManagerName() + "\", \"" + project.getAddress() + "\", " +
                project.getProjectTypeId() + ", " + project.getClientId() + ")";

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }



    @Override
    public void updateElement(Project project){

    }

    @Override
    public void deleteElement(int projectId){

    }
}
