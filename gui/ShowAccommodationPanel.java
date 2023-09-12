package gui;

import api.Accommodation;
import api.Amenities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowAccommodationPanel {

    private JPanel panel;
    private JLabel[] labels1,labels2;

    public ShowAccommodationPanel(Accommodation acc){

        panel = new JPanel();

        GridLayout gridLayout = new GridLayout(17,4,0,0);

        panel.setLayout(gridLayout);
        panel.setBackground(new Color(188,184,185));

        labels1 = new JLabel[33];
        labels2 = new JLabel[33];

        for(int i=0;i<33;i++){
            labels1[i] = new JLabel();
            labels2[i] = new JLabel();

            labels1[i].setFont(new Font("Serif", Font.BOLD, 16));
            labels1[i].setForeground(new Color(1,1,1));
            labels2[i].setFont(new Font("Serif", Font.BOLD, 16));
            labels2[i].setForeground(new Color(37,40,50));
        }

        labels1[0].setText("Όνομα :");
        labels1[1].setText("Τύπος :");
        labels1[2].setText("Διεύθυνση :");
        labels1[3].setText("Πόλη :");
        labels1[4].setText("Τ.Κ. :");
        labels1[5].setText("Περιγραφή :");
        labels1[6].setText("Παροχές");
        labels1[7].setText("Θέα σε πισίνα :");
        labels1[8].setText("Θέα στη θάλασσα :");
        labels1[9].setText("Θέα στο λιμάνι :");
        labels1[10].setText("θέα στο βουνό :");
        labels1[11].setText("Θέα σε παραλία :");
        labels1[12].setText("Θέα στο δρόμο :");
        labels1[13].setText("Πιστολάκι μαλλιών :");
        labels1[14].setText("Πλυντήριο ρούχων :");
        labels1[15].setText("Στεγνωτήριο :");
        labels1[16].setText("Τηλεόραση :");
        labels1[17].setText("Εσωτερικό τζάκι :");
        labels1[18].setText("κλιματισμός :");
        labels1[19].setText("κεντρική θέρμανση :");
        labels1[20].setText("wifi :");
        labels1[21].setText("ethernet :");
        labels1[22].setText("Κουζίνα :");
        labels1[23].setText("Ψυγείο :");
        labels1[24].setText("Φούρνος μικροκυμάτων :");
        labels1[25].setText("Μαγειρικά είδη :");
        labels1[26].setText("Πιάτα και μαχαιροπίρουνα :");
        labels1[27].setText("Πλυντήριο πιάτων :");
        labels1[28].setText("Καφετιέρα :");
        labels1[29].setText("Μπαλκόνι :");
        labels1[30].setText("Αυλή :");
        labels1[31].setText("Πάρκινγκ ιδιοκτησίας :");
        labels1[32].setText("Πάρκινγκ στο δρόμο :");

        Amenities am = acc.getAmenities();

        labels2[0].setText(acc.getName());
        labels2[1].setText(acc.getType());
        labels2[2].setText(acc.getAddress());
        labels2[3].setText(acc.getCity());
        labels2[4].setText(Integer.toString(acc.getPostcode()));
        labels2[5].setText(acc.getDescription());
        labels2[6].setText("");

        boolean[] bool = am.getViewB();
        labels2[7].setText(setAmenities(bool[0]));
        labels2[8].setText(setAmenities(bool[1]));
        labels2[9].setText(setAmenities(bool[2]));
        labels2[10].setText(setAmenities(bool[3]));
        labels2[11].setText(setAmenities(bool[4]));
        labels2[12].setText(setAmenities(bool[5]));
        bool = am.getBathB();
        labels2[13].setText(setAmenities(bool[0]));
        bool = am.getWash_clothesB();
        labels2[14].setText(setAmenities(bool[0]));
        labels2[15].setText(setAmenities(bool[1]));
        bool = am.getEntertainmentB();
        labels2[16].setText(setAmenities(bool[0]));
        bool = am.getHeatingB();
        labels2[17].setText(setAmenities(bool[0]));
        labels2[18].setText(setAmenities(bool[1]));
        labels2[19].setText(setAmenities(bool[2]));
        bool = am.getInternetB();
        labels2[20].setText(setAmenities(bool[0]));
        labels2[21].setText(setAmenities(bool[1]));
        bool = am.getKitchenB();
        labels2[22].setText(setAmenities(bool[0]));
        labels2[23].setText(setAmenities(bool[1]));
        labels2[24].setText(setAmenities(bool[2]));
        labels2[25].setText(setAmenities(bool[3]));
        labels2[26].setText(setAmenities(bool[4]));
        labels2[27].setText(setAmenities(bool[5]));
        labels2[28].setText(setAmenities(bool[6]));
        bool = am.getOutsideB();
        labels2[29].setText(setAmenities(bool[0]));
        labels2[30].setText(setAmenities(bool[1]));
        bool = am.getParkingB();
        labels2[31].setText(setAmenities(bool[0]));
        labels2[32].setText(setAmenities(bool[1]));

        for(int i=0;i<16;i++){
            panel.add(labels1[i]);
            panel.add(labels2[i]);
            panel.add(labels1[i+16]);
            panel.add(labels2[i+16]);
        }
        panel.add(labels1[32]);
        panel.add(labels2[32]);
    }

    String setAmenities(boolean b){

        if(b){
            return "Διαθέσιμο";
        }

        return " - ";
    }

    public JPanel getPanel(){
        return panel;
    }
}
