package businessLayer;

import GUI.OrderOP;
import Model.Orders;
import Model.Products;
import connection.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Gligor Mihai
 */

public class OrdersActions {

    protected static final Logger LOGGER = Logger.getLogger(ProductActions.class.getName());
    private static final String insert= "INSERT INTO orders (nameClient,nameProduct,quantity)" + " VALUES ((SELECT name FROM clients WHERE idC = ?),(SELECT name FROM products WHERE idP = ?),?)";

    /**
     *
     * @param o
     */

    public static void insertOrder(Orders o)
    {
        Connection conectO = Connect.getConnection();

        PreparedStatement insertO = null;
        //Products p = new Products();
        try {

            insertO = conectO.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            insertO.setString(1, o.getNameClient());
            insertO.setString(2, o.getNameProduct());
            insertO.setInt(3,o.getQuantity());
            insertO.executeUpdate();

        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "insert " + e.getMessage());
        } finally {
            Connect.close(insertO);
            Connect.close(conectO);
        }
    }



}
