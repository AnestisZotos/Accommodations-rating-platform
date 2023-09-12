package api;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * Η κλάση αυτή αναπαριστά μια αξιολόγηση ενός καταλύματος
 * @author Anestis Zotos
 */

public class Evaluation implements Serializable {
    private String txt_eval;     //αξιολόγηση σε μορφή κειμένου
    private double num_eval;    //αξιολόγηση σε μορφή αριθμού


    private LocalDate curDate; //ημερομηνία τελευταίας(πιο πρόσφατης)αξιολόγησης

    //constructor
    public Evaluation(String txt,double num)
    {
        txt_eval=txt;
        num_eval=num;

        curDate=LocalDate.now();


    }
    //empty constructor
    public Evaluation(){
        curDate=LocalDate.now();
        txt_eval=null;
        num_eval=0;

    }
    //getters

    public String getTxt_eval(){
        return txt_eval;
    }

    public double getNum_eval(){
        return num_eval;
    }



    //setters

    public void setTxt_eval(String s){
        txt_eval=s;
        curDate=LocalDate.now();
    }

    public void setNum_eval(double num){
        num_eval=num;
        curDate=LocalDate.now();
    }




}

