package gui;
/*
 * Η κλάση αναπαριστά μια καρτέλα στην οποία ο simple user θα μπορεί να διαγράφει την αξιολόγηση που έχει κάνει για το επιλεγμένο κατάλυμα.
 * @author Anestis Zotos
 */

import api.Accommodation;
import api.CurrentUser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteEvaluationFrame {
    private JFrame delframe;
    //constructor
    public DeleteEvaluationFrame(Accommodation acc){
        delframe=new JFrame("Delete evaluation");
        delframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                UserFunctionsFrame.setVisible(true);
            }
        });

        JLabel lab1=new JLabel("Για την διαγραφή της αξιολόγησής σας πατήστε το κουμπί διαγραφή αξιολόγησης: ");
         lab1.setBackground(new Color(144,144,144));
        lab1.setBorder(new LineBorder(Color.BLACK));
        lab1.setFont(new Font("Serif",Font.BOLD,16));

        JButton delbut=new JButton("Διαγραφή αξιολόγησης");
        delbut.setBackground(new Color(144,144,144));
        delbut.setBorder(new LineBorder(Color.BLACK));
        delbut.setFont(new Font("Serif",Font.BOLD,16));
        delbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acc.removeEvaluation(CurrentUser.getCurrentUser().getUsername());
                JOptionPane.showMessageDialog(delframe,"Η αξιολόγηση σου διαγράφηκε");
                delframe.setVisible(false);
                UserFunctionsFrame.setVisible(true);
            }
        });

        //DeleteEvaluation frame construction
        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(2,1));
        panel1.add(lab1);
        panel1.add(delbut);

        delframe.add(panel1);
        delframe.setSize(1000,700);
        delframe.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        delframe.setLocationRelativeTo(null);
    }

    public void setVisible(boolean b){
        delframe.setVisible(b);
    }
}
