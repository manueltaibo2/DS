package e1;

public abstract class TropaRomana extends Tropa{

    public TropaRomana(double ataque, double defensa){
        super(ataque, defensa);
    }

    @Override
    public abstract String toString();
}
