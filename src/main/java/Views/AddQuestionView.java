package Views;

import Controllers.Controller;
import org.json.simple.JSONArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

public class AddQuestionView {

    private final JTextArea content;
    private final JTextArea answerA;
    private final JTextArea answerB;
    private final JTextArea answerC;
    private final JTextArea answerD;
    private final JTextArea correctAnswer;

    public AddQuestionView(){
        JPanel panel = new JPanel(new GridLayout(0 ,2));
        panel.add(new JLabel("Wprowadż tu swoje pytanie:"));
        panel.add(new JLabel());

        panel.add(new JLabel("Treść pytania:"));
        content = new JTextArea();
        panel.add(content);
        content.setRows(2);
        content.setLineWrap(true);
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Odpowiedź A"));
        answerA = new JTextArea();
        panel.add(answerA);
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Odpowiedź B"));
        answerB = new JTextArea();
        panel.add(answerB);
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Odpowiedź C"));
        answerC = new JTextArea();
        panel.add(answerC);
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Odpowiedź D"));
        answerD = new JTextArea();
        panel.add(answerD);
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Poprawna odpowiedź (podaj literę)"));
        correctAnswer = new JTextArea();
        correctAnswer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String answer = correctAnswer.getText();
                if(answer.length() > 1){
                    correctAnswer.setText(answer.substring(0, 1));
                }
                else if(answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D")){
                }
                else{
                    correctAnswer.setText("");
                }

            }
        });
        panel.add(correctAnswer);

        JButton addButton = new JButton("Dodaj pytanie");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendQuestion();
            }
        });
        panel.add(addButton);

        JButton backButton = new JButton("Wróć do menu");
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

    private void sendQuestion(){
        HashMap<String, String> question = new HashMap<String, String>();
        if (correctAnswer.getText().equals("")  || content.getText().equals("") ||
                answerA.getText().equals("") || answerB.getText().equals("") ||
                answerC.getText().equals("") || answerD.getText().equals("")){
            Controller.showMessageDialog("Jedno z pól jest puste. Spróbuj ponownie. ");
        }
        else {
            question.put("correctAnswer", correctAnswer.getText());
            question.put("content", content.getText());
            question.put("answerA", answerA.getText());
            question.put("answerB", answerB.getText());
            question.put("answerC", answerC.getText());
            question.put("answerD", answerD.getText());
            Controller.addQuestion(question);
            Controller.showMessageDialog("Pytanie zostało dodane do bazy. ");
            try {
                Controller.backToMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
