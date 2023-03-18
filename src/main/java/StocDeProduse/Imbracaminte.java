package StocDeProduse;

public class Imbracaminte extends Produs {

    private String marime;
    private String culoare;




    public Imbracaminte(String numeProdus, double pret,int cantitate,String marime,String culoare) {
        super(numeProdus, pret,cantitate);
        this.marime = marime;
        this.culoare = culoare;
    }

    public String getMarime() {
        return marime;
    }

    public void setMarime(String marime) {
        this.marime = marime;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    @Override
    public String toString() {
        return this.getProdusID() + " : " +
                this.getNumeProdus() + ",Marimea: " + marime + ",Culoarea: " +
                culoare + "," + String.format("%.2f",this.getPret()) + " RON " + "," +
                this.getCantitate() + " unitati disponibile";
    }
}


