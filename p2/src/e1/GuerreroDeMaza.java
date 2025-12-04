package e1;

public class GuerreroDeMaza extends TropaTeutona {
    private boolean mazaMejorada;

    public GuerreroDeMaza(boolean mazaMejorada) {
        super(mazaMejorada ? 40 +  (40 * 0.25) : 40, 20);
        this.mazaMejorada = mazaMejorada;
    }

    @Override
    public String toString() {
        return mazaMejorada ? "Teutons Soldiery - Maceman with iron mace\n" : "Teutons Soldiery - Maceman\n";
    }
}