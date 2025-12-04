package e1;

public class AldeaTeutona extends Aldea<TropaTeutona>{
    public AldeaTeutona(String nombre, int edad, float nivelMuralla){
        super(nombre, edad, nivelMuralla);
    }

    @Override
    public double calcularPoderOfensivo(){
        double poderOfensivo = 0;

        for (TropaTeutona tropa : ejercito){
            poderOfensivo += tropa.getAtaque()*0.95;
        }
        return poderOfensivo;
    }

    @Override
    public double calcularPoderDefensivo(){
        double poderDefensivo = 0;

        for (TropaTeutona tropa : ejercito){
            poderDefensivo += tropa.getDefensa() + nivelMuralla;
        }
        return poderDefensivo;
    }
}