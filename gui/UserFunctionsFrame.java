package gui;
/*Η κλάση αναπαριστά μια καρτέλα που περιέχει  τις λειτουργίες  που μπορεί να εκτελέσει ένας simple user σε ένα κατάλυμα
 *@author Anestis Zotos
*/
import api.Accommodation;
import api.CurrentUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserFunctionsFrame {
    private static JFrame frame;
    //constructor
    public UserFunctionsFrame(Accommodation acc){
        frame=new JFrame(acc.getName());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                AccommodationsFrame.setVisible(true);
            }
        });

        frame.setSize(1000,700);


        JButton butShow=new JButton("Προβολή Καταλύματος"); //1 button
        butShow.setBackground(new Color(144,144,144));
        butShow.setFont(new Font("Serif",Font.BOLD,22));

        butShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        JButton butNeweval=new JButton("Εισαγωγή Αξιολόγησης"); //2 button
        butNeweval.setBackground(new Color(144,144,144));
        butNeweval.setFont(new Font("Serif",Font.BOLD,22));

        butNeweval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check if user hasn't evaluated the accommodation
                if(acc.getEval(CurrentUser.getCurrentUser().getUsername())==null){
                    NewEvaluationFrame nevf = new NewEvaluationFrame(acc);

                    nevf.setVisible(true);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Έχετε ήδη καταχωρήσει αξιολόγηση για το επιλεγμένο κατάλυμα.");
                }
            }
        });


        JButton butEditeval=new JButton("Επεξεργασία Αξιολόγησης");
        butEditeval.setBackground(new Color(144,144,144));
        butEditeval.setFont(new Font("Serif",Font.BOLD,22));
        butEditeval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check if evaluation exists
                if(acc.getEval(CurrentUser.getCurrentUser().getUsername())!=null) {
                    EditEvaluationFrame fr = new EditEvaluationFrame(acc);

                    fr.setVisible(true);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Δεν έχετε καταχωρήσει αξιολόγηση για το επιλεγμένο κατάλυμα.");
                }

            }
        });

        JButton butdel=new JButton("Διαγραφή αξιολόγησης");
        butdel.setBackground(new Color(144,144,144));
        butdel.setFont(new Font("Serif",Font.BOLD,22));
        butdel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check if evaluation exists
                if(acc.getEval(CurrentUser.getCurrentUser().getUsername())!=null) {
                    DeleteEvaluationFrame delframe = new DeleteEvaluationFrame(acc);
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Δεν έχετε καταχωρήσει αξιολόγηση για το επιλεγμένο κατάλυμα.");
                }
                DeleteEvaluationFrame delframe=new DeleteEvaluationFrame(acc);

                delframe.setVisible(true);
                setVisible(false);
            }
        });

        //UserFunctions frame construction
        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(4,1,0,20));
        panel1.setBackground(new Color(49,83,94));
        panel1.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel1.add(butShow);
        panel1.add(butNeweval);
        panel1.add(butEditeval);
        panel1.add(butdel);

        frame.add(panel1);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    public static void setVisible(boolean b){
        frame.setVisible(b);
    }
}
