package e3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    private static Property p1, p2, p3, p4;

    @BeforeAll
    static void setUp() {
        p1 = new Property(PropertyType.APARTMENT,
                "01234567890123456789",
                "Aurelio Aguirre Galarraga 100, 1-A, A Coruna",
                "15190",
                80,
                2,
                1
        );

        p2 = new Property(PropertyType.APARTMENT,
                "56789012345678901234",
                "Aurelio Aguirre Galarraga 202, 5-D, A Coruna",
                "15190",
                100,
                3,
                2
        );

        /* Same cadaster as p2 but the entered address and meters are different. */
        p3 = new Property(PropertyType.APARTMENT,
                "56789012345678901234",
                "Aurelio Aguirre Galarraga 202, 5º D (A Coruna)",
                "15190",
                95,
                3,
                2
        );
    }

    /* Verificar que el método equals funciona correctamente */
    @Test
    void testEquals() {
        assertEquals(p2, p3);  // Comparar dos propiedades con el mismo catastro.
        assertNotEquals(p1, null);  // Comparar con null.
        assertNotEquals(p1, p2);  // Comparar propiedades con catastros diferentes.
        assertNotEquals(p1, p3);  // Comparar con otra propiedad que no es igual.
        assertNotEquals(p1, p4);  // Comparar con una propiedad de tipo diferente.
    }

    /* Verificar la consistencia entre equals y hashCode */
    @Test
    void testHashCode() {
        assertEquals(p2.hashCode(), p3.hashCode());  // Si son iguales, deben tener el mismo hashCode.
        assertNotEquals(p1.hashCode(), p2.hashCode());  // Si no son iguales, los hashCode deben ser diferentes.
    }

    // Prueba del metodo toString con varias propiedades
    @Test
    void testToString() {
        String expected = """
                APARTMENT
                01234567890123456789
                Aurelio Aguirre Galarraga 100, 1-A, A Coruna
                15190
                80 meters, 2 rooms, 1 bathrooms
                """;
        String actual = p1.toString();
        assertEquals(expected, actual);
    }
}
