package clothing4you;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderSummary extends JDialog{
    private JPanel orderSummaryPanel;
    private ArrayList<Item> items;
    private JTable table;
    private DefaultTableModel model;
    private Cart cart;

    public OrderSummary(JFrame parent, ArrayList<Item> items){
        super(parent);
        setTitle("Order Summary");
        orderSummaryPanel = new JPanel(new BorderLayout());
        setContentPane(orderSummaryPanel);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setLocationRelativeTo(parent);

        this.items = items;
        cart = new Cart();

        String[] column = {"Name", "Price"};
        model = new DefaultTableModel(column, 0);

        table = new JTable(model);
        int totalQuantity = 0;
        for (Item item: items){
            cart.addItem(item);
            model.addRow(new Object[]{item.getName(), "$" + String.format("%.2f",item.getPrice())});
        }
        model.addRow(new Object[]{"Total Price:", "$" + String.format("%.2f",cart.getTotal())});

        orderSummaryPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        table.setDefaultEditor(Object.class, null);

        JPanel button = new JPanel();
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Catalog myCatalog = new Catalog(null);
            }
        });
        button.add(back);

        JButton checkout = new JButton("CheckOut");
        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Checkout myCheckout = new Checkout(null);
            }
        });
        button.add(checkout);
        orderSummaryPanel.add(button, BorderLayout.SOUTH);



        setVisible(true);
    }
}
