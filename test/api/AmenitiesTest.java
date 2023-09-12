package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
class AmenitiesTest {
    private Amenities amenities;

    @Before
    public void setUp() {
        amenities=new Amenities();

    }

    @Test
    public void setviewB() {
        amenities.setviewB(0,true);
        assertEquals(amenities.getViewB()[0],true);
    }

    @Test
    public void setbathB() {
        amenities.setbathB(0,true);
        assertEquals(amenities.getBathB()[0],true);
    }

    @Test
    public void setheatingB() {
        amenities.setheatingB(0,true);
        assertEquals(amenities.getHeatingB()[0],true);


    }

    @Test
    public void setwash_clothesB() {
        amenities.setwash_clothesB(0,true);
        assertEquals(amenities.getWash_clothesB()[0],true);
    }

    @Test
    public void setentertainmentB() {
        amenities.setentertainmentB(0,true);
        assertEquals(amenities.getEntertainmentB()[0],true);
    }

    @Test
    public void setinternetB() {
        amenities.setinternetB(0,true);
        assertEquals(amenities.getInternetB()[0],true);
    }

    @Test
    public void setkitchenB() {
        amenities.setkitchenB(0,true);
        assertEquals(amenities.getKitchenB()[0],true);
    }

    @Test
    public void setoutsideB() {
        amenities.setoutsideB(0,true);
        assertEquals(amenities.getOutsideB()[0],true);
    }

    @Test
    public void setparkingB() {
        amenities.setparkingB(0,true);
        assertEquals(amenities.getParkingB()[0],true);
    }

    @Test
    public void testEquals() {
        Amenities amenities2=new Amenities();
        assertEquals(amenities.equals(amenities2),true);
        amenities2.setparkingB(0,true);
        assertEquals(amenities.equals(amenities2),false);
        amenities2.setinternetB(0,true);
        amenities2.setentertainmentB(0,true);
        amenities.setentertainmentB(0,true);
        assertEquals(amenities.equals(amenities2),false);
    }
}