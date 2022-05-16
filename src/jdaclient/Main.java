package jdaclient;

import jdaclient.layouts.Colors;
import jdaclient.listener.ActionHandler;
import jdaclient.panels.Chat;

import javax.swing.*;
import java.awt.*;

public class Main {

    static String title = "JDA Client";

    public static JFrame frame;

    public static Font menuFont;
    public static Font menuItemFont;

    public static JMenuBar menu;

    public static JMenu bot;

    public static JMenu appearance;
    public static JMenu theme;
    public static JMenuItem dark;
    public static JMenuItem light;

    public static JMenu language;

    public static JMenu window;

    public static JMenu logout;

    public static void main(String[] args) {
        new Colors();
        frame();
    }

    public static void frame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setContentPane(new Chat());
        frame.setSize(new Dimension(750, 500));
        frame.setMinimumSize(new Dimension(750, 500));
        frame.pack();
        frame.setVisible(true);


        menuFont = new Font(Font.DIALOG, Font.PLAIN, 20);
        menuItemFont = new Font(Font.DIALOG, Font.PLAIN, 16);

        menu = new JMenuBar();

        //bot
        bot = new JMenu("Bot");
        bot.setFont(menuFont);

        //appearance
        appearance = new JMenu("Appearance");
        appearance.setFont(menuFont);

        theme = new JMenu("Theme");
        theme.setFont(menuItemFont);

        dark = new JMenuItem("Dark");
        dark.setFont(menuItemFont);
        dark.addActionListener(new ActionHandler());

        light = new JMenuItem("Light");
        light.setFont(menuItemFont);
        light.addActionListener(new ActionHandler());

        //language
        language = new JMenu("Language");
        language.setFont(menuFont);

        //window
        window = new JMenu("Window");
        window.setFont(menuFont);

        //logout
        logout = new JMenu("Logout");
        logout.setFont(menuFont);
        logout.addActionListener(new ActionHandler());


        menu.add(bot);

        theme.add(dark);
        theme.add(light);
        appearance.add(theme);
        menu.add(appearance);

        menu.add(language);

        menu.add(window);

        menu.add(logout);

        frame.setJMenuBar(menu);
    }

    public static void update() {

    }
}
