package e4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuroCoinTest {

    private EuroCoin coin1;
    private EuroCoin coin2;
    private EuroCoin coin3; // Duplicate of coin1
    private EuroCoinCollection collection;

    @BeforeEach
    void setUp() {
        coin1 = new EuroCoin(200, EuroCountry.SPAIN, 2023, "Felipe VI", CoinMaterial.GOLD);
        coin2 = new EuroCoin(100, EuroCountry.FRANCE, 2022, "Marianne", CoinMaterial.BRONZE);
        coin3 = new EuroCoin(200, EuroCountry.SPAIN, 2022, "Felipe VI", CoinMaterial.GOLD); // Duplicado de coin1 pero distinto año
        collection = new EuroCoinCollection();
    }

    @Test
    void testEuroCoinCreation() {
        assertEquals(200, coin1.value()); // Verificar que el valor es 200 céntimos
        assertEquals(100, coin2.value());
        assertEquals(EuroCountry.SPAIN, coin1.country());
        assertEquals(EuroCountry.FRANCE, coin2.country());
        assertEquals(2022, coin3.year());
        assertEquals("Felipe VI", coin1.design());
        assertEquals("Marianne", coin2.design());
        assertEquals(CoinMaterial.GOLD, coin1.material());
        assertEquals(CoinMaterial.BRONZE, coin2.material());
    }

    @Test
    void testEuroCoinEquality() {
        assertEquals(coin1, coin3); // Debe ser igual
        assertNotEquals(coin1, coin2); // No debe ser igual
    }

    @Test
    void testEuroCoinCollectionAdd() {
        assertTrue(collection.add(coin1)); // Debe agregar coin1
        assertFalse(collection.add(coin3)); // No debe agregar el duplicado (coin1)
        assertEquals(1, collection.count()); // Debe tener solo 1 moneda única
        assertTrue(collection.add(coin2));
        assertEquals(2, collection.count());
    }

    @Test
    void testEuroCoinCollectionRemove() {
        collection.add(coin1);
        collection.add(coin2);
        assertTrue(collection.remove(coin1)); // Debe eliminar coin1
        assertTrue(collection.remove(coin2)); // Debe eliminar coin1
    }

    @Test
    void testEuroCoinCollectionTotalValue() {
        collection.add(coin1); // 200 céntimos
        collection.add(coin2); // 100 céntimos
        assertEquals(300, collection.totalValue()); // 200 + 100 = 300 céntimos
    }

    @Test
    void testEuroCoinCollectionHasCoin() {
        collection.add(coin1);
        assertTrue(collection.hasCoin(coin1)); // Debe tener coin1
        assertFalse(collection.hasCoin(coin2)); // No debe tener coin2
    }

    @Test
    void testEuroCoinCollectionToString() {
        collection.add(coin1);
        collection.add(coin2);

        String expected = "Collection of: 2 coins:\n"
                + "200CENT - Felipe VI (Spain, GOLD)\n"
                + "100CENT - Marianne (France, BRONZE)\n";

        // Comparamos las cadenas
        assertEquals(expected.trim(), collection.toString().trim());
    }
}