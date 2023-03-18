package StocDeProduse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImbracaminteTest {
    private Imbracaminte imbracaminte;

    @BeforeEach
    public void setUp() {
        Produs.setUrmatorulProdusID(1);
        imbracaminte = new Imbracaminte("bluza", 39.99, 10, "S", "Alb");
    }

    @Test
    public void testConstructorAndGetters() {
        Assertions.assertEquals("bluza", imbracaminte.getNumeProdus());
        Assertions.assertEquals(39.99, imbracaminte.getPret(), 0.01);
        Assertions.assertEquals(10, imbracaminte.getCantitate());
        Assertions.assertEquals("S", imbracaminte.getMarime());
        Assertions.assertEquals("Alb", imbracaminte.getCuloare());
    }

    @Test
    public void testSetMarime() {
        imbracaminte.setMarime("L");
        Assertions.assertEquals("L", imbracaminte.getMarime());
    }
    @Test
    public void testGetMarime() {
        Assertions.assertEquals("S", imbracaminte.getMarime());
    }

    @Test
    public void testSetCuloare() {
        imbracaminte.setCuloare("Blue");
        Assertions.assertEquals("Blue", imbracaminte.getCuloare());
    }

    @Test
    public void testToString() {
        String expectedString = imbracaminte.getProdusID() + " : " + imbracaminte.getNumeProdus() +
                ", Marime: " + imbracaminte.getMarime() + ", Culoare: " + imbracaminte.getCuloare() +
                ", " + String.format("%.2f", imbracaminte.getPret()) + " RON" + ", "
                + imbracaminte.getCantitate() + " unitati disponibile";
        expectedString = expectedString.replaceAll("\\s+","");
        Assertions.assertEquals(expectedString, imbracaminte.toString().replaceAll("\\s+",""));
    }
}
