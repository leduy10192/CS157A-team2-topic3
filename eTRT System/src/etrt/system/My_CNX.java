package etrt.system;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.DriverManager;
import java.util.Properties;
/**
 *
 * @author leduy
 */
//public class My_CNX {
//    
//    private static String servername = "localhost";
//    private static String username = "root";
//    private static String dbname = "users_db?autoReconnect=true&useSSL=false";
//    private static Integer portnumber = 3306;
//    private static String password="Aloha1999!";
//    
//    public static Connection getConnection()
//    {
//        Connection cnx = null;
//        
//        MysqlDataSource datasource = new MysqlDataSource();
//        datasource.setServerName(servername);
//        datasource.setUser(username);
//        datasource.setPassword(password);
//        datasource.setDatabaseName(dbname);
//        datasource.setPortNumber(portnumber);
//       
//        try {
//            
//            cnx = datasource.getConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger("Get Connection -> "+ My_CNX.class.getName()).log(Level.SEVERE, null, ex);
//        }
//          
//        return cnx;
//
//    }
//           
//}

public class My_CNX {
    // init database constants
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cs157?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "leduy";
    private static final String PASSWORD = "homework11";
    private static final String MAX_POOL = "250";

    // init connection object
    private static Connection connection;
    // init properties object
    private static Properties properties;

    // create properties
    private static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect database
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect database
    public static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


//Test connection
//public static void main (String args[]){
//            String url = "jdbc:mysql://localhost:3306/users_db";
//            String username = "root";
//            String password = "Aloha1999!";
//
//            System.out.println("Connecting database...");
//
//            try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Database connected!");
//            } catch (SQLException e) {
//                throw new IllegalStateException("Cannot connect the database!", e);
//            }
//        }