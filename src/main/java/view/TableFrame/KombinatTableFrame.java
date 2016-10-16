package view.TableFrame;

import model.TableModel.TableModelKombinat;
import view.Dialog.AddDialogKombinat;
import view.Dialog.FindDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KombinatTableFrame extends JFrame {

    private static final int DEFAULT_HEIGHT = 600;
    private static final int DEFAULT_WIDHT = 800;

    private JFrame jFrame;
    private TableModelKombinat tableModelKombinat;
    private AddDialogKombinat addDialogKombinat;
    private FindDialog findDialog;
    private JButton addButton;
    private JButton deleteButton;
    private JButton renameButton;
    private Box buttonBox;

    public KombinatTableFrame() {
        this.setTitle("Kombinat Table");
        this.setSize(DEFAULT_WIDHT, DEFAULT_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        jFrame = this;

        createButton();
        replaceButton(this);

        tableModelKombinat = new TableModelKombinat();
        JTable table = new JTable(tableModelKombinat);
        table.setPreferredSize(new Dimension(800, 600));
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(400, 300));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jScrollPane);

        addDialogKombinat = new AddDialogKombinat(this, tableModelKombinat);
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
                addDialogKombinat.setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialog = new FindDialog(jFrame, tableModelKombinat, "Delete");
                findDialog.setVisible(true);
            }
        });
        renameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialog = new FindDialog(jFrame, tableModelKombinat, "Rename");
                findDialog.setVisible(true);
            }
        });
    }
}
