package Views;

import Controllers.Controller;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class GameView {

    private final Label scoreLabel;
    private final Label contentLabel;
    private final Button answerA;
    private final Button answerB;
    private final Button answerC;
    private final Button answerD;
    private String correctAnswer;
    private int score;

    public GameView() throws IOException {

        // Create panel to hold components
        Panel panel = new Panel(new GridLayout(2));
        panel.addComponent(new EmptySpace(new TerminalSize(0, 0)));
        score = 0;
        scoreLabel = new Label("Twój aktualny wynik: ");
        panel.addComponent(scoreLabel);

        contentLabel = new Label("Miejsce na tresc");
        contentLabel.setPreferredSize(new TerminalSize(40, 4));
        panel.addComponent(contentLabel);
        panel.addComponent(new EmptySpace(new TerminalSize(0, 2)));

        answerA = new Button("AnswerA", new Runnable() {
            @Override
            public void run() {
                checkAnswer("A");
            }
        });

        answerB = new Button("AnswerB", new Runnable() {
            @Override
            public void run() {
                checkAnswer("B");
            }
        });

        answerC = new Button("AnswerC", new Runnable() {
            @Override
            public void run() {
                checkAnswer("C");
            }
        });

        answerD = new Button("AnswerD", new Runnable() {
            @Override
            public void run() {
                checkAnswer("D");
            }
        });

        panel.addComponent(answerA);
        panel.addComponent(answerB);
        panel.addComponent(answerC);
        panel.addComponent(answerD);
        setNewQuestion();
        Controller.changeView(panel);
    }

    public void setNewQuestion(){
        HashMap<String, String> question = Controller.getQuestion();
        scoreLabel.setText("Twój aktualny wynik: " + score);
        correctAnswer = question.get("correctAnswer");
        contentLabel.setText(question.get("content"));
        answerA.setLabel(question.get("answerA"));
        answerB.setLabel(question.get("answerB"));
        answerC.setLabel(question.get("answerC"));
        answerD.setLabel(question.get("answerD"));
    }

    private void checkAnswer(String answer){
        if (answer.equals(correctAnswer)){
            score++;
            setNewQuestion();
        }
        else{
            Controller.showMessageDialog("Przegrana ","Przegrałeś :(  Poprawną odpowiedzą było "+ correctAnswer, MessageDialogButton.Continue);
            Controller.addResult(score);
            try {
                Controller.backToMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
