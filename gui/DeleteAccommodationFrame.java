package gui;

import api.Accommodation;
import api.CurrentUser;
import api.ProviderFunctions;

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
 * Η κλάση αναπαριστά το παράθυρο διαγραφής καταλύματος από ένα πάροχο
 * @author trifon
 */
public class DeleteAccommodationFrame {

    private JFrame delFrame;

    public DeleteAccommodationFrame(){

        delFrame = new JFrame("Τα καταλύματα του " + CurrentUser.getCurrentUser().getName());

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

            butts[i]=new JButton("Διαγραφή");
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

                    ShowAccommodationPanel pan = new ShowAccommodationPanel(selectedAccommodation);

                    JFrame Frame = new JFrame(selectedAccommodation.getName());
                    Frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    Frame.setSize(1000,700);
                    Frame.setResizable(false);
                    Frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            setVisible(true);
                            Frame.setVisible(false);
                        }
                    });
                    Frame.add(pan.getPanel());
                    Frame.setLocationRelativeTo(null);

                    Frame.setVisible(true);
                    setVisible(false);

                    JOptionPane pane = new JOptionPane("Είστε σίγουρος ότι θέλετε να διαγράψετε το συγκεκριμένο κατάλυμα;", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
                    JDialog dialog = pane.createDialog(null, "Επιβαιβέωση");
                    dialog.setVisible(true);
                    Object selectedValue = pane.getValue();
                    if(selectedValue != null && selectedValue.equals(JOptionPane.YES_OPTION)){
                        // user clicked Yes
                        ProviderFunctions.removeAccommodation(Main.accommodations,selectedAccommodation);
                    }
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
        delFrame.add(sp);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        delFrame.setSize(1000,700);
        delFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        delFrame.setLocationRelativeTo(null);
        delFrame.setResizable(true);
        delFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                ProviderFunctionsFrame.setVisible(true);
            }
        });
    }

    public void setVisible(boolean b){
        delFrame.setVisible(b);
    }
}
