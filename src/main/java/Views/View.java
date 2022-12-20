package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Arrays;

public class View {
    private JFrame frame;
    private Box box;

    public View() throws IOException {
        frame = new JFrame();
        box = new Box(BoxLayout.Y_AXIS);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("QUIZ APP");
        frame.setVisible(true);
    }

    public void closeView(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    public void addPanel(JPanel panel){
        this.box.add(Box.createVerticalGlue());
        this.box.add(panel);
        this.box.add(Box.createVerticalGlue());
        this.frame.add(box);
        this.frame.pack();
        this.frame.setSize(600, 500);
    }

    public void clearView(){
        this.box.removeAll();
    }

    public void showMessageDialog(String text){
        JOptionPane.showMessageDialog(this.frame, text);
    }


}
