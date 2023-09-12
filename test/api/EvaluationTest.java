package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class EvaluationTest {
    private Evaluation evaluation;

    @Before
    public void setUp() {
        evaluation=new Evaluation();
    }

    @Test
    public void getTxt_eval() {
        evaluation.setTxt_eval("Test text");
        assertEquals(evaluation.getTxt_eval(),"Test text");
    }

    @Test
    public void getNum_eval() {
        evaluation.setNum_eval(5);
        assertEquals(evaluation.getNum_eval(),5);
    }

    @Test
    public void setTxt_eval() {
        evaluation.setTxt_eval("Testing text");
        assertEquals(evaluation.getTxt_eval(),"Testing text");
    }

    @Test
    public void setNum_eval() {
        evaluation.setNum_eval(0);
        assertEquals(evaluation.getNum_eval(),0);
    }
}