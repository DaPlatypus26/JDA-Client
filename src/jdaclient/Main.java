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
    public static JMenu settings;
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
        menu.setBackground(Colors.components);
        menu.setBorderPainted(false);
        menu.setBorder(null);
        menu.setOpaque(true);

        //bot
        bot = new JMenu("Bot");
        bot.setFont(menuFont);
        bot.setBackground(Colors.components);
        bot.setForeground(Colors.components2);
        bot.setBorder(null);
        bot.setOpaque(true);

        //settings
        settings = new JMenu("Settings");
        settings.setFont(menuFont);
        settings.setBackground(Colors.components);
        settings.setForeground(Colors.components2);
        settings.setBorderPainted(false);
        settings.setBorder(null);
        settings.setOpaque(true);

        //appearance
        appearance = new JMenu("Appearance");
        appearance.setFont(menuFont);
        appearance.setBackground(Colors.components);
        appearance.setForeground(Colors.components2);
        appearance.setBorderPainted(false);
        appearance.setBorder(null);
        appearance.setOpaque(true);

        theme = new JMenu("Theme");
        theme.setFont(menuItemFont);
        theme.setBackground(Colors.components);
        theme.setForeground(Colors.components2);
        theme.setBorder(null);
        theme.setOpaque(true);

        dark = new JMenuItem("Dark");
        dark.setFont(menuItemFont);
        dark.addActionListener(new ActionHandler());
        dark.setBackground(Colors.components);
        dark.setForeground(Colors.components2);
        dark.setBorder(null);
        dark.setOpaque(true);

        light = new JMenuItem("Light");
        light.setFont(menuItemFont);
        light.addActionListener(new ActionHandler());
        light.setBackground(Colors.components);
        light.setForeground(Colors.components2);
        light.setBorder(null);
        light.setOpaque(true);

        //language
        language = new JMenu("Language");
        language.setFont(menuFont);
        language.setBackground(Colors.components);
        language.setForeground(Colors.components2);
        language.setBorder(null);
        language.setOpaque(true);

        //window
        window = new JMenu("Window");
        window.setFont(menuFont);
        window.setBackground(Colors.components);
        window.setForeground(Colors.components2);
        window.setBorder(null);
        window.setOpaque(true);

        //logout
        logout = new JMenu("Logout");
        logout.setFont(menuFont);
        logout.addActionListener(new ActionHandler());
        logout.setBackground(Colors.components);
        logout.setForeground(Colors.components2);
        logout.setBorder(null);
        logout.setOpaque(true);


        menu.add(bot);

        theme.add(dark);
        theme.add(light);
        appearance.add(theme);
        settings.add(appearance);
        settings.add(language);
        settings.add(window);
        menu.add(settings);

        menu.add(logout);

        frame.setJMenuBar(menu);
    }

    public static void update() {

    }
}
