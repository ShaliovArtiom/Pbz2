package view.Dialog;

import controller.MysqlOption;
import model.TableModel.TableModelKombinat;
import model.TableModel.TableModelPrice;
import model.TableModel.TableModelProduct;
import model.TableModel.TableModelSclad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class FindDialog extends JDialog {

    private TableModelPrice tableModelPrice;
    private TableModelSclad tableModelSclad;
    private TableModelProduct tableModelProduct;
    private TableModelKombinat tableModelKombinat;
    private JFrame owner;
    private RenameDialog renameDialog;
    private JLabel idLable = new JLabel("Enter id");
    private JTextField idField = new JTextField(10);
    private JButton findButton = new JButton("Find");
    private JButton deleteButton;
    private Box optionBox = Box.createHorizontalBox();
    private Box boxButton = Box.createVerticalBox();
    private String string;

    public FindDialog(JFrame owner, TableModelPrice tableModelPrice, String string) {
        super(owner);
        this.setTitle(string + "dialog");
        this.setSize(150, 150);
        this.setLocationRelativeTo(null);
        this.tableModelPrice = tableModelPrice;
        deleteButton = new JButton(string);
        this.string = string;
        this.owner = owner;
        replaceButton(this);
        initListenersPrice();
    }

    public FindDialog(JFrame owner, TableModelSclad tableModelSclad, String string) {
        super(owner);
        this.setTitle(string + "dialog");
        this.setSize(150, 150);
        this.setLocationRelativeTo(null);
        this.tableModelSclad = tableModelSclad;
        deleteButton = new JButton(string);
        this.string = string;
        this.owner = owner;
        replaceButton(this);
        initListenersSclad();
    }

    public FindDialog(JFrame owner, TableModelProduct tableModelProduct, String string) {
        super(owner);
        this.setTitle(string + "dialog");
        this.setSize(150, 150);
        this.setLocationRelativeTo(null);
        this.tableModelProduct = tableModelProduct;
        deleteButton = new JButton(string);
        this.string = string;
        this.owner = owner;
        replaceButton(this);
        initListenersProduct();
    }

    public FindDialog(JFrame owner, TableModelKombinat tableModelKombinat, String string) {
        super(owner);
        this.setTitle(string + "dialog");
        this.setSize(150, 150);
        this.setLocationRelativeTo(null);
        this.tableModelKombinat = tableModelKombinat;
        deleteButton = new JButton(string);
        this.string = string;
        this.owner = owner;
        replaceButton(this);
        initListenersKombinat();
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            idField.setText("");
        }else {
            if(tableModelKombinat != null)tableModelKombinat.fireTableDataChanged();
            if(tableModelSclad != null)tableModelSclad.fireTableDataChanged();
            if(tableModelPrice != null)tableModelPrice.fireTableDataChanged();
            if(tableModelProduct != null)tableModelProduct.fireTableDataChanged();
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

    private void initListenersPrice() {
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
        } else if (Objects.equals(string, "Rename")) {
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    renameDialog = new RenameDialog(owner, tableModelPrice);
                    renameDialog.setVisible(true);
                    setVisible(false);
                }
            });
        }
    }


    private void initListenersSclad() {
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModelSclad.filterId(idField.getText());
                tableModelSclad.refresh();
            }
        });

        if (Objects.equals(string, "Delete")) {
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MysqlOption.getInstance().deleteSckladTable(tableModelSclad.getDisplayedScladList().get(0));
                    tableModelSclad.fireTableDataChanged();
                }
            });
        } else if (Objects.equals(string, "Rename")) {
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    renameDialog = new RenameDialog(owner, tableModelSclad);
                    renameDialog.setVisible(true);
                    setVisible(false);
                }
            });
        }
    }

    private void initListenersProduct() {
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModelProduct.filterId(idField.getText());
                tableModelProduct.refresh();
            }
        });

        if (Objects.equals(string, "Delete")) {
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MysqlOption.getInstance().deleteProductTable(tableModelProduct.getDisplayedProductList().get(0));
                    tableModelProduct.fireTableDataChanged();
                }
            });
        } else if (Objects.equals(string, "Rename")) {
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    renameDialog = new RenameDialog(owner, tableModelProduct);
                    renameDialog.setVisible(true);
                    setVisible(false);
                }
            });
        }
    }

    private void initListenersKombinat() {
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModelKombinat.filterId(idField.getText());
                tableModelKombinat.refresh();
            }
        });

        if (Objects.equals(string, "Delete")) {
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MysqlOption.getInstance().deleteKombinatTable(tableModelKombinat.getDisplayedKombinatList().get(0));
                    tableModelKombinat.fireTableDataChanged();
                }
            });
        } else if (Objects.equals(string, "Rename")) {
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    renameDialog = new RenameDialog(owner, tableModelKombinat);
                    renameDialog.setVisible(true);
                    setVisible(false);
                }
            });
        }
    }
}