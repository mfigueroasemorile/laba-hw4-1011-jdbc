package main;

import dao.EmployeeDAO;
import dao.ProjectDAO;
import jdbc.JDBCConectivity;
import model.Employee;
import model.Project;

public class Main {
    public static void main(String[] args) {

        System.out.println("Before statement");
        ProjectDAO projectDAO = new ProjectDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = new Employee();
        employee.setName("Maxi");
        employee.setAddress("Olaya");
        employee.setRoleId(1);
        employee.setContractId(2);
        employee.setGender("Male");
        employeeDAO.insertElement(employee);

       /* Project newProject = new Project();

        newProject.setManagerName("Lucas");
        newProject.setAddress("123 Some randome ave");
        newProject.setProjectTypeId(2);
        newProject.setClientId(2);

        projectDAO.insertElement(newProject);
        System.out.println("New project inserted succesfully");*/

        Project proj = projectDAO.getElement(6);
        System.out.println(proj.toString());
    }
}