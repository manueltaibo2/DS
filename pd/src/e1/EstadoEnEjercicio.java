package e1;

public class EstadoEnEjercicio implements EstadoBuque{

    @Override
    public String toString() {
        return "EN EJERCICIO";
    }

    @Override
    public void empezarEjercicio(Buque buque, BaseNaval base) {}

    @Override
    public void finalizarEjercicio(Buque buque, BaseNaval base) {
        System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : ha finalizado el ejercicio.");
        buque.setNumMisiones(buque.getNumMisiones()+1);
        base.setFondos(base.getFondos()+buque.calcularRecompensa());
        buque.setEstado(new EstadoActivo());
    }

    @Override
    public void solicitarReparacion(Buque buque, BaseNaval base) {}

    @Override
    public void reparar(Buque buque, BaseNaval base) {}

    @Override
    public void finalizarReparacion(Buque buque, BaseNaval base) {}

    @Override
    public void hundir(Buque buque, BaseNaval base) {
        System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : ha sido hundido.");
        buque.setEstado(new EstadoHundido());
    }

    @Override
    public void desmantelar(Buque buque, BaseNaval base, String motivo) {}

    @Override
    public void solicitarExpress(Buque buque, BaseNaval base) {}

    @Override
    public boolean esOperativo(){
        return true;
    }
}
