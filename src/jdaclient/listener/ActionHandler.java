package jdaclient.listener;

import jdaclient.JDA;
import jdaclient.layouts.Colors;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static jdaclient.Main.*;
import static jdaclient.JDA.*;
import static jdaclient.panels.Chat.*;

public class ActionHandler implements ActionListener {

    static JLabel botTokenLabel;
    static JTextField botToken;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == activateButton) {
            if(Objects.equals(activateButton.getText(), "On")) { //deactivates Bot
                stop();
                activateButton.setText("Off");
            } else if(Objects.equals(activateButton.getText(), "Off")) { //activates Bot
                if(shardMan != null) {
                    stop();
                }
                if(JDA.botToken != null) {
                    try {
                        build(JDA.botToken);
                    } catch (LoginException | InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    botToken.setText(JDA.botToken);

                    serverList();
                    activateButton.setText("On");
                }
            }
        }

        if (e.getSource() == textField) {
            System.out.println(textField.getText());
            textField.setText("");
        }

        if (e.getSource() == setup) {
            botTokenLabel = new JLabel("Bot Token");
            botTokenLabel.setForeground(Colors.components2);

            botToken = new JTextField();
            botToken.setBackground(Colors.components);
            botToken.setBorder(null);
            botToken.setForeground(Colors.components2);
            botToken.setCaretColor(Colors.components2);

            /*UIManager.put("OptionPane.background",Color.RED);
            UIManager.put("Panel.background",Color.RED);
            UIManager.put("Button.background",Color.RED);*/

            botToken.setText(JDA.botToken);

            Object[] inputFields = {botTokenLabel, botToken};
            int setupPane = JOptionPane.showConfirmDialog(null, inputFields, "Bot Setup", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if(setupPane == JOptionPane.OK_OPTION) {
                JDA.botToken = botToken.getText();
            }
        }

        if (e.getSource() == dark) {
            Colors.darkmode = true;
            Colors.updateColors();
        }
        if (e.getSource() == light) {
            Colors.darkmode = false;
            Colors.updateColors();
        }
    }
}
