package businessLayer;

import Model.Clients;
import connection.Connect;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Gligor Mihai
 */

public class ClientsActions {


    protected static final Logger LOGGER = Logger.getLogger(ClientsActions.class.getName());
    private static final String insert= "INSERT INTO clients (name, adress)" + " VALUES (?, ?)";
    private static final String delete = "DELETE FROM clients where idC = ?";
    private static final String edit = "UPDATE clients SET name = ? , adress=? WHERE idC=?";

    /**
     *
     * @param c
     */
    public static void insertClient(Clients c)
    {

        Connection conectIns = Connect.getConnection();
        PreparedStatement insertS = null;
        try {
            insertS = conectIns.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            insertS.setString(1, c.getName());
            insertS.setString(2, c.getAdress());
            insertS.executeUpdate();
        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "insert " + e.getMessage());
        } finally {
            Connect.close(insertS);
            Connect.close(conectIns);
        }
    }


    /**
     *
     * @param c
     */
    public static void deleteClient(Clients c)
    {
        Connection conectDel = Connect.getConnection();
        PreparedStatement deleteS = null;
        try {
            deleteS = conectDel.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            deleteS.setString(1, c.getName());
            deleteS.executeUpdate();
        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "delete " + e.getMessage());
        } finally {
            Connect.close(deleteS);
            Connect.close(conectDel);
        }
    }

    /**
     *
     * @param c
     */
    public static void editClient(Clients c)
    {
        Connection conectEdit = Connect.getConnection();
        PreparedStatement editS = null;
        try {
            editS = conectEdit.prepareStatement(edit, Statement.RETURN_GENERATED_KEYS);

            editS.setString(1, c.getName());
            editS.setString(2, c.getAdress());
            editS.setString(3, c.getIdC());
            editS.executeUpdate();
        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "insert " + e.getMessage());
        } finally {
            Connect.close(editS);
            Connect.close(conectEdit);
        }
    }

}
