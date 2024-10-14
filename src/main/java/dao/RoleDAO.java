package dao;

import jdbc.JDBCConectivity;
import model.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IDao<Role>{

    private JDBCConectivity connection;

    public RoleDAO(){
        this.connection = new JDBCConectivity();
    }

    @Override
    public Role getElement(int idRole) {
        Role role = new Role();
        String query = "SELECT * FROM Role WHERE id_role = " + idRole;

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement();
             ResultSet resultSet = st.executeQuery(query)) {
            if(resultSet.next()){
                role.setIdRole(resultSet.getInt("id_role"));
                role.setDescription(resultSet.getString("description"));


            } else {
                System.out.println("The idRole provided does not exist");
            }


        } catch (SQLException e) {
            System.out.println("Error getting role: " + e.getMessage());
        }

        return role;
    }

    @Override
    public List<Role> getAllElements(){
        List<Role> roleList = new ArrayList<>();

        return roleList;
    }

    @Override
    public void insertElement(Role role){

        String query = "INSERT INTO Role () VALUES ()";
        System.out.println(query);

        try (Connection conn = connection.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }



    @Override
    public void updateElement(Role role){

    }

    @Override
    public void deleteElement(int roleId){

    }


}
