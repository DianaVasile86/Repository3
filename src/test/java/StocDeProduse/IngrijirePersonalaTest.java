package StocDeProduse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngrijirePersonalaTest {

    private IngrijirePersonala ingrijirePersonala;

    @BeforeEach
    public void setUp() {
        ingrijirePersonala = new IngrijirePersonala("Lotiune de corp", 29.99, 15,
                "Nivea", "Creme");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Lotiune de corp", ingrijirePersonala.getNumeProdus());
        assertEquals(29.99, ingrijirePersonala.getPret(), 0.01);
        assertEquals(15, ingrijirePersonala.getCantitate());
        assertEquals("Nivea", ingrijirePersonala.getMarca());
        assertEquals("Creme", ingrijirePersonala.getCategoria());
    }

    @Test
    public void testSetters() {
        ingrijirePersonala.setMarca("Loreal");
        assertEquals("Loreal", ingrijirePersonala.getMarca());

        ingrijirePersonala.setCategoria("Make-up");
        assertEquals("Make-up", ingrijirePersonala.getCategoria());
    }

    @Test
    public void testToString() {
        String expected = ingrijirePersonala.getProdusID() + " : " + "Lotiune de corp, Marca: Nivea, 29,99 RON, " +
                "15 unitati disponibile";
        assertEquals(expected, ingrijirePersonala.toString());
    }
}
