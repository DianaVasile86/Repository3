package StocDeProduse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private Client client;

    @BeforeEach
    public void setUp() {
        client = new Client("Marius", "1234");
    }

    @Test
    public void testGetNumeUtilizator() {
        assertEquals("Max Mustermann", client.getNumeUtilizator());
    }

    @Test
    public void testLogin() {
        assertTrue(client.login("Marius", "1234"));
    }

    @Test
    public void testAddCumparaturi() {
        client.addCumparaturi("Imbracaminte", 50.0);
        client.addCumparaturi("Electronice", 100.0);
        // String expected = "Istoric comanda:\n" + "Imbracaminte: 50,00 RON\n" + "Electronice: 100,00 RON\n" +
        // "Total: 150,00 RON\n";
        String expected = "Istoric comanda:\nImbracaminte: 50,00 RON\nElectronice: 100,00 RON\nTotal: 150,00 RON\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        client.afisareIstoricComanda();
        String actual = outContent.toString();
        // entferne Leerzeichen aus beiden Strings
        expected = expected.replaceAll("\\s+","");
        actual = actual.replaceAll("\\s+","");
        assertEquals(expected, actual);
    }

    @Test
    public void testafisareIstoricComanda() {
        client.addCumparaturi("Imbracaminte", 50.0);
        client.addCumparaturi("Electronice", 100.0);
        String expected = "Istoric comanda:\nImbracaminte: 50,00 RON\nElectronice: 100,00 RON\nTotal: 150,00 RON\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        client.afisareIstoricComanda();
        String actual = outContent.toString();
        expected = expected.replaceAll("\\s+","");
        actual = actual.replaceAll("\\s+","");
        assertEquals(expected, actual);
    }

    @Test
    public void testGettersAndSetters() {
        client.setNumeUtilizator("Alina");
        client.setParola("4321");
        assertEquals("Alina", client.getNumeUtilizator());
        assertEquals("4321", client.getParola());
    }
}