package jdaclient.panels;

import jdaclient.Main;
import jdaclient.layouts.Colors;
import jdaclient.listener.ActionHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Chat extends JPanel {

    public static JPanel background;


    static Font textFont;

    static JPanel chatPanel;
    static JTextPane chatField;

    static JPanel textPanel;
    public static JTextField textField;

    public Chat() {
        setLayout(new BorderLayout(5, 5));
        //setBorder(new EmptyBorder(10, 10, 10, 10));

        //background Panel
        background = new JPanel();
        background.setLayout(new BorderLayout(5,5));
        background.setBorder(new EmptyBorder(20,15,20,15));
        background.setPreferredSize(new Dimension(750,500));
        background.setBackground(Colors.background);

        textFont = new Font(Font.DIALOG, Font.PLAIN, 16);

        //textField Panel
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout(5,0));
        textPanel.setBorder(new EmptyBorder(5, 10, 5, 10));
        textPanel.setPreferredSize(new Dimension(background.getWidth(),40));
        textPanel.setBackground(Colors.components);

        textField = new JTextField();
        textField.setFont(textFont);
        textField.setOpaque(false);
        textField.setBackground(null);
        textField.setBorder(null);
        textField.setForeground(Colors.components2);
        textField.setCaretColor(Colors.components2);
        textField.addActionListener(new ActionHandler());


        textPanel.add(textField);

        background.add(textPanel, BorderLayout.SOUTH);

        add(background);
    }

    public static void update() {
        background.setBackground(Colors.background);

        textPanel.setBackground(Colors.components);
        
        textField.setForeground(Colors.components2);
        textField.setCaretColor(Colors.components2);
    }
}
