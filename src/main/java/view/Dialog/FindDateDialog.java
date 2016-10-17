package view.Dialog;

import Storage.Storage;
import controller.MysqlOption;
import view.TableFrame.PriceScladTableFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindDateDialog  extends  JDialog{

    private JLabel dateLable = new JLabel("Введите дату:");
    private JTextField dateField = new JTextField(10);
    private JButton findButton = new JButton("Find");
    private java.sql.Date date;
    private Box optionBox = Box.createHorizontalBox();
    private Box boxButton = Box.createVerticalBox();

    public FindDateDialog(JFrame owner) {
        super(owner);
        this.setTitle("find dialog");
        this.setSize(200, 130);
        this.setLocationRelativeTo(null);
        replaceButton(this);
        initListener();
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            dateField.setText("");
        }else{Storage.getIstance().getPriceScladList().clear();}
        super.setVisible(visible);
    }

    private void replaceButton(JDialog dialog) {
        boxButton.add(dateLable);
        boxButton.add(dateField);
        optionBox.add(findButton);
        boxButton.add(Box.createVerticalStrut(10));
        boxButton.add(optionBox);

        JPanel panel = new JPanel();
        panel.add(boxButton);
        dialog.add(panel, BorderLayout.CENTER);
    }

    private void initListener() {

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date = java.sql.Date.valueOf(dateField.getText());
                MysqlOption.getInstance().makePriceScladTableSQL(date);
                new PriceScladTableFrame();
                setVisible(false);
            }
        });
    }
}
