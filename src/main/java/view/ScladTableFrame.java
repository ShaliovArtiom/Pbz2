package view;


import controller.MysqlOption;
import model.TableModelPrice;
import model.TableModelSclad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScladTableFrame extends JFrame {

    private static final int DEFAULT_HEIGHT = 600;
    private static final int DEFAULT_WIDHT = 800;

    private AddDialogSclad addDialogSclad;

    private JButton addButton;
    private JButton deleteButton;
    private Box buttonBox;

    public ScladTableFrame(){
        this.setTitle("Sclad Table");
        this.setSize(DEFAULT_WIDHT, DEFAULT_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        createButton();
        replaceButton(this);

        TableModelSclad tableModelSclad = new TableModelSclad();
        JTable table = new JTable(tableModelSclad);
        table.setPreferredSize(new Dimension(800, 600));
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(400, 300));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jScrollPane);

        addDialogSclad = new AddDialogSclad(this, tableModelSclad);
        initListeners();

    }

    private void replaceButton(JFrame frame) {
        buttonBox = Box.createVerticalBox();
        buttonBox.add(addButton);
        buttonBox.add(Box.createVerticalStrut(10));
        buttonBox.add(deleteButton);

        JPanel panel = new JPanel();
        panel.add(buttonBox);
        frame.add(panel, BorderLayout.EAST);
    }

    private void createButton() {
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
    }


    private void initListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialogSclad.setVisible(true);
            }
        });
    }
}
