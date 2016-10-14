package view.DialogPrice;

import controller.MysqlOption;
import model.TableModelPrice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class FindDialogPrice extends JDialog {

    private TableModelPrice tableModelPrice;
    private JFrame owner;
    private RenameDialogPrice renameDialogPrice;
    private JLabel idLable = new JLabel("Enter id");
    private JTextField idField = new JTextField(10);
    private JButton findButton = new JButton("Find");
    private JButton deleteButton;
    private Box optionBox = Box.createHorizontalBox();
    private Box boxButton = Box.createVerticalBox();
    private String string;

    public FindDialogPrice(JFrame owner, TableModelPrice tableModelPrice, String string) {
        super(owner);
        this.setTitle(string + "dialog");
        this.setSize(150, 150);
        this.setLocationRelativeTo(null);
        this.tableModelPrice = tableModelPrice;
        deleteButton = new JButton(string);
        this.string = string;
        this.owner = owner;
        replaceButton(this);
        initListeners();
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            idField.setText("");
        }
        super.setVisible(visible);
    }


    private void replaceButton(JDialog dialog) {
        boxButton.add(idLable);
        boxButton.add(idField);
        optionBox.add(findButton);
        optionBox.add(deleteButton);
        boxButton.add(Box.createVerticalStrut(30));
        boxButton.add(optionBox);
        dialog.add(boxButton);
    }

    private void initListeners() {
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModelPrice.filterId(idField.getText());
                tableModelPrice.refresh();
            }
        });

        if (Objects.equals(string, "Delete")) {
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MysqlOption.getInstance().deletePriceTable(tableModelPrice.getDisplayedPriceList().get(0));
                    tableModelPrice.fireTableDataChanged();
                }
            });
        }else if(Objects.equals(string, "Rename")){
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    renameDialogPrice = new RenameDialogPrice(owner, tableModelPrice);
                    renameDialogPrice.setVisible(true);
                    setVisible(false);
                }
            });
        }
    }

}
