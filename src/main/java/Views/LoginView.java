package Views;

import Controllers.Controller;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;

import java.io.IOException;

public class LoginView {
    public LoginView(){
        Panel panel = new Panel();
        panel.addComponent(new Label("Wprowadż tu swoją nazwę użytkownika:"));
        TextBox username = new TextBox(new TerminalSize(35, 1)).addTo(panel);
        new Button("Kontynuuj", new Runnable() {
            @Override
            public void run() {
                if(username.getText() == ""){
                    Controller.showMessageDialog("Błąd logowania", "Musisz wprowadzić nazwę użytkownika. ", MessageDialogButton.Retry);
                }
                else{
                    try {
                        Controller.setGame(username.getText());
                        Controller.backToMenu();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).addTo(panel);

        Controller.changeView(panel);
    }
}
