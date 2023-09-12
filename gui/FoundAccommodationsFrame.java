package gui;
/*
Η κλάση αναπαριστά μια καρτέλα με όλα τα καταλύματα που βρέθηκαν να πληρούν τα κριτήρια αναζήτησης του χρήστη
@author Anestis Zotos
 */

import api.Accommodation;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FoundAccommodationsFrame {

    private JFrame frame;
    public FoundAccommodationsFrame(ArrayList<Accommodation> accommodations){
        frame=new JFrame("Found Accommodations");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                SearchAccommodationsFrame.setVisible(true);
            }
        });

        int i=0;
        JButton[] buttons=new JButton[accommodations.size()];
        JPanel[] panels=new JPanel[accommodations.size()];  //κάθε panel του πίνακα panels θα αποθηκεύει 5 συστατικα
        JLabel[] label1=new  JLabel[accommodations.size()];

        int[] flag=new int[1]; //βοηθητική μεταβλητή(πίνακας 1 θέσης) που θα μας δείξει σε ποία θέση του arr
        // βρίσκεται το accommodation που αντιστοιχεί στο κουμπί που πάτησε ο χρήστης

        for(Accommodation ACC: accommodations){
            buttons[i]=new JButton("Επιλογή"); //δημιουργία κουμπιών επιλογής των καταλυμάτων,κάθε κουμπί αντιστοιχεί σε ένα κατάλυμα
            buttons[i].setBackground(new Color(144,144,144));
            buttons[i].setBorder(new LineBorder(Color.BLACK));
            buttons[i].setFont(new Font("Serif",Font.BOLD,16));
            buttons[i].setActionCommand(Integer.toString(i)); //θέτω ως actioncommand του εκάστοτε κουμπιού την θέση που έχει στον πίνακα buttons
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    flag[0]= Integer.parseInt(e.getActionCommand());

                    Accommodation acc ;
                    acc = accommodations.get(flag[0]);

                    ShowAccommodationPanel pan = new ShowAccommodationPanel(acc);

                    JFrame showFrame = new JFrame(acc.getName());
                    showFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    showFrame.setSize(1000,700);
                    showFrame.setResizable(false);
                    showFrame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            showFrame.setVisible(false);
                            setVisible(true);
                        }
                    });
                    showFrame.add(pan.getPanel());

                    Toolkit t = Toolkit.getDefaultToolkit();
                    Dimension d = t.getScreenSize();
                    showFrame.setLocation((d.width - frame.getWidth()) / 2, (d.height - frame.getHeight()) / 2);

                    showFrame.setVisible(true);
                    setVisible(false);

                }
            });
            panels[i]=new JPanel();
            panels[i].setBackground(new Color(144,144,144));
            panels[i].setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));
            panels[i].setLayout(new GridLayout(5,1));

            label1[i]=new JLabel(ACC.getName()); //ονομα καταλύματος
            label1[i].setFont(new Font("Serif",Font.BOLD,22));
            panels[i].add(label1[i]);

            panels[i].add(new JLabel(ACC.getType())); // τύπος καταλύματος
            panels[i].add(new JLabel(ACC.getCity())); // πόλη καταλύματος
            panels[i].add(new JLabel(String.valueOf(ACC.calculateAverageScore())+"/5")); //μέση βαθμολογία καταλύματος
            panels[i].add(buttons[i]);


            i++;
        }

        JPanel panel2=new JPanel();
        panel2.setBackground(new Color(49,83,94));
        panel2.setLayout(new FlowLayout());
        for(i=0;i<accommodations.size();i++)
        {
            panel2.add(panels[i]);
        }

        frame.add(panel2);
        frame.setSize(1000,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
