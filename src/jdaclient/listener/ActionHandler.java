package jdaclient.listener;

import jdaclient.layouts.Colors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static jdaclient.Main.*;
import static jdaclient.panels.Chat.*;

public class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == textField) {
            System.out.println(textField.getText());
            textField.setText("");
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
