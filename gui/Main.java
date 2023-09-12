package gui;

import api.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    private static MainFrame mainFrame;
    private static SignInFrame signinFrame;

    public static AllUsers users;
    public static InsertedAccommodations accommodations;

    public static void main(String []args){

        ArrayList<Object> list = (ArrayList<Object>) readFile();
        users = (AllUsers) list.get(0);
        accommodations = (InsertedAccommodations) list.get(1);

        // Create upper panel
        JLabel entrylabel = new JLabel("Καλώς Ήλθατε!");
        entrylabel.setBackground(new Color(144,144,144));
        entrylabel.setFont(new Font("Serif",Font.BOLD,26));
        entrylabel.setBorder(new EmptyBorder(20,20,20,20));
        entrylabel.setHorizontalAlignment(SwingConstants.CENTER);
        entrylabel.setVerticalAlignment(SwingConstants.CENTER);

        JButton buttonEntry = new JButton("Είσοδος");
        buttonEntry.setBackground(new Color(144,144,144));
        buttonEntry.setPreferredSize(new Dimension(10,10));
        buttonEntry.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Check if the current user is simple user or provider and create the right frame
                if(Objects.equals(CurrentUser.getCurrentUser().getType(), "user")){
                    // Create the User Functions Frame
                    AccommodationsFrame fr = new AccommodationsFrame(accommodations);

                    fr.setVisible(true);
                    mainFrame.setVisible(false);
                }
                else{
                    // Create the Provider Functions Frame
                    ProviderFunctionsFrame providerFr = new ProviderFunctionsFrame();

                    providerFr.setVisible(true);
                    mainFrame.setVisible(false);
                }
            }
        });
        buttonEntry.setFont(new Font("Serif",Font.BOLD,22));

        JLabel emptyla = new JLabel("");

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,1,0,50));
        panel1.setBorder(BorderFactory.createEmptyBorder(150, 300, 80, 300));
        panel1.setBackground(new Color(49,83,94));
        panel1.add(entrylabel);
        panel1.add(buttonEntry);
        panel1.add(emptyla);

        // Create bottom panel
        JButton buttonExit = new JButton("Έξοδος");
        buttonExit.setBackground(new Color(144,144,144));
        buttonExit.setPreferredSize(new Dimension(200,30));
        buttonExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onExit();
            }
        });
        buttonExit.setFont(new Font("Serif",Font.PLAIN,22));

        JButton buttonSwitch = new JButton("Αποσύνδεση");
        buttonSwitch.setBackground(new Color(144,144,144));
        buttonSwitch.setPreferredSize(new Dimension(200,30));
        buttonSwitch.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Go to login frame
                mainFrame.setVisible(false);
                signinFrame.setVisible(true);
                CurrentUser.setCurrentUser(null);
            }
        });
        buttonSwitch.setFont(new Font("Serif",Font.PLAIN,22));

        JPanel panel2 = new JPanel();
        FlowLayout layout = new FlowLayout();
        panel2.setLayout(layout);
        panel2.setBackground(Color.DARK_GRAY);
        panel2.add(buttonSwitch);
        panel2.add(buttonExit);

        // Create main panel
        JPanel entryPanel = new JPanel();
        entryPanel.setLayout(new BorderLayout());

        entryPanel.setBackground(new Color(49,83,94));
        entryPanel.add(panel1,"Center");
        entryPanel.add(panel2,"South");

        mainFrame = new MainFrame(entryPanel);
        signinFrame = new SignInFrame(users,mainFrame);

        // Show Sign in Frame
        signinFrame.setVisible(true);
    }

    public static void onExit(){
        // Save Accomodations and Users in files
        writeFile(users,accommodations);
        System.exit(0);
    }

    // Function to read file
    private static List<Object> readFile(){
        AllUsers users1 = new AllUsers();
        InsertedAccommodations accommodations1 = new InsertedAccommodations();

        try (FileInputStream fis = new FileInputStream("Save File.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            users1 = (AllUsers) ois.readObject();
            accommodations1 = (InsertedAccommodations) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Object> array = new ArrayList<>();
        array.add(users1);
        array.add(accommodations1);

        return array;
    }

    // Function to write file
    private static void writeFile(AllUsers users, InsertedAccommodations accommodations){
        try (FileOutputStream fos = new FileOutputStream("Save File.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(users);
            oos.writeObject(accommodations);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
