/**
 * Created by Wojtek on 2015-11-22.
 */
import javax.swing.*;

public class ActionFrame extends JFrame {

    public ActionFrame() {
        super("Odtwarzacz");

        JPanel buttonPanel = new ButtonPanel();
        add(buttonPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
