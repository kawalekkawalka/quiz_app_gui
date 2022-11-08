package Controllers;
import Views.*;
import Models.*;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;

import java.io.IOException;
import java.util.HashMap;

public class Controller {
    public static View view;

    public Controller() throws IOException {
        view = new View();
        new MenuView();
    }

    public static void changeView(Panel panel) {
        view.addPanel(panel);
    }

    public static void startGame() throws IOException {
        new GameView();
    }

    public static void closeApp(){
        view.closeView();
    }

    public static HashMap<String, String> getQuestion(){
        return Questions.getQuestion();
    }

    public static void showMessageDialog(String title, String text, MessageDialogButton button){
        view.showMessageDialog(title, text, button);
    }
}
