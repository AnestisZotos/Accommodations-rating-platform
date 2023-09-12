package api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Η κλάση αυτή χρησιμοποιείται για την οργάνωση όλων των χρηστών σε ένα ArrayList
 */
public class AllUsers implements Serializable {

    private ArrayList<User> users;

    public AllUsers(){
        users = new ArrayList<>();
    }

    /**
     * Προσθήκη χρήστη με την χρήση αντεικιμένου τύπου User
     * @param user Χρήστης
     * @return true εάν δεν υπάρχει άλλος χρήστης με ίδιο username, false αντίθετα
     */
    public boolean addUser(User user){
        for(User us : users){
            if(Objects.equals(user.getUsername(), us.getUsername())){
                return false;
            }
        }

        users.add(user);
        return true;
    }

    /**
     * Προσθήκη χρήστη χωρίς την χρήση αντεικιμένου τύπου User
     * @param name Όνομα
     * @param surname Επίθετο
     * @param username Όνομα χρήστη
     * @param password Κωδικός
     * @param type Τύπος χρήστη
     * @return true εάν δεν υπάρχει άλλος χρήστης με ίδιο username, false αντίθετα
     */
    public boolean addUser(String name, String surname, String username, String password, String type){

        for(User us : users){
            if(Objects.equals(username, us.getUsername())){
                return false;
            }
        }

        User user = new User(name,surname,username,password,type);

        users.add(user);
        return true;
    }

    /**
     * Η μέθοδος αφαιρεί ένα χρήστη
     * @param user Χρήστης
     * @return true εάν ο χρήστης αφαιρεθεί, false αντίθετα
     */
    public boolean removeUser(User user){

        if(users.size() == 0){
            return false;
        }

        return users.remove(user);
    }

    /**
     * Η μέθοδος αναζητεί ένα χρήστη με βάση το username του
     * @param username Όναμα χρήστη
     * @return Επιστρέφει το αντικείμενο User εάν ο χρήστης υπάρχει, null εάν ο χρήστης δεν υπάρχει
     */
    public User searchUserByUsername(String username){

        for(User user : users){
            if(Objects.equals(username, user.getUsername())){
                return user;
            }
        }

        return null;
    }

    public ArrayList<User> getAllUsers(){
        return users;
    }

}
