package view.Dialog;

import controller.MysqlOption;
import model.Price;
import model.TableModel.TableModelPrice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialogPrice extends JDialog {

    private MysqlOption mysqlOption = MysqlOption.getInstance();
    private TableModelPrice tableModelPrice;
    private JLabel idPriceLable = new JLabel("ид продукта: ");
    private JTextField idPriceField = new JTextField(10);
    private JLabel purchasePriceLable = new JLabel("Закупочная цена: ");
    private JTextField purchasePriceField = new JTextField(10);
    private JLabel costPriceLable = new JLabel("Рознечная цена :");
    private JTextField costPriceField = new JTextField(10);
    private JButton addButton = new JButton("Add");
    private Box boxButton = Box.createVerticalBox();

    public AddDialogPrice(JFrame owner, TableModelPrice tableModelPrice) {
        super(owner);
        this.setTitle("Add dialog price");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.tableModelPrice = tableModelPrice;
        replaceButton(this);
        initListeners();
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            idPriceField.setText("");
            purchasePriceField.setText("");
            costPriceField.setText("");
        }
        super.setVisible(visible);
    }

    private void replaceButton(JDialog dialog) {
        boxButton.add(idPriceLable);
        boxButton.add(idPriceField);
        boxButton.add(purchasePriceLable);
        boxButton.add(purchasePriceField);
        boxButton.add(costPriceLable);
        boxButton.add(costPriceField);
        boxButton.add(addButton);
        dialog.add(boxButton);
    }


    private void initListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Price price = new Price();
                try {
                    price.setIdProduct(idPriceField.getText());
                    Integer purchase = Integer.valueOf(purchasePriceField.getText());
                    price.setPurchasePrice(purchase);
                    Integer cost = Integer.valueOf(costPriceField.getText());
                    price.setCostPrice(cost);
                } catch (NumberFormatException e1) {
                    System.err.println("Неверный формат строки!");
                }
                mysqlOption.addPriceTable(price);
                setVisible(false);
                tableModelPrice.fireTableDataChanged();
            }
        });
    }

}