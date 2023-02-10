package clothing4you;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Catalog extends JDialog {
    private JPanel catalogPanel;
    private JComboBox<String> cmCategory;
    private JTable table;
    private DefaultTableModel model;
    private ArrayList<Item> items;
    private Cart cart;

    public Catalog(JFrame parent) {
        super(parent);
        setTitle("Catalog");
        catalogPanel = new JPanel(new BorderLayout());
        setContentPane(catalogPanel);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setLocationRelativeTo(parent);

        cart = new Cart();

        items = new ArrayList<>();
        Image tShirt = new ImageIcon("Tshirt.png").getImage();
        Image hoodie = new ImageIcon("Hoodie.png").getImage();
        Image jeans = new ImageIcon("Jeans.png").getImage();
        Image shorts = new ImageIcon("Shorts.png").getImage();
        Image beanie = new ImageIcon("Beanie.png").getImage();
        Image hat = new ImageIcon("Hat.png").getImage();
        items.add(new Item("T-shirt", "Tops", "M", 1, 20.00, tShirt));
        items.add(new Item("Hoodie", "Tops", "M",1,25.00, hoodie));
        items.add(new Item("Jeans", "Bottoms", "M",1, 20.00, jeans));
        items.add(new Item("Shorts", "Bottoms", "M",1,15.00, shorts));
        items.add(new Item("Beanie", "Hats", "M",1,7.50, beanie));
        items.add(new Item("Hat", "Hats", "M",1,7.50, hat));



        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Size");
        model.addColumn("Price");
        model.addColumn("Image");
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        catalogPanel.add(scrollPane, BorderLayout.CENTER);
        table.setDefaultEditor(Object.class, null);


        JPanel filter = new JPanel();
        cmCategory = new JComboBox<String>();
        cmCategory.addItem("All");
        cmCategory.addItem("Tops");
        cmCategory.addItem("Bottoms");
        cmCategory.addItem("Footwear");
        cmCategory.addItem("Hats");
        cmCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable();
            }
        });
        filter.add(cmCategory);
        catalogPanel.add(filter, BorderLayout.NORTH);
        cmCategory.setSelectedItem("All");


        JPanel button = new JPanel();
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login myLogin = new Login(null);
            }
        });
        button.add(back);

        JButton checkout = new JButton("CheckOut");
        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                OrderSummary mySummary = new OrderSummary(null, cart.getItems());
            }
        });
        button.add(checkout);
        catalogPanel.add(button, BorderLayout.SOUTH);

        JPanel button1 = new JPanel();
        JButton addToCart = new JButton("Add To Cart");
        addToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    Item item = items.get(row);
                    cart.addItem(item);
                    JOptionPane.showMessageDialog(catalogPanel, item.getName() + " added to cart.");
                } else {
                    JOptionPane.showMessageDialog(catalogPanel, "Please select an item that is available.");
                }
            }
        });
        button1.add(addToCart);
        catalogPanel.add(button1, BorderLayout.EAST);


        setVisible(true);
        updateTable();

    }

    private void updateTable() {
        model.setRowCount(0);
        String selectedCategory = (String) cmCategory.getSelectedItem();
        for (Item item : items) {
            if (selectedCategory.equals("All") || selectedCategory.equals(item.getCategory())) {
                model.addRow(new Object[] { item.getName(), item.getSize(), "$" + String.format("%.2f",item.getPrice()), item.getImage() });
            }
        }
    }


}

