package e1;

public class Buque {
    private final String nombre;
    private final TipoBuque tipo;
    private int numMisiones;
    private EstadoBuque estado;
    private PesoBuque peso;

    public Buque(String nombre, TipoBuque tipo, int numMisiones, EstadoBuque estado, PesoBuque peso) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.numMisiones = numMisiones;
        this.estado = estado;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoBuque getTipo() {
        return tipo;
    }

    public int getNumMisiones() {
        return numMisiones;
    }

    public void setNumMisiones(int numMisiones) {
        this.numMisiones = numMisiones;
    }

    public EstadoBuque getEstado() {
        return estado;
    }

    public void setEstado(EstadoBuque estado) {
        this.estado = estado;
    }

    public PesoBuque getPeso() {
        return peso;
    }

    public void empezarEjercicio(BaseNaval base){
        estado.empezarEjercicio(this, base);
    }

    public void finalizarEjercicio(BaseNaval base){
        estado.finalizarEjercicio(this, base);
    }

    public void solicitarReparacion(BaseNaval base){
        estado.solicitarReparacion(this, base);
    }

    public void reparar(BaseNaval base){
        estado.reparar(this, base);
    }

    public void finalizarReparacion(BaseNaval base){
        estado.finalizarReparacion(this, base);
    }

    public void hundir(BaseNaval base){
        estado.hundir(this, base);
    }

    public void desmantelar(BaseNaval base, String motivo){
        estado.desmantelar(this, base, motivo);
    }

    public void solicitarExpress (BaseNaval base){
        estado.solicitarExpress(this, base);
    }

    boolean esOperativo(){
         return estado.esOperativo();
    }



    public String toString(){
        return estado.toString();
    }

    public int calcularCosteReparacion(){
        if (peso==PesoBuque.ULIGERO) return 1000;
        else if (peso==PesoBuque.LIGERO) return 1500;
        else if (peso==PesoBuque.PESADO) return 2000;
        else return 2500;
    }
    public int calcularRecompensa(){
        if (peso==PesoBuque.ULIGERO) return 2000;
        else if (peso==PesoBuque.LIGERO) return 4000;
        else if (peso==PesoBuque.PESADO) return 6000;
        else return 8000;
    }
}
