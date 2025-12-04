package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseNavalTest {

    private BaseNaval baseNaval;
    private Buque buque1;
    private Buque buque2;
    private Buque buque3;

    @BeforeEach
    void setUp() {
        baseNaval = new BaseNaval("Base Alfa", 10000);
        buque1 = new Buque("Buque A", TipoBuque.CL, 3, new EstadoActivo(), PesoBuque.ULIGERO);
        buque2 = new Buque("Buque B", TipoBuque.CA, 2, new EstadoInactivo("Antigüedad"), PesoBuque.PESADO);
        buque3 = new Buque("Buque C", TipoBuque.DE, 6, new EstadoEnEjercicio(), PesoBuque.LIGERO);

        assertEquals("Base Alfa", baseNaval.getNombre());

        baseNaval.addBuque(buque1);
        baseNaval.addBuque(buque2);
        baseNaval.addBuque(buque3);
    }

    @Test
    void testAddAndRemoveBuque() {
        assertTrue(baseNaval.getBuques().contains(buque1));
        assertTrue(baseNaval.getBuques().contains(buque2));
        assertTrue(baseNaval.getBuques().contains(buque3));

        baseNaval.removeBuque(buque1, baseNaval);
        assertFalse(baseNaval.getBuques().contains(buque1));
    }

    @Test

    void Fondos(){
        assertEquals(10000, baseNaval.getFondos());
        baseNaval.setFondos(12000);
        assertEquals(12000, baseNaval.getFondos());
    }

    @Test
    void testLsBuquesActivos() {
        String expectedOutput = """
            BUQUES ACTIVOS EN LA BASE: Base Alfa
            ----------------------------------
            Buque A | CL: ACTIVO
            Buque C | DE: EN EJERCICIO
            """;

        assertEquals(expectedOutput, baseNaval.lsBuquesActivos());
    }

    @Test
    void testLsBuquesInactivos() {
        String expectedOutput = """
            BUQUES INACTIVOS EN LA BASE: Base Alfa
            ----------------------------------
            Buque B | CA: DESMANTELADO Motivo: Antigüedad | Misiones: 2
            """;

        assertEquals(expectedOutput, baseNaval.lsBuquesInactivos());
    }

    @Test
    void testCuentas(){
        String expected = """
                Fondos actuales: 10000€
                Proximos ingresos: 4000€
                Proximos gastos: 0€
                """;

        assertEquals(expected, baseNaval.cuentas());
    }

    @Test
    void testEnEjercicio(){
        assertInstanceOf(EstadoEnEjercicio.class, buque3.getEstado());
        buque3.finalizarEjercicio(baseNaval);
        assertInstanceOf(EstadoActivo.class, buque3.getEstado());
        assertEquals(7, buque3.getNumMisiones());
        assertEquals(14000, baseNaval.getFondos());
        buque3.empezarEjercicio(baseNaval);
        assertInstanceOf(EstadoEnEjercicio.class, buque3.getEstado());
    }

    @Test
    void testEnReparacion(){
        buque1.solicitarReparacion(baseNaval);
        assertInstanceOf(EstadoEsperaReparacion.class, buque1.getEstado());
        buque1.reparar(baseNaval);
        assertInstanceOf(EstadoEnReparacion.class, buque1.getEstado());
        assertEquals(9000, baseNaval.getFondos());
        buque1.finalizarReparacion(baseNaval);
        assertInstanceOf(EstadoActivo.class, buque1.getEstado());
        assertTrue(buque1.esOperativo());
    }

    @Test
    void testEsperaReparacionExpress(){
        buque1.solicitarExpress(baseNaval);
        assertInstanceOf(EstadoEsperaReparacionExpress.class, buque1.getEstado());
        buque1.reparar(baseNaval);
        assertInstanceOf(EstadoActivo.class, buque1.getEstado());
        assertEquals(10000, baseNaval.getFondos());
    }

    @Test
    void testEstadoInactivo(){
        buque1.desmantelar(baseNaval, "Antigüedad");
        assertInstanceOf(EstadoInactivo.class, buque1.getEstado());
        buque3.desmantelar(baseNaval, "");
        assertInstanceOf(EstadoEnEjercicio.class, buque3.getEstado());
    }

    @Test
    void testEstadoHundido(){
        buque3.hundir(baseNaval);
        assertInstanceOf(EstadoHundido.class, buque3.getEstado());
        assertFalse(buque3.esOperativo());
        buque1.hundir(baseNaval);
        assertInstanceOf(EstadoActivo.class, buque1.getEstado());
    }
}
