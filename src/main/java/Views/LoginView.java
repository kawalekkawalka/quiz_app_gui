package Views;

import Controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static Controllers.Controller.showMessageDialog;

public class LoginView {
    public LoginView(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Wprowadż tu swoją nazwę użytkownika:");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        JTextField usernameField = new JTextField();
        usernameField.setMaximumSize(new Dimension(200, 20));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(usernameField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        JButton button = new JButton("Kontynuuj");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usernameField.getText().equals("")){
                    showMessageDialog("Musisz wprowadzić nazwę użytkownika!");
                }
                else{
                    try {
                        Controller.setGame(usernameField.getText());
                        Controller.backToMenu();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);
        Controller.changeView(panel);
    }
}
