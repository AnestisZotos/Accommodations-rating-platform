package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame {

    private static JFrame frame;

    public MainFrame(JPanel panel){

        frame = new JFrame("Accommodation Application");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Main.onExit();
            }
        });
        frame.setSize(1000,700);
        frame.setResizable(false);
        frame.add(panel);

        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        frame.setLocation((d.width - frame.getWidth()) / 2, (d.height - frame.getHeight()) / 2);
    }

    public static void setVisible(boolean b){
        frame.setVisible(b);
    }

}
