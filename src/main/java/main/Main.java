package main;

import dao.ProjectDAO;
import jdbc.JDBCConectivity;
import model.Project;

public class Main {
    public static void main(String[] args) {
        System.out.println("Before inserting");

        ProjectDAO projectDAO = new ProjectDAO();

        Project newProject = new Project();

        newProject.setManagerName("MIRSE");
        newProject.setAddress("123 Boulevard ave");
        newProject.setProjectTypeId(2);
        newProject.setClientId(2);

        projectDAO.insertElement(newProject);

        System.out.println("New project inserted succesfully");
    }
}