package jdaclient.listener;

import jdaclient.layouts.Colors;
import jdaclient.panels.Chat;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static jdaclient.Main.*;
import static jdaclient.panels.Chat.*;

public class ActionHandler implements ActionListener {

    static JOptionPane setupPane;
    static JLabel applicationIDLabel;
    static JTextField applicationID;
    static JLabel botTokenLabel;
    static JTextField botToken;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == textField) {
            System.out.println(textField.getText());
            textField.setText("");
        }

        if (e.getSource() == setup) {
            applicationIDLabel = new JLabel("Application ID");
            applicationIDLabel.setForeground(Colors.components2);

            applicationID = new JTextField();
            applicationID.setBackground(Colors.components);
            applicationID.setBorder(null);
            applicationID.setForeground(Colors.components2);
            applicationID.setCaretColor(Colors.components2);

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

            Object[] inputFields = {applicationIDLabel, applicationID, botTokenLabel, botToken};
            setupPane = new JOptionPane(inputFields, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            setupPane.createDialog(new Chat(), "Bot Setup").setVisible(true);

            if(setupPane.getOptionType() == JOptionPane.OK_OPTION) {
                JDABuilder builder = JDABuilder.createDefault(botToken.getText());
                try {
                    builder.build();
                } catch (LoginException ex) {
                    ex.printStackTrace();
                }
            };
        }

        if (e.getSource() == dark) {
            Colors.darkmode = true;
            Colors.update();
        }
        if (e.getSource() == light) {
            Colors.darkmode = false;
            Colors.update();
        }
    }
}
