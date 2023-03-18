

package StocDeProduse;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MagazinTest {

    //lista Clienti->objects
    @Test
    public void testAddClient() {
        Magazin magazin = new Magazin();
        Client client = new Client("Test", "parola");
        magazin.addClient(client);
        assertEquals(client, magazin.Login("Test", "parola"));
    }

    @Test
    public void testLogin() {
        Magazin magazin = new Magazin();
        Client client = new Client("Test", "parola");
        magazin.addClient(client);
        assertEquals(client, magazin.Login("Test", "parola"));
        assertNull(magazin.Login("Test", "parola incorecta"));
        assertNull(magazin.Login("Nume utilizator gresit", "parola"));
    }

    @Test
    public void testArticoleDeImbracat() {
        // creare magazin-> object cu produse
        Magazin magazin = new Magazin();

        String expected = "Imbracaminte:\n" +
                "1 : Bluza, marime: S, culoare: Alb, 39,99 RON, 10 unitati disponibile\n" +
                "2 : Bluza, marime: M, culoare: Galben, 39,99 RON, 5 unitati disponibile\n" +
                "3 : Pantaloni, marime: M, Culoare: Negru, 49,99 RON, 7 unitati disponibile\n" +
                "4 : Pantaloni, marime: L, Culoare: Albastru, 49,99 RON, 5 unitati disponibile\n" +
                "5 : Accesorii, marime: -, Culoare: Argintiu, 19,99 RON, 20 unitati disponibile";

        // redirectionare output -> stream pentru al  captura
        //catch outputstream si il comparam cu cel din consola.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        // apelam metoda si capturam output
        magazin.displayImbracaminte();
        String output = baos.toString();

        // reset the standard output stream
        //directionarea outputului intr o variabila si dupa ce este gata il setam din nou redirectionat
        // la valoarea initiala din consola
        System.setOut(System.out);

        // spatiul liber il elimina sintaxa \\s+...apelata de regex.
        expected = expected.replaceAll("\\s+","");
        output = output.replaceAll("\\s+","");

        // verificare daca output ul corespunde cu output ul  asteptat
        assertEquals(expected, output);
    }

    @Test
    public void testDisplayIngrijirePersonala() {
        Magazin magazin = new Magazin();
        magazin.displayIngrijirePersonala();
    }

    @Test
    public void testDisplayElectronice() {
        Magazin magazin = new Magazin();
        magazin.displayElectronice();
    }

    @Test
    public void testDisplayProduse() {
        Magazin magazin = new Magazin();
        magazin.displayProduse("Imbracaminte");
        magazin.displayProduse("IngrijirePersonala");
        magazin.displayProduse("Electronice");
    }

    @Test
    public void testDisplayProduseCategorieInvalida() {
        Magazin magazin = new Magazin();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        magazin.displayProduse("Categorie Invalida");
        String expected = "Nu se gaseste nici un produs in aceasta categorie.\n";
        expected = expected.replaceAll("\\s+","");
        assertEquals(expected, outContent.toString().replaceAll("\\s+",""));
    }

    @Test
    public void testGetProdustById() {
        Magazin magazin = new Magazin();
        Produs produs = magazin.getProdusById(1, "Imbracaminte");
        assertNotNull(produs);
        assertEquals(1, produs.getProdusID());
        assertNull(magazin.getProdusById(99, "Imbracaminte"));
        assertNull(magazin.getProdusById(1, "Categorie invalida"));
    }

    @Test
    public void testProduseDisponibile() {
        Magazin magazin = new Magazin();
        assertTrue(magazin.produseDisponibile(1, "Imbracaminte"));
        assertFalse(magazin.produseDisponibile(99, "Imbracaminte"));
        assertFalse(magazin.produseDisponibile(1, "Categorie invalida"));
    }

    @Test
    public void testProduseAchizitionate() {
        Magazin magazin = new Magazin();
        double pret = magazin.ProduseAchizitionate(1, 1, "Imbracaminte");
        assertTrue(pret > 0);
        Produs produs = magazin.getProdusById(1, "Imbracaminte");
        assertEquals(9, produs.getCantitate());
        double pret2 = magazin.ProduseAchizitionate(99, 1, "Imbracaminte");
        assertEquals(0, pret2, 0);
        double pret3 = magazin.ProduseAchizitionate(1, 99, "Imbracaminte");
        assertEquals(0, pret3, 0);
        magazin.setProcentDeDiscount(50);
        double pret4 = magazin.ProduseAchizitionate(6, 1, "Ingrijjre personala");
        assertEquals(29.99, pret4, 0);
        double pret5 = magazin.ProduseAchizitionate(1, 1, "Electronice");
        assertEquals(0, pret5, 0);
    }

    @Test
    public void testGetDiscount() {
        Magazin magazin = new Magazin();
        magazin.setProcentDeDiscount(20);
        double procentDeDiscount = magazin.getDiscount(100);
        assertEquals(20, procentDeDiscount, 0);
        magazin.setProcentDeDiscount(0);
        double procentDeDiscount2 = magazin.getDiscount(100);
        assertEquals(0, procentDeDiscount2, 0);
    }
}