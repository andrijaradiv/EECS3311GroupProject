package clothing4you;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checkout extends JDialog {
    private JTextField tfCardName;
    private JTextField tfCardNum;
    private JTextField tfAddress;
    private JTextField tfCVC;
    private JTextField tfExpirationMonth;
    private JButton cancelButton;
    private JButton submitButton;
    private JTextField tfExpirationYear;
    private JPanel checkoutPanel;
    private JLabel creditImage;

    ImageIcon creditIcon = new ImageIcon("credit-card.png");

    public Checkout(JFrame parent) {
        super(parent);
        setTitle("Checkout");
        setContentPane(checkoutPanel);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setLocationRelativeTo(parent);

        creditImage.setText("");
        creditImage.setIcon(creditIcon);

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
                authorizePayment();
            }
        });

        setVisible(true);
    }

    private void authorizePayment() {
        String cardName = tfCardName.getText();
        String cardNum = String.valueOf(tfCardNum.getText());
        String billAddress = tfAddress.getText();
        String cvc = String.valueOf(tfCVC.getText());
        String expirationMonth = tfExpirationMonth.getText();
        String expirationYear =  tfExpirationYear.getText();

        if (cardNum.isEmpty() || cardName.isEmpty() || billAddress.isEmpty() || cvc.isEmpty() || expirationMonth.isEmpty() || expirationYear.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    //main method to test it
    public static void main(String[] args) {
        Checkout chk = new Checkout(null);
    }

}
