package gui;
/*
Η κλάση αναπαροστά μια καρτέλα για αναζήτηση καταλυμάτων απο έναν χρήστη
@auhtor Anestis Zotos
 */

import api.Accommodation;
import api.Amenities;
import api.InsertedAccommodations;
import api.UserFunctions;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class SearchAccommodationsFrame {
    private static JFrame frame;

    public SearchAccommodationsFrame(InsertedAccommodations accommodations){
        frame=new JFrame("Search Accommodations");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                AccommodationsFrame.setVisible(true);
            }
        });

        String[]  name=new String[1];
        name[0]="";
        String[] type=new String[1];
        type[0]="";
        String[] location=new String[1];
        location[0]="";
        Amenities amenities=new Amenities();
        Amenities emptyAmenities=new Amenities(); //Θα χρησιμοποιηθεί για να ελέγξω αν το ο χρήστης έχει βάλει εστω και μία παροχή στα check box

        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(4,2));
        JPanel panel2=new JPanel();
        panel2.setLayout(new GridLayout(2,1));

        JLabel lab1=new JLabel("Όνομα καταλύματος:");
        lab1.setBackground(new Color(144,144,144));
        lab1.setBorder(new LineBorder(Color.BLACK));
        lab1.setFont(new Font("Serif",Font.BOLD,16));

        JLabel lab2=new JLabel("Τύπος καταλύματος:");
        lab2.setBackground(new Color(144,144,144));
        lab2.setBorder(new LineBorder(Color.BLACK));
        lab2.setFont(new Font("Serif",Font.BOLD,16));

        JLabel lab3=new JLabel("Τοποθεσία καταλύματος:");
        lab3.setBackground(new Color(144,144,144));
        lab3.setBorder(new LineBorder(Color.BLACK));
        lab3.setFont(new Font("Serif",Font.BOLD,16));

        JLabel lab4=new JLabel("Παροχές καταλύματος:");
        lab4.setBackground(new Color(144,144,144));
        lab4.setBorder(new LineBorder(Color.BLACK));
        lab4.setFont(new Font("Serif",Font.BOLD,20));

        JTextField txtName=new JTextField("");
       // txtName.setBackground(new Color(49,83,94));
        txtName.setBorder(new LineBorder(Color.BLACK));
        txtName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                    name[0] = txtName.getText();
            }
        });

        JTextField txtType=new JTextField("");
       // txtType.setBackground(new Color(49,83,94));
        txtType.setBorder(new LineBorder(Color.BLACK));
        txtType.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                type[0]=txtType.getText();

            }
        });

        JTextField txtLocation=new JTextField("");
       // txtLocation.setBackground(new Color(49,83,94));
        txtLocation.setBorder(new LineBorder(Color.BLACK));
        txtLocation.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                location[0]=txtLocation.getText();

            }
        });

        //BUTTON FOR SEARCH
        JButton insertButton=new JButton("ΕΥΡΕΣΗ ΚΑΤΑΛΥΜΆΤΩΝ");
        insertButton.setBackground(new Color(144,144,144));
        insertButton.setBorder(new LineBorder(Color.BLACK));
        insertButton.setFont(new Font("Serif",Font.BOLD,16));


        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempName,tempType,tempLoc;
                if(name[0].equals("")){
                    tempName=null;
                }
                else{
                    tempName=name[0];
                }

                if(type[0].equals("")){
                    tempType=null;
                }
                else{
                    tempType=type[0];
                }

                if(location[0].equals("")){
                    tempLoc=null;
                }
                else{
                    tempLoc=location[0];
                }

                ArrayList<Accommodation> arrayList=new ArrayList<>();
                if(amenities.equals(emptyAmenities)){
                    arrayList=UserFunctions.searchWithCriteria(tempName,tempType,tempLoc,null,accommodations);
                }
                else{
                    arrayList=UserFunctions.searchWithCriteria(tempName,tempType,tempLoc,amenities,accommodations);
                }
                if(arrayList.size()==0){
                    JOptionPane.showMessageDialog(frame,"Δεν υπάρχουν καταλύματα με τα ζητούμενα κριτήρια");

                }
                else {
                    FoundAccommodationsFrame foundFrame = new FoundAccommodationsFrame(arrayList);

                    foundFrame.setVisible(true);
                    setVisible(false);
                }
            }
        });

        panel1.add(lab1);
        panel1.add(txtName);
        panel1.add(lab2);
        panel1.add(txtType);
        panel1.add(lab3);
        panel1.add(txtLocation);
        panel1.add(insertButton);
        panel1.setSize(20,20);

        JPanel panelCheckBoxes=new JPanel();
        panelCheckBoxes.setLayout(new GridLayout(26,1));

        JCheckBox[] arrayBoxes=new JCheckBox[26];
        int i,k=0; //k is an  index for arrayBoxes

        //View Amenities
        int [] temp1=new int[1]; //βοηθητικό array
        for(i=0;i<6;i++,k++)
        {
            temp1[0]=i ;
            arrayBoxes[k]=new JCheckBox( amenities.getView()[i]);
            arrayBoxes[k].setBackground(new Color(144,144,144));

            arrayBoxes[k].setSelected(false);
           arrayBoxes[k].addItemListener(new ItemListener() {
               @Override
               public void itemStateChanged(ItemEvent e) {
                   if(e.getStateChange()==ItemEvent.SELECTED){
                       amenities.setviewB(temp1[0],true);
                   }
                   else if(e.getStateChange()==ItemEvent.DESELECTED)
                   {
                       amenities.setviewB(temp1[0],false);
                   }

               }
           });
           panelCheckBoxes.add(arrayBoxes[k]);
        }

        //Bath Amenities
        int [] temp2=new int[1]; //βοηθητικό array
        for(i=0;i<1;i++,k++)
        {
            temp2[0]=i ;
            arrayBoxes[k]=new JCheckBox( amenities.getBath()[i]);
            arrayBoxes[k].setBackground(new Color(144,144,144));

            arrayBoxes[k].setSelected(false);
            arrayBoxes[k].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        amenities.setbathB(temp2[0],true);
                    }
                    else if(e.getStateChange()==ItemEvent.DESELECTED)
                    {
                        amenities.setbathB(temp2[0],false);
                    }

                }
            });
            panelCheckBoxes.add(arrayBoxes[k]);
        }

        //Wash Clothes Amenities
        int [] temp3=new int[1]; //βοηθητικό array
        for(i=0;i<2;i++,k++)
        {
            temp3[0]=i ;
            arrayBoxes[k]=new JCheckBox( amenities.getWash_clothes()[i]);
            arrayBoxes[k].setBackground(new Color(144,144,144));

            arrayBoxes[k].setSelected(false);
            arrayBoxes[k].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        amenities.setwash_clothesB(temp3[0],true);
                    }
                    else if(e.getStateChange()==ItemEvent.DESELECTED)
                    {
                        amenities.setwash_clothesB(temp3[0],false);
                    }

                }
            });
            panelCheckBoxes.add(arrayBoxes[k]);
        }

        //Entertainment Amenities
        int [] temp4=new int[1]; //βοηθητικό array
        for(i=0;i<1;i++,k++)
        {
            temp4[0]=i ;
            arrayBoxes[k]=new JCheckBox( amenities.getEntertainment()[i]);
            arrayBoxes[k].setBackground(new Color(144,144,144));

            arrayBoxes[k].setSelected(false);
            arrayBoxes[k].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        amenities.setentertainmentB(temp4[0],true);
                    }
                    else if(e.getStateChange()==ItemEvent.DESELECTED)
                    {
                        amenities.setentertainmentB(temp4[0],false);
                    }

                }
            });
            panelCheckBoxes.add(arrayBoxes[k]);
        }

        //Heating Amenities
        int [] temp5=new int[1]; //βοηθητικό array
        for(i=0;i<3;i++,k++)
        {
            temp5[0]=i ;
            arrayBoxes[k]=new JCheckBox( amenities.getHeating()[i]);
            arrayBoxes[k].setBackground(new Color(144,144,144));

            arrayBoxes[k].setSelected(false);
            arrayBoxes[k].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        amenities.setheatingB(temp5[0],true);
                    }
                    else if(e.getStateChange()==ItemEvent.DESELECTED)
                    {
                        amenities.setheatingB(temp5[0],false);
                    }

                }
            });
            panelCheckBoxes.add(arrayBoxes[k]);
        }

        //Internet Amenities
        int [] temp6=new int[1]; //βοηθητικό array
        for(i=0;i<2;i++,k++)
        {
            temp6[0]=i ;
            arrayBoxes[k]=new JCheckBox( amenities.getInternet()[i]);
            arrayBoxes[k].setBackground(new Color(144,144,144));

            arrayBoxes[k].setSelected(false);
            arrayBoxes[k].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        amenities.setinternetB(temp6[0],true);
                    }
                    else if(e.getStateChange()==ItemEvent.DESELECTED)
                    {
                        amenities.setinternetB(temp6[0],false);
                    }

                }
            });
            panelCheckBoxes.add(arrayBoxes[k]);
        }

        //Kitchen Amenities
        int [] temp7=new int[1]; //βοηθητικό array
        for(i=0;i<7;i++,k++)
        {
            temp7[0]=i ;
            arrayBoxes[k]=new JCheckBox( amenities.getKitchen()[i]);
            arrayBoxes[k].setBackground(new Color(144,144,144));

            arrayBoxes[k].setSelected(false);
            arrayBoxes[k].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        amenities.setkitchenB(temp7[0],true);
                    }
                    else if(e.getStateChange()==ItemEvent.DESELECTED)
                    {
                        amenities.setkitchenB(temp7[0],false);
                    }

                }
            });
            panelCheckBoxes.add(arrayBoxes[k]);
        }

        //Outside Amenities
        int [] temp8=new int[1]; //βοηθητικό array
        for(i=0;i<2;i++,k++)
        {
            temp8[0]=i ;
            arrayBoxes[k]=new JCheckBox( amenities.getOutside()[i]);
            arrayBoxes[k].setBackground(new Color(144,144,144));

            arrayBoxes[k].setSelected(false);
            arrayBoxes[k].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        amenities.setoutsideB(temp8[0],true);
                    }
                    else if(e.getStateChange()==ItemEvent.DESELECTED)
                    {
                        amenities.setoutsideB(temp8[0],false);
                    }

                }
            });
            panelCheckBoxes.add(arrayBoxes[k]);
        }

        //Parking Amenities
        int [] temp9=new int[1]; //βοηθητικό array
        for(i=0;i<2;i++,k++)
        {
            temp9[0]=i ;
            arrayBoxes[k]=new JCheckBox( amenities.getParking()[i]);
            arrayBoxes[k].setBackground(new Color(144,144,144));

            arrayBoxes[k].setSelected(false);
            arrayBoxes[k].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        amenities.setparkingB(temp9[0],true);
                    }
                    else if(e.getStateChange()==ItemEvent.DESELECTED)
                    {
                        amenities.setparkingB(temp9[0],false);
                    }

                }
            });
            panelCheckBoxes.add(arrayBoxes[k]);
        }

        panel2.add(lab4);
        panel2.add(panelCheckBoxes);

        JPanel generalPanel=new JPanel();
        generalPanel.setBackground(new Color(49,83,94));
        panel2.setBackground(new Color(144,144,144));
        panelCheckBoxes.setBackground(new Color(144,144,144));
        panel1.setBackground(new Color(144,144,144));

        generalPanel.setLayout(new GridLayout(1,2));
        generalPanel.add(panel1);
        generalPanel.add(panel2);

        frame.add(generalPanel);
        frame.setSize(1000,700);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    public static void setVisible(boolean b){
        frame.setVisible(b);
    }

}
