package view.TableFrame;

import model.TableModel.TableModelPriceSlad;
import model.TableModel.TableModelProductScladPrice;

import javax.swing.*;
import java.awt.*;

public class ProductScladPriceTableFrame extends JFrame {

    private static final int DEFAULT_HEIGHT = 600;
    private static final int DEFAULT_WIDHT = 800;

    private TableModelProductScladPrice tableModelProductScladPrice;


    public ProductScladPriceTableFrame() {
        this.setTitle("Table");
        this.setSize(DEFAULT_WIDHT, DEFAULT_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        tableModelProductScladPrice = new TableModelProductScladPrice();
        JTable table = new JTable(tableModelProductScladPrice);
        table.setPreferredSize(new Dimension(800, 600));
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(400, 300));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jScrollPane);
    }
}
