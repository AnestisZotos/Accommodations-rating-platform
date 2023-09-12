package gui;
/**
 * Η κλάση αναπαριστά μια καρτέλα που περιέχει όλες τις λειτουργίες που
 * μπορεί να εκτελέσει ένας πάροχος σε ένα κατάλυμα
 * @author trifon
 */

import api.CurrentUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProviderFunctionsFrame {

    private static JFrame providerFrame;
    private JButton buttAdd,buttEdit,buttRemove,buttDashboard;
    private JPanel panel;

    public ProviderFunctionsFrame(){

        providerFrame = new JFrame(CurrentUser.getCurrentUser().getUsername());
        providerFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                MainFrame.setVisible(true);
            }
        });
        providerFrame.setSize(1000,700);
        providerFrame.setResizable(false);
        providerFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        providerFrame.setLocationRelativeTo(null);

        buttAdd = new JButton("Προσθήκη καταχώρισης");
        buttAdd.setBackground(new Color(144,144,144));
        buttAdd.setFont(new Font("Serif",Font.BOLD,22));
        buttAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Add accommodation
                AddAccommodationFrame addFr = new AddAccommodationFrame();

                addFr.setVisible(true);
                setVisible(false);
            }
        });

        buttEdit = new JButton("Επεξεργασία καταχώρισης");
        buttEdit.setBackground(new Color(144,144,144));
        buttEdit.setFont(new Font("Serif",Font.BOLD,22));
        buttEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Edit accommodation
                EditAccommodationFrame editFr = new EditAccommodationFrame();

                editFr.setVisible(true);
                setVisible(false);
            }
        });

        buttRemove = new JButton("Διαγραφή καταχώρισης");
        buttRemove.setBackground(new Color(144,144,144));
        buttRemove.setFont(new Font("Serif",Font.BOLD,22));
        buttRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Remove accommodation
                DeleteAccommodationFrame delFr = new DeleteAccommodationFrame();

                delFr.setVisible(true);
                setVisible(false);
            }
        });

        buttDashboard = new JButton("Καρτέλα καταχωρίσεων");
        buttDashboard.setBackground(new Color(144,144,144));
        buttDashboard.setFont(new Font("Serif",Font.BOLD,22));
        buttDashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Show all accommodations
                ProviderAccomodationsFrame accomodationsFrame = new ProviderAccomodationsFrame();

                accomodationsFrame.setVisible(true);
                setVisible(false);
            }
        });

        GridLayout grid = new GridLayout(4,1,0,20);

        panel = new JPanel();
        panel.setLayout(grid);
        panel.setBackground(new Color(49,83,94));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        panel.add(buttAdd);
        panel.add(buttEdit);
        panel.add(buttRemove);
        panel.add(buttDashboard);

        providerFrame.add(panel);
    }

    public static void setVisible(boolean b) {
        providerFrame.setVisible(b);
    }
}
