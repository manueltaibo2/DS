package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestShareDataGettersSetters {

    private ShareData shareData;

    @BeforeEach
    void inicializar() {
        // Inicializar una acción con datos de prueba
        shareData = new ShareData("AAPL", 150.0, 155.0, 145.0, 10000);
    }

    @Test
    void testGetSymbol() {
        assertEquals("AAPL", shareData.getSymbol());
    }

    @Test
    void testSetSymbol() {
        shareData.setSymbol("MSFT");
        assertEquals("MSFT", shareData.getSymbol());
    }

    @Test
    void testGetClose() {
        assertEquals(150.0, shareData.getClose());
    }

    @Test
    void testSetClose() {
        shareData.setClose(160.0);
        assertEquals(160.0, shareData.getClose());
    }

    @Test
    void testGetHigh() {
        assertEquals(155.0, shareData.getHigh());
    }

    @Test
    void testSetHigh() {
        shareData.setHigh(165.0);
        assertEquals(165.0, shareData.getHigh());
    }

    @Test
    void testGetLow() {
        assertEquals(145.0, shareData.getLow());
    }

    @Test
    void testSetLow() {
        shareData.setLow(140.0);
        assertEquals(140.0, shareData.getLow());
    }

    @Test
    void testGetVolume() {
        assertEquals(10000, shareData.getVolume());
    }

    @Test
    void testSetVolume() {
        shareData.setVolume(20000);
        assertEquals(20000, shareData.getVolume());
    }

    @Test
    void testMultipleSetters() {
        shareData.setSymbol("GOOGL");
        shareData.setClose(2800.0);
        shareData.setHigh(2850.0);
        shareData.setLow(2780.0);
        shareData.setVolume(15000);

        assertAll(
                () -> assertEquals("GOOGL", shareData.getSymbol()),
                () -> assertEquals(2800.0, shareData.getClose()),
                () -> assertEquals(2850.0, shareData.getHigh()),
                () -> assertEquals(2780.0, shareData.getLow()),
                () -> assertEquals(15000, shareData.getVolume())
        );
    }

    @Test
    void testSetCloseWithNegativeValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            shareData.setClose(-100.0);
        });
        assertEquals("El precio de cierre no puede ser negativo", exception.getMessage());
    }

    @Test
    void testSetVolumeWithNegativeValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            shareData.setVolume(-5000);
        });
        assertEquals("El volumen no puede ser negativo", exception.getMessage());
    }

}
