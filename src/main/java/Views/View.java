package Views;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

public class View {
    private JFrame frame;

    public View() throws IOException {
        frame = new JFrame();
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("QUIZ APP");
        frame.setVisible(true);
    }

//    public void closeView(){
//        try {
//            terminal.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void addPanel(JPanel panel){
        this.frame.add(panel, BorderLayout.CENTER);
        this.frame.pack();
        this.frame.setSize(600, 500);
    }

    public void clearView(){
        this.frame.removeAll();
    }

    public void showMessageDialog(String text){
        JOptionPane.showMessageDialog(this.frame, text);
    }


}
