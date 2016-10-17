package view.Dialog;

import controller.MysqlOption;
import model.Kombinat;
import model.TableModel.TableModelKombinat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialogKombinat extends JDialog {

    private MysqlOption mysqlOption = MysqlOption.getInstance();
    private TableModelKombinat tableModelKombinat;
    private JLabel idKombinatLable = new JLabel("ид комбината: ");
    private JTextField idKombinatField = new JTextField(10);
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
    private JButton addButton = new JButton("Add");
    private Box boxButton = Box.createVerticalBox();

    public AddDialogKombinat(JFrame owner, TableModelKombinat tableModelKombinat) {
        super(owner);
        this.setTitle("Add dialog price");
        this.setSize(300, 350);
        this.setLocationRelativeTo(null);
        this.tableModelKombinat = tableModelKombinat;
        initBox();
        replaceButton(this);
        initListeners();
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            idKombinatField.setText("");
            nameKombinatField.setText("");
            adressKombinatField.setText("");
            telephoneKombinatField.setText("");
            FIOKombinatField.setText("");
            positionKombinatField.setText("");
        }
        super.setVisible(visible);
    }

    private void initBox() {
        String regionBox[] = {"Минский", "Гродненскй", "Витебский", "Брестский", "Гомельский", "Могелевский"};
        regionKombinatBox = new JComboBox<String>(regionBox);
    }


    private void replaceButton(JDialog dialog) {
        boxButton.add(idKombinatLable);
        boxButton.add(idKombinatField);
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
        boxButton.add(addButton);
        JPanel panel = new JPanel();
        panel.add(boxButton);
        dialog.add(panel, BorderLayout.CENTER);
    }


    private void initListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kombinat kombinat = new Kombinat();

                kombinat.setIdKombinat(idKombinatField.getText());
                kombinat.setNameKombinat(nameKombinatField.getText());
                kombinat.setAdressKombinat(adressKombinatField.getText());
                kombinat.setTelephoneKombinat(telephoneKombinatField.getText());
                kombinat.setFIOKombinat(FIOKombinatField.getText());
                kombinat.setPositionKombinat(positionKombinatField.getText());
                kombinat.setEnumRegeonKombinat((String) regionKombinatBox.getSelectedItem());

                mysqlOption.addKombinatTable(kombinat);
                setVisible(false);
                tableModelKombinat.fireTableDataChanged();
            }
        });
    }


}
