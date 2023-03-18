package StocDeProduse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdusTest {
    private Produs produs;

    @BeforeEach
    void setUp() {
        Produs.setUrmatorulProdusID(1);
        produs = new Produs("Test Produs", 10.0, 5);
    }

    @AfterEach
    void tearDown() {
        produs = null;
    }

    @Test
    void testSetProdusID() {
        produs.setProdusID(10);
        assertEquals(10, produs.getProdusID());
    }

    @Test
    void testGetNumeProdus() {
        assertEquals("Test Produs", produs.getNumeProdus());
    }

    @Test
    void testGetPret() {
        assertEquals(10.0, produs.getPret());
    }

    @Test
    void testGetCantitate() {
        assertEquals(5, produs.getCantitate());
    }

    @Test
    void testSetPret() {
        produs.setPret(15.0);
        assertEquals(15.0, produs.getPret());
    }

    @Test
    void testSetCantitate() {
        produs.setCantitate(10);
        assertEquals(10, produs.getCantitate());
    }

    @Test
    void testToString() {
        String expectedString = "1 : Test Produs, 10,00 RON, 5 unitati disponibile, ";
        expectedString = expectedString.replaceAll("\\s+","");
        assertEquals(expectedString, produs.toString().replaceAll("\\s+",""));
    }

    @Test
    void testValoareTotalaDinStoc() {
        assertEquals(50.0, produs.valoareaTotalaDinStoc());
    }

    @Test
    void testAddProduse() {
        produs.addProduse(3);
        assertEquals(8, produs.getCantitate());
    }

    @Test
    void testScadereProduseDinStoc() {
        produs.scadereProduseDinStoc(2);
        assertEquals(3, produs.getCantitate());
    }

    @Test
    void testScadereaStocului() {
        produs.scadereaStocului(2);
        assertEquals(3, produs.getCantitate());
    }
}
