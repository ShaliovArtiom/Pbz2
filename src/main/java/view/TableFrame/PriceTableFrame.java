package view.TableFrame;

import model.TableModel.TableModelPrice;
import view.Dialog.AddDialogPrice;
import view.Dialog.FindDialog;
import view.Dialog.RenameDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PriceTableFrame extends JFrame{

    private static final int DEFAULT_HEIGHT = 600;
    private static final int DEFAULT_WIDHT = 800;

    private JFrame jFrame;
    private TableModelPrice tableModelPrice;
    private FindDialog findDialog;
    private AddDialogPrice addDialogPrice;
    private RenameDialog renameDialog;
    private JButton addButton;
    private JButton deleteButton;
    private JButton renameButton;
    private Box buttonBox;

    public PriceTableFrame() {
        this.setTitle("Price Table");
        this.setSize(DEFAULT_WIDHT, DEFAULT_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        jFrame = this;

        createButton();
        replaceButton(this);

        tableModelPrice = new TableModelPrice();
        JTable table = new JTable(tableModelPrice);
        table.setPreferredSize(new Dimension(800, 600));
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(400, 300));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jScrollPane);

        addDialogPrice = new AddDialogPrice(this, tableModelPrice);
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
                addDialogPrice.setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialog = new FindDialog(jFrame, tableModelPrice, "Delete");
                findDialog.setVisible(true);
            }
        });
        renameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialog = new FindDialog(jFrame, tableModelPrice, "Rename");
                findDialog.setVisible(true);
            }
        });
    }
}
