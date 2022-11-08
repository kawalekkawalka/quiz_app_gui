package Views;

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

public class View {
    private Terminal terminal;
    private Screen screen;
    private BasicWindow window;
    private MultiWindowTextGUI gui;

    public View() throws IOException {
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();
        window = new BasicWindow();
        window.setHints(Arrays.asList(Window.Hint.CENTERED));
    }

    public void closeView(){
        try {
            terminal.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPanel(Panel panel){
        this.window.setComponent(panel);
        // Create gui and start gui
        gui = new MultiWindowTextGUI(this.screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(this.window);
    }

    public void showMessageDialog(String title, String text, MessageDialogButton button){
        MessageDialog.showMessageDialog(gui, title, text, button);
    }


}
