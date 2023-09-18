package GUI;

import Model.Clients;
import Model.Orders;
import connection.Connect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Gligor Mihai
 */
public class OrderOP extends JFrame {

    private JPanel contentPane;
    private JTextField cantitate;
    private JTextField idProdus;
    private JTextField idClient;
    private JButton btnNewButton;
    private JButton OrderBtn;


    /**
     *
     * @param mview
     */
    public OrderOP(MainOpView mview) {
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 240);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        cantitate = new JTextField();
        cantitate.setBounds(300, 69, 86, 39);
        contentPane.add(cantitate);
        cantitate.setColumns(10);

        JLabel cant = new JLabel("Cantitate");
        cant.setBounds(300, 30, 86, 14);
        contentPane.add(cant);

        idProdus = new JTextField();
        idProdus.setColumns(10);
        idProdus.setBounds(164, 69, 86, 39);
        contentPane.add(idProdus);

        idClient = new JTextField();
        idClient.setColumns(10);
        idClient.setBounds(38, 69, 86, 39);
        contentPane.add(idClient);

        JLabel IDpr = new JLabel("ID Produs");
        IDpr.setBounds(164, 30, 86, 14);
        contentPane.add(IDpr);

        JLabel IDcl = new JLabel("ID Client");
        IDcl.setBounds(38, 30, 46, 14);
        contentPane.add(IDcl);

        btnNewButton = new JButton("View Orders");
        btnNewButton.setBounds(223, 134, 163, 45);
        contentPane.add(btnNewButton);

        OrderBtn = new JButton("Order");
        OrderBtn.setBounds(38, 134, 163, 45);
        contentPane.add(OrderBtn);
    }

    public String getCantitate() {
        return cantitate.getText();
    }
    public String getIdProdus() {
        return idProdus.getText();
    }
    public String getIdClient() {
        return idClient.getText();
    }

    public JButton getBtnNewButton() {
        return btnNewButton;
    }
    public JButton getOrderBtn() {
        return OrderBtn;
    }
    public static void showError(String x) {
        JOptionPane.showMessageDialog(null,x);
    }
    /**
     *
     * @return
     * @throws Exception
     */
    public static ArrayList<Orders> getAllOrders() throws Exception {
        Connection conn= Connect.getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "Select * From orders";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Orders> ordersList = new ArrayList<>();
        while (rst.next()) {
             Orders order = new Orders(rst.getString("idO"), rst.getString("nameClient"), rst.getString("nameProduct"),Integer.parseInt(rst.getString("quantity")));
            ordersList.add(order);
        }
        return ordersList;
    }

}