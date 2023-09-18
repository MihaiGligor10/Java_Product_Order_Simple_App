package GUI;

import Model.Clients;
import Model.Orders;
import Model.Products;
import connection.Connect;

import javax.swing.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static businessLayer.ClientsActions.*;
import static businessLayer.OrdersActions.insertOrder;
import static businessLayer.ProductActions.*;
import static reflection.Reflection.retrieveTable;

public class Controller {
    private MainOpView Mview;
    private ClientOP cop;
    private ProductOP pop;
    private OrderOP oop;


    public Controller(MainOpView Mview) {
        this.Mview = Mview;


        this.Mview.getClientOP().addActionListener(e -> {

                ClientOP COP = new ClientOP(Mview);
                COP.setVisible(true);
                this.cop = COP;

                this.cop.getAddC().addActionListener(e1 -> {
                    Clients c = new Clients(cop.getNumeIC(), cop.getAdressIC());
                    insertClient(c);
                });

                this.cop.getDeleteC().addActionListener(e1 -> {
                  Clients c = new Clients(cop.getIdC());
                  deleteClient(c);
                });

                this.cop.getEditC().addActionListener(e1 -> {
                  Clients c = new Clients(cop.getIdcE(),cop.getNumeE(),cop.getAdressE());
                  editClient(c);
                });

            this.cop.getViewC().addActionListener(e1 -> {
                ViewClients view = null;
                try {
                    view = new ViewClients(retrieveTable(ClientOP.getAllCustomer(),new Clients()));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                view.setVisible(true);

            });



        });

        this.Mview.getProductOp().addActionListener(e -> {

            ProductOP POP = new ProductOP(Mview);
            POP.setVisible(true);
            this.pop = POP;

            this.pop.getAddP().addActionListener(e1 -> {
                Products p = new Products(pop.getNumeP(), Integer.parseInt(pop.getCantitateP()) , Integer.parseInt(pop.getPretP()));
                insertProduct(p);
            });

            this.pop.getDeleteP().addActionListener(e1 -> {
                Products p = new Products(pop.getIdP());
                deleteProduct(p);
            });

            this.pop.getEditP().addActionListener(e1 -> {
                Products p = new Products(pop.getIdcEP(), pop.getNumeEP(), Integer.parseInt(pop.getCantitateEP()) , Integer.parseInt(pop.getPretEP()));
                editProduct(p);
            });

            this.pop.getViewP().addActionListener(e1 -> {
                ViewClients view = null;
                try {
                    view = new ViewClients(retrieveTable(ProductOP.getAllProducts(),new Products()));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                view.setVisible(true);

            });

        });

        this.Mview.getProductOrders().addActionListener(e -> {

            OrderOP OOP = new OrderOP(Mview);
            OOP.setVisible(true);
            this.oop=OOP;


            this.oop.getOrderBtn().addActionListener(e1 -> {

                Orders o = new Orders(oop.getIdClient(),oop.getIdProdus(),Integer.parseInt(oop.getCantitate()));

                 try {
                     Products p=new Products();
                     p=getProductI(oop.getIdProdus());
                     if(Integer.parseInt(oop.getCantitate())>p.getQuantity())
                     {
                         OrderOP.showError("Stock insuficient");
                     }else
                     {
                        editPQ(p,p.getQuantity()-Integer.parseInt(oop.getCantitate()));
                         insertOrder(o);
                         FileWriter myWriter = new FileWriter("bll.txt");
                         myWriter.write(o.toString());
                         myWriter.close();

                     }



                } catch (Exception exception) {
                    exception.printStackTrace();
                }


            });

            this.oop.getBtnNewButton().addActionListener(e1 -> {
                ViewClients view = null;
                try {
                    view = new ViewClients(retrieveTable(OrderOP.getAllOrders(),new Orders()));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                view.setVisible(true);

            });

        });



    }
    File myObj = new File("bll.txt");



}


