

import StocDeProduse.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Magazin magazin = new Magazin();

        System.out.println("Bun venit in lumea modei la ImpaktFashion magazin!");
        System.out.println("Va asteapta o lista vasta cu ofertele noastre.");

        boolean cumparaturi = true;
        Client clientActual = null;
        while(cumparaturi){
            if(clientActual==null){
                System.out.println("\n Va rugam sa va logati pentru a continua procesul de cumparaturi");
                System.out.print("Nume utilizator:");
                String numeUtilizator = sc.nextLine();
                System.out.print("Parola:");
                String parola= sc.nextLine();
                clientActual = magazin.Login(numeUtilizator,parola);
                if(clientActual == null){
                    System.out.println("\nNume utilizator sau parola invalida.Va rugam sa incercati din nou.");
                    continue;
                }else{
                    System.out.printf("\n Bun venit %s ! \n",clientActual.getNumeUtilizator());
                }
            }
            System.out.println("\n Selectati o categorie:");
            System.out.println("1.Imbracaminte");
            System.out.println("2.Ingrijire personala");
            System.out.println("3.Electronice");
            System.out.println("4.Produse achizitionate");
            System.out.println("5.Exit");

            int alegeCategoria = sc.nextInt();
            sc.nextLine();
            switch(alegeCategoria){
                case 1:
                    magazin.displayImbracaminte();
                    System.out.println("\n Introduceti ID ul produsului dorit pentru a l cumpara sau 0 pentru " +
                            " a reveni la meniul initial:" );
                    int produsID = sc.nextInt();
                    if(produsID==0){
                        break;
                    }
                    if(magazin.produseDisponibile(produsID,"Imbracaminte")){
                        System.out.println("\n alegeti cantitatea dorita:");
                        int cantitate =sc.nextInt();
                        double pretTotal=magazin.ProduseAchizitionate(produsID,cantitate,"Imbracaminte");
                        if(pretTotal >0){
                            double procentDeDiscount= magazin.getProcentDeDiscount(pretTotal);
                            System.out.printf("\n Pretul total inainte de discount: %.2f RON\n",procentDeDiscount);
                            System.out.printf("\n Discount aplicat: %.2f RON\n",procentDeDiscount);
                            System.out.printf("\n Pretul total dupa aplicarea discountului: %.2f RON\n"
                                    , pretTotal- procentDeDiscount);
                            clientActual.addCumparaturi("Imbracaminte",
                                    pretTotal-procentDeDiscount);
                        }
                    }else{
                        System.out.println("\nProdusul nu mai este in stoc sau id ul prodului este gresit.");
                    }
                    break;
                case 2:
                  magazin.displayIngrijirePersonala();
                    System.out.println("\n Introduceti ID ul produsului dorit pentru a l cumpara sau 0 pentru " +
                            " a reveni la meniul initial:");
                    produsID= sc.nextInt();
                    sc.nextLine();
                    if(produsID==0){
                        break;
                    }
                    if(magazin.produseDisponibile(produsID,"Ingrijire personala")){
                        System.out.println("\n Alege ti cantitatea dorita:");
                        int cantitate = sc.nextInt();
                        sc.nextLine();
                        double pretTotal=magazin.ProduseAchizitionate(produsID,cantitate,"Ingrijire personala");
                        if(pretTotal >0){
                            double procentDeDiscount = magazin.getProcentDeDiscount(pretTotal);
                            System.out.printf("Pretul total inainte de discount: %.2f RON\n",pretTotal);
                            System.out.printf("\n Discount aplicat:%.2f RON\n",procentDeDiscount);
                            System.out.printf("\n Pretul total dupa aplicarea discountului:%.2f RON\n"
                                    ,pretTotal-procentDeDiscount);
                            clientActual.addCumparaturi("Ingrijire personala",
                                    pretTotal-procentDeDiscount);
                        }
                    }else{
                        System.out.println("\nProdusul nu mai este in stoc sau Id ul produsului este gresit");
                    }
                    break;
                case 3:
                    magazin.displayElectronice();
                    System.out.println("\nIntroduce ti ID ul produsului dorit pentru a l cumpara sau 0 pentru " +
                            "a reveni la meniul anterior:");
                    produsID = sc.nextInt();
                    sc.nextLine();
                    if(produsID==0){
                        break;
                    }
                    if(magazin.produseDisponibile(produsID,"Electronice")){
                        System.out.println("\nAlege ti cantitatea dorita:");
                        int cantitate = sc.nextInt();
                        sc.nextLine();
                        double pretTotal = magazin.ProduseAchizitionate(produsID,cantitate,"Electronice");
                        if(pretTotal >0){
                            double procentDeDiscount = magazin.getProcentDeDiscount(pretTotal);
                            System.out.printf("Pretul total inainte de discount: %.2f RON\n",pretTotal);
                            System.out.printf("\n Discount aplicat:%.2f RON\n",procentDeDiscount);
                            System.out.printf("\n Pretul total dupa aplicarea discountului:%.2f RON\n"
                                    ,pretTotal-procentDeDiscount);
                            clientActual.addCumparaturi("Electronice",
                                    pretTotal-procentDeDiscount);
                        }
                    }else{
                        System.out.println("\nProdusul nu mai este in stoc sau Id ul produsului este gresit");
                    }
                    break;
                case 4:
                    clientActual.afisareIstoricComanda();
                    break;
                case 5:
                    System.out.println("\nDoresti sa vizualizezi comanda?");
                    System.out.println("1.DA");
                    System.out.println("2.NU");
                    int istoricComanda = sc.nextInt();
                    sc.nextLine();
                    switch (istoricComanda){
                        case 1:
                            clientActual.afisareIstoricComanda();
                            break;
                        case 2:
                        default:
                            System.out.println("Optiune inexistenta");
                            break;
                    }
                    cumparaturi = false;
                    break;
                default:
                    System.out.println("Optiune inexistenta");
            }
        }
        sc.close();
        System.out.println("Va multumim pentru cumparaturile efectuate si va mai asteptam!");

    }
}
