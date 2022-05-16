package jdaclient.layouts;

import jdaclient.panels.Chat;

import java.awt.*;

public class Colors {

    public static boolean darkmode = true;

    public static Color background;
    public static Color components;
    public static Color components1; //dark
    public static Color components2; //light

    public Colors() {
        background = Color.decode("#2F3136");
        components = Color.decode("#36393F");
        components1 = Color.decode("#202225");
        components2 = Color.decode("#99AAB5");
    }

    public static void update() {
        if(!darkmode) {
            background = Color.decode("#F5F5F5");
            components = Color.decode("#ECECEC");
            components1 = Color.decode("#D8D8D8");
            components2 = Color.decode("#676767");
        }
        else {
            new Colors();
        }
        Chat.update();
    }
}
