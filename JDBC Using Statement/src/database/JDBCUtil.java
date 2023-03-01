package database;
import com.mysql.jdbc.Driver;
import java.sql.DatabaseMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtil {
    private static Connection connection = null;

    // oppen database
    public static Connection getConnection() {
        try {
            //register
            DriverManager.registerDriver(new Driver());
            // chosse database
             final String url = "jdbc:mySQL://Localhost:3306/lythanhlong";
             final String userName = "root";
             final String password = "111201";
            // connect
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connect successfully !");
        } catch (SQLException e) {
            System.out.println("Connect failed !");
            throw new RuntimeException(e);
        }
        return connection;
    }

    // close database
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnect successfully!");
            } catch (SQLException e) {
                System.out.println("Disconnect failed !");
                throw new RuntimeException(e);
            }
        }
    }

    // show info tool and database
    public static void ShowAllInfo() {
        try {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println("Connection: "+metaData.getConnection());
                System.out.println(metaData.getDatabaseProductName());
                System.out.println("Version mySQL: "+metaData.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
