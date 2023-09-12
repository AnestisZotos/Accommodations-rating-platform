package gui;

import api.Accommodation;
import api.Amenities;
import api.ProviderFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Η κλάση αναπαριστά το παράθυρο εισαγωγής νέου καταλύματος από έναν πάροχο
 * @author trifon
 */
public class AddAccommodationFrame {

    private JFrame addFrame;
    private JLabel[] labels;
    private JTextField[] texts;
    private JPanel panel;
    private JCheckBox[] boxes;

    public AddAccommodationFrame(){

        addFrame = new JFrame("Καταχώριση Κατατλύματος");
        panel = new JPanel();

        GridLayout grid = new GridLayout(18,4,5,5);
        panel.setLayout(grid);
        panel.setBackground(new Color(188,184,185));

        labels = new JLabel[33];
        texts = new JTextField[6];
        boxes = new JCheckBox[26];

        for(int i=0;i<33;i++){
            labels[i] = new JLabel();
            labels[i].setFont(new Font("Serif", Font.BOLD, 16));
            labels[i].setForeground(new Color(1,1,1));
        }

        for(int i=0;i<6;i++){
            texts[i] = new JTextField("");
        }

        for(int i=0;i<26;i++){
            boxes[i] = new JCheckBox();

            boxes[i].setVerticalAlignment(SwingConstants.CENTER);
            boxes[i].setBackground(new Color(188,184,185));
        }

        JButton buttAdd = new JButton("Καταχώριση");
        buttAdd.setBackground(new Color(144,144,144));
        buttAdd.setFont(new Font("Serif",Font.BOLD,22));
        buttAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                createAccommodation();
            }
        });

        labels[0].setText("Όνομα :");
        labels[1].setText("Τύπος :");
        labels[2].setText("Διεύθυνση :");
        labels[3].setText("Πόλη :");
        labels[4].setText("Τ.Κ. :");
        labels[5].setText("Περιγραφή :");
        labels[6].setText("Παροχές");
        labels[7].setText("Θέα σε πισίνα :");
        labels[8].setText("Θέα στη θάλασσα :");
        labels[9].setText("Θέα στο λιμάνι :");
        labels[10].setText("θέα στο βουνό :");
        labels[11].setText("Θέα σε παραλία :");
        labels[12].setText("Θέα στο δρόμο :");
        labels[13].setText("Πιστολάκι μαλλιών :");
        labels[14].setText("Πλυντήριο ρούχων :");
        labels[15].setText("Στεγνωτήριο :");
        labels[16].setText("Τηλεόραση :");
        labels[17].setText("Εσωτερικό τζάκι :");
        labels[18].setText("κλιματισμός :");
        labels[19].setText("κεντρική θέρμανση :");
        labels[20].setText("wifi :");
        labels[21].setText("ethernet :");
        labels[22].setText("Κουζίνα :");
        labels[23].setText("Ψυγείο :");
        labels[24].setText("Φούρνος μικροκυμάτων :");
        labels[25].setText("Μαγειρικά είδη :");
        labels[26].setText("Πιάτα και μαχαιροπίρουνα :");
        labels[27].setText("Πλυντήριο πιάτων :");
        labels[28].setText("Καφετιέρα :");
        labels[29].setText("Μπαλκόνι :");
        labels[30].setText("Αυλή :");
        labels[31].setText("Πάρκινγκ ιδιοκτησίας :");
        labels[32].setText("Πάρκινγκ στο δρόμο :");

        for(int i=0;i<6;i++){
            panel.add(labels[i]);
            panel.add(texts[i]);
        }

        panel.add(labels[6]);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        for(int i=0;i<26;i++){
            panel.add(labels[i+7]);
            panel.add(boxes[i]);
        }

        panel.add(new JLabel(""));
        panel.add(buttAdd);

        addFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        addFrame.setSize(1000,700);
        addFrame.setResizable(false);
        addFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                ProviderFunctionsFrame.setVisible(true);
            }
        });
        addFrame.add(panel);
        addFrame.setLocationRelativeTo(null);
    }

    public void setVisible(boolean b){
        addFrame.setVisible(true);
    }

    private void createAccommodation(){

        String[] values = new String[6];

        for(int i=0;i<6;i++){
            values[i] = texts[i].getText();
            if(values[i].isEmpty()){
                JOptionPane.showMessageDialog(addFrame, "Κάποιο από τα πεδία είναι κενό. Προσπαθήστε ξανά.");
                return;
            }
        }

        Amenities amenities = new Amenities();

        if(boxes[0].isSelected()){
            amenities.setviewB(0,true);
        }

        if(boxes[1].isSelected()){
            amenities.setviewB(1,true);
        }

        if(boxes[2].isSelected()){
            amenities.setviewB(2,true);
        }

        if(boxes[3].isSelected()){
            amenities.setviewB(3,true);
        }

        if(boxes[4].isSelected()){
            amenities.setviewB(4,true);
        }

        if(boxes[5].isSelected()){
            amenities.setviewB(5,true);
        }

        if(boxes[6].isSelected()){
            amenities.setbathB(0,true);
        }

        if(boxes[7].isSelected()){
            amenities.setwash_clothesB(0,true);
        }

        if(boxes[8].isSelected()){
            amenities.setwash_clothesB(1,true);
        }

        if(boxes[9].isSelected()){
            amenities.setentertainmentB(0,true);
        }

        if(boxes[10].isSelected()){
            amenities.setheatingB(0,true);
        }

        if(boxes[11].isSelected()){
            amenities.setheatingB(1,true);
        }

        if(boxes[12].isSelected()){
            amenities.setheatingB(2,true);
        }

        if(boxes[13].isSelected()){
            amenities.setinternetB(0,true);
        }

        if(boxes[14].isSelected()){
            amenities.setinternetB(1,true);
        }

        if(boxes[15].isSelected()){
            amenities.setkitchenB(0,true);
        }

        if(boxes[16].isSelected()){
            amenities.setkitchenB(1,true);
        }

        if(boxes[17].isSelected()){
            amenities.setkitchenB(2,true);
        }

        if(boxes[18].isSelected()){
            amenities.setkitchenB(3,true);
        }

        if(boxes[19].isSelected()){
            amenities.setkitchenB(4,true);
        }

        if(boxes[20].isSelected()){
            amenities.setkitchenB(5,true);
        }

        if(boxes[21].isSelected()){
            amenities.setkitchenB(6,true);
        }

        if(boxes[22].isSelected()){
            amenities.setoutsideB(0,true);
        }

        if(boxes[23].isSelected()){
            amenities.setoutsideB(1,true);
        }

        if(boxes[24].isSelected()){
            amenities.setparkingB(0,true);
        }

        if(boxes[25].isSelected()){
            amenities.setparkingB(1,true);
        }

        Accommodation accommodation = new Accommodation(values[0],values[1],values[2],values[3],Integer.parseInt(values[4]),values[5],amenities);
        ProviderFunctions.addAccommodation(Main.accommodations,accommodation);
        JOptionPane.showMessageDialog(addFrame, "Το κατάλυμα προστέθηκε με επιτυχία.");
    }

}
