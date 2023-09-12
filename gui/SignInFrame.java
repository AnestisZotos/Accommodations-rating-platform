package gui;

import api.AllUsers;
import api.CurrentUser;
import api.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class SignInFrame {

    private JFrame frame;
    private JPanel panel;
    private JLabel userLab,passLab;
    private JTextField userText;
    private JPasswordField passText;
    private JButton buttonSignUp,buttonSignIn,buttonDelete;

    public SignInFrame(AllUsers users,MainFrame mainFrame){

        frame = new JFrame("Σύνδεση");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Main.onExit();
            }
        });
        frame.setSize(450,300);
        frame.setResizable(false);

        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        frame.setLocation((d.width - frame.getWidth()) / 2, (d.height - frame.getHeight()) / 2);

        panel = new JPanel();
        GridLayout gridLayout = new GridLayout(4,2,10,10);
        panel.setLayout(gridLayout);
        panel.setBackground(new Color(188,184,185));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        userLab = new JLabel("Όνομα χρήστη");
        passLab = new JLabel("Κωδικός");
        userText = new JTextField("");
        passText = new JPasswordField("");
        JLabel empty = new JLabel("");

        buttonSignIn = new JButton("Είσοδος");
        buttonSignIn.setBackground(new Color(144,144,144));
        buttonSignIn.setPreferredSize(new Dimension(100,30));
        buttonSignIn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String username = userText.getText();
                String password = passText.getText();
                User user = users.searchUserByUsername(username);

                if(user != null){
                    if(Objects.equals(user.getPassword(), password)){
                        // Connect
                        setVisible(false);
                        mainFrame.setVisible(true);
                        userText.setText("");
                        passText.setText("");
                        CurrentUser.setCurrentUser(user);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Ο χρήστης δεν υπάρχει. Προσπαθήστε ξανά.");
                }
            }
        });
        buttonSignIn.setFont(new Font("Serif",Font.BOLD,22));

        buttonSignUp = new JButton("Εγγραφή");
        buttonSignUp.setBackground(new Color(144,144,144));
        buttonSignUp.setPreferredSize(new Dimension(100,30));
        buttonSignUp.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame signUp = new JFrame("Εγγραφή");
                signUp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                signUp.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        Main.onExit();
                    }
                });
                signUp.setSize(450,300);
                signUp.setResizable(false);

                Toolkit t = Toolkit.getDefaultToolkit();
                Dimension d = t.getScreenSize();
                signUp.setLocation((d.width - frame.getWidth()) / 2, (d.height - frame.getHeight()) / 2);

                JLabel nameLab,surnameLab,userlab,passlab,pass2Lab;
                JTextField nameText,surnameText,usertext,passtext;
                JPasswordField pass2Text;
                JLabel emptyLab = new JLabel("");

                JCheckBox bx1 = new JCheckBox("Πάροχος");
                JCheckBox bx2 = new JCheckBox("Χρήστης");

                nameLab = new JLabel("Όνομα");
                surnameLab = new JLabel("Επίθετο");
                userlab = new JLabel("Όνομα χρήστη");
                passlab = new JLabel("Κωδικός");
                pass2Lab = new JLabel("Επαλήθευση");

                nameText = new JTextField("");
                surnameText = new JTextField("");
                usertext = new JTextField("");
                passtext = new JTextField("");
                pass2Text = new JPasswordField("");

                JButton sign = new JButton("Εγγραφή");
                sign.setBackground(new Color(144,144,144));
                sign.setFont(new Font("Serif",Font.BOLD,22));
                sign.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        String temp1,temp2,temp3,temp4,temp5;
                        temp1 = nameText.getText();
                        temp2 = surnameText.getText();
                        temp3 = usertext.getText();
                        temp4 = passtext.getText();
                        char[] temp = pass2Text.getPassword();
                        temp5 = String.valueOf(temp);

                        if(temp1.isEmpty() || temp2.isEmpty() || temp3.isEmpty() || temp4.isEmpty() || temp5.isEmpty() || (!bx1.isSelected() && !bx2.isSelected())){
                            JOptionPane.showMessageDialog(frame, "Κάποιο από τα πεδία είναι κενό. Προσπαθήστε ξανά.");
                        }
                        else if(!temp4.equals(temp5)){
                            JOptionPane.showMessageDialog(frame, "Ο κωδικός πρέπει να είναι ίδιος. Προσπαθήστε ξανά.");
                        }
                        else{
                            User us;
                            if(bx1.isSelected()) {
                                us = new User(temp1,temp2,temp3,temp4,"provider");
                            }
                            else{
                                us = new User(temp1,temp2,temp3,temp4,"user");
                            }

                            for(User user : Main.users.getAllUsers()){
                                if(temp3.equals(user.getUsername())){
                                    JOptionPane.showMessageDialog(frame, "Το συγκεκριμένο όνομα χρήστη δεν είναι διαθέσιμο. Επιλέξτε ένα διαφορετικό.");
                                    return;
                                }
                            }

                            JOptionPane.showMessageDialog(frame, "Επιτυχής εγγραφή.");
                            signUp.setVisible(false);
                            frame.setVisible(true);

                            // Add the new user to the AllUsers object
                            Main.users.addUser(us);
                        }
                    }
                });

                JPanel pan = new JPanel();
                GridLayout grid = new GridLayout(7,2,10,10);
                pan.setLayout(grid);
                pan.setBackground(new Color(188,184,185));
                pan.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

                pan.add(nameLab);
                pan.add(nameText);
                pan.add(surnameLab);
                pan.add(surnameText);
                pan.add(userlab);
                pan.add(usertext);
                pan.add(passlab);
                pan.add(passtext);
                pan.add(pass2Lab);
                pan.add(pass2Text);

                ButtonGroup bg = new ButtonGroup();
                bg.add(bx1);
                bg.add(bx2);
                pan.add(bx1);
                pan.add(emptyLab);
                pan.add(bx2);
                pan.add(sign);

                signUp.add(pan);

                setVisible(false);
                signUp.setVisible(true);
            }
        });
        buttonSignUp.setFont(new Font("Serif",Font.BOLD,22));

        buttonDelete = new JButton("Διαγραφή Λογαριασμού");
        buttonDelete.setBackground(new Color(144,144,144));
        buttonDelete.setPreferredSize(new Dimension(100,30));
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame fr = new JFrame("Διαγραφή Λογαριασμού");
                fr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                fr.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        Main.onExit();
                    }
                });
                fr.setSize(400,250);
                fr.setResizable(false);

                Toolkit t = Toolkit.getDefaultToolkit();
                Dimension d = t.getScreenSize();
                fr.setLocation((d.width - frame.getWidth()) / 2, (d.height - frame.getHeight()) / 2);

                JPanel pane1 = new JPanel();
                GridLayout gridLayout = new GridLayout(3,2,10,10);
                pane1.setLayout(gridLayout);
                pane1.setBackground(new Color(188,184,185));
                pane1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

                JLabel user2 = new JLabel("Όνομα χρήστη");
                JLabel pass2 = new JLabel("Κωδικός");
                JTextField userText2 = new JTextField("");
                JTextField passText2 = new JPasswordField("");
                //JLabel empty2 = new JLabel("");

                JButton butt1 = new JButton("Διαγραφή");
                butt1.setBackground(new Color(144,144,144));
                butt1.setFont(new Font("Serif",Font.BOLD,22));
                butt1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        User u;
                        String name = userText2.getText();
                        String password = passText2.getText();

                        if(!name.isEmpty() && !password.isEmpty()) {
                            u = Main.users.searchUserByUsername(name);

                            if(u != null){
                                if(Objects.equals(u.getPassword(), password)){
                                    Main.users.removeUser(u);
                                    JOptionPane.showMessageDialog(frame, "Ο χρήστης διαγράφηκε με επιτυχία.");
                                    fr.setVisible(false);
                                    setVisible(true);
                                }
                                else{
                                    JOptionPane.showMessageDialog(frame, "Λάθος κωδικός.");
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(frame, "Ο χρήστης αυτός δεν υπάρχει.");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(frame, "Το πεδίο είναι κενό. Προσπαθήστε ξανά.");
                        }
                    }
                });

                JButton butt2 = new JButton("Πίσω");
                butt2.setBackground(new Color(144,144,144));
                butt2.setFont(new Font("Serif",Font.BOLD,22));
                butt2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        fr.setVisible(false);
                        setVisible(true);
                    }
                });

                pane1.add(user2);
                pane1.add(userText2);
                pane1.add(pass2);
                pane1.add(passText2);
                pane1.add(butt2);
                pane1.add(butt1);

                fr.add(pane1);

                setVisible(false);
                fr.setVisible(true);

            }
        });

        panel.add(userLab);
        panel.add(userText);
        panel.add(passLab);
        panel.add(passText);
        panel.add(buttonDelete);
        panel.add(empty);
        panel.add(buttonSignUp);
        panel.add(buttonSignIn);

        frame.add(panel);
    }

    public void setVisible(boolean b){
        frame.setVisible(b);
    }
}
