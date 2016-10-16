package view.Dialog;


import view.TableFrame.PriceScladTableFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoseOptionDialog  extends JDialog{

    private FindDateDialog findDateDialog;
    private FindNameDateDialog findNameDateDialog;
    private JButton priceScladButton = new JButton("Просмотр закупочных и отпускных цен предприятий на заданную дату");
    private JButton productScladPriceButton = new JButton("Просмотр динамики закупочных и отпускных цен на заданное наименование товара и за заданный промежуток времени");
    private Box boxButton = Box.createVerticalBox();

    public ChoseOptionDialog(JFrame owner) {
        super(owner);
        this.setTitle("Chose dialog price");
        this.setSize(800, 120);
        this.setLocationRelativeTo(null);
        findDateDialog = new FindDateDialog(owner);
        findNameDateDialog = new FindNameDateDialog(owner);

        replaseButton(this);
        initListeners();
    }

    private void replaseButton(JDialog dialog) {
        boxButton.add(priceScladButton);
        boxButton.add(Box.createVerticalStrut(15));
        boxButton.add(productScladPriceButton);

        JPanel panel = new JPanel();
        dialog.add(panel, BorderLayout.CENTER);
        panel.add(boxButton, "CENTER");
    }


    private void initListeners() {
        priceScladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDateDialog.setVisible(true);
            }
        });

        productScladPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findNameDateDialog.setVisible(true);
            }
        });
    }
}
