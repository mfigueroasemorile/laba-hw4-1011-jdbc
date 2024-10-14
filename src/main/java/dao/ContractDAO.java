package dao;

import jdbc.JDBCConectivity;
import model.Contract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContractDAO implements IDao<Contract>{

    private JDBCConectivity connection;

    public ContractDAO(){
        this.connection = new JDBCConectivity();
    }

    @Override
    public Contract getElement(int idContract) {
        Contract contract = new Contract();
        String query = "SELECT * FROM Contract WHERE id_contract = " + idContract;

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            if(resultSet.next()){
                contract.setIdContract(resultSet.getInt("id_contract"));
                contract.setStartDate(resultSet.getDate("start_date"));
                contract.setSalary(resultSet.getFloat("salary"));
                contract.setHoursPerWeek(resultSet.getInt("hours_per_week"));


            } else {
                System.out.println("The id provided does not exist");
            }


        } catch (SQLException e) {
            System.out.println("Error getting element: " + e.getMessage());
        }

        return contract;
    }

    @Override
    public List<Contract> getAllElements(){
        List<Contract> contractList = new ArrayList<>();

        return contractList;
    }

    @Override
    public void insertElement(Contract contract){

        String query = "INSERT INTO Contract () VALUES ()";
        System.out.println(query);

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }



    @Override
    public void updateElement(Contract contract){

    }

    @Override
    public void deleteElement(int contractId){

    }
}
