package api;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserFunctionsTest {

    @Test
    public void searchWithCriteria() {

        User us = new User("Steph","ball","sball","4545","provider");
        Amenities am = new Amenities();

        Accommodation a1 = new Accommodation("Voras","Hotel","Fillipou 7","Thessaloniki",54444,"Big",am);
        Accommodation a2 = new Accommodation("Metropole","Motel","Fillipou 7","Thessaloniki",54444,"Big",am);
        Accommodation a3 = new Accommodation("Voras","Hotel","Fillipou 7","Thessaloniki",54444,"Big",am);
        Accommodation a4 = new Accommodation("Voras","Hotel","Fillipou 7","Athens",54444,"Big",am);
        Accommodation a5 = new Accommodation("Metropole","Hotel","Fillipou 7","Thessaloniki",54448,"Big",am);
        Accommodation a6 = new Accommodation("Voras","Hotel","Fillipou 7","Thessaloniki",54444,"Small",am);
        Accommodation a7 = new Accommodation("Neon","Hotel","Fillipou 7","Thessaloniki",54448,"Big",am);
        Accommodation a8 = new Accommodation("Voras","Hotel","Fillipou 7","Thessaloniki",54444,"Small",am);
        Accommodation a9 = new Accommodation("Neon","Hotel","Fillipou 7","Thessaloniki",54448,"Big",am);

        InsertedAccommodations accs = new InsertedAccommodations();
        accs.AddAccommodation(a1,us);
        accs.AddAccommodation(a2,us);
        accs.AddAccommodation(a3,us);
        accs.AddAccommodation(a4,us);
        accs.AddAccommodation(a5,us);
        accs.AddAccommodation(a6,us);
        accs.AddAccommodation(a7,us);
        accs.AddAccommodation(a8,us);
        accs.AddAccommodation(a9,us);

        assertEquals(UserFunctions.searchWithCriteria("Voras",null,null,null,accs).size(),5);
        assertEquals(UserFunctions.searchWithCriteria("Metropole","Motel",null,null,accs).size(),1);
        assertEquals(UserFunctions.searchWithCriteria("Neon",null,"Fillipou 7",null,accs).size(),2);
        assertEquals(UserFunctions.searchWithCriteria(null,null,null,am,accs).size(),9);
    }
}