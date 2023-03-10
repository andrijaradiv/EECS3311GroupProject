package clothing4you;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class WishlistPage extends JDialog {
    private JPanel wishlistPanel;
    private ArrayList<Item> items;
    private JTable table;
    private DefaultTableModel model;
    private Cart cart;

    public WishlistPage(JFrame parent, ArrayList<Item> items){
        super(parent);
        setTitle("My WishList");
        wishlistPanel = new JPanel(new BorderLayout());
        setContentPane(wishlistPanel);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setLocationRelativeTo(parent);

        this.items = items;
        cart = new Cart();

        model = new DefaultTableModel(new Object[]{"Name", "Price", "Category"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        wishlistPanel.add(scrollPane, BorderLayout.CENTER);
        table.setDefaultEditor(Object.class, null);

        for (Item item: items){
            model.addRow(new Object[]{item.getName(), item.getPrice(), item.getCategory()});
        }

        JPanel button = new JPanel();
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Catalog myCatalog = new Catalog(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        button.add(back);

        JButton addToCart = new JButton("Add To Cart");
        addToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    Item item = items.get(row);
                    cart.addItem(item);
                    JOptionPane.showMessageDialog(wishlistPanel, item.getName() + " added to cart.");
                } else {
                    JOptionPane.showMessageDialog(wishlistPanel, "Please select an item that is available.");
                }
            }
        });
        button.add(addToCart);

        JButton checkout = new JButton("CheckOut");
        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                OrderSummary mySummary = new OrderSummary(null, cart.getItems());
            }
        });
        button.add(checkout);

        wishlistPanel.add(button, BorderLayout.SOUTH);


        setVisible(true);
    }

}
