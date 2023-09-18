package main;

import GUI.Controller;
import GUI.MainOpView;

import java.util.logging.Logger;

/**
 * @author Gligor Mihai
 */
public class Main {

    protected static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        MainOpView frame = new MainOpView();
        Controller controll = new Controller(frame);
        frame.setVisible(true);
    }
}
