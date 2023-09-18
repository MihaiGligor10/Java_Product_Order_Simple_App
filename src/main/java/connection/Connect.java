package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Gligor Mihai
 */
public class Connect {

    private static final Logger LOGGER = Logger.getLogger(Connect.class.getName());
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String DBurl = "jdbc:mysql://localhost:3306/ordersdb";
    private static final String user ="root";
    private static final String pass = "1234";

    private static Connect singleInstance = new Connect();


    private Connect(){
        try{
            Class.forName(driver);
           // singleInstance.createConnection();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    /**
     *
     * @return connection
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBurl, user, pass);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "eroare la conectare");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     *
     * @return
     */

    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     *
     * @param connection
     */
    public static void close(Connection connection)
    {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "eroare la inchiderea conexiunii");
            }
        }
    }


    /**
     *
     * @param statement
     */
    public static void close(Statement statement)
    {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "eroare la inchidere de statement");
            }
        }
    }

    /**
     *
     * @param resultSet
     */
    public static void close(ResultSet resultSet)
    {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "eroare la inchiderea result set");
            }
        }
    }
}
