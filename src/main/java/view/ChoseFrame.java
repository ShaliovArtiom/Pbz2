package view;


import controller.MysqlOption;
import view.Dialog.ChoseOptionDialog;
import view.TableFrame.KombinatTableFrame;
import view.TableFrame.PriceTableFrame;
import view.TableFrame.ProductTableFrame;
import view.TableFrame.ScladTableFrame;

import javax.swing.*;
import javax.swing.text.BoxView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoseFrame extends JFrame {

    private static final int DEFAULT_HEIGHT = 250;
    private static final int DEFAULT_WIDHT = 250;

    private ChoseOptionDialog choseOptionDialog;

    private Box buttonBox;
    private JButton priceButton;
    private JButton kombinatButton;
    private JButton productButton;
    private JButton scladButton;
    private JButton optionOfTable;

    public ChoseFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chose");
        this.setSize(DEFAULT_WIDHT, DEFAULT_HEIGHT);
        createButton();
        replaceButton(this);
        this.setVisible(true);

        MysqlOption.getInstance().readTable(1);
        MysqlOption.getInstance().readTable(2);
        MysqlOption.getInstance().readTable(3);
        MysqlOption.getInstance().readTable(4);

        choseOptionDialog = new ChoseOptionDialog(this);
    }

    private void replaceButton(JFrame frame) {
        buttonBox = Box.createVerticalBox();
        buttonBox.add(productButton);
        buttonBox.add(Box.createVerticalStrut(15));
        buttonBox.add(kombinatButton);
        buttonBox.add(Box.createVerticalStrut(15));
        buttonBox.add(scladButton);
        buttonBox.add(Box.createVerticalStrut(15));
        buttonBox.add(priceButton);
        buttonBox.add(Box.createVerticalStrut(15));
        buttonBox.add(optionOfTable);
        buttonBox.add(Box.createVerticalStrut(15));
        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);
        panel.add(buttonBox, BoxView.CENTER);
    }

    private void createButton() {
        productButton = new JButton("Показать таблицу 'продукт'");
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductTableFrame();
            }
        });
        kombinatButton = new JButton("Показать таблицу 'комбинат'");
        kombinatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KombinatTableFrame();
            }
        });
        scladButton = new JButton("Показать таблицу 'склад'");
        scladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScladTableFrame();
            }
        });
        priceButton = new JButton("Показать таблицу 'закупка'");
        priceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PriceTableFrame();
            }
        });
        optionOfTable = new JButton("Действия на таблицах");
        optionOfTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choseOptionDialog.setVisible(true);
            }
        });
    }
}
