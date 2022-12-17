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
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(new JLabel("Wprowadż tu swoją nazwę użytkownika:"));
        JTextField usernameField = new JTextField();
        usernameField.setColumns(20);
        panel.add(usernameField);

        JButton button = new JButton("Kontynuuj");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(button.getText() == ""){
                    System.out.println("niefajnie");
                }
                else{
                    showMessageDialog("Musisz wprowadzić nazwę użytkownika!");
                }
            }
        });
        panel.add(button);

        Controller.changeView(panel);
    }
}
