package view.Dialog;


import view.TableFrame.PriceScladTableFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoseOptionDialog  extends JDialog{

    private FindDateDialog findDateDialog;
    private JButton priceScladButton = new JButton("Просмотр закупочных и отпускных цен предприятий на заданную дату");
    private Box boxButton = Box.createVerticalBox();

    public ChoseOptionDialog(JFrame owner) {
        super(owner);
        this.setTitle("Chose dialog price");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        findDateDialog = new FindDateDialog(owner);

        replaseButton(this);
        initListeners();
    }

    private void replaseButton(JDialog dialog) {
        boxButton.add(priceScladButton);
        dialog.add(boxButton);
    }


    private void initListeners() {
        priceScladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDateDialog.setVisible(true);
            }
        });
    }
}
