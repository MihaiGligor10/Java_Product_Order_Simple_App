package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @author Gligor Mihai
 */
public class MainOpView extends JFrame {

    private JPanel contentPane;
    private JButton clientOP;
    private JButton productOp;
    private JButton productOrders;

    public MainOpView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 545, 260);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        clientOP = new JButton("Client Operations");
        clientOP.setBounds(10, 60, 156, 90);
        contentPane.add(clientOP);

        productOp = new JButton("Product Operations");
        productOp.setBounds(176, 60, 164, 90);
        contentPane.add(productOp);

        productOrders = new JButton("Order Products");
        productOrders.setBounds(350, 60, 163, 90);
        contentPane.add(productOrders);
    }

    public JButton getProductOrders() {
        return productOrders;
    }

    public JButton getProductOp() {
        return productOp;
    }

    public JButton getClientOP() {
        return clientOP;
    }

    public JButton getProductOrder() {
        return productOrders;
    }
}
