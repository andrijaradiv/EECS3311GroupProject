package clothing4you;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Return extends JDialog{
    private JPanel returnPanel;
    private JSpinner quantitySpinner;
    private JTextField returnTF;
    private JTextField nameTF;
    private JButton submitBtn;
    private JButton cancelBtn;
    private ArrayList<Item> items;
    private Cart cart;

    public Return(JFrame parent, ArrayList<Item> items){
        super(parent);
        setTitle("Login");
        setContentPane(returnPanel);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setLocationRelativeTo(parent);

        this.items = items;
        cart = new Cart();

        quantitySpinner.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                successfulReturn();
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Catalog myCatalog = new Catalog(null);
            }
        });

        setVisible(true);
    }

    public void successfulReturn(){
        String itemName = nameTF.getText();
        int quantity = (int) quantitySpinner.getValue();
        boolean itemExist = true;

        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemExist = true;
                // perform the return submission for this item
                break;
            }
        }

        if (itemExist) {
            JOptionPane.showMessageDialog(null, "Your return submission was submitted successfully.");

            // preform the return submission
        } else {
            JOptionPane.showMessageDialog(null, "The item you entered does not exist.");
        }
    }

}

