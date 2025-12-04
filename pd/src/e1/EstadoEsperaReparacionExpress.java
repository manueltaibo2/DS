package e1;

public class EstadoEsperaReparacionExpress implements EstadoBuque{

    @Override
    public String toString() {
        return "REPARACION EXPRESS";
    }

    @Override
    public void empezarEjercicio(Buque buque, BaseNaval base) {}

    @Override
    public void finalizarEjercicio(Buque buque, BaseNaval base) {}

    @Override
    public void solicitarReparacion(Buque buque, BaseNaval base) {}

    @Override
    public void reparar(Buque buque, BaseNaval base) {
        if(!base.hayBuquesEnReparacion()) {
            finalizarReparacion(buque, base);
        } else {
            System.out.println("Ya hay buques en reparacion.");
        }
    }

    @Override
    public void finalizarReparacion(Buque buque, BaseNaval base) {
        System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : ha sido reparado.");
        buque.setEstado(new EstadoActivo());
    }

    @Override
    public void hundir(Buque buque, BaseNaval base) {}

    @Override
    public void desmantelar(Buque buque, BaseNaval base, String motivo) {
        System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : ha sido desmantelado.");
        buque.setEstado(new EstadoInactivo(motivo));
    }

    @Override
    public void solicitarExpress(Buque buque, BaseNaval base) {}

    @Override
    public boolean esOperativo() {return true;}
}
