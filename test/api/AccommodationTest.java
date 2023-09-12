package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class AccommodationTest {
    private  Accommodation acc;

    @Before
    public void setUp() {
        Amenities amenities=new Amenities();
        Evaluation evaluation=new Evaluation("metrio",3.5);
        acc=new Accommodation("name","Hotel","Balaoritou 10","Skg",55534,"Mikro hotel",amenities);
        acc.addEvaluation("George",evaluation);

    }


    @Test
    public void addEvaluation() {
        Evaluation evaluation=new Evaluation("Poly kalo",5);
        acc.addEvaluation("Anestis",evaluation);
        assertEquals(acc.getEval("Anestis").getNum_eval(),5);
        assertEquals(acc.getEval("Anestis").getTxt_eval(),"Poly kalo");

    }

    @Test
    public void removeEvaluation() {
        acc.removeEvaluation("George");
        assertEquals(acc.getEval("George"),null);
    }

    @Test
    public void calculateAverageScore() {
        acc.removeEvaluation("George");
        assertEquals(acc.calculateAverageScore(),0);

        Evaluation evaluation1=new Evaluation("Metrio",3.5);
        Evaluation evaluation2=new Evaluation("Aristo",5);
        Evaluation evaluation3=new Evaluation("Aristo",5);
        acc.addEvaluation("George",evaluation1);
        acc.addEvaluation("Makis",evaluation2);
        acc.addEvaluation("Kostas",evaluation3);
        assertEquals(acc.calculateAverageScore(),4,5);
    }

    @Test
    public void getEval() {

        assertEquals(acc.getEval("George").getTxt_eval(),"metrio");
        assertEquals(acc.getEval("George").getNum_eval(),3.5);
    }
}