package Views;

import Controllers.Controller;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class LeaderboardView {
    public LeaderboardView(LinkedHashMap<String, Integer> top5){
        Panel panel = new Panel();
        panel.addComponent(new Label("Najlepsi z najlepszych:"));
        panel.addComponent(new EmptySpace(new TerminalSize(0, 0)));

        for (Map.Entry<String, Integer> entry :
                top5.entrySet()) {
            panel.addComponent(new Label(entry.getValue() + " - " + entry.getKey()));
        }

        Label userLabel = new Label("");

        if(Controller.checkUserScore() == 0){
            userLabel.setText("Nie odpowiedziałeś jeszcze na żadne pytanie.");
        }
        else{
            userLabel.setText("Twój najlepszy wynik to " + Controller.checkUserScore() + " poprawnych odpowiedzi z rzędu.");
        }
        panel.addComponent(userLabel);

        new Button("OK", new Runnable() {
            @Override
            public void run() {
                try {
                    Controller.backToMenu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).addTo(panel);

        Controller.changeView(panel);

    }
}
