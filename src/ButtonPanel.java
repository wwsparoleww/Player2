/**
 * Created by Wojtek on 2015-11-22.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import java.io.File;

import javax.swing.*;

public class ButtonPanel extends JPanel implements ActionListener{

    Odtwarzacz Odt = new Odtwarzacz();
   // JFileChooser fileChooser = new JFileChooser();

    public static final int HEIGHT = 100;
    public static final int WIDTH = 300;
    private JButton stopButton;
    private JButton playButton;
    private JButton pauseButton;
    private JButton openButton;

    public ButtonPanel() {
        stopButton = new JButton("STOP");
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        openButton = new JButton("...");

        stopButton.addActionListener(this);
        playButton.addActionListener(this);
        pauseButton.addActionListener(this);
        openButton.addActionListener(this);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(stopButton);
        add(playButton);
        add(pauseButton);
        add(openButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == stopButton)
            Odt.Stop();

        else if(source == playButton)
            Odt.Wznow();

        else if(source == pauseButton)
            Odt.Pause();

        else if(source == openButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path=selectedFile.getAbsolutePath();
            Odt.Graj(path);
            }
        }
    }
}
