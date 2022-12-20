package Views;

import Controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class GameView {

    private final JLabel scoreLabel;
    private final TextNote contentLabel;
    private final JButton answerA;
    private final JButton answerB;
    private final JButton answerC;
    private final JButton answerD;
    private String correctAnswer;
    private int score;

    public GameView() throws IOException {

        // Create panel to hold components
        JPanel panel = new JPanel(new GridLayout(0 ,2));

        contentLabel = new TextNote("Miejsce na tresc");
        panel.add(contentLabel);

        score = 0;
        scoreLabel = new JLabel("Twój aktualny wynik: ");
        panel.add(scoreLabel);


        answerA = new JButton("AnswerA");
        answerA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer("A");
            }
        });
        panel.add(answerA);

        answerB = new JButton("AnswerB");
        answerB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer("B");
            }
        });
        panel.add(answerB);

        answerC = new JButton("AnswerC");
        answerC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer("C");
            }
        });
        panel.add(answerC);

        answerD = new JButton("AnswerD");
        answerD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer("D");
            }
        });
        panel.add(answerD);

        setNewQuestion();
        Controller.changeView(panel);
    }

    public void setNewQuestion(){
        HashMap<String, String> question = Controller.getQuestion();
        scoreLabel.setText("Twój aktualny wynik: " + score);
        correctAnswer = question.get("correctAnswer");
        contentLabel.setText(question.get("content"));
        answerA.setLabel("A: " + question.get("answerA"));
        answerB.setLabel("B: " + question.get("answerB"));
        answerC.setLabel("C: " + question.get("answerC"));
        answerD.setLabel("D: " + question.get("answerD"));
    }

    private void checkAnswer(String answer){
        if (answer.equals(correctAnswer)){
            score++;
            setNewQuestion();
        }
        else{
            Controller.showMessageDialog("Przegrałeś :(  Poprawną odpowiedzą było "+ correctAnswer);
            Controller.addResult(score);
            try {
                Controller.backToMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class TextNote extends JTextArea {
        public TextNote(String text) {
            super(text);
            setBackground(null);
            setEditable(false);
            setBorder(null);
            setLineWrap(true);
            setWrapStyleWord(true);
            setFocusable(false);
        }
    }
}
