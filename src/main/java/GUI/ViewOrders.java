package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @author Gligor Mihai
 */
    public class ViewOrders extends JFrame {

        private JPanel contentPane;

        public ViewOrders(JTable t) {
           // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 470, 510);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblNewLabel = new JLabel("Orders");
            lblNewLabel.setBounds(140, 10, 60, 20);
            contentPane.add(lblNewLabel);

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(10, 50, 320, 350);
            contentPane.add(scrollPane);

            JTable table = t;
            scrollPane.setViewportView(table);
        }

    }

