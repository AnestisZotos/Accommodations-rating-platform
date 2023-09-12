package api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

/**
 * Η κλάση αυτή χρεισημοποιείται για την υλοποίηση όλων των λειτουργιών που μπορεί να εκτελέσει ένας χρήστης
 * @author trifon
 */
public class UserFunctions {

    /**
     * Η μέθοδος αυτή υποποιεί την αναζήτηση καταλυμάτων με βάση συγκεκριμένα κριτίρια που
     * επιθθμεί ο κάθε χρήστης. Εάν κάποιο κριτίριο δεν είναι θεμιτό να συμπεριληφθέι στην
     * αναζήτηση τότε στη θέση της παραμέτρου τοποθετείται ο δείκτης null.
     *
     * @param name Όνομα
     * @param type Τύπος
     * @param location Τοποθεσία (Πόλη ή διεύθυνση)
     * @param amenities Παροχές
     * @param accommodations HashMap με τα καταλύματα @NotNull
     * @return Ένα ArrayList με τα αποτελέσματα της αναζήτησης
     */
    public static ArrayList<Accommodation> searchWithCriteria(String name,String type,String location,Amenities amenities,InsertedAccommodations accommodations){

        ArrayList<Accommodation> list = new ArrayList<>();
        ArrayList<Accommodation> removeList = new ArrayList<>();
        Set<Accommodation> accommodationSet = accommodations.getKeySet();

        if(name != null){
            for(Accommodation acc : accommodationSet){
                if(Objects.equals(name, acc.getName())){
                    list.add(acc);
                }
            }

            if(type != null){
                for(Accommodation acc : list){
                    if(!Objects.equals(acc.getType(), type)){
                        removeList.add(acc);
                    }
                }

                for(Accommodation acc : removeList){
                    list.remove(acc);
                }
                removeList.clear();
            }

            if(location != null){
                for(Accommodation acc : list){
                    if(!Objects.equals(acc.getAddress(), location) && !Objects.equals(acc.getCity(), location)){
                        removeList.add(acc);
                    }
                }

                for(Accommodation acc : removeList){
                    list.remove(acc);
                }
                removeList.clear();
            }

            if(amenities != null){
                for(Accommodation acc : list){
                    if(!acc.getAmenities().equals(amenities)){
                        removeList.add(acc);
                    }
                }

                for(Accommodation acc : removeList){
                    list.remove(acc);
                }
                removeList.clear();
            }
        }
        else if(type != null){
            for(Accommodation acc : accommodationSet){
                if(Objects.equals(acc.getType(), type)){
                    list.add(acc);
                }
            }

            if(location != null){
                for(Accommodation acc : list){
                    if(!Objects.equals(acc.getAddress(), location) && !Objects.equals(acc.getCity(), location)){
                        removeList.add(acc);
                    }
                }

                for(Accommodation acc : removeList){
                    list.remove(acc);
                }
                removeList.clear();
            }

            if(amenities != null){
                for(Accommodation acc : list){
                    if(!acc.getAmenities().equals(amenities)){
                        removeList.add(acc);
                    }
                }

                for(Accommodation acc : removeList){
                    list.remove(acc);
                }
                removeList.clear();
            }
        }
        else if(location != null){
            for(Accommodation acc : accommodationSet){
                if(Objects.equals(acc.getAddress(), location) || Objects.equals(acc.getCity(), location)){
                    list.add(acc);
                }
            }

            if(amenities != null){
                for(Accommodation acc : list){
                    if(!acc.getAmenities().equals(amenities)){
                        removeList.add(acc);
                    }
                }

                for(Accommodation acc : removeList){
                    list.remove(acc);
                }
                removeList.clear();
            }
        }
        else if(amenities != null){
            for(Accommodation acc : accommodationSet){
                if(amenities.equals(acc.getAmenities())){
                    list.add(acc);
                }
            }
        }

        return list;
    }

    /**
     * Η μέθοδος επιστρέφει ένα ArrayList με όλα τα Accommodations τα οποία έχει αξιολογήσει ο χρήστης(username)
     * @param username όνομα χρήστη για τον οποίο βρίσκουμε τα αξιολογημένα καταλύματα
     * @param accommodations τα υπάρχοντα καταλύματα πάνω στα οποία θα γίνει η αναζήτηση
     * @return ArrayList με Accommodations τα οποία έχει αξιολογήσει ο χρήστης
     */

    public static ArrayList<Accommodation> FindEvaluatedAccommodations(String username,InsertedAccommodations accommodations){
        ArrayList<Accommodation> evaluatedAccommodations=new ArrayList<>();
        for(Accommodation acc:accommodations.getKeySet()){
            if(acc.getEval(username)!=null){
                evaluatedAccommodations.add(acc);
            }
        }
        return evaluatedAccommodations;
    }

    /**
     * Η μέθοδος υπολογίζει τον μέσο όρο της βαθμολογίας που έχει  δώσει ο χρήστης (username) συνολικά στα καταλύματα που
     * έχει αξιολογήσει.
     * @param username όνομα χρήστη
     * @param accommodations υπάρχοντα καταλύματα
     * @return τον μέσο όρο βαθμολογίας που έχει δώσει ο χρήστης συνολικά (double)
     */

    public  static double CalculateAverageEvaluation(String username,InsertedAccommodations accommodations){
        double sum=0;
        ArrayList<Accommodation> evaluatedAccommodations=UserFunctions.FindEvaluatedAccommodations(username,accommodations);
        for(Accommodation acc:evaluatedAccommodations){
            sum+=acc.getEval(username).getNum_eval();
        }
        if(evaluatedAccommodations.size()!=0) {
            return sum / evaluatedAccommodations.size();
        }
        else{
            return 0;
        }

    }


}
