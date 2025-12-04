package e1;

public class Pretoriano extends TropaRomana{
    public boolean armadura;

    public Pretoriano(boolean armadura){
        super(30, armadura ? (int) (65 * 1.1) : 65);
        this.armadura = armadura;
    }

    @Override
    public String toString(){
        return armadura ? "Roman Soldier - Praetorian with armor\n" : "Roman Soldier - Praetorian\n";
    }
}
