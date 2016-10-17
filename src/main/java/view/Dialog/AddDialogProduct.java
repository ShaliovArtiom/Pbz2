package view.Dialog;

import controller.MysqlOption;
import model.Product;
import model.TableModel.TableModelProduct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialogProduct extends JDialog{

    TableModelProduct tableModelProduct;
    private MysqlOption mysqlOption = MysqlOption.getInstance();
    private JLabel idProductLable = new JLabel("ид продукта: ");
    private JTextField idProductField = new JTextField(10);
    private JLabel nameProductLable = new JLabel("Название продукта: ");
    private JTextField nameProductField = new JTextField(10);
    private JLabel gradeProducLable = new JLabel("Сорт продукта:");
    private JComboBox<String> gradeProductBox;
    private JLabel groupProducLable = new JLabel("Группа продукта:");
    private JComboBox<String> groupProductBox;
    private JButton addButton = new JButton("Add");
    private Box boxButton = Box.createVerticalBox();

    public AddDialogProduct (JFrame owner, TableModelProduct tableModelProduct) {
        super(owner);
        this.setTitle("Add dialog price");
        this.setSize(300, 250);
        this.setLocationRelativeTo(null);
        this.tableModelProduct = tableModelProduct;
        initBox();
        replaceButton(this);
        initListeners();
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            idProductField.setText("");
            nameProductField.setText("");
        }
        super.setVisible(visible);
    }

    private void initBox() {
        String gradeString[] = {"1", "2", "3"};
        String groupString[] = {"колбасные изделия", "мясные полуфабрикаты", "сыры", "молоко", "творожные изделия"};
        gradeProductBox = new JComboBox<String>(gradeString);
        groupProductBox = new JComboBox<String>(groupString);
    }

    private void replaceButton(JDialog dialog) {
        boxButton.add(idProductLable);
        boxButton.add(idProductField);
        boxButton.add(nameProductLable);
        boxButton.add(nameProductField);
        boxButton.add(gradeProducLable);
        boxButton.add(gradeProductBox);
        boxButton.add(groupProducLable);
        boxButton.add(groupProductBox);
        boxButton.add(Box.createVerticalStrut(10));
        boxButton.add(addButton);

        JPanel panel = new JPanel();
        panel.add(boxButton);
        dialog.add(panel, BorderLayout.CENTER);

    }

    private void initListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product product = new Product();
                    product.setIdProduct(idProductField.getText());
                    product.setNameProduct(nameProductField.getText());
                    product.setEnumGradeProduct((String) gradeProductBox.getSelectedItem());
                    product.setEnumGroupProduct((String) groupProductBox.getSelectedItem());

                mysqlOption.addProductTable(product);
                setVisible(false);
                tableModelProduct.fireTableDataChanged();
            }
        });
    }
}
