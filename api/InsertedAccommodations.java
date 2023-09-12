package api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * Η κλάση αυτή αναπαριστά όλα τα καταχωρημένα καταλύματα χρησιμοποιώντας ένα HashMap
 * @author  Anestis Zotos
 */

public class InsertedAccommodations implements Serializable {
    private HashMap<Accommodation, User> accommodations;

    public InsertedAccommodations(){
        accommodations = new HashMap<>();

    }
   public void AddAccommodation(Accommodation acc, User user){       //η μέθοδος καταχωρεί ένα κατάλυμα
        accommodations.put(acc,user);

    }

    /**
     * Η μέθοδος διαγράφει το επιλεγμένο κατάλυμα
     * @param acc Το κατάλυμα προς διαγραφή
     */
   public void removeAccommodation(Accommodation acc){
        accommodations.remove(acc);

   }

    /**
     * Η μέθοδος διαγράφει το κατάλυμα με το συγκεκριμένο όνομα
     * @param name Το όνομα του καταλύματος
     */
    public void removeAccommodationByName(String name){
        Accommodation remove = null;

        for(Accommodation a : accommodations.keySet()){
            if(Objects.equals(a.getName(), name)){
                remove = a;
            }
        }

        if(remove != null){
            accommodations.remove(remove);
        }
    }

    /**
     * Η μέθοδος αναζητεί τον πάροχο του καταλύματος
     * @param acc Το κατάλυμα προς αναζήτηση
     * @return Ένα αντικείμενο τύπου User εάν τι κατάλυμα υπάρχει
     */
   public User getAccommodationProvider(Accommodation acc){
        return accommodations.getOrDefault(acc,null);
   }

    /**
     * Η μέθοδος επιστρέφει ένα σύνολο με τα κλειδιά του HashMap
     * @return Set με τα κλειδιά (Accommodation)
     */
   public Set<Accommodation> getKeySet(){
       return accommodations.keySet();
   }

    /**
     * Η μέθοδος επιστρέφει όλα τα κλειδιά του hashmap accommodations σε ένα ArrayList
     * @return ArrayList με τα κλειδιά (τύπου Accommodation)
     */
    public ArrayList<Accommodation> getArrayList(){
       ArrayList<Accommodation> arr=new ArrayList<>();
       for(Accommodation acc: accommodations.keySet()){
           arr.add(acc);
       }
       return arr;

    }
}


