package api;

/**
 * Η κλάση χρησιμοποιείται για την αναγνώριση του χρήστη που χρησιμοποιεί την εφαρμογή
 * @author trifon
 */
public class CurrentUser {

    private static User currentUser = null;

    /**
     * Getter του χρήστη
     * @return Τον χρήστη
     */
    public static User getCurrentUser(){
        return currentUser;
    }

    /**
     * Setter του χρήστη
     * @param user Ο κύριος χρήστης
     */
    public static void setCurrentUser(User user){
        currentUser = user;
    }

}
