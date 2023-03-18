package StocDeProduse;

public class Electronice extends Produs {

    private String marca;
    private int voltaj;

    public Electronice(String numeProdus, double pret, int cantitate,String marca,int voltaj) {
        super(numeProdus, pret,cantitate);
        this.marca = marca;
        this.voltaj=voltaj;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVoltaj() {
        return voltaj;
    }

    public void setVoltaj(int voltaj) {
        this.voltaj = voltaj;
    }
    public String toString(){
       return this.getProdusID() + ":" + this.getNumeProdus() + ",Marca: " + marca + ",Voltaj: " + voltaj + " V " +
               "," + String.format("%.2f",this.getPret()) + " RON " + "," +
               this.getCantitate() + " unitati disponibile";

    }
}
