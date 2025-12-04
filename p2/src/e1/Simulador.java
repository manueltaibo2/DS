package e1;

import java.util.ArrayList;
import java.util.List;

public class Simulador {
    public <T extends Tropa, U extends Tropa> String batalla(Aldea<T> aldeaAtacante, Aldea<U> aldeaDefensora) {
        List<String> resultado = new ArrayList<>();

        // Inicia la batalla
        resultado.add("### Starts the battle! --> " + aldeaAtacante.nombre + " Attacks " + aldeaDefensora.nombre + "! ###\n");

        //Mostrar el ejercito de la aldea atacante
        resultado.add(aldeaAtacante.nombre + " have the following soldiery:\n");
        for (T tropa : aldeaAtacante.ejercito){
            resultado.add(tropa.toString());
        }
        //Calcular poder ofensivo
        double poderOfensivoAtacante = aldeaAtacante.calcularPoderOfensivo();
        resultado.add("Total " + aldeaAtacante.nombre + " attack power: " + poderOfensivoAtacante+"\n\n");

        //Mostrar ejercito defensa
        resultado.add(aldeaDefensora.nombre + " have the following soldiery:\n");
        for (U tropa : aldeaDefensora.ejercito) {
            resultado.add(tropa.toString());
        }

        //Calcular poder defensivo
        double poderDefensivoDefensor = aldeaDefensora.calcularPoderDefensivo();
        resultado.add("Total " + aldeaDefensora.nombre + " defense power: " + poderDefensivoDefensor+"\n\n");

        //Resultado
        if (poderOfensivoAtacante>=poderDefensivoDefensor){
            resultado.add(aldeaAtacante.nombre + " with an age of " + aldeaAtacante.edad + " years WINS!");
        } else {
            resultado.add(aldeaDefensora.nombre + " with an age of " + aldeaDefensora.edad + " years WINS!");
        }
        return String.join("",resultado);
    }
}
