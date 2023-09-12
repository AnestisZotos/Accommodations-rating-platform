package gui;

/*
 * Η κλάση αναπαριστά μια καρτέλα στην οποία ένας simple user θα μπορεί να γράψει μια καινουρια αξιολόγηση για το επιλεγμένο κατάλυμα
 * @author Anestis Zotos
 */


import api.Accommodation;
import api.CurrentUser;
import api.Evaluation;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class NewEvaluationFrame {

    private JFrame NewEframe;
    //constructor
    public NewEvaluationFrame(Accommodation acc){

        Evaluation evl=new Evaluation();

        boolean[] flag1=new boolean[1];
        flag1[0]=false;
        boolean[] flag2=new boolean[1];
        flag2[0]=false;
        boolean[] flag3=new boolean[1];
        flag3[0]=false;


        NewEframe=new JFrame("New Evaluation");

        NewEframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                UserFunctionsFrame.setVisible(true);
            }
        });

        //first text field
       String[] str=new String[1]; //βοηθητικός πίνακας συμβολοσειράς μίας θέσης

        JLabel lab1=new JLabel("Παρακαλώ εισάγετε την αξιολόγησή σας σε μορρφή κειμένου :");
        lab1.setBackground(new Color(144,144,144));
        lab1.setBorder(new LineBorder(Color.BLACK));
        lab1.setFont(new Font("Serif",Font.BOLD,16));


        JTextField txtf1=new JTextField("");
        txtf1.setBorder(new LineBorder(Color.BLACK));
        txtf1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                String s=txtf1.getText();
                if(s.equals("")){
                    flag1[0]=false;

                str[0] = s;
                evl.setTxt_eval(str[0]);
                }else {
                    str[0] = s;
                    evl.setTxt_eval(str[0]);
                    flag1[0]=true;
                }


            }
        });

        //second text field
        JLabel lab2=new JLabel("Εισάγετε την αξιολόγηση σας σε μορφή δεκαδικού αριθμού(1-5):");
         lab2.setBackground(new Color(144,144,144));
         lab2.setBorder(new LineBorder(Color.BLACK));
         lab2.setFont(new Font("Serif",Font.BOLD,16));

        JTextField txtf2 =new JTextField();
        txtf2.setBorder(new LineBorder(Color.BLACK));
        txtf2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    if (Double.parseDouble(txtf2.getText()) < 1 || Double.parseDouble(txtf2.getText()) > 5) {
                        flag3[0] = false;
                        JOptionPane.showMessageDialog(NewEframe, "Παρακαλώ εισάγετε αριθμό στο διάστημα 1-5");
                    } else {
                        flag3[0] = true;
                        if (txtf2.getText().equals("")) {
                            flag2[0] = false;

                double num = Double.parseDouble(txtf2.getText());
                evl.setNum_eval(num);
                        } else {
                            double num = Double.parseDouble(txtf2.getText());
                            evl.setNum_eval(num);
                            flag2[0] = true;
                        }
                    }


                }catch (Exception exception){
                    JOptionPane.showMessageDialog(NewEframe, "Παρακαλώ εισάγετε αριθμό στο διάστημα 1-5");
                    flag2[0]=false;
                }
            }
        });

        //insert button
        JLabel lab3=new JLabel("Ολοκληρώστε την εισαγωγή της αξιλόγησης πατώντας καταχώρηση:");
        lab3.setBackground(new Color(144,144,144));
        lab3.setBorder(new LineBorder(Color.BLACK));
        lab3.setFont(new Font("Serif",Font.BOLD,16));

        JButton insert=new JButton("Καταχώρηση αξιολόγησης");
        insert.setBackground(new Color(144,144,144));
        insert.setBorder(new LineBorder(Color.BLACK));
        insert.setFont(new Font("Serif",Font.BOLD,16));
       insert.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               acc.addEvaluation(CurrentUser.getCurrentUser().getUsername(), evl); //add the evaluation to the accommodation

                   if (flag1[0] != false && flag2[0] != false && flag3[0] != false) {
                       acc.addEvaluation(CurrentUser.getCurrentUser().getUsername(), evl); //add the evaluation to the accommodation
                       JOptionPane.showMessageDialog(NewEframe, "Η καταχώρηση της αξιολόγησης σας ολοκληρώθηκε");
                   } else {
                       JOptionPane.showMessageDialog(NewEframe, "Παρακαλώ συμπληρώστε όλα τα πεδία.");
                   }

           }
       });

        //NewEvaluation frame construction
        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(3,3));
        panel1.add(lab1);
        panel1.add(txtf1);
        panel1.add(lab2);
        panel1.add(txtf2);
        panel1.add(lab3);
        panel1.add(insert);

        NewEframe.setSize(1000,700);
        NewEframe.add(panel1);
        NewEframe.setLocationRelativeTo(null);
        NewEframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        NewEframe.setResizable(false);
    }

    public void setVisible(boolean b){
        NewEframe.setVisible(b);
    }
}
