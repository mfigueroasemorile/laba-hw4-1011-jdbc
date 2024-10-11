package jdbc;

import constants.Credentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConectivity {

    public Connection getConnection() throws SQLException {

        Connection conn = null;
        String url = Credentials.URL;
        String user = Credentials.USER;
        String password = Credentials.PASSWORD;

        Properties prop = new Properties();
        prop.put("user",user);
        prop.put("password", password);


        return DriverManager.getConnection(url,prop);
    }
}
