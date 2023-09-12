package gui;

import api.Accommodation;
import api.Amenities;
import api.CurrentUser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Η κλάση αναπαριστά το παράθυρο επεξεργασίας ενός καταλύματος από έναν πάροχο
 * @author trifon
 */
public class EditAccommodationFrame {

    private JFrame editFrame,edFr;
    private JLabel[] labels;
    private JTextField[] texts;
    private JPanel panel;
    private JCheckBox[] boxes;

    public EditAccommodationFrame(){

        editFrame = new JFrame("Τα καταλύματα του " + CurrentUser.getCurrentUser().getName());

        int i=0;
        int[] flag = new int[1];

        ArrayList<Accommodation> list0  = Main.accommodations.getArrayList();
        ArrayList<Accommodation> list = new ArrayList<>();

        for(Accommodation acco : list0){
            if(Objects.equals(Main.accommodations.getAccommodationProvider(acco).getUsername(), CurrentUser.getCurrentUser().getUsername())){
                list.add(acco);
            }
        }

        JButton[] butts = new JButton[list.size()];
        JPanel[] panels = new JPanel[list.size()];
        JLabel[] labels = new JLabel[list.size()];

        for(Accommodation ac : list){

            butts[i]=new JButton("Επεξεργασία");
            butts[i].setBackground(new Color(144,144,144));
            butts[i].setBorder(new LineBorder(Color.BLACK));
            butts[i].setFont(new Font("Serif",Font.BOLD,16));
            butts[i].setActionCommand(Integer.toString(i));
            butts[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    flag[0] = Integer.parseInt(e.getActionCommand());

                    Accommodation selectedAccommodation;
                    selectedAccommodation = list.get(flag[0]);

                    // Open edit frame with parameter the selectedAccommodation
                    EditFrame(selectedAccommodation);
                }
            });

            panels[i] = new JPanel();
            panels[i].setBackground(new Color(144,144,144));
            panels[i].setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));
            panels[i].setLayout(new GridLayout(4,1));

            labels[i] = new JLabel(ac.getName());
            labels[i].setFont(new Font("Serif",Font.BOLD,22));

            panels[i].add(labels[i]);
            panels[i].add(new JLabel(ac.getType()));
            panels[i].add(new JLabel(ac.getCity()));
            panels[i].add(butts[i]);

            i++;
        }

        JPanel secPanel = new JPanel();
        secPanel.setBackground(new Color(49,83,94));
        secPanel.setLayout(new FlowLayout());

        for(int k=0;k<list.size();k++){
            secPanel.add(panels[k]);
        }

        secPanel.setPreferredSize(new Dimension(1000,2500));

        JScrollPane sp = new JScrollPane(secPanel);
        editFrame.add(sp);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        editFrame.setSize(1000,700);
        editFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        editFrame.setLocationRelativeTo(null);
        editFrame.setResizable(false);
        editFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                ProviderFunctionsFrame.setVisible(true);
            }
        });
    }

    public void setVisible(boolean b){
        editFrame.setVisible(b);
    }

    private void EditFrame(Accommodation ac){

        edFr = new JFrame(ac.getName());
        panel = new JPanel();

        GridLayout gridLayout = new GridLayout(18,4,5,5);
        panel.setLayout(gridLayout);
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

        JButton buttEdit = new JButton("Εφαρμογή");
        buttEdit.setBackground(new Color(144,144,144));
        buttEdit.setFont(new Font("Serif",Font.BOLD,22));
        buttEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                makeEdit(ac);
            }
        });

        texts[0].setText(ac.getName());
        texts[1].setText(ac.getType());
        texts[2].setText(ac.getAddress());
        texts[3].setText(ac.getCity());
        texts[4].setText(Integer.toString(ac.getPostcode()));
        texts[5].setText(ac.getDescription());

        Amenities am = ac.getAmenities();

        boolean[] bool = am.getViewB();
        if(bool[0]){
            boxes[0].setSelected(true);
        }

        if(bool[1]){
            boxes[1].setSelected(true);
        }

        if(bool[2]){
            boxes[2].setSelected(true);
        }

        if(bool[3]){
            boxes[3].setSelected(true);
        }

        if(bool[4]){
            boxes[4].setSelected(true);
        }

        if(bool[5]){
            boxes[5].setSelected(true);
        }

        bool = am.getBathB();
        if(bool[0]){
            boxes[6].setSelected(true);
        }

        bool = am.getWash_clothesB();
        if(bool[0]){
            boxes[7].setSelected(true);
        }

        if(bool[1]){
            boxes[8].setSelected(true);
        }

        bool = am.getEntertainmentB();
        if(bool[0]){
            boxes[9].setSelected(true);
        }

        bool = am.getHeatingB();
        if(bool[0]){
            boxes[10].setSelected(true);
        }

        if(bool[1]){
            boxes[11].setSelected(true);
        }

        if(bool[2]){
            boxes[12].setSelected(true);
        }

        bool = am.getInternetB();
        if(bool[0]){
            boxes[13].setSelected(true);
        }

        if(bool[1]){
            boxes[14].setSelected(true);
        }

        bool = am.getKitchenB();
        if(bool[0]){
            boxes[15].setSelected(true);
        }

        if(bool[1]){
            boxes[16].setSelected(true);
        }

        if(bool[2]){
            boxes[17].setSelected(true);
        }

        if(bool[3]){
            boxes[18].setSelected(true);
        }

        if(bool[4]){
            boxes[19].setSelected(true);
        }

        if(bool[5]){
            boxes[20].setSelected(true);
        }

        if(bool[6]){
            boxes[21].setSelected(true);
        }

        bool =  am.getOutsideB();
        if(bool[0]){
            boxes[22].setSelected(true);
        }

        if(bool[1]){
            boxes[23].setSelected(true);
        }

        bool = am.getParkingB();
        if(bool[0]){
            boxes[24].setSelected(true);
        }

        if(bool[1]){
            boxes[25].setSelected(true);
        }

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
        panel.add(buttEdit);

        edFr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        edFr.setSize(1000,700);
        edFr.setResizable(false);
        edFr.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                editFrame.setVisible(true);
            }
        });
        edFr.add(panel);
        edFr.setLocationRelativeTo(null);
        edFr.setVisible(true);
    }

    private void makeEdit(Accommodation accommodation){

        String[] values = new String[6];

        for(int i=0;i<6;i++){
            values[i] = texts[i].getText();
            if(values[i].isEmpty()){
                JOptionPane.showMessageDialog(edFr, "Κάποιο από τα πεδία είναι κενό. Προσπαθήστε ξανά.");
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

        accommodation.setName(values[0]);
        accommodation.setType(values[1]);
        accommodation.setAddress(values[2]);
        accommodation.setCity(values[3]);
        accommodation.setPostcode(Integer.parseInt(values[4]));
        accommodation.setDescription(values[5]);
        accommodation.setAmenities(amenities);

        JOptionPane.showMessageDialog(edFr, "Οι επεξεργασίες έγινανμε επιτυχία.");
    }
}
