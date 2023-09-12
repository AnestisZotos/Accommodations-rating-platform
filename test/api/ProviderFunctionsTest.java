package api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProviderFunctionsTest {

    InsertedAccommodations accs;

    @Before
    public void setUp() throws Exception {
        User us = new User("Steph","ball","sball","4545","provider");
        CurrentUser.setCurrentUser(us);
        Amenities am = new Amenities();

        Accommodation a1 = new Accommodation("Voras","Hotel","Fillipou 7","Thessaloniki",54444,"Big",am);
        Accommodation a2 = new Accommodation("Metropole","Motel","Fillipou 7","Thessaloniki",54444,"Big",am);
        Accommodation a3 = new Accommodation("Voras","Hotel","Fillipou 7","Thessaloniki",54444,"Big",am);

        accs = new InsertedAccommodations();
        accs.AddAccommodation(a1,us);
        accs.AddAccommodation(a2,us);
        accs.AddAccommodation(a3,us);
    }

    @Test
    public void addAccommodation() {
        Amenities am = new Amenities();
        User u = new User("Steph","ball","sball","4545","provider");

        Accommodation a4 = new Accommodation("Voras","Hotel","Fillipou 7","Athens",54444,"Big",am);
        Accommodation a5 = new Accommodation("Metropole","Hotel","Fillipou 7","Thessaloniki",54448,"Big",am);
        ProviderFunctions.addAccommodation(accs,a4);
        ProviderFunctions.addAccommodation(accs,a5);

        assertEquals(accs.getArrayList().size(),5);
        assertEquals(accs.getAccommodationProvider(a4).getUsername(),u.getUsername());
    }

    @Test
    public void removeAccommodation() {
        ArrayList<Accommodation> list = accs.getArrayList();

        ProviderFunctions.removeAccommodation(accs, list.get(0));
        assertEquals(accs.getKeySet().size(),2);
    }
}