package itr0;

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

        items = new ArrayList<>();
        items.add(new Item("T-shirt", "Tops", "M",10.0, new ImageIcon("Tshirt.png")));
        items.add(new Item("Hoodie", "Tops", "M",20.0, new ImageIcon("Hoodie.png")));
        items.add(new Item("Jeans", "Bottoms", "M", 30.0, new ImageIcon("Jeans.png")));
        items.add(new Item("Shorts", "Bottoms", "M",10.0, new ImageIcon("shorts.png")));
        items.add(new Item("Beanie", "Hats", "M",10.0, new ImageIcon("Beanie.png")));
        items.add(new Item("Hat", "Hats", "M",10.0, new ImageIcon("Hat.png")));


        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Size");
        model.addColumn("Price");
        model.addColumn("Image");
        model.addColumn("");
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        catalogPanel.add(scrollPane, BorderLayout.CENTER);


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

            }
        });
        button.add(checkout);
        catalogPanel.add(button, BorderLayout.SOUTH);

        table.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JButton addToCart = new JButton("Add to Cart");
                addToCart.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int row = table.getSelectedRow();
                        Item item = items.get(row);
                        cart.addItem(item);
                    }

                });
                return addToCart;
            }
        });
        table.setDefaultEditor(Object.class, null);
        setVisible(true);
        updateTable();

    }

    private void updateTable() {
        model.setRowCount(0);
        String selectedCategory = (String) cmCategory.getSelectedItem();
        for (Item item : items) {
            if (selectedCategory.equals("All") || selectedCategory.equals(item.getCategory())) {
                model.addRow(new Object[] { item.getName(), item.getSize(), item.getPrice(), item.getImage() });
            }
        }
    }


}


