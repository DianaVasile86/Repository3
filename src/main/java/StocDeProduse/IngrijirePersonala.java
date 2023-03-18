package StocDeProduse;

public class IngrijirePersonala extends Produs {
    private String marca;
    private String categoria;

    public IngrijirePersonala(String numeProdus, double pret, int cantitate, String marca, String categoria) {
        super(numeProdus, pret, cantitate);
        this.marca = marca;
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String toString() {

        return this.getProdusID() + " : "+ this.getNumeProdus() + ", Marca: " + marca + ", " +
                String.format("%.2f", this.getPret()) + " RON " + ", " + this.getCantitate() + " unitati disponibile";
    }
}

