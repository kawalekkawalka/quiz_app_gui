package Controllers;
import Views.*;
import Models.*;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class Controller {
    public static View view;
    public static Game game;

    public Controller() throws IOException {
        view = new View();
        new LoginView();
    }

    public static void changeView(JPanel panel) {
        view.clearView();
        view.addPanel(panel);
    }

    public static void setGame(String username) {
        game = new Game(username);
    }

    public static void startGame() throws IOException {
        new GameView();
    }

    public static void backToMenu() throws IOException {
        new MenuView();
    }

    public static void addQuestionMenu(){
        new AddQuestionView();
    }

    public static void showLeaderboard(){
        new LeaderboardView(game.getTop5());
    }

    public static void addQuestion(HashMap<String, String> question){
        Questions.addQuestion(question);
    }

    public static void closeApp(){
        view.closeView();
    }

    public static HashMap<String, String> getQuestion(){
        return Questions.getQuestion();
    }

    public static void showMessageDialog(String text){
        view.showMessageDialog(text);
    }

    public static void addResult(int score){
        game.addResult(score);
    }

    public static int checkUserScore(){
        return game.checkUserScore();
    }

}
