package jdaclient;

import jdaclient.layouts.Colors;
import jdaclient.listener.ActionHandler;
import jdaclient.panels.Chat;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.Arrays;

public class Main {

    static String title = "JDA Client";

    public static JFrame frame;

    public static Font menuFont;
    public static Font menuItemFont;

    public static JMenuBar menu;
    public static JMenu bot;
    public static JMenuItem setup;
    public static JMenu settings;
    public static JMenu appearance;
    public static JMenu theme;
    public static JMenuItem dark;
    public static JMenuItem light;
    public static JMenu language;
    public static JMenu window;
    public static JMenu server;

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

        UIManager.put("PopupMenu.background", Colors.components);
        UIManager.put("PopupMenu.border", null);
        UIManager.put("PopupMenu.borderPainted", false);

        UIManager.put("MenuBar.background", Colors.components);
        UIManager.put("MenuBar.foreground", Colors.components2);
        UIManager.put("MenuBar.border", null);
        UIManager.put("MenuBar.opaque", true);

        UIManager.put("Menu.font", menuFont);
        UIManager.put("Menu.background", Colors.components);
        UIManager.put("Menu.foreground", Colors.components2);
        UIManager.put("Menu.border", null);
        UIManager.put("Menu.opaque", true);
        UIManager.put("Menu.selectionBackground", Colors.hover);
        UIManager.put("Menu.selectionForeground", Colors.components2);

        UIManager.put("MenuItem.font", menuItemFont);
        UIManager.put("MenuItem.background", Colors.components);
        UIManager.put("MenuItem.foreground", Colors.components2);
        UIManager.put("MenuItem.border", null);
        UIManager.put("MenuItem.borderPainted", false);
        UIManager.put("MenuItem.opaque", true);

        menu = new JMenuBar();
        menu.setBorderPainted(false);

        //bot
        bot = new JMenu("Bot");
        setup = new JMenuItem("Setup");
        setup.addActionListener(new ActionHandler());
        //setup.setBorderPainted(false);

        //bot.getPopupMenu().setBackground(Colors.components);
        //bot.getPopupMenu().setBorderPainted(false);

        //settings
        settings = new JMenu("Settings");

        //appearance
        appearance = new JMenu("Appearance");
        theme = new JMenu("Theme");
        dark = new JMenuItem("Dark");
        dark.addActionListener(new ActionHandler());
        light = new JMenuItem("Light");
        light.addActionListener(new ActionHandler());

        //language
        language = new JMenu("Language");

        //window
        window = new JMenu("Window");

        //server
        server = new JMenu("Server");


        bot.add(setup);
        menu.add(bot);

        theme.add(dark);
        theme.add(light);
        appearance.add(theme);
        settings.add(appearance);
        settings.add(language);
        settings.add(window);
        menu.add(settings);

        frame.setJMenuBar(menu);
    }

    public static void update() {
        /*menu.setBackground(Colors.components);
        menu.setForeground(Colors.components2);

        bot.setBackground(Colors.components);
        bot.setForeground(Colors.components2);

        setup.setBackground(Colors.components);
        setup.setForeground(Colors.components2);

        settings.setBackground(Colors.components);
        settings.setForeground(Colors.components2);

        appearance.setBackground(Colors.components);
        appearance.setForeground(Colors.components2);

        theme.setBackground(Colors.components);
        theme.setForeground(Colors.components2);

        dark.setBackground(Colors.components);
        dark.setForeground(Colors.components2);

        light.setBackground(Colors.components);
        light.setForeground(Colors.components2);

        language.setBackground(Colors.components);
        language.setForeground(Colors.components2);

        window.setBackground(Colors.components);
        window.setForeground(Colors.components2);*/

        SwingUtilities.updateComponentTreeUI(menu);
        SwingUtilities.updateComponentTreeUI(frame);
    }
}
