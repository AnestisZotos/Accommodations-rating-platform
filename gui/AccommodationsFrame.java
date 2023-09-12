package gui;

/*Η καρτέλα αυτή περιλαμβάνει όλα τα καταλύματα που έχουν καταχωρηθεί στην πλατφόρμα.Η καρτέλα θα εμφανίζεται αμέσως μετά το login ενός simple user.
Σημείωση: τα accommodations δεν εμφανίζονται στη σειρά που έχουν καταχωρηθεί στο InsertedAccommodations λόγω της χρήσης set στην getArrayList.
 @author Anestis Zotos
 */
import api.Accommodation;
import api.InsertedAccommodations;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AccommodationsFrame {
    private static JFrame acfr;
    //constructor
    public AccommodationsFrame(InsertedAccommodations accs){

        acfr=new JFrame("Accommodations");
        acfr.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               setVisible(false);
               MainFrame.setVisible(true);
           }
        });

        ArrayList<Accommodation> arr=accs.getArrayList();  //Βάζουμε όλα τα καταλύματα σε ένα arraylist ώστε να έχουν μια σειρά

       int i=0;
       JButton[] buttons=new JButton[arr.size()];
       JPanel[] panels=new JPanel[arr.size()];  //κάθε panel του πίνακα panels θα αποθηκεύει 5 συστατικα
       JLabel[] label1=new  JLabel[arr.size()];

       int[] flag=new int[1]; //βοηθητική μεταβλητή(πίνακας 1 θέσης) που θα μας δείξει σε ποία θέση του arr
                                // βρίσκεται το accommodation που αντιστοιχεί στο κουμπί που πάτησε ο χρήστης

       for(Accommodation ACC: arr){
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
                   temp=arr.get(flag[0]);
                   UserFunctionsFrame uff = new UserFunctionsFrame(temp); //το temp είναι το accommodation που επέλεξε ο χρήστης

                   uff.setVisible(true);
                   setVisible(false);
               }
           });
           panels[i]=new JPanel();
           panels[i].setBackground(new Color(144,144,144));
           panels[i].setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));
           panels[i].setLayout(new GridLayout(5,1));

           label1[i]=new JLabel(ACC.getName()); //όνομα καταλύματος
           label1[i].setFont(new Font("Serif",Font.BOLD,22));
           panels[i].add(label1[i]);
           panels[i].add(new JLabel(ACC.getType())); // τύπος καταλύματος
           panels[i].add(new JLabel(ACC.getCity())); // πόλη καταλύματος
           panels[i].add(new JLabel(String.valueOf(ACC.calculateAverageScore())+"/5")); //μέση βαθμολογία καταλύματος
           panels[i].add(buttons[i]);

           i++;
       }

       //menu construction
       JMenuBar menuBar=new JMenuBar();
       JMenu menu=new JMenu("MENU");

       JMenuItem searchItem=new JMenuItem("Αναζήτηση Καταλυμάτων");
       searchItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               SearchAccommodationsFrame searchFrame = new SearchAccommodationsFrame(accs);

               searchFrame.setVisible(true);
               setVisible(false);
           }
       });

        JMenuItem dashboard = new JMenuItem("Καρτέλα");
        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DashBoardFrame dashboard = new DashBoardFrame(accs);

                dashboard.setVisible(true);
                setVisible(false);
            }
        });

               menu.add(searchItem);
               menu.add(dashboard);
               menuBar.add(menu);

               //Accommodations frame construction
               JPanel panel2 = new JPanel();
               panel2.setBackground(new Color(49, 83, 94));
               panel2.setLayout(new FlowLayout());
               acfr.add(menuBar, BorderLayout.PAGE_START);
               for (i = 0; i < accs.getKeySet().size(); i++) {
                   panel2.add(panels[i]);
               }

               panel2.setPreferredSize(new Dimension(1000, 2500));

               JScrollPane sp = new JScrollPane(panel2);
               sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
               sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

               acfr.add(sp);
               acfr.setResizable(true);
               acfr.setSize(1000, 700);
               acfr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
               acfr.setLocationRelativeTo(null);

    }

    public static void setVisible(boolean b) {
        acfr.setVisible(b);
    }

}
