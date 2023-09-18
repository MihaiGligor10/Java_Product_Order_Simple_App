package GUI;

import Model.Clients;
import Model.Products;
import connection.Connect;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @author Gligor Mihai
 */
public class ProductOP extends JFrame {

    private JPanel contentPane;
    private JButton AddP;
    private JButton EditP;
    private JButton DeleteP;
    private JButton ViewP;
    private JTextField numeP;
    private JTextField cantitateP;
    private JTextField idP;
    private JTextField pretP;
    private JTextField numeEP;
    private JTextField cantitateEP;
    private JTextField idcEP;
    private JTextField pretEP;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;

    /**
     *
     * @param mview
     */
    public ProductOP(MainOpView mview) {
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        AddP = new JButton("Add Product");
        AddP.setBounds(10, 40, 190, 50);
        contentPane.add( AddP);

        EditP = new JButton("Edit Product");
        EditP.setBounds(10, 101, 190, 50);
        contentPane.add(EditP);

        DeleteP = new JButton("Delete Product");
        DeleteP.setBounds(10, 162, 190, 50);
        contentPane.add(DeleteP);

        ViewP = new JButton("View Product");
        ViewP.setBounds(10, 223, 190, 50);
        contentPane.add(ViewP);

        numeP = new JTextField();
        numeP.setColumns(10);
        numeP.setBounds(240, 48, 129, 35);
        contentPane.add(numeP);


        cantitateP = new JTextField();
        cantitateP.setColumns(10);
        cantitateP.setBounds(390, 48, 129, 35);
        contentPane.add(cantitateP);

        pretP = new JTextField();
        pretP.setColumns(10);
        pretP.setBounds(550, 48, 129, 35);
        contentPane.add(pretP);

        idP = new JTextField();
        idP.setColumns(10);
        idP.setBounds(240, 169, 129, 36);
        contentPane.add(idP);

        idcEP = new JTextField();
        idcEP.setColumns(10);
        idcEP.setBounds(240, 109, 100, 35);
        contentPane.add(idcEP);

        numeEP = new JTextField();
        numeEP.setBounds(350, 109, 100, 35);
        contentPane.add(numeEP);
        numeEP.setColumns(10);

        cantitateEP = new JTextField();
        cantitateEP.setColumns(10);
        cantitateEP.setBounds(460, 109, 100, 35);
        contentPane.add(cantitateEP);

        pretEP = new JTextField();
        pretEP.setColumns(10);
        pretEP.setBounds(570, 109, 100, 35);
        contentPane.add(pretEP);

        lblNewLabel = new JLabel("Nume");
        lblNewLabel.setBounds(240, 35, 46, 14);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Cantitate");
        lblNewLabel_1.setBounds(390, 35, 55, 14);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Pret");
        lblNewLabel_2.setBounds(550, 35, 46, 14);
        contentPane.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("ID");
        lblNewLabel_3.setBounds(240, 89, 46, 14);
        contentPane.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("Nume");
        lblNewLabel_4.setBounds(350, 89, 46, 14);
        contentPane.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("Cantitate");
        lblNewLabel_5.setBounds(460, 89, 55, 14);
        contentPane.add(lblNewLabel_5);

        lblNewLabel_6 = new JLabel("Pret");
        lblNewLabel_6.setBounds(570, 89, 46, 14);
        contentPane.add(lblNewLabel_6);

        lblNewLabel_7 = new JLabel("ID");
        lblNewLabel_7.setBounds(240, 156, 46, 14);
        contentPane.add(lblNewLabel_7);
    }

    public JButton getEditP() {
        return EditP;
    }

    public JButton getDeleteP() {
        return DeleteP;
    }

    public JButton getViewP() {
        return ViewP;
    }

    public JButton getAddP() {
        return AddP;
    }

    public String getNumeP() {
        return numeP.getText();
    }

    public String getIdP() {
        return (String) idP.getText();
    }

    public String getCantitateP() {
        return cantitateP.getText();
    }

    public String getPretP() {
        return pretP.getText();
    }

    public String getNumeEP() {
        return numeEP.getText();
    }

    public String getIdcEP() {
        return (String) idcEP.getText();
    }

    public String getCantitateEP() {
        return cantitateEP.getText();
    }
    public String getPretEP() {
        return pretEP.getText();
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static ArrayList<Products> getAllProducts() throws Exception {
        Connection conn=Connect.getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "Select * From Products";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Products> prList = new ArrayList<>();
        while (rst.next()) {
            Products plist = new Products(rst.getString("idP"), rst.getString("name"), Integer.parseInt(rst.getString("quantity")),Integer.parseInt(rst.getString("price")));
            prList.add(plist);
        }
        return prList;
    }

}