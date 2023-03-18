package StocDeProduse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Magazin {

    private Map<String, List<Produs>> produse;

    private double procentDeDiscount = 10;

    private List<Produs> articoleDeImbracat;
    private List<Produs> articoleIngrijirePersonala;
    private List<Produs> produseElectronice;
    // clientul -lista
    private List<Client> clienti = new ArrayList<Client>();

    public Magazin() {
        produse = new HashMap<String, List<Produs>>();
        Produs.setUrmatorulProdusID(1);

        // Add lista  de imbracaminte .
        articoleDeImbracat = new ArrayList<>();

        articoleDeImbracat.add(new Imbracaminte("Bluza", 39.99, 10, "S", "Alb"));
        articoleDeImbracat.add(new Imbracaminte("Bluza", 39.99, 5, "M", "Galben"));
        articoleDeImbracat.add(new Imbracaminte("Pantaloni", 49.99, 7, "M",
                "Negru"));
        articoleDeImbracat.add(new Imbracaminte("Pantaloni", 49.99, 5, "L",
                "Albastru"));
        articoleDeImbracat.add(new Imbracaminte("Accesorii", 19.99, 20, "-",
                "argintiu"));
        produse.put("Imbracaminte", articoleDeImbracat);

        // Add lista cu produse de ingrijire personala.
        articoleIngrijirePersonala = new ArrayList<>();
        articoleIngrijirePersonala.add(new IngrijirePersonala("Lotiune de corp", 29.99, 15,
                "Nivea", "Creme"));
        articoleIngrijirePersonala.add(new IngrijirePersonala("Rimel", 19.99, 20,
                "Maybeline", "Make-up"));
        produse.put("Ingrijire personala", articoleIngrijirePersonala);

        // add  lista de produse electronice
        produseElectronice = new ArrayList<>();
        produseElectronice.add(new Electronice("Feon", 69.99, 8, "Phillips",
                220));
        produseElectronice.add(new Electronice("Placa de par", 79.99, 5, "Remington",
                220));
        produseElectronice.add(new Electronice("Ondulator", 49.99, 10, "Remington",
                220));
        produseElectronice.add(new Electronice("Epilator", 99.99, 3, "Bosch",
                220));
        produse.put("Electronice", produseElectronice);

        //add clienti existenti
        clienti.add(new Client("Marius", "1234"));
        clienti.add(new Client("Alina", "1234"));
    }

    //metoda care am folosit o pentru a adauga clienti

    public void addClient(Client client) {
        clienti.add(client);
    }

    //metoda care verifica daca clientul exista

    public Client Login(String numeUtilizator, String parola) {
        for (Client client : clienti) {
            if (client.getNumeUtilizator().equals(numeUtilizator) && client.getParola().equals(parola)) {
                return client;
            }
        }

        return null;
    }


    // Getters and setters pentru produse
    public Map<String, List<Produs>> getProduse() {
        return produse;
    }

    //get,set produse din stoc
    public List<Produs>getArticoleDeImbracat(){
        return articoleDeImbracat;
    }
    public List<Produs>getArticoleIngrijirePersonala(){
        return articoleIngrijirePersonala;
    }
    public List<Produs>getProduseElectronice(){
        return produseElectronice;
    }

    public double getProcentDeDiscount(double pretTotal) {
        return procentDeDiscount;
    }

    public void setProcentDeDiscount(double procentDeDiscount) {
        this.procentDeDiscount = procentDeDiscount;
    }



    public void displayImbracaminte() {
        System.out.println("Imbracaminte:");
        for (Produs imbracaminte : articoleDeImbracat) {
            System.out.println(imbracaminte.toString());
        }
    }

    public void displayIngrijirePersonala() {
        System.out.println("Ingrijire personala:");
        for (Produs articol : articoleIngrijirePersonala) {
            System.out.println(articol.toString());
        }
    }


    public void displayElectronice() {
        System.out.println("Electronice:");
        for (Produs articol : produseElectronice) {
            System.out.println(articol.toString());
        }
    }


    public void displayProduse(String categorie) {
        List<Produs> ListaDeProduse = produse.get(categorie);
        if(ListaDeProduse !=null){
            System.out.println("\nProdusele se gasesc in categoria: " + categorie);
            for (Produs produs : ListaDeProduse) {
                System.out.println(produs);
            }
        }else{
            System.out.println("In aceasta categorie nu mai sunt produse disponibile");
        }
    }


    public double ProduseAchizitionate(int produsId, int cantitate, String categorie) {

        Produs produs = getProdusById(produsId, categorie);
        if (produs == null) {
            return 0;
        }
        double totalPrice = produs.getPret() * cantitate;
        if (produs.getStoc() >= cantitate) {
            produs.scadereaStocului(cantitate);
            return totalPrice;
        } else {
            System.out.println("Acest produs nu mai este disponibil.");
            return 0;
        }
    }

    // importam din mapa produsele dupa id si categorie

    public Produs getProdusById(int produsId, String categorie) {
        List<Produs> ListaDeProduse = produse.get(categorie);
        for (Produs produs : ListaDeProduse) {
            if (produs.getProdusID() == produsId) {
                return produs;
            }
        }
        return null;
    }

    public boolean produseDisponibile(int produsID, String categorie) {
        switch (categorie.toLowerCase()) {
            case "imbracaminte":
                for (Produs imbracaminte : articoleDeImbracat) {
                    if (imbracaminte.getProdusID() == produsID && imbracaminte.getCantitate() > 0) {
                        return true;
                    }
                }
                break;
            case "ingrijire personala":
                for (Produs ingrijirePersonala : articoleIngrijirePersonala) {
                    if (ingrijirePersonala.getProdusID() == produsID && ingrijirePersonala.getCantitate() > 0) {
                        return true;
                    }
                }
                break;
            case "electronice":
                for (Produs electronice : produseElectronice) {
                    if (electronice.getProdusID() == produsID && electronice.getCantitate() > 0) {
                        return true;
                    }
                }

                break;
            default:
                System.out.println("Optiune inexistenta.");
        }
        return false;
    }

    public List<Client>getClienti(){
        return clienti;
    }

    public double getDiscount(double pretTotal) {

        return pretTotal * (procentDeDiscount / 100.0);
    }
}


