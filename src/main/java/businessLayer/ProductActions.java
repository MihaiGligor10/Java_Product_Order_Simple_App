package businessLayer;

import Model.Clients;
import Model.Products;
import connection.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Gligor Mihai
 */
public class ProductActions {

    protected static final Logger LOGGER = Logger.getLogger(ProductActions.class.getName());
    private static final String insert= "INSERT INTO products (name,quantity,price)" + " VALUES (?,?,?)";
    private static final String delete = "DELETE FROM products where idP = ?";
    private static final String edit = "UPDATE products SET name = ? , quantity=?,price=? WHERE idP =?";
    private static final String sql = "SELECT * FROM products WHERE idP = ? ";

    /**
     *
     * @param p
     */
    public static void insertProduct(Products p)
    {
        Connection conectIns = Connect.getConnection();
        PreparedStatement insertS = null;
        try {
            insertS = conectIns.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            insertS.setString(1, p.getName());
            insertS.setInt(2, p.getQuantity());
            insertS.setInt(3,p.getPrice());
            insertS.executeUpdate();
        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "insert " + e.getMessage());
        } finally {
            Connect.close(insertS);
            Connect.close(conectIns);
        }
    }
/*
    public static Products getProductQ(String id)
    {
        Connection conectG = Connect.getConnection();
        PreparedStatement insertG = null;
        try {
            insertG = conectG.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            insertG.setString(1, id);
            insertG.executeUpdate();
        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "get " + e.getMessage());
        } finally {
            Connect.close(insertG);
            Connect.close(conectG);
        }
        return ;
    }
  */
    public static Products getProductI(String id) throws Exception {
        Connection conn=Connect.getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "Select * From products WHERE idP="+id;
        ResultSet rst;
        rst = stm.executeQuery(sql);
        rst.next();
        Products p=new Products();
        p.setIdP(rst.getString("idP"));
        p.setName(rst.getString("name"));
        p.setQuantity(rst.getInt("quantity"));
        p.setPrice(rst.getInt("price"));
        return p;
    }

    /**
     *
     * @param p
     */

    public static void deleteProduct(Products p)
    {
        Connection conectDel = Connect.getConnection();
        PreparedStatement deleteS = null;
        try {
            deleteS = conectDel.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            deleteS.setString(1, p.getIdP());
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
     * @param p
     */
    public static void editProduct(Products p)
    {
        Connection conectEditP = Connect.getConnection();
        PreparedStatement editP = null;
        try {
            editP = conectEditP.prepareStatement(edit, Statement.RETURN_GENERATED_KEYS);

            editP.setString(1, p.getName());
            editP.setInt(2, p.getQuantity());
            editP.setInt(3, p.getPrice());
            editP.setString(4,p.getIdP());
            editP.executeUpdate();
        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "insert " + e.getMessage());
        } finally {
            Connect.close(editP);
            Connect.close(conectEditP);
        }
    }

    public static void editPQ(Products p,int q)
    {
        Connection conectEditP = Connect.getConnection();
        PreparedStatement editP = null;
        try {
            editP = conectEditP.prepareStatement(edit, Statement.RETURN_GENERATED_KEYS);

            editP.setString(1, p.getName());
            editP.setInt(2, q);
            editP.setInt(3, p.getPrice());
            editP.setString(4,p.getIdP());
            editP.executeUpdate();
        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "insert " + e.getMessage());
        } finally {
            Connect.close(editP);
            Connect.close(conectEditP);
        }
    }

}
