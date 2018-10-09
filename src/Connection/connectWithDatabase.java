package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectWithDatabase {

    public static Connection getConnection(){
        // ten driver + url db
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/dictionary?autoReconnect=true&useSSL=false";

        //username + password
        final String user = "root";
        final String password = "23041999";
        try{
            Class.forName(JDBC_DRIVER);

            return DriverManager.getConnection(url, user, password);
        }
        catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
