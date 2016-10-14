package view.DialogPrice;

import controller.MysqlOption;
import model.Price;
import model.TableModelPrice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenameDialogPrice  extends JDialog{

    private TableModelPrice tableModelPrice;
    private MysqlOption mysqlOption = MysqlOption.getInstance();
    private JLabel purchasePriceLable = new JLabel("Закупочная цена: ");
    private JTextField purchasePriceField = new JTextField(10);
    private JLabel costPriceLable = new JLabel("Рознечная цена :");
    private JTextField costPriceField = new JTextField(10);
    private JButton renamButton = new JButton("Rename");
    private Box boxButton = Box.createVerticalBox();

    public RenameDialogPrice(JFrame owner, TableModelPrice tableModelPrice) {
        super(owner);
        this.setTitle("Rename dialog");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.tableModelPrice = tableModelPrice;
        replaceButton(this);
        initListeners();
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            purchasePriceField.setText("");
            costPriceField.setText("");
        }
        super.setVisible(visible);
    }

    private void replaceButton(JDialog dialog) {
        boxButton.add(purchasePriceLable);
        boxButton.add(purchasePriceField);
        boxButton.add(costPriceLable);
        boxButton.add(costPriceField);
        boxButton.add(renamButton);
        dialog.add(boxButton);
    }


    private void initListeners() {
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

}
