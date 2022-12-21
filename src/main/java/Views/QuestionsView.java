package Views;

import Controllers.Controller;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class QuestionsView {
    public QuestionsView(List<HashMap<String, String>> questions){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JTextArea questionIndex;

        panel.add(new JLabel("Podaj indeks pytania do edycji"));
        questionIndex = new JTextArea();
        panel.add(questionIndex);

        JButton editButton = new JButton("Edytuj wybrane pytanie");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.editQuestionMenu(Integer.parseInt(questionIndex.getText()));
            }
        });
        editButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(editButton);
        panel.add(new JLabel());
        panel.add(new JLabel());

        JTableButtonModel model = new JTableButtonModel();
        TableCellRenderer tableRenderer;

// Create a couple of columns
        model.addColumn("Indeks pytania");
        model.addColumn("Treść pytania");
        //model.addColumn("Edytuj pytanie");

// Append a row
        for (int i =0; i < questions.size(); i++){
//            JButton button = new JButton("Edytuj pytanie");
//            button.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    Controller.addQuestionMenu();
//                }
//            });
//            button.setAlignmentX(Component.CENTER_ALIGNMENT);

            model.addRow(new Object[]{i, questions.get(i).get("content")});
        }
        JTable table = new JTable(model);
        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        JScrollPane scroll_table = new JScrollPane(table);            // add table to scroll panel
        scroll_table.setBounds(5, 10, 300, 150);
        scroll_table.setVisible(true);
        panel.add(scroll_table);

        JButton backButton = new JButton("Wróć do menu");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
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

    class JTableButtonRenderer implements TableCellRenderer {
        private TableCellRenderer defaultRenderer;
        public JTableButtonRenderer(TableCellRenderer renderer) {
            defaultRenderer = renderer;
        }
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if(value instanceof Component)
                return (Component)value;
            return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
    class JTableButtonModel extends DefaultTableModel {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
        public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    }
}
