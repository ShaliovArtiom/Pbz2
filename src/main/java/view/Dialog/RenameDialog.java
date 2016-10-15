package view.Dialog;

import controller.MysqlOption;
import model.Price;
import model.Sclad;
import model.TableModelPrice;
import model.TableModelSclad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class RenameDialog extends JDialog{

    private TableModelPrice tableModelPrice;
    private TableModelSclad tableModelSclad;
    private MysqlOption mysqlOption = MysqlOption.getInstance();
    private JLabel purchasePriceLable = new JLabel("Закупочная цена: ");
    private JTextField purchasePriceField = new JTextField(10);
    private JLabel costPriceLable = new JLabel("Рознечная цена :");
    private JTextField costPriceField = new JTextField(10);

    private JLabel idProductLable = new JLabel("Ид продукта: ");
    private JTextField idProductField = new JTextField(10);
    private JLabel idKombinatLable = new JLabel("Ид комбината: ");
    private JTextField idKombinatField = new JTextField(10);
    private JLabel numberProductLable = new JLabel("Номер продукта: ");
    private JTextField numberProductField = new JTextField(10);
    private JLabel dataProductLable = new JLabel("Дата поступления: ");
    private JTextField dataProductFiled = new JTextField(10);

    private JButton renamButton = new JButton("Rename");
    private Box boxButton = Box.createVerticalBox();

    public RenameDialog(JFrame owner, TableModelPrice tableModelPrice) {
        super(owner);
        this.setTitle("Rename dialog");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.tableModelPrice = tableModelPrice;
        replaceButtonPrice(this);
        initListenersPrice();
    }

    public RenameDialog(JFrame owner, TableModelSclad tableModelSclad) {
        super(owner);
        this.setTitle("Rename dialog");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.tableModelSclad = tableModelSclad;
        replaceButtonSclad(this);
        initListenersSclad();
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            purchasePriceField.setText("");
            costPriceField.setText("");

            idProductField.setText("");
            idKombinatField.setText("");
            numberProductField.setText("");
            dataProductFiled.setText("");
        }
        super.setVisible(visible);
    }

    private void replaceButtonPrice(JDialog dialog) {
        boxButton.add(purchasePriceLable);
        boxButton.add(purchasePriceField);
        boxButton.add(costPriceLable);
        boxButton.add(costPriceField);
        boxButton.add(renamButton);
        dialog.add(boxButton);
    }

    private void replaceButtonSclad(JDialog dialog) {
        boxButton.add(idProductLable);
        boxButton.add(idProductField);
        boxButton.add(idKombinatLable);
        boxButton.add(idKombinatField);
        boxButton.add(numberProductLable);
        boxButton.add(numberProductField);
        boxButton.add(dataProductLable);
        boxButton.add(dataProductFiled);
        boxButton.add(renamButton);
        dialog.add(boxButton);
    }


    private void initListenersPrice() {
        renamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Price price = tableModelPrice.getDisplayedPriceList().get(0);
                try {
                    Integer purchase = Integer.valueOf(purchasePriceField.getText());
                    price.setPurchasePrice(purchase);
                    Integer cost = Integer.valueOf(costPriceField.getText());
                    price.setCostPrice(cost);
                } catch (NumberFormatException e1) {
                    System.err.println("Неверный формат строки!");
                }
                mysqlOption.renamePriceTable(price);
                setVisible(false);
                tableModelPrice.fireTableDataChanged();
            }
        });
    }

    private void initListenersSclad() {
        renamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sclad sclad = tableModelSclad.getDisplayedScladList().get(0);
                try {
                    sclad.setIdProduct(idProductField.getText());
                    sclad.setIdKombinat(idKombinatField.getText());
                    Integer number = Integer.valueOf(numberProductField.getText());
                    sclad.setNumberProduct(number);
                    sclad.setData(Date.valueOf(dataProductFiled.getText()));
                } catch (NumberFormatException e1) {
                    System.err.println("Неверный формат строки!");
                }
                mysqlOption.renameScladTable(sclad);
                setVisible(false);
                tableModelSclad.fireTableDataChanged();
            }
        });
    }

}
