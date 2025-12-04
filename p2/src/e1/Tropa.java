package e1;

public abstract class Tropa {
    protected double ataque;
    protected double defensa;

    public Tropa(double ataque, double defensa) {
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public final double getAtaque() {
        return ataque;
    }

    public final double getDefensa() {
        return defensa;
    }

    public abstract String toString();
}
