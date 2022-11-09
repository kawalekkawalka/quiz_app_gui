package Views;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import Controllers.Controller;

public class MenuView {
    public MenuView() throws IOException {

        // Create panel to hold components
        Panel panel = new Panel();

        panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        new Button("Rozpocznij grę!", new Runnable() {
            @Override
            public void run() {
                try {
                    Controller.startGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).addTo(panel);

        panel.addComponent(new EmptySpace(new TerminalSize(0, 2)));
        new Button("Dodaj pytanie", new Runnable() {
            @Override
            public void run() {
                Controller.addQuestionMenu();
            }
        }).addTo(panel);

        panel.addComponent(new EmptySpace(new TerminalSize(0, 2)));
        new Button("Tabela wyników", new Runnable() {
            @Override
            public void run() {
                Controller.showLeaderboard();
            }
        }).addTo(panel);

        panel.addComponent(new EmptySpace(new TerminalSize(0, 2)));
        new Button("Wyjdź z gry", new Runnable() {
            @Override
            public void run() {
                Controller.closeApp();
            }
        }).addTo(panel);
        panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

        Controller.changeView(panel);
    }

}
