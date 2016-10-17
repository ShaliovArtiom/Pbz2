package view.Dialog;

import controller.MysqlOption;
import model.Sclad;
import model.TableModel.TableModelSclad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialogSclad extends JDialog {

    private TableModelSclad tableModelSclad;
    private MysqlOption mysqlOption = MysqlOption.getInstance();

    private JLabel idScladLable = new JLabel("Ид склада: ");
    private JTextField idScladField = new JTextField(10);
    private JLabel idProductLable = new JLabel("Ид продукта: ");
    private JTextField idProductField = new JTextField(10);
    private JLabel idKombinatLable = new JLabel("Ид комбината: ");
    private JTextField idKombinatField = new JTextField(10);
    private JLabel nubmerProductLable = new JLabel("Номер продукта: ");
    private JTextField numberProductField = new JTextField(10);
    private JLabel dataProductLable = new JLabel("Дата поступления: ");
    private JTextField dataProductFiled = new JTextField(10);
    private JButton addButton = new JButton("Add");
    private Box boxButton = Box.createVerticalBox();

    public AddDialogSclad(Frame owner, TableModelSclad tableModelSclad) {
        super(owner);
        this.setTitle("Add dialog Sclad");
        this.setSize(300, 280);
        this.setLocationRelativeTo(null);
        this.tableModelSclad = tableModelSclad;
        createButton(this);
        initListeners();
    }

    @Override
    public void setVisible(boolean visible){
        if(visible) {
            idScladField.setText("");
            idProductField.setText("");
            idKombinatField.setText("");
            numberProductField.setText("");
            dataProductFiled.setText("");
        }
        super.setVisible(visible);
    }

    private void createButton(JDialog dialog){
        boxButton.add(idScladLable);
        boxButton.add(idScladField);
        boxButton.add(idProductLable);
        boxButton.add(idProductField);
        boxButton.add(idKombinatLable);
        boxButton.add(idKombinatField);
        boxButton.add(nubmerProductLable);
        boxButton.add(numberProductField);
        boxButton.add(dataProductLable);
        boxButton.add(dataProductFiled);
        boxButton.add(addButton);

        JPanel panel = new JPanel();
        panel.add(boxButton);
        dialog.add(panel, BorderLayout.CENTER);
    }

    private void initListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sclad sclad = new Sclad();
                try {
                    sclad.setIdSclad(idScladField.getText());
                    sclad.setIdProduct(idProductField.getText());
                    sclad.setIdKombinat(idKombinatField.getText());

                    Integer number = Integer.valueOf(numberProductField.getText());
                    sclad.setNumberProduct(number);

                    sclad.setDate(java.sql.Date.valueOf(dataProductFiled.getText()));

                } catch (NumberFormatException e1) {
                    System.err.println("Неверный формат строки!");
                }

                mysqlOption.addScladTable(sclad);
                setVisible(false);
                tableModelSclad.fireTableDataChanged();
            }
        });
    }

}
