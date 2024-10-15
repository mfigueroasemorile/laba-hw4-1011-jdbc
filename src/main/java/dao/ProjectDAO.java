package dao;

import jdbc.JDBCConectivity;
import model.Project;

import java.sql.Connection;
import java.sql.ResultSet;
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
        String query = "SELECT * FROM Project WHERE id_project = " + projectId;

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            if(resultSet.next()){
                project.setIdProject(resultSet.getInt("id_project"));
                project.setManagerName(resultSet.getString("manager_name"));
                project.setAddress(resultSet.getString("address"));
                project.setProjectTypeId(resultSet.getInt("ProjectType_id_type"));
                project.setClientId(resultSet.getInt("Client_id_client"));
                project.setEstimatedDuration(resultSet.getInt("estimated_duration"));
            } else {
                System.out.println("The idProject provided does not exist");
            }


        } catch (SQLException e) {
            System.out.println("Error getting projetct: " + e.getMessage());
        }

        return project;
    }

    @Override
    public List<Project> getAllElements(){
        List<Project> projectList = new ArrayList<>();

        String query = "SELECT * FROM Project";

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            while (resultSet.next()) {
                Project project = new Project();
                project.setIdProject(resultSet.getInt("id_project"));
                project.setManagerName(resultSet.getString("manager_name"));
                project.setAddress(resultSet.getString("address"));
                project.setProjectTypeId(resultSet.getInt("ProjectType_id_type"));
                project.setClientId(resultSet.getInt("Client_id_client"));
                project.setEstimatedDuration(resultSet.getInt("estimated_duration"));
                projectList.add(project);
            }
            if (projectList.isEmpty()) {
                System.out.println("There are no projects in db");
            }
        } catch (SQLException e) {
            System.out.println("Error getting projetct: " + e.getMessage());
        }

        return projectList;
    }

    @Override
    public void insertElement(Project project){

        String query = "INSERT INTO Project (manager_name, address, ProjectType_id_type, Client_id_client) " +
                "VALUES (\"" + project.getManagerName() + "\", \"" + project.getAddress() + "\", " +
                project.getProjectTypeId() + ", " + project.getClientId() + ")";

        System.out.println(query);
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
