package main;

import dao.EmployeeDAO;
import dao.ProjectDAO;
import jdbc.JDBCConectivity;
import menu.GeneralMenu;
import model.Employee;
import model.Project;
import xsd.SAXValidator;

public class Main {
    public static void main(String[] args) {

        GeneralMenu menu = new GeneralMenu();
        menu.displayGeneralMenu();

    }
}