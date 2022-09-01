package jdaclient.panels;

import jdaclient.layouts.Colors;
import jdaclient.listener.ActionHandler;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

import static jdaclient.JDA.*;

public class Chat extends JPanel implements Runnable {

    public static JPanel chatPanel;

    static Font textFont;
    static Border border;

    public static Thread thread;

    static JPanel sideBarPanel;

    static JPanel serverSelectorPanel;
    public static JComboBox serverList;
    public static List<Guild> serverListArray;
    public static String[] serverString;
    public static JComboBox serverChannelList;
    public static List<GuildChannel> serverChannelListArray;
    public static JComboBox serverMemberList;

    static JPanel activateButtonPanel;
    public static JButton activateButton;
    static JLabel nameLabel;
    public static String name;
    static JLabel statusLabel;
    public static String status;

    static JPanel textPanel;
    public static JTextField textField;

    public Chat() {
        textFont = new Font(Font.DIALOG, Font.PLAIN, 16);
        border = BorderFactory.createLineBorder(Colors.components2, 1);

        setLayout(new BorderLayout(0, 0));
        //setBorder(new EmptyBorder(10, 10, 10, 10));

        //background Panel
        chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout(5,5));
        chatPanel.setBorder(new EmptyBorder(20,15,20,15));
        chatPanel.setPreferredSize(new Dimension(750,500));
        chatPanel.setBackground(Colors.background);

        //sideBar
        sideBarPanel = new JPanel();
        sideBarPanel.setLayout(new BorderLayout(5,5));
        sideBarPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        sideBarPanel.setPreferredSize(new Dimension(200, chatPanel.getHeight()));
        sideBarPanel.setBackground(Colors.components1);

        serverSelectorPanel = new JPanel();
        serverSelectorPanel.setLayout(null);
        serverSelectorPanel.setPreferredSize(new Dimension(170,92));
        serverSelectorPanel.setBackground(null);

        serverList = new JComboBox();
        serverList.setBounds(0, 0, 170, 30);
        serverList.setFont(textFont);
        serverList.setOpaque(true);
        serverList.setBorder(border);
        serverList.setBackground(Colors.components);
        serverList.setForeground(Colors.components2);
        serverList.setFocusable(false);
        serverList.addActionListener(new ActionHandler());

        activateButtonPanel = new JPanel();
        activateButtonPanel.setLayout(null);
        activateButtonPanel.setPreferredSize(new Dimension(170,50));
        activateButtonPanel.setBackground(null);

        activateButton = new JButton("activateButton");
        activateButton.setBounds(120, 0, 50, 50);
        activateButton.setFont(textFont);
        activateButton.setOpaque(true);
        activateButton.setText("Off");
        activateButton.setBorder(null);
        activateButton.setBorderPainted(false);
        activateButton.setBackground(Colors.components);
        activateButton.setForeground(Colors.components2);
        activateButton.setFocusable(false);
        activateButton.addActionListener(new ActionHandler());

        startThread();

        nameLabel = new JLabel();
        nameLabel.setText(name);
        nameLabel.setBounds(0, 0, 100, 25);

        statusLabel = new JLabel();
        statusLabel.setText(status);
        statusLabel.setBounds(0, 25, 100, 25);

        //textField Panel
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout(5,0));
        textPanel.setBorder(new EmptyBorder(5, 10, 5, 10));
        textPanel.setPreferredSize(new Dimension(chatPanel.getWidth(),40));
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

        sideBarPanel.add(serverSelectorPanel, BorderLayout.NORTH);
        serverSelectorPanel.add(serverList);

        sideBarPanel.add(activateButtonPanel, BorderLayout.SOUTH);
        activateButtonPanel.add(activateButton);
        activateButtonPanel.add(nameLabel);
        activateButtonPanel.add(statusLabel);

        chatPanel.add(textPanel, BorderLayout.SOUTH);

        add(sideBarPanel, BorderLayout.EAST);
        add(chatPanel, BorderLayout.CENTER);
    }

    public static void repaintComponents() {
        chatPanel.setBackground(Colors.background);

        textPanel.setBackground(Colors.components);

        textField.setForeground(Colors.components2);
        textField.setCaretColor(Colors.components2);
    }

    public static void update() {
        if(shardMan != null) {
            name = shardMan.getSelfUser().getAsTag();

            if (shardMan.getPresence().getActivity() != null) {
                status = shardMan.getPresence().getActivity().getName();
            } else {
                status = "EMPTY";
            }
        }
        else {
            name = "undefined#0000";
            status = "undefined";
        }

        nameLabel.setText(name);
        statusLabel.setText(status);
    }

    public void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while(thread != null) {
            update();

            try {
                thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
