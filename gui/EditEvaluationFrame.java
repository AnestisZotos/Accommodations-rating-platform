package gui;
/*
 * Η κλάση αναπαριστά μια καρτέλα στην οποία ο simple user μπορεί να επεξεργαστεί την αξιολόγηση που έχει κάνει σε ένα κατάλυμα\
 * @author Anestis Zotos
 */


import api.Accommodation;
import api.CurrentUser;
import api.Evaluation;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;


public class EditEvaluationFrame {
    private JFrame editFrame;
    //constructor
    public EditEvaluationFrame(Accommodation acc){
         editFrame=new JFrame("Edit Evaluation");

         editFrame.addWindowListener(new WindowAdapter() {
             @Override
             public void windowClosing(WindowEvent e) {
                 setVisible(false);
                 UserFunctionsFrame.setVisible(true);
             }
         });
        boolean[] flag1=new boolean[1];
        flag1[0]=false;
        boolean[] flag2=new boolean[1];
        flag2[0]=false;
        boolean[] flag3=new boolean[1];
        flag3[0]=false;

        Evaluation evl=new Evaluation(acc.getEval(CurrentUser.getCurrentUser().getUsername()).getTxt_eval(),acc.getEval(CurrentUser.getCurrentUser().getUsername()).getNum_eval());

        //first text field
         JLabel lab1=new JLabel("Η αξιολόγησή σας σε μορφή κειμένου:");
         lab1.setBackground(new Color(144,144,144));
         lab1.setBorder(new LineBorder(Color.BLACK));
         lab1.setFont(new Font("Serif",Font.BOLD,16));

         String[] evltxt=new String[1];
         //αρχικοποήση του text field με την αξιολόγηση που έχει ήδη κάνει ο χρήστης(text)
         JTextField txt=new JTextField(acc.getEval(CurrentUser.getCurrentUser().getUsername()).getTxt_eval());
         txt.setBorder(new LineBorder(Color.BLACK));
         txt.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {

             }

             @Override
             public void focusLost(FocusEvent e) {
                 if(txt.getText().equals("")){
                     flag1[0]=false;
                 }
                 else {
                     flag1[0]=true;
                     evltxt[0] = txt.getText();
                     evl.setTxt_eval(evltxt[0]);
                 }

             }
         });


        //second text field
         JLabel lab2=new JLabel("Η αξιολόγησή σας σε μορφή αριθμού:");
         lab2.setBackground(new Color(144,144,144));
        lab2.setBorder(new LineBorder(Color.BLACK));
        lab2.setFont(new Font("Serif",Font.BOLD,16));

         double[] evlnum=new double[1];
        //αρχικοποήση του text field με την αξιολόγηση που έχει ήδη κάνει ο χρήστης(number)
         JTextField numf=new JTextField(String.valueOf(acc.getEval(CurrentUser.getCurrentUser().getUsername()).getNum_eval()));
         numf.setBorder(new LineBorder(Color.BLACK));
         numf.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {

             }

             @Override
             public void focusLost(FocusEvent e) {
                 try {
                     evlnum[0] = Double.parseDouble(numf.getText());
                     if (evlnum[0] > 5 || evlnum[0] < 1) {
                         JOptionPane.showMessageDialog(editFrame, "Παρακαλώ εισάγετε αριθμό στο διάστημα 1-5");
                         flag3[0] = false;
                     } else {
                         flag3[0] = true;
                         if (numf.getText().equals("")) {
                             flag2[0] = false;
                         } else {
                             flag2[0] = true;
                             evl.setNum_eval(evlnum[0]);
                         }
                     }

                 }catch (Exception exception){
                     JOptionPane.showMessageDialog(editFrame, "Παρακαλώ εισάγετε αριθμό στο διάστημα 1-5");
                     flag2[0]=false;
                 }
             }
         });


            //insert button
         JLabel lab3=new JLabel("Όταν τελειώσετε την επεξεργασία πατήστε καταχώρηση αξιολόγησης:");
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
                 if(flag1[0]!=false&&flag2[0]!=false&&flag3[0]!=false) {
                     acc.addEvaluation(CurrentUser.getCurrentUser().getUsername(), evl);
                     JOptionPane.showMessageDialog(editFrame, "Η καταχώρηση της νέας αξιολόγησης σου ολοκληρώθηκε");
                     editFrame.setVisible(false);
                 }
                 else{
                     JOptionPane.showMessageDialog(editFrame, "Παρακαλώ συμπληρώστε όλα τα πεδία.");
                 }

             }
         });


        //editEvaluation frame construction
        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(3,3));
        panel1.add(lab1);
        panel1.add(txt);
        panel1.add(lab2);
        panel1.add(numf);
        panel1.add(lab3);
        panel1.add(insert);
        editFrame.add(panel1);
        editFrame.setSize(1000,700);
        editFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        editFrame.setLocationRelativeTo(null);
    }

    public void setVisible(boolean b){
        editFrame.setVisible(b);
    }
}
