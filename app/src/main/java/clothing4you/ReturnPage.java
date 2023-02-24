package clothing4you;

import javax.swing.*;
import java.awt.*;

public class ReturnPage extends JDialog {
    private JPanel returnPanel;

    public ReturnPage(JFrame parent){
        super(parent);
        setTitle("Return");
        returnPanel = new JPanel(new BorderLayout());
        setContentPane(returnPanel);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setLocationRelativeTo(parent);



        setVisible(true);
    }
}
