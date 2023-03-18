package StocDeProduse;

import java.util.HashMap;
import java.util.Map;

public class Client {

    private String numeUtilizator;
    private String parola;

    private Map<String,Double> istoricComanda;


    public Client(String numeUtilizator,String parola){
        this.numeUtilizator = numeUtilizator;
        this.parola = parola;
        istoricComanda = new HashMap<>();
    }

    public String getUsername() {
        return numeUtilizator;
    }

    public boolean login(String numeUtilizator,String parola){
        return this.numeUtilizator.equals(numeUtilizator) && this.parola.equals(parola);

    }
    public void addCumparaturi(String categorie, double plataCumparaturi){
        istoricComanda.put(categorie,plataCumparaturi);
    }

    public void afisareIstoricComanda(){
        if(istoricComanda.isEmpty()){
            System.out.println("Produsul nu se gaseste.");
        }else{
            double total = 0;
            System.out.println("Istoric comanda: ");
            for(Map.Entry<String,Double> entry:istoricComanda.entrySet()){
                System.out.printf("%s: %.2f RON,\n",entry.getKey(), entry.getValue());
                total += entry.getValue();
            }
            System.out.printf("Total: %.2f RON,\n" , total);
        }
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    public String toString(){
        return "Nume utilizator: " + numeUtilizator;
    }
}
