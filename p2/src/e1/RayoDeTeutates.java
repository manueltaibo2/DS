package e1;

public class RayoDeTeutates extends TropaGala{
    boolean armaduraPesada;
    public RayoDeTeutates(boolean armaduraPesada) {
        super(armaduraPesada ? (100 * 0.75) : 100, armaduraPesada ?  (25 * 1.25) : 25);
        this.armaduraPesada = armaduraPesada;
    }

    @Override
    public String toString() {
        return armaduraPesada ? "Gauls Soldiery - Theutates Thunder with heavy armor\n" : "Gauls Soldiery - Theutates Thunder\n";
    }
}