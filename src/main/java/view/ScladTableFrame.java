package view;


import model.TableModelPrice;
import model.TableModelSclad;
import view.Dialog.FindDialog;
import view.DialogSclad.AddDialogSclad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScladTableFrame extends JFrame {

    private static final int DEFAULT_HEIGHT = 600;
    private static final int DEFAULT_WIDHT = 800;

    private AddDialogSclad addDialogSclad;
    private JFrame frame;
    private TableModelSclad tableModelSclad;
    private FindDialog findDialog;
    private JButton addButton;
    private JButton deleteButton;
    private JButton renameButton;
    private Box buttonBox;

    public ScladTableFrame() {
        this.setTitle("Sclad Table");
        this.setSize(DEFAULT_WIDHT, DEFAULT_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.frame = this;

        tableModelSclad = new TableModelSclad();
        JTable table = new JTable(tableModelSclad);
        table.setPreferredSize(new Dimension(800, 600));
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(400, 300));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jScrollPane);

        createButton();
        replaceButton(this);

        addDialogSclad = new AddDialogSclad(this, tableModelSclad);
        initListeners();

    }

    private void replaceButton(JFrame frame) {
        buttonBox = Box.createVerticalBox();
        buttonBox.add(addButton);
        buttonBox.add(Box.createVerticalStrut(10));
        buttonBox.add(deleteButton);
        buttonBox.add(Box.createVerticalStrut(10));
        buttonBox.add(renameButton);

        JPanel panel = new JPanel();
        panel.add(buttonBox);
        frame.add(panel, BorderLayout.EAST);
    }

    private void createButton() {
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        renameButton = new JButton("Rename");
    }


    private void initListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialogSclad.setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialog = new FindDialog(frame, tableModelSclad, "Delete");
                findDialog.setVisible(true);
            }
        });
        renameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialog = new FindDialog(frame, tableModelSclad, "Rename");
                findDialog.setVisible(true);
            }
        });
    }
}
