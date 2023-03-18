
package StocDeProduse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectroniceTest {
    private Electronice electronice;

    @BeforeEach
    public void setUp() {
        Produs.setUrmatorulProdusID(1);
        electronice = new Electronice("Placa de par", 79.99, 5, "Remington", 220);
    }



    @Test
    public void testGetMarca() {
        assertEquals("Remington", electronice.getMarca());
    }

    @Test
    public void testGetVoltaj() {
        assertEquals(220, electronice.getVoltaj());
    }

    @Test
    public void testSetMarca() {
        electronice.setMarca("Dell");
        assertEquals("Dell", electronice.getMarca());
    }

    @Test
    public void testSetVoltage() {
        electronice.setVoltaj(240);
        assertEquals(240, electronice.getVoltaj());
    }

    @Test
    public void testToString() {
        Produs.setUrmatorulProdusID(1);
        String expected = "1 : Placa de par, Marca: Remington, Voltage: 220 V, 79,99 RON, 5 unitati disponibile";
        expected.replaceAll("\\s+","");
        assertEquals(expected, electronice.toString().replaceAll("\\s",""));
    }
}
