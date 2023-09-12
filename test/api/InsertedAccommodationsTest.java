package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class InsertedAccommodationsTest {
    private InsertedAccommodations accommodations;

    @Before
    public void setUp() {
        accommodations=new InsertedAccommodations();


    }

    @Test
    public void addAccommodation() {
        Amenities amenities=new Amenities();
        Accommodation accommodation=new Accommodation("Name1","Hotel","Agioy nikolaou 15","Athens",55551,"Big",amenities);
        User user1=new User("Makis","Papadopoulos","makispap","123","provider");
        accommodations.AddAccommodation(accommodation,user1);
        Accommodation temp=accommodations.getArrayList().get(0);
        assertEquals(temp.getName(),"Name1");


    }


    @Test
    public void removeAccommodation() {
        Amenities amenities=new Amenities();
        Accommodation accommodation=new Accommodation("Name1","Hotel","Agioy nikolaou 15","Athens",55551,"Big",amenities);
        User user1=new User("Makis","Papadopoulos","makispap","123","provider");
        accommodations.AddAccommodation(accommodation,user1);
        accommodations.removeAccommodation(accommodation);
        assertEquals(accommodations.getKeySet().size(),0);

    }

    @Test
    public void removeAccommodationByName() {
        Amenities amenities=new Amenities();
        Accommodation accommodation=new Accommodation("Name1","Hotel","Agioy nikolaou 15","Athens",55551,"Big",amenities);
        User user1=new User("Makis","Papadopoulos","makispap","123","provider");
        accommodations.AddAccommodation(accommodation,user1);
        accommodations.removeAccommodationByName("");
        assertEquals(accommodations.getKeySet().size(),1);
        accommodations.removeAccommodationByName("Name1");
        assertEquals(accommodations.getKeySet().size(),0);
    }

    @Test
    public void getAccommodationProvider() {
        Amenities amenities=new Amenities();
        Accommodation accommodation=new Accommodation("Name1","Hotel","Agioy nikolaou 15","Athens",55551,"Big",amenities);
        User user1=new User("Makis","Papadopoulos","makispap","123","provider");
        accommodations.AddAccommodation(accommodation,user1);
        User user=accommodations.getAccommodationProvider(accommodation);
        assertEquals(user.getUsername(),"makispap");
    }

    @Test
    public void getKeySet() {
        Amenities amenities=new Amenities();
        Accommodation accommodation=new Accommodation("Name1","Hotel","Agioy nikolaou 15","Athens",55551,"Big",amenities);
        User user1=new User("Makis","Papadopoulos","makispap","123","provider");
        accommodations.AddAccommodation(accommodation,user1);
        Amenities amenities2=new Amenities();
        Accommodation accommodation2=new Accommodation("Name2","Motel","Tsimiski 20","Athens",55451,"Big",amenities);
        User user2=new User("Sotiris","Nasiopoulos","sotos","343","provider");
        accommodations.AddAccommodation(accommodation2,user2);
        assertEquals(accommodations.getKeySet().size(),2);

    }

    @Test
    public void getArrayList() {
        Amenities amenities=new Amenities();
        Accommodation accommodation=new Accommodation("Name1","Hotel","Agioy nikolaou 15","Athens",55551,"Big",amenities);
        User user1=new User("Makis","Papadopoulos","makispap","123","provider");
        accommodations.AddAccommodation(accommodation,user1);
        Amenities amenities2=new Amenities();
        Accommodation accommodation2=new Accommodation("Name2","Motel","Tsimiski 20","Athens",55451,"Big",amenities);
        User user2=new User("Sotiris","Nasiopoulos","sotos","343","provider");
        accommodations.AddAccommodation(accommodation2,user2);
        assertEquals(accommodations.getArrayList().size(),2);
    }
}