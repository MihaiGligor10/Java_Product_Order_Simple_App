package GUI;

import Model.Clients;
import connection.Connect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Gligor Mihai
 */
public class ClientOP extends JFrame {

    private JPanel contentPane;
    private JButton AddC;
    private JButton EditC;
    private JButton DeleteC;
    private JButton ViewC;
    private JTextField numeIC;
    private JTextField adressIC;
    private JTextField idC;
    private JTextField numeE;
    private JTextField adressE;
    private JTextField idcE;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;


    /**
     *
     * @param mview
     */
    public ClientOP(MainOpView mview) {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 710, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        AddC = new JButton("Add Client");
        AddC.setBounds(10, 40, 190, 50);
        contentPane.add(AddC);

        EditC = new JButton("Edit Client");
        EditC.setBounds(10, 101, 190, 50);
        contentPane.add(EditC);

        DeleteC = new JButton("Delete Client");
        DeleteC.setBounds(10, 162, 190, 50);
        contentPane.add(DeleteC);

        ViewC = new JButton("View Clients");
        ViewC.setBounds(10, 223, 190, 50);
        contentPane.add(ViewC);

        numeIC = new JTextField();
        numeIC.setBounds(240, 48, 129, 35);
        contentPane.add(numeIC);
        numeIC.setColumns(10);

        adressIC = new JTextField();
        adressIC.setColumns(10);
        adressIC.setBounds(405, 48, 129, 35);
        contentPane.add(adressIC);

        idC = new JTextField();
        idC.setColumns(10);
        idC.setBounds(240, 169, 129, 36);
        contentPane.add(idC);

        idcE = new JTextField();
        idcE.setColumns(10);
        idcE.setBounds(240, 109, 129, 35);
        contentPane.add(idcE);

        numeE = new JTextField();
        numeE.setBounds(405, 109, 129, 35);
        contentPane.add(numeE);
        numeE.setColumns(10);

        adressE = new JTextField();
        adressE.setColumns(10);
        adressE.setBounds(555, 109, 129, 35);
        contentPane.add(adressE);

        lblNewLabel = new JLabel("Nume");
        lblNewLabel.setBounds(240, 23, 46, 14);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Adresa");
        lblNewLabel_1.setBounds(405, 23, 46, 14);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("ID");
        lblNewLabel_2.setBounds(240, 94, 46, 14);
        contentPane.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("Nume");
        lblNewLabel_3.setBounds(405, 94, 46, 14);
        contentPane.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("Adresa");
        lblNewLabel_4.setBounds(555, 94, 46, 14);
        contentPane.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("ID");
        lblNewLabel_5.setBounds(240, 155, 46, 14);
        contentPane.add(lblNewLabel_5);

    }


    public JButton getEditC() {
        return EditC;
    }

    public JButton getDeleteC() {
        return DeleteC;
    }

    public JButton getViewC() {
        return ViewC;
    }

    public JButton getAddC() {
        return AddC;
    }

    public String getNumeIC() {
        return numeIC.getText();
    }

    public String getIdC() {
        return (String) idC.getText();
    }

    public String getAdressIC() {
        return adressIC.getText();
    }

    public String getNumeE() {
        return numeE.getText();
    }

    public String getIdcE() {
        return (String) idcE.getText();
    }

    public String getAdressE() {
        return adressE.getText();
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static ArrayList<Clients> getAllCustomer() throws Exception {
        Connection conn=Connect.getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "Select * From Clients";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Clients> customerList = new ArrayList<>();
        while (rst.next()) {
            Clients customer = new Clients(rst.getString("idC"), rst.getString("name"), rst.getString("adress"));
            customerList.add(customer);
        }
        return customerList;
    }

}
