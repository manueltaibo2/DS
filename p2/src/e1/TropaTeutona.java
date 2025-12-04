package e1;

public abstract class TropaTeutona extends Tropa{

    public TropaTeutona(double ataque, double defensa){
        super(ataque, defensa);
    }

    @Override
    public abstract String toString();
}
