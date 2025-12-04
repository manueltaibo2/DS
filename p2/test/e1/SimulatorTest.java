package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

class SimulatorTest {
    // Declarar las tropas y aldeas como variables
    Legionario legionario1;
    Pretoriano pretoriano1;
    Pretoriano pretoriano2;
    EquitesImperatoris equitesImperatoris1;

    GuerreroDeHacha guerreroDeHacha1;
    GuerreroDeMaza guerreroDeMaza1;
    GuerreroDeMaza guerreroDeMaza2;
    Paladin paladin1;

    Druida druida1;
    Falange falange1;
    RayoDeTeutates rayoDeTeutates1;
    RayoDeTeutates rayoDeTeutates2;

    AldeaRomana aldeaRomana1;
    AldeaTeutona aldeaTeutona1;
    AldeaGala aldeaGala1;

    Simulador simulador;

    // Inicializar todos los objetos antes de cada prueba
    @BeforeEach
    void setUp() {
        // Crear tropas romanas
        legionario1 = new Legionario();
        pretoriano1 = new Pretoriano(false);
        pretoriano2 = new Pretoriano(true);
        equitesImperatoris1 = new EquitesImperatoris();

        // Crear tropas teutonas
        guerreroDeHacha1 = new GuerreroDeHacha();
        guerreroDeMaza1 = new GuerreroDeMaza(false);
        guerreroDeMaza2 = new GuerreroDeMaza(true);
        paladin1 = new Paladin();

        // Crear tropas galas
        druida1 = new Druida();
        falange1 = new Falange();
        rayoDeTeutates1 = new RayoDeTeutates(false);
        rayoDeTeutates2 = new RayoDeTeutates(true);

        // Crear aldeas
        aldeaRomana1 = new AldeaRomana("Roma", 500, 5);
        aldeaTeutona1 = new AldeaTeutona("Teutonia", 400, 3);
        aldeaGala1 = new AldeaGala("Galia", 500, 5);

        // Añadir tropas a las aldeas romanas
        aldeaRomana1.agregarTropa(legionario1);
        aldeaRomana1.agregarTropa(pretoriano1);
        aldeaRomana1.agregarTropa(pretoriano2);
        aldeaRomana1.agregarTropa(equitesImperatoris1);

        // Añadir tropas a las aldeas teutonas
        aldeaTeutona1.agregarTropa(guerreroDeHacha1);
        aldeaTeutona1.agregarTropa(guerreroDeMaza1);
        aldeaTeutona1.agregarTropa(guerreroDeMaza2);
        aldeaTeutona1.agregarTropa(paladin1);

        // Añadir tropas a las aldeas galas
        aldeaGala1.agregarTropa(druida1);
        aldeaGala1.agregarTropa(falange1);
        aldeaGala1.agregarTropa(rayoDeTeutates1);
        aldeaGala1.agregarTropa(rayoDeTeutates2);

        // Crear simulador
        simulador = new Simulador();
    }

    @Test //ok
    public void testRomaAtacaGalia() {
        String resultadoEsperado = "### Starts the battle! --> Roma Attacks Galia! ###\n" +
                "Roma have the following soldiery:\n" +
                "Roman Soldier - Legionary\n" +
                "Roman Soldier - Praetorian\n" +
                "Roman Soldier - Praetorian with armor\n" +
                "Roman Soldier - Equites Imperatoris\n" +
                "Total Roma attack power: 242.0\n\n" +

                "Galia have the following soldiery:\n" +
                "Gauls Soldiery - Druidrider\n" +
                "Gauls Soldiery - Phalanx\n" +
                "Gauls Soldiery - Theutates Thunder\n" +
                "Gauls Soldiery - Theutates Thunder with heavy armor\n" +
                "Total Galia defense power: 241.25\n\n" +

                "Roma with an age of 500 years WINS!";

        String resultadoActual = simulador.batalla(aldeaRomana1, aldeaGala1);
        assertEquals(resultadoEsperado, resultadoActual);
    }

    @Test
    public void testGaliaAtacaTeutonia() {
        String resultadoEsperado = "### Starts the battle! --> Galia Attacks Teutonia! ###\n" +
                "Galia have the following soldiery:\n" +
                "Gauls Soldiery - Druidrider\n" +
                "Gauls Soldiery - Phalanx\n" +
                "Gauls Soldiery - Theutates Thunder\n" +
                "Gauls Soldiery - Theutates Thunder with heavy armor\n" +
                "Total Galia attack power: 282.0\n\n" +

                "Teutonia have the following soldiery:\n" +
                "Teutons Soldiery - Axeman\n"+
                "Teutons Soldiery - Maceman\n"+
                "Teutons Soldiery - Maceman with iron mace\n"+
                "Teutons Soldiery - Paladin\n"+
                "Total Teutonia defense power: 182.0\n\n" +

                "Galia with an age of 500 years WINS!";

        String resultadoActual = simulador.batalla(aldeaGala1, aldeaTeutona1);
        assertEquals(resultadoEsperado, resultadoActual);
    }

    @Test
    public void testTeutoniaAtacaRoma() {
        String resultadoEsperado = "### Starts the battle! --> Teutonia Attacks Roma! ###\n" +
                "Teutonia have the following soldiery:\n" +
                "Teutons Soldiery - Axeman\n"+
                "Teutons Soldiery - Maceman\n"+
                "Teutons Soldiery - Maceman with iron mace\n"+
                "Teutons Soldiery - Paladin\n"+
                "Total Teutonia attack power: 194.75\n\n" +

                "Roma have the following soldiery:\n" +
                "Roman Soldier - Legionary\n" +
                "Roman Soldier - Praetorian\n" +
                "Roman Soldier - Praetorian with armor\n" +
                "Roman Soldier - Equites Imperatoris\n" +
                "Total Roma defense power: 276.0\n\n" +

                "Roma with an age of 500 years WINS!";

        String resultadoActual = simulador.batalla(aldeaTeutona1, aldeaRomana1);
        assertEquals(resultadoEsperado, resultadoActual);
    }

    @Test
    public void testRomaAtacaTeutonia() {
        String resultadoEsperado = "### Starts the battle! --> Roma Attacks Teutonia! ###\n" +
                "Roma have the following soldiery:\n" +
                "Roman Soldier - Legionary\n" +
                "Roman Soldier - Praetorian\n" +
                "Roman Soldier - Praetorian with armor\n" +
                "Roman Soldier - Equites Imperatoris\n" +
                "Total Roma attack power: 242.0\n\n" +

                "Teutonia have the following soldiery:\n" +
                "Teutons Soldiery - Axeman\n"+
                "Teutons Soldiery - Maceman\n"+
                "Teutons Soldiery - Maceman with iron mace\n"+
                "Teutons Soldiery - Paladin\n"+
                "Total Teutonia defense power: 182.0\n\n" +

                "Roma with an age of 500 years WINS!";

        String resultadoActual = simulador.batalla(aldeaRomana1, aldeaTeutona1);
        assertEquals(resultadoEsperado, resultadoActual);
    }
}