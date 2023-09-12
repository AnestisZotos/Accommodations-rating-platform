package api;

import java.io.Serializable;

/**
 * Η κλάση αυτή αναφέρεται στις παροχές ενός καταλύματος.Για κάθε κατηγορία παροχής(π.χ. θέα) υπάρχουν 2 παράλληλοι πίνακες,ο ένας τύπου string αποθηκεύει
 * κάθε  υποπαροχή(π.χ θέα στη θάλασσα) σαν string σε μία θέση του πίνακα,και στην αντίστοιχη θέση του άλλου παράλληλου πίνακα που είναι τύπου boolean
 * αποθηκεύεται η τιμή true αν η υποπαροχή αυτή παρέχεται από το κατάλυμα,αλλίως αποθηκεύεται false.Ο πίνακας τύπου Boolean αρχικοποιείται με τιμές false
 * @author Anestis Zotos
 */

public class Amenities implements Serializable {
   private String[] view;
   private boolean[] viewB;
   private String[] bath;
   private boolean[] bathB;
   private String[] wash_clothes;
   private boolean[] wash_clothesB;
   private String[] entertainment;
    private boolean[] entertainmentB;
    private String[] heating;
    private boolean[] heatingB;
    private String[] internet;
    private boolean[] internetB;
    private String[] kitchen;
    private boolean[] kitchenB;
    private String[] outside;
    private boolean[] outsideB;
    private String[] parking;
    private boolean[] parkingB;

    public Amenities()
    {
        int i;
        view=new String[6];
        viewB=new boolean[6];
        for(i=0;i<6;i++)
        {
            viewB[i]=false;
        }
        view[0]="Θέα σε πισίνα";
        view[1]="Θέα στη θάλασσα";
        view[2]="Θέα στο λιμάνι";
        view[3]="θέα στο βουνό";
        view[4]="Θέα σε παραλία";
        view[5] ="Θέα στο δρόμο";

        bath=new String[1];
        bathB=new boolean[1];
        bathB[0]=false;
        bath[0]="Πιστολάκι μαλλιών";

        wash_clothes=new String[2];
        wash_clothesB=new boolean[2];
        for(i=0;i<2;i++)
        {
            wash_clothesB[i]=false;
        }
        wash_clothes[0]="Πλυντήριο ρούχων";
        wash_clothes[1]="Στεγνωτήριο";

        entertainment=new String[1];
        entertainmentB=new boolean[1];
        entertainmentB[0]=false;
        entertainment[0]="Τηλεόραση";

        heating=new String[3];
        heatingB=new boolean[3];
        for(i=0;i<3;i++)
        {
            heatingB[i]=false;
        }
        heating[0]="Εσωτερικό τζάκι";
        heating[1]="κλιματισμός";
        heating[2]="κεντρική θέρμανση";

        internet=new String[2];
        internetB=new boolean[2];
        for(i=0;i<2;i++)
        {
            internetB[i]=false;
        }
        internet[0]="wifi";
        internet[1]="ethernet";

        kitchen=new String[7];
        kitchenB=new boolean[7];
        for(i=0;i<7;i++)
        {
            kitchenB[i]=false;
        }
        kitchen[0]="Κουζίνα";
        kitchen[1]="Ψυγείο";
        kitchen[2]="Φούρνος μικροκυμάτων";
        kitchen[3]="Μαγειρικά είδη";
        kitchen[4]="Πιάτα και μαχαιροπίρουνα";
        kitchen[5]="Πλυντήριο πιάτων";
        kitchen[6]="Καφετιέρα";

        outside=new String[2];
        outsideB=new boolean[2];
        for(i=0;i<2;i++)
        {
            outsideB[i]=false;
        }
        outside[0]="Μπαλκόνι";
        outside[1]="Αυλή";

        parking=new String[2];
        parkingB=new boolean[2];
        for(i=0;i<2;i++)
        {
            parkingB[i]=false;
        }
        parking[0]="Δωρεάν χώρος στάθμευσης στην ιδιοκτησία";
        parking[1]="Δωρεάν πάρκινγκ στο δρόμο";

    }


    //setters for boolean type array

    public void setviewB(int index,boolean t){
        viewB[index]=t;
    }



    public void setbathB(int index,boolean t){
        bathB[index]=t;

    }

    public void setheatingB(int index,boolean t){
        heatingB[index]=t;

    }
    public void setwash_clothesB(int index,boolean t){
        wash_clothesB[index]=t;

    }

    public void setentertainmentB(int index,boolean t){
        entertainmentB[index]=t;
    }
    public void setinternetB(int index,boolean t){
        internetB[index]=t;
    }
    public void setkitchenB(int index,boolean t){
        kitchenB[index]=t;
    }

    public void setoutsideB(int index,boolean t){
        outsideB[index]=t;
    }
    public void setparkingB(int index,boolean t){
        parkingB[index]=t;
    }

    //getters


   public  boolean[] getViewB()
    {
        return  viewB;
    }

    public boolean[] getBathB()
    {
        return bathB;
    }

    public boolean[] getWash_clothesB()
    {
        return wash_clothesB;
    }

    public boolean[] getEntertainmentB()
    {
        return entertainmentB;
    }

    public boolean[] getHeatingB()
    {
        return heatingB;
    }

    public boolean[] getInternetB(){
        return internetB;
    }

    public boolean[] getKitchenB(){
        return kitchenB;
    }

    public boolean[] getOutsideB(){
        return outsideB;
    }

    public boolean[] getParkingB(){
        return parkingB;
    }

    public  String[] getView()
    {
        return  view;
    }

    public String[] getBath()
    {
        return bath;
    }

    public String[] getWash_clothes()
    {
        return wash_clothes;
    }

    public String[] getEntertainment()
    {
        return entertainment;
    }

    public String[] getHeating()
    {
        return heating;
    }

    public String[] getInternet(){
        return internet;
    }

    public String[] getKitchen(){
        return kitchen;
    }

    public String[] getOutside(){
        return outside;
    }

    public String[] getParking(){
        return parking;
    }

    /**
     * Ελέγχει την ισότητα δύο αντεικιμένων
     * @param am Παροχές
     * @return true αν τα αντεικίμενα είναι ίσα, false αντίθετα
     */
    public boolean equals(Amenities am) {
        return this.hashCode() == am.hashCode();
    }

    /**
     * Η μέθοδος αυτή κάνει Override την μέθοδο της κλάσης Object για να μπορέσει να προσδιοριστεί
     * η ισότητα μεταξύ δύο αντεικιμένων
     * @return hash code
     */
    public int hashCode(){

        int sum = 0;

        for(int i=0;i<6;i++){
            sum += convert(viewB[i])^(i+1);
        }
        for(int i=0;i<3;i++){
            sum += convert(heatingB[i])^2*(i+1);
        }

        for(int i=0;i<2;i++){
            sum += convert(outsideB[i])^3*(i+1);
        }

        for(int i=0;i<2;i++){
            sum += convert(parkingB[i])^4*(i+1);
        }

        for(int i=0;i<7;i++){
                sum += convert(kitchenB[i])^5*(i+1);
        }

        for(int i=0;i<2;i++){
            sum += convert(internetB[i])^6*(i+1);
        }

        for(int i=0;i<2;i++){
            sum += convert(wash_clothesB[i])^7*(i+1);
        }

        sum += convert(entertainmentB[0])^8*11;
        sum += convert(bathB[0])^9*12;

        return sum;

    }

    /**
     * Μετατροπή μιάς boolean σε int μεταβλητή
     * @param b boolean μεταβλητή
     * @return int μεταβλητή
     */
    private int convert(boolean b){
        if(b)
            return 1;
        else
            return 0;
    }
}
