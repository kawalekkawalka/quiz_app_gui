package Views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import Controllers.Controller;

import javax.swing.*;

import static Controllers.Controller.showMessageDialog;

public class MenuView {
    public MenuView() throws IOException {

        // Create panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton gameButton = new JButton("Rozpocznij grę");
        gameButton.setMaximumSize(new Dimension(200, 40));
        gameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Controller.startGame();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        gameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(gameButton);
        panel.add(panel.add(Box.createRigidArea(new Dimension(0, 15))));

        JButton addQuestionButton = new JButton("Dodaj pytanie");
        addQuestionButton.setMaximumSize(new Dimension(200, 40));
        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.addQuestionMenu();
            }
        });
        addQuestionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(addQuestionButton);
        panel.add(panel.add(Box.createRigidArea(new Dimension(0, 15))));

        JButton editQuestionButton = new JButton("Edytuj pytanie");
        editQuestionButton.setMaximumSize(new Dimension(200, 40));
        editQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.QuestionsMenu();
            }
        });
        editQuestionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(editQuestionButton);
        panel.add(panel.add(Box.createRigidArea(new Dimension(0, 15))));

        JButton leaderboardButton = new JButton("Tabela wyników");
        leaderboardButton.setMaximumSize(new Dimension(200, 40));
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.showLeaderboard();
            }
        });
        leaderboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(leaderboardButton);
        panel.add(panel.add(Box.createRigidArea(new Dimension(0, 15))));

        JButton exitButton = new JButton("Wyjdź z gry");
        exitButton.setMaximumSize(new Dimension(200, 40));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.closeApp();
            }
        });
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(exitButton);

        Controller.changeView(panel);
    }

}
