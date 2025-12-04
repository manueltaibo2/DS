package e1;

import java.util.ArrayList;
import java.util.List;

public abstract class Aldea <T extends Tropa> {
    protected String nombre;
    protected int edad;
    protected float nivelMuralla;
    protected List<T> ejercito;

    public Aldea(String nombre, int edad, float nivelMuralla) {
        this.nombre = nombre;
        this.edad = edad;
        this.nivelMuralla = nivelMuralla;
        ejercito = new ArrayList<>();
    }

    public void agregarTropa(T tropa){
        ejercito.add(tropa);
    };

    public abstract double calcularPoderOfensivo();
    public abstract double calcularPoderDefensivo();
}
