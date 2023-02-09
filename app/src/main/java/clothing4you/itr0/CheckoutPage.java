package clothing4you.itr0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutPage extends JDialog {
    private JTextField tfCardName;
    private JTextField tfCardNum;
    private JTextField tfAddress;
    private JTextField tfCVC;
    private JTextField tfExpirationMonth;
    private JButton cancelButton;
    private JButton submitButton;
    private JTextField tfExpirationYear;
    private JPanel checkoutPanel;

    public CheckoutPage(JFrame parent) {
        super(parent);
        setTitle("Checkout");
        setContentPane(checkoutPanel);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setLocationRelativeTo(parent);


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add card info to the database
                //verify the details
                //printout a msg
            }
        });

        setVisible(true);
    }
}
