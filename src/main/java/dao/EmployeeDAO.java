package dao;

import jdbc.JDBCConectivity;
import model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IDao<Employee> {

    private JDBCConectivity connection;

    public EmployeeDAO(){
        this.connection = new JDBCConectivity();
    }

    @Override
    public Employee getElement(int idEmloyee) {
        Employee employee = new Employee();
        String query = "SELECT * FROM Employee WHERE id_employee = " + idEmloyee;

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            if(resultSet.next()){
                employee.setIdEmployee(resultSet.getInt("id_employee"));
                employee.setName(resultSet.getString("name"));
                employee.setAddress(resultSet.getString("address"));
                employee.setRoleId(resultSet.getInt("Role_id_role"));
                employee.setContractId(resultSet.getInt("Contract_id_contract"));

            } else {
                System.out.println("The idEmployee provided does not exist");
            }


        } catch (SQLException e) {
            System.out.println("Error getting employee: " + e.getMessage());
        }

        return employee;
    }

    @Override
    public List<Employee> getAllElements(){
        List<Employee> employeeList = new ArrayList<>();

        return employeeList;
    }

    @Override
    public void insertElement(Employee employee){

        String query = "INSERT INTO Employee (name, address, Role_id_role, Contract_id_contract, gender) VALUES (\"" + employee.getName() + "\", \"" + employee.getAddress() + "\", " +
                employee.getRoleId() + ", " + employee.getContractId() + ", \"" + employee.getGender()+ "\")";
        System.out.println(query);

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }



    @Override
    public void updateElement(Employee employee){

    }

    @Override
    public void deleteElement(int employeeId){

    }
}
