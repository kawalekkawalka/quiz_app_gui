//package Views;
//
//import Controllers.Controller;
//import com.googlecode.lanterna.TerminalSize;
//import com.googlecode.lanterna.gui2.*;
//import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
//import org.json.simple.JSONArray;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.regex.Pattern;
//
//public class AddQuestionView {
//
//    private final TextBox content;
//    private final TextBox answerA;
//    private final TextBox answerB;
//    private final TextBox answerC;
//    private final TextBox answerD;
//    private final TextBox correctAnswer;
//
//    public AddQuestionView(){
//        Panel panel = new Panel(new GridLayout(2));
//        panel.addComponent(new Label("Wprowadż tu swoje pytanie:"));
//        panel.addComponent(new EmptySpace(new TerminalSize(0, 0)));
//
//        panel.addComponent(new Label("Treść pytania:"));
//        content = new TextBox(new TerminalSize(30, 3)).addTo(panel);
//        panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
//        panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
//        panel.addComponent(new Label("Odpowiedź A"));
//        answerA = new TextBox(new TerminalSize(20, 1)).addTo(panel);
//        panel.addComponent(new Label("Odpowiedź B"));
//        answerB = new TextBox(new TerminalSize(20, 1)).addTo(panel);
//        panel.addComponent(new Label("Odpowiedź C"));
//        answerC = new TextBox(new TerminalSize(20, 1)).addTo(panel);
//        panel.addComponent(new Label("Odpowiedź D"));
//        answerD = new TextBox(new TerminalSize(20, 1)).addTo(panel);
//        panel.addComponent(new Label("Poprawna odpowiedź (podaj literę)"));
//        correctAnswer = new TextBox(new TerminalSize(3, 1)).addTo(panel);
//        correctAnswer.setValidationPattern(Pattern.compile("[A-D]"));
//        new Button("Dodaj pytanie", new Runnable() {
//            @Override
//            public void run() {
//                sendQuestion();
//            }
//        }).addTo(panel);
//
//        new Button("Wróć do menu", new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Controller.backToMenu();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).addTo(panel);
//        Controller.changeView(panel);
//    }
//
//    private void sendQuestion(){
//        HashMap<String, String> question = new HashMap<String, String>();
//        if (correctAnswer.getText() == "" || content.getText() == "" ||
//                answerA.getText() == "" || answerB.getText() == "" ||
//                answerC.getText() == "" || answerD.getText() == ""){
//            Controller.showMessageDialog("Błąd tworzenia", "Jedno z pól jest puste. Spróbuj ponownie. ", MessageDialogButton.Retry);
//        }
//        else {
//            question.put("correctAnswer", correctAnswer.getText());
//            question.put("content", content.getText());
//            question.put("answerA", answerA.getText());
//            question.put("answerB", answerB.getText());
//            question.put("answerC", answerC.getText());
//            question.put("answerD", answerD.getText());
//            Controller.addQuestion(question);
//            Controller.showMessageDialog(" ", "Pytanie zostało dodane do bazy. ", MessageDialogButton.Continue);
//            try {
//                Controller.backToMenu();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
