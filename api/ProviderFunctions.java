package api;

/**
 *  Η κλάση αυτή χρεισημοποιείται για την υλοποίηση όλων των λειτουργιών που μπορεί να εκτελέσει ένας πάροχος
 * @author trifon
 */
public class ProviderFunctions {

    public static void addAccommodation(InsertedAccommodations accommodations, Accommodation acc){
        accommodations.AddAccommodation(acc,CurrentUser.getCurrentUser());
    }

    public static void removeAccommodation(InsertedAccommodations accommodations, Accommodation acc){
        accommodations.removeAccommodation(acc);
    }

}
