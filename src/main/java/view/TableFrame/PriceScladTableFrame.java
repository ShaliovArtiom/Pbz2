package view.TableFrame;

import controller.MysqlOption;
import model.TableModel.TableModelPrice;
import model.TableModel.TableModelPriceSlad;
import view.Dialog.AddDialogPrice;
import view.Dialog.FindDialog;

import javax.swing.*;
import java.awt.*;

public class PriceScladTableFrame extends JFrame{
    private static final int DEFAULT_HEIGHT = 600;
    private static final int DEFAULT_WIDHT = 800;

    private TableModelPriceSlad tableModelPriceSlad;


    public PriceScladTableFrame() {
        this.setTitle("Price Table");
        this.setSize(DEFAULT_WIDHT, DEFAULT_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        tableModelPriceSlad = new TableModelPriceSlad();
        JTable table = new JTable(tableModelPriceSlad);
        table.setPreferredSize(new Dimension(800, 600));
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(400, 300));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jScrollPane);
    }
}
