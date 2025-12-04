package e1;

public class AldeaRomana extends Aldea<TropaRomana>{
    public AldeaRomana(String nombre, int edad, float nivelMuralla) {
        super(nombre, edad, nivelMuralla);
    }

    @Override
    public double calcularPoderOfensivo(){
        double poderOfensivo = 0;
        for (TropaRomana tropa : ejercito){
            poderOfensivo += tropa.getAtaque()*1.1; //  +10% ataque
        }
        return poderOfensivo;
    }

    @Override
    public double calcularPoderDefensivo(){
        double poderDefensivo = 0;
        for (TropaRomana tropa : ejercito){
            poderDefensivo += tropa.getDefensa() + (2*nivelMuralla);    //  Aumento por muralla
        }
        return poderDefensivo;
    }
}
