package view;


import controller.MysqlOption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoseFrame extends JFrame {

    private static final int DEFAULT_HEIGHT = 250;
    private static final int DEFAULT_WIDHT = 250;

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
        panel.add(buttonBox,"CENTER");
    }

    private void createButton() {
        productButton = new JButton("Показать таблицу 'продукт'");
        kombinatButton = new JButton("Показать таблицу 'комбинат'");
        scladButton = new JButton("Показать таблицу 'склад'");
        scladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScladTableFrame();
            }
        });
        priceButton = new JButton("Показать таблицу 'закупка'");
        priceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PriceTableFrame();
            }
        });
        optionOfTable = new JButton("Действия на таблицах");
    }
}
