package gui;
/*Η κλάση αναπαριστά μια καρτέλα τύπου dashboard που εξυπηρετεί τον χρήστη
    @author Anestis Zotos
*/



import api.Accommodation;
import api.CurrentUser;
import api.InsertedAccommodations;
import api.UserFunctions;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class DashBoardFrame {
    private JFrame frame;

    public  DashBoardFrame(InsertedAccommodations accommodations){
        frame=new JFrame("Dashboard Frame");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                AccommodationsFrame.setVisible(true);
            }
        });
        //Ευρεση αξιολογημένων καταλυμάτων απο τον χρήστη και τοποθέτηση τους σε ArrayList
        ArrayList<Accommodation> evaluatedAccommodations;
        evaluatedAccommodations= UserFunctions.FindEvaluatedAccommodations(CurrentUser.getCurrentUser().getUsername(),accommodations);
        // ο χρήστης έχει κάνει αξιολόγηση
        if(evaluatedAccommodations.size()!=0){

            int i=0;
            JButton[] buttons=new JButton[evaluatedAccommodations.size()];
            JPanel[] panels=new JPanel[evaluatedAccommodations.size()];  //κάθε panel του πίνακα panels θα αποθηκεύει 5 συστατικα
            JLabel[] label1=new  JLabel[evaluatedAccommodations.size()];

            int[] flag=new int[1]; //βοηθητική μεταβλητή(πίνακας 1 θέσης) που θα μας δείξει σε ποία θέση του arr
            // βρίσκεται το accommodation που αντιστοιχεί στο κουμπί που πάτησε ο χρήστης

            for(Accommodation ACC: evaluatedAccommodations){
                buttons[i]=new JButton("Επιλογή"); //δημιουργία κουμπιών επιλογής των καταλυμάτων,κάθε κουμπί αντιστοιχεί σε ένα κατάλυμα
                buttons[i].setBackground(new Color(144,144,144));
                buttons[i].setBorder(new LineBorder(Color.BLACK));
                buttons[i].setFont(new Font("Serif",Font.BOLD,16));
                buttons[i].setActionCommand(Integer.toString(i)); //θέτω ως actioncommand του εκάστοτε κουμπιού την θέση που έχει στον πίνακα buttons
                buttons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        flag[0]= Integer.parseInt(e.getActionCommand());

                        Accommodation temp ;
                        temp=evaluatedAccommodations.get(flag[0]);
                        //!!!TRYFWN BALE THN EPILOGH PROBOLHS KATALYMATOS!!!!!!

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
                panels[i].add(new JLabel("Η αξιολόγησή σας:"+Double.toString(ACC.getEval(CurrentUser.getCurrentUser().getUsername()).getNum_eval()))); //βαθμό αξιολόγησης που έχει δώσει ο χρήστης στο κατάλυμα
                panels[i].add(buttons[i]);


                i++;
            }
            JPanel panel2=new JPanel();
            panel2.setBackground(new Color(49,83,94));
            panel2.setLayout(new FlowLayout());
            for(i=0;i<evaluatedAccommodations.size();i++)
            {
                panel2.add(panels[i]);
            }

            JLabel label=new JLabel("Ο μέσος όρος της βαθμολογίας που έχετε δώσει στα καταλύματα είναι:");
            JLabel labelnum=new JLabel(Double.toString(UserFunctions.CalculateAverageEvaluation(CurrentUser.getCurrentUser().getUsername(),accommodations)));
           JPanel panel=new JPanel();
           panel.setBackground(new Color(144,144,144));
            panel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));
            panel.setLayout(new GridLayout(5,1));
           panel.setLayout(new FlowLayout());
           panel.add(label);
           panel.add(labelnum);
           frame.add(panel,BorderLayout.PAGE_END);
            frame.add(panel2);


        }
        //Ο χρήστης δεν εχει κάνει καμία αξιολόγηση
        else{
            JPanel panel1=new JPanel();
            panel1.setLayout(new FlowLayout());
            panel1.setBackground(new Color(49,83,94));
            JLabel lab1=new JLabel("Δεν έχετε καταχωρήσει αξιολόγηση σε κανένα κατάλυμα");
            lab1.setBackground(new Color(144,144,144));
            lab1.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));
            lab1.setLayout(new GridLayout(5,1));
            panel1.add(lab1);
            frame.add(panel1);
        }







        frame.setSize(1000,700);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void setVisible(boolean b){
        frame.setVisible(b);
    }

}
