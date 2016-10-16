package view.TableFrame;

import model.TableModel.TableModelProduct;
import view.Dialog.AddDialogProduct;
import view.Dialog.FindDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductTableFrame extends JFrame {

    private static final int DEFAULT_HEIGHT = 600;
    private static final int DEFAULT_WIDHT = 800;

    private JFrame jFrame;
    private TableModelProduct tableModelProduct;
    private AddDialogProduct addDialogProduct;
    private FindDialog findDialog;
    private JButton addButton;
    private JButton deleteButton;
    private JButton renameButton;
    private Box buttonBox;

    public ProductTableFrame() {
        this.setTitle("Product Table");
        this.setSize(DEFAULT_WIDHT, DEFAULT_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        jFrame = this;

        createButton();
        replaceButton(this);

        tableModelProduct = new TableModelProduct();
        JTable table = new JTable(tableModelProduct);
        table.setPreferredSize(new Dimension(800, 600));
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(400, 300));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jScrollPane);

        addDialogProduct = new AddDialogProduct(this, tableModelProduct);
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
                addDialogProduct.setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialog = new FindDialog(jFrame, tableModelProduct, "Delete");
                findDialog.setVisible(true);
            }
        });
        renameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialog = new FindDialog(jFrame, tableModelProduct, "Rename");
                findDialog.setVisible(true);
            }
        });
    }
}
