package view.Dialog;

import Storage.Storage;
import controller.MysqlOption;
import view.TableFrame.PriceScladTableFrame;
import view.TableFrame.ProductScladPriceTableFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindNameDateDialog extends JDialog {

    private JLabel nameLable = new JLabel("Введите Название продукта:");
    private JTextField nameField = new JTextField(10);
    private JLabel firstDateLable = new JLabel("Ведите дату с: ");
    private JTextField firstDateField = new JTextField(10);
    private JLabel lastDateLable = new JLabel("по: ");
    private JTextField lastDateField = new JTextField(10);
    private JButton findButton = new JButton("Find");
    private java.sql.Date firstDate;
    private java.sql.Date lastDate;
    private Box optionBox = Box.createHorizontalBox();
    private Box dateBox = Box.createHorizontalBox();
    private Box boxButton = Box.createVerticalBox();

    public FindNameDateDialog(JFrame owner) {
        super(owner);
        this.setTitle("find dialog");
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        replaceButton(this);
        initListener();
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            nameField.setText("");
        }else{
            Storage.getIstance().getProductScladPriceList().clear();}
        super.setVisible(visible);
    }

    private void replaceButton(JDialog dialog) {
        boxButton.add(nameLable);
        boxButton.add(nameField);

        boxButton.add(Box.createVerticalStrut(30));

        dateBox.add(firstDateLable);
        dateBox.add(Box.createHorizontalStrut(5));
        dateBox.add(firstDateField);
        dateBox.add(Box.createHorizontalStrut(5));
        dateBox.add(lastDateLable);
        dateBox.add(Box.createHorizontalStrut(5));
        dateBox.add(lastDateField);

        optionBox.add(findButton);

        boxButton.add(dateBox);
        boxButton.add(Box.createVerticalStrut(30));
        boxButton.add(optionBox);
        dialog.add(boxButton);
    }

    private void initListener() {

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstDate = java.sql.Date.valueOf(firstDateField.getText());
                lastDate = java.sql.Date.valueOf(lastDateField.getText());
                MysqlOption.getInstance().makeProductScladPriceTableSQL(firstDate, lastDate, nameField.getText());
                new ProductScladPriceTableFrame();
                setVisible(false);
            }
        });
    }
}
