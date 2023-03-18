import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import StocDeProduse.Client;
import StocDeProduse.Magazin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;



import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static final String testNumeUtilizator = "testnumeutilizator";
    private static final String testParola = "testparola";
    private static final int testCantitateaCumparata = 2;


    private Magazin testMagazin;
    private Client testClient;

    @BeforeEach
    public void setUp() {
        testMagazin = new Magazin();
        testClient = new Client(testNumeUtilizator,testParola);
    }

    @Test
    public void testLoginSiCumparaturi() {
        assertEquals(testClient,testMagazin.Login("testnumeutilizator","testparola"));
        /*
    actualizeaza inputul 1,13,2,5, 2 la cumpararea produsului cu id ul 13 si cantitatea 2(bluza,39,99 Ron)
    discount 10% din pretul total.Imputul corespunde cu acela din main dar adaugand metoda System.lineSeparator()
    atunci aceasta simuleaza un utilizator  care direct  apasa tasta enter apoi iese din program.
     */
        String input = "Alina" + System.lineSeparator() + "parola" + System.lineSeparator() + "1" + System.lineSeparator()
                + "1" + System.lineSeparator() + testCantitateaCumparata + System.lineSeparator() + "5" +
                System.lineSeparator() + "2" + System.lineSeparator();

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.ISO_8859_1));
        PrintStream originalOut = System.out;

        try {
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            System.setIn(in);

            Main.main(new String[]{});

            // verificare pentru a vedea daca output ul contine mesajul asteptat
            String output = outContent.toString();
            assertTrue(output.contains("Va multumim pentru cumparaturile efectuate si va mai asteptam!"));
            assertTrue(output.contains("Pret total inainte de discount: 79,98 RON"));
            assertTrue(output.contains("Discount aplicat: 8,00 RON"));
            assertTrue(output.contains("Pret total cu discount aplicat : 71,98 RON"));

        } finally {
            System.setOut(originalOut);
        }
    }

}




