package Views;

import Controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class LeaderboardView {
    public LeaderboardView(LinkedHashMap<String, Integer> top5){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Najlepsi z najlepszych:");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        for (Map.Entry<String, Integer> entry :
                top5.entrySet()) {
            JLabel label = new JLabel(entry.getValue() + " - " + entry.getKey());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(label);
        }

        JLabel userLabel = new JLabel("");
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        if(Controller.checkUserScore() == 0){
            userLabel.setText("Nie odpowiedziałeś jeszcze na żadne pytanie.");
        }
        else{
            userLabel.setText("Twój najlepszy wynik to " + Controller.checkUserScore() + " poprawnych odpowiedzi z rzędu.");
        }
        panel.add(userLabel);

        JButton backButton = new JButton("Wróć do menu");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Controller.backToMenu();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(backButton);

        Controller.changeView(panel);

    }
}
