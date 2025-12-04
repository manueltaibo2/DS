package e1;

public class AldeaGala extends Aldea<TropaGala>{
    public AldeaGala(String name, int edad, float nivelMuralla) {
        super(name, edad, nivelMuralla);
    }

    @Override
    public double calcularPoderOfensivo(){
        double poderOfensivo = 0;

        for (TropaGala tropa : ejercito){
            poderOfensivo += tropa.getAtaque()*1.2;
        }
        return poderOfensivo;
    }

    @Override
    public double calcularPoderDefensivo(){
        double poderDefensivo = 0;

        for (TropaGala tropa : ejercito){
            poderDefensivo += tropa.getDefensa()+(1.5*nivelMuralla);
        }
        return poderDefensivo;
    }
}