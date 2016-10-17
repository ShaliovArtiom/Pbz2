package view.Dialog;

import controller.MysqlOption;
import model.*;
import model.TableModel.TableModelKombinat;
import model.TableModel.TableModelPrice;
import model.TableModel.TableModelProduct;
import model.TableModel.TableModelSclad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class RenameDialog extends JDialog{

    private TableModelPrice tableModelPrice;
    private TableModelSclad tableModelSclad;
    private TableModelProduct tableModelProduct;
    private TableModelKombinat tableModelKombinat;

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

    private JLabel nameProductLable = new JLabel("Название продукта: ");
    private JTextField nameProductField = new JTextField(10);
    private JLabel gradeProducLable = new JLabel("Сорт продукта:");
    private JComboBox<String> gradeProductBox;
    private JLabel groupProducLable = new JLabel("Группа продукта:");
    private JComboBox<String> groupProductBox;

    private JLabel nameKombinatLable = new JLabel("Название комбинта: ");
    private JTextField nameKombinatField = new JTextField(10);
    private JLabel adressKombinatLable = new JLabel("Адрес комбината:");
    private JTextField adressKombinatField = new JTextField(10);
    private JLabel telephoneKombinatLable = new JLabel("Телефон комбината:");
    private JTextField telephoneKombinatField = new JTextField(10);
    private JLabel FIOKombinatLable = new JLabel("ФИО работника:");
    private JTextField FIOKombinatField = new JTextField(10);
    private JLabel positionKombinatLable = new JLabel("Должность работника:");
    private JTextField positionKombinatField = new JTextField(10);
    private JLabel regionKombinatLable = new JLabel("Регион:");
    private JComboBox<String> regionKombinatBox;

    private JButton renamButton = new JButton("Rename");
    private Box boxButton = Box.createVerticalBox();

    public RenameDialog(JFrame owner, TableModelPrice tableModelPrice) {
        super(owner);
        this.setTitle("Rename dialog");
        this.setSize(300, 165);
        this.setLocationRelativeTo(null);
        this.tableModelPrice = tableModelPrice;
        replaceButtonPrice(this);
        initListenersPrice();
    }

    public RenameDialog(JFrame owner, TableModelSclad tableModelSclad) {
        super(owner);
        this.setTitle("Rename dialog");
        this.setSize(300, 250);
        this.setLocationRelativeTo(null);
        this.tableModelSclad = tableModelSclad;
        replaceButtonSclad(this);
        initListenersSclad();
    }

    public RenameDialog(JFrame owner, TableModelProduct tableModelProduct) {
        super(owner);
        this.setTitle("Rename dialog");
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.tableModelProduct = tableModelProduct;
        initBoxProduct();
        replaceButtonProduct(this);
        initListenersProduct();
    }

    public RenameDialog(JFrame owner, TableModelKombinat tableModelKombinat) {
        super(owner);
        this.setTitle("Rename dialog");
        this.setSize(300, 320);
        this.setLocationRelativeTo(null);
        this.tableModelKombinat = tableModelKombinat;
        initBoxKombinat();
        replaceButtonKombonat(this);
        initListenersKombinat();
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            purchasePriceField.setText("");
            costPriceField.setText("");

            idProductField.setText("");
            idKombinatField.setText("");
            numberProductField.setText("");
            dataProductFiled.setText("");

            nameProductField.setText("");

            nameKombinatField.setText("");
            adressKombinatField.setText("");
            telephoneKombinatField.setText("");
            FIOKombinatField.setText("");
            positionKombinatField.setText("");
        } else{
            if(tableModelKombinat != null)tableModelKombinat.fireTableDataChanged();
            if(tableModelSclad != null)tableModelSclad.fireTableDataChanged();
            if(tableModelPrice != null)tableModelPrice.fireTableDataChanged();
            if(tableModelProduct != null)tableModelProduct.fireTableDataChanged();
        }
    }

    private void replaceButtonPrice(JDialog dialog) {
        boxButton.add(purchasePriceLable);
        boxButton.add(purchasePriceField);
        boxButton.add(costPriceLable);
        boxButton.add(costPriceField);
        boxButton.add(Box.createVerticalStrut(10));
        boxButton.add(renamButton);
        JPanel panel = new JPanel();
        panel.add(boxButton);
        dialog.add(panel, BorderLayout.CENTER);
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
        boxButton.add(Box.createVerticalStrut(10));
        boxButton.add(renamButton);
        JPanel panel = new JPanel();
        panel.add(boxButton);
        dialog.add(panel, BorderLayout.CENTER);
    }

    private void replaceButtonKombonat(JDialog dialog) {
        boxButton.add(nameKombinatLable);
        boxButton.add(nameKombinatField);
        boxButton.add(adressKombinatLable);
        boxButton.add(adressKombinatField);
        boxButton.add(telephoneKombinatLable);
        boxButton.add(telephoneKombinatField);
        boxButton.add(FIOKombinatLable);
        boxButton.add(FIOKombinatField);
        boxButton.add(positionKombinatLable);
        boxButton.add(positionKombinatField);
        boxButton.add(regionKombinatLable);
        boxButton.add(regionKombinatBox);
        boxButton.add(Box.createVerticalStrut(10));
        boxButton.add(renamButton);
        JPanel panel = new JPanel();
        panel.add(boxButton);
        dialog.add(panel, BorderLayout.CENTER);
    }

    private void replaceButtonProduct(JDialog dialog) {
        boxButton.add(nameProductLable);
        boxButton.add(nameProductField);
        boxButton.add(gradeProducLable);
        boxButton.add(gradeProductBox);
        boxButton.add(groupProducLable);
        boxButton.add(groupProductBox);
        boxButton.add(Box.createVerticalStrut(10));
        boxButton.add(renamButton);
        JPanel panel = new JPanel();
        panel.add(boxButton);
        dialog.add(panel, BorderLayout.CENTER);
    }

    private void initBoxProduct() {
        String gradeString[] = {"1", "2", "3"};
        String groupString[] = {"колбасные изделия", "мясные полуфабрикаты", "сыры", "молоко", "творожные изделия"};
        gradeProductBox = new JComboBox<String>(gradeString);
        groupProductBox = new JComboBox<String>(groupString);
    }

    private void initBoxKombinat() {
        String regionBox[] = {"Минский", "Гродненскй", "Витебский", "Брестский", "Гомельский", "Могелевский"};
        regionKombinatBox = new JComboBox<String>(regionBox);
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
                    sclad.setDate(Date.valueOf(dataProductFiled.getText()));
                } catch (NumberFormatException e1) {
                    System.err.println("Неверный формат строки!");
                }
                mysqlOption.renameScladTable(sclad);
                setVisible(false);
                tableModelSclad.fireTableDataChanged();
            }
        });
    }

    private void initListenersProduct() {
        renamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product product = tableModelProduct.getDisplayedProductList().get(0);

                product.setNameProduct(nameProductField.getText());
                product.setEnumGradeProduct((String) gradeProductBox.getSelectedItem());
                product.setEnumGroupProduct((String) groupProductBox.getSelectedItem());

                mysqlOption.renameProductTable(product);
                setVisible(false);
                tableModelProduct.fireTableDataChanged();
            }
        });
    }

    private void initListenersKombinat() {
        renamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kombinat kombinat = tableModelKombinat.getDisplayedKombinatList().get(0);

                kombinat.setNameKombinat(nameKombinatField.getText());
                kombinat.setAdressKombinat(adressKombinatField.getText());
                kombinat.setTelephoneKombinat(telephoneKombinatField.getText());
                kombinat.setFIOKombinat(FIOKombinatField.getText());
                kombinat.setPositionKombinat(positionKombinatField.getText());
                kombinat.setEnumRegeonKombinat((String) regionKombinatBox.getSelectedItem());

                mysqlOption.renameKombinatTable(kombinat);
                setVisible(false);
                tableModelKombinat.fireTableDataChanged();
            }
        });
    }

}
