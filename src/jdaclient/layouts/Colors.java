package jdaclient.layouts;

import jdaclient.Main;
import jdaclient.panels.Chat;

import java.awt.*;

public class Colors {

    public static boolean darkmode = true;

    public static Color background;
    public static Color components;
    public static Color components1;
    public static Color components2;
    public static Color hover;

    public Colors() {
        background = Color.decode("#2F3136");
        components = Color.decode("#36393F");
        components1 = Color.decode("#202225");
        components2 = Color.decode("#99AAB5");
        hover = Color.decode("#4d525b");
    }

    public static void update() {
        if(!darkmode) {
            background = Color.decode("#F5F5F5");
            components = Color.decode("#D8D8D8");
            components1 = Color.decode("#ECECEC");
            components2 = Color.decode("#676767");
            hover = Color.decode("#BFBFBF");
        }
        else {
            new Colors();
        }
        Chat.update();
        Main.update();
    }
}
