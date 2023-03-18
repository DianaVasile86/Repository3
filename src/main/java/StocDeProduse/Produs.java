package StocDeProduse;

public class Produs {
    private int produsID;
    private String numeProdus;
    private double pret;
    private int cantitate;


    public Produs(String numeProdus, double pret, int cantitate){
        this.numeProdus = numeProdus;
        this.pret = pret;
        this.cantitate = cantitate;
        this.produsID = getUrmatorulProdusID();
    }

    public static void setUrmatorulProdusID(int i ){
        urmatorulProdusID=i;
    }

    public int getProdusID() {
        return produsID;
    }

    public void setProdusID(int produsID) {

        this.produsID = produsID;
    }

    // metoda folosita pentru a apela urmatorul produsID
    private static int urmatorulProdusID = 1;
    private static int getUrmatorulProdusID(){

        return urmatorulProdusID++;
    }
    public String getNumeProdus() {

        return numeProdus;
    }

    public void setNumeProdus(String numeProdus) {

        this.numeProdus = numeProdus;
    }

    public double getPret() {

        return pret;
    }

    public void setPret(double pret) {

        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public String toString(){
        return produsID + ": " + numeProdus + "," +
                String.format("%.2f",pret) + " RON " + "," + cantitate + " unitati disponibile";
    }
    public double valoareaTotalaDinStoc(){
        return pret * cantitate;
    }
    public void addProduse(int cantitate){
        this.cantitate += cantitate;
    }
    public void scadereProduseDinStoc(int cantitate){
        this.cantitate -= cantitate;
    }

    public int getStoc(){
        return cantitate;
    }
    public void scadereaStocului(int cantitate){
        this.cantitate -= cantitate;
    }
}
