package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConectivity {

    public Connection getConnection() throws SQLException {

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/BuildingCompany";
        String user = "root";
        String password = "Loreto18";

        Properties prop = new Properties();
        prop.put("user",user);
        prop.put("password", password);


        return DriverManager.getConnection(url,prop);
    }
}
