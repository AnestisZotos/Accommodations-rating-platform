package api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Η κλάση αυτή περιγράφει ένα κατάλυμα
 *@author Anestis Zotos
*/

public class Accommodation implements Serializable {
    private String name;
    private String type;
    private String address;
    private String city;
    private int postcode;
    private String description;
    private Amenities amenities;

    private HashMap<String,Evaluation> evaluations;


    public Accommodation(String Name,String Type,String Address,String City,int Postcode,String Description,Amenities am)
    {
        name=Name;
        type=Type;
        address=Address;
        city=City;
        postcode=Postcode;
        description=Description;
        amenities=am;
        evaluations=new HashMap<>();

    }

    // Getters
    public String getName(){return name;}

    public String getType(){return type;}

    public String getAddress(){return address;}

    public String getCity(){return city;}

    public int getPostcode(){return postcode;}

    public String getDescription(){return description;}

    public Amenities getAmenities(){return amenities;}



    // Setters

    public void setType(String type){
        this.type = type;}

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

    /**
     * Η μέθοδος αυτή δέχεται ως ορίσματα ένα username  και μία αξιολόγηση
     *και προσθέτει την αξιολόγηση που έκανε ο χρήστης στις συνολικές αξιολογήσεις του καταλύματος
     * @param username το όνομα του χρήστη που έκανε την αξιολόγηση
     * @param evl  η αξιολόγηση του χρήστη
     */

    public void addEvaluation(String username,Evaluation evl){
        evaluations.put(username,evl);
    }

    /**
     * Η μέθοδος δέχεται ως όρισμα ένα username και διαγράφει την αξιολόγηση που έκανε ο χρήστης με το συγκεκριμένο username
     * @param username όνομα χρήστη
     */
    public void removeEvaluation(String username){
        evaluations.remove(username);
    }

    /**
     * Η μέθοδος υπολογίζει το μέσο όρο των αξιολογήσεων του καταλύματος.Αν το πλήθος τον αξιολογήσεων
     * είναι διάφορο του μηδενός επιστρέφει το μέσο όρο,αλλίως επιστρέφει 0
     * @return μέσο όρο αξιολογήσεων (double)
     */

    public double calculateAverageScore(){
        double sum=0;
        int pl= evaluations.size();
        for(String s : evaluations.keySet()){
            sum+= evaluations.get(s).getNum_eval();
        }
        if(pl!=0){
            return sum*1.0/pl;
        }
        else{
            return 0;
        }

    }

    /**
     * Η μέθοδος δέχεται ως παράμετρο ένα username ενός simple user και επιστρέφει την αξιολόγηση που έχει κάνει στο κατάλυμα
     * Αν δεν έχει κάνει αξιολόγηση επιστρέφει null
     * @param username username ενος simple user
     * @return evaluation ή null
     */

    public Evaluation getEval(String username){
        return evaluations.get(username);
    }

    /**
     * Η μέθοδος υπολογίζει τον αριθμό των αξιολογήσεων που έχει δεχτεί το κατάλυμα
     * @return αριθμός αξιολογήσεων
     */
    public int getNumberOfEvals(){
        return evaluations.size();
    }

}
