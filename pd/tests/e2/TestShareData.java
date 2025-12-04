package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestShareData {

    private String normalize(String input) {
        return input.trim().replaceAll("\\r\\n", "\n").replaceAll("\\s+$", "").replaceAll("(?m)^[ \\t]+", "");
    }


    private ShareData shareData;
    private SimpleClient simpleClient;
    private DetailedClient detailedClient;
    private CustomClient customClient;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // Inicializar una acción con datos de prueba
        shareData = new ShareData("AAPL", 150.0, 155.0, 145.0, 10000);

        // Inicializar clientes
        simpleClient = new SimpleClient();
        detailedClient = new DetailedClient();
        customClient = new CustomClient(Set.of("symbol", "high"));

        // Capturar la salida por consola para verificar el resultado
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testDetachObserver(){
        shareData.attach(simpleClient);
        shareData.detach(simpleClient);
        shareData.setClose(155.0);

        assertTrue(outContent.toString().isEmpty(), "No debería haber notificaciones después de eliminar el observador.");
    }

    @Test
    void testAttachAndNotifySimpleClient() {
        shareData.attach(simpleClient);
        shareData.setClose(152.0);

        String expectedOutput = """
        SimpleClient Notification:
        Symbol: AAPL, Close: 152.0
        """;
        assertEquals(normalize(expectedOutput), normalize(outContent.toString()));
    }

    @Test
    void testAttachAndNotifyDetailedClient() {
        shareData.attach(detailedClient);
        shareData.setHigh(157.0);

        String expectedOutput = """
        DetailedClient Notification:
        Symbol: AAPL, Close: 150.0, High: 157.0, Low: 145.0, Volume: 10000
        """;
        assertEquals(normalize(expectedOutput), normalize(outContent.toString()));
    }

    @Test
    void testAttachAndNotifyCustomClient() {
        shareData.attach(customClient);
        shareData.setHigh(158.0);

        String expectedOutput = """
        CustomClient Notification:
        Symbol: AAPL
        High: 158.0
        """;
        assertEquals(normalize(expectedOutput), normalize(outContent.toString()));
    }

    @Test
    void testMultipleObserversNotification() {
        shareData.attach(simpleClient);
        shareData.attach(detailedClient);
        shareData.setClose(153.0);

        String expectedOutput = """
        SimpleClient Notification:
        Symbol: AAPL, Close: 153.0
        DetailedClient Notification:
        Symbol: AAPL, Close: 153.0, High: 155.0, Low: 145.0, Volume: 10000
        """;
        assertEquals(normalize(expectedOutput), normalize(outContent.toString()));
    }

    @Test
    void testNotifyOnMultipleAttributeChanges() {
        shareData.attach(detailedClient);
        shareData.setSymbol("GOGL");
        shareData.setClose(2800.0);
        shareData.setHigh(2825.0);
        shareData.setLow(2780.0);
        shareData.setVolume(20000);

        String expectedOutput = """
        DetailedClient Notification:
        Symbol: GOGL, Close: 150.0, High: 155.0, Low: 145.0, Volume: 10000
        DetailedClient Notification:
        Symbol: GOGL, Close: 2800.0, High: 155.0, Low: 145.0, Volume: 10000
        DetailedClient Notification:
        Symbol: GOGL, Close: 2800.0, High: 2825.0, Low: 145.0, Volume: 10000
        DetailedClient Notification:
        Symbol: GOGL, Close: 2800.0, High: 2825.0, Low: 2780.0, Volume: 10000
        DetailedClient Notification:
        Symbol: GOGL, Close: 2800.0, High: 2825.0, Low: 2780.0, Volume: 20000
        """;
        assertEquals(normalize(expectedOutput), normalize(outContent.toString()));
    }

    @Test
    void testDetachObserver2(){
        shareData.attach(simpleClient);
        shareData.detach(simpleClient);
        shareData.setClose(155.0);

        assertTrue(outContent.toString().isEmpty(), "No debería haber notificaciones después de eliminar el observador.");
    }

    @Test
    void testMultipleAttributeChanges() {
        shareData.attach(detailedClient);
        shareData.setClose(160.0);
        shareData.setHigh(165.0);
        shareData.setLow(158.0);

        String expectedOutput = """
        DetailedClient Notification:
        Symbol: AAPL, Close: 160.0, High: 155.0, Low: 145.0, Volume: 10000
        DetailedClient Notification:
        Symbol: AAPL, Close: 160.0, High: 165.0, Low: 145.0, Volume: 10000
        DetailedClient Notification:
        Symbol: AAPL, Close: 160.0, High: 165.0, Low: 158.0, Volume: 10000
        """;
        assertEquals(normalize(expectedOutput), normalize(outContent.toString()));
    }

    @Test
    void testCustomClientWithDifferentAttributes() {
        CustomClient customClient2 = new CustomClient(Set.of("close", "volume"));
        shareData.attach(customClient2);
        shareData.setClose(162.0);
        shareData.setVolume(12000);

        String expectedOutput = """
        CustomClient Notification:
        Close: 162.0
        Volume: 10000
        CustomClient Notification:
        Close: 162.0
        Volume: 12000
        """;
        assertEquals(normalize(expectedOutput), normalize(outContent.toString()));
    }

    @Test
    void testMultipleObserverTypes() {
        shareData.attach(simpleClient);
        shareData.attach(detailedClient);
        shareData.attach(customClient);

        shareData.setClose(180.0);

        String expectedOutput = """
        SimpleClient Notification:
        Symbol: AAPL, Close: 180.0
        DetailedClient Notification:
        Symbol: AAPL, Close: 180.0, High: 155.0, Low: 145.0, Volume: 10000
        CustomClient Notification:
        Symbol: AAPL
        High: 155.0
        """;
        assertEquals(normalize(expectedOutput), normalize(outContent.toString()));
    }

    @Test
    void testAttachSameObserverMultipleTimes() {
        shareData.attach(simpleClient);
        shareData.attach(simpleClient);
        shareData.setClose(170.0);

        String expectedOutput =
        """
        SimpleClient Notification:
        Symbol: AAPL, Close: 170.0
        SimpleClient Notification:
        Symbol: AAPL, Close: 170.0
        """;
        assertEquals(normalize(expectedOutput), normalize(outContent.toString()));
    }

    @Test
    void testMultipleChangesWithObservers() {
        shareData.attach(detailedClient);
        shareData.setClose(160.0);
        shareData.setHigh(165.0);
        shareData.setLow(158.0);

        String expectedOutput = """
        DetailedClient Notification:
        Symbol: AAPL, Close: 160.0, High: 155.0, Low: 145.0, Volume: 10000
        DetailedClient Notification:
        Symbol: AAPL, Close: 160.0, High: 165.0, Low: 145.0, Volume: 10000
        DetailedClient Notification:
        Symbol: AAPL, Close: 160.0, High: 165.0, Low: 158.0, Volume: 10000
        """;
        assertEquals(normalize(expectedOutput), normalize(outContent.toString()));
    }

    @Test
    void testSetCloseWithInvalidValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            shareData.setClose(-100.0);
        });
        assertEquals("El precio de cierre no puede ser negativo", exception.getMessage());
    }



}
