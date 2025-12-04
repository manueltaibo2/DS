package e1;

public class EstadoEsperaReparacion implements EstadoBuque{

    @Override
    public String toString() {
        return "EN ESPERA PARA REPARACIÓN";
    }

    @Override
    public void empezarEjercicio(Buque buque, BaseNaval base) {}

    @Override
    public void finalizarEjercicio(Buque buque, BaseNaval base) {}

    @Override
    public void solicitarReparacion(Buque buque, BaseNaval base) {}

    @Override
    public void reparar(Buque buque, BaseNaval base) {
        if (base.getFondos()<=buque.calcularCosteReparacion()){
            System.out.println("Fondos insuficientes para reparar: "+buque.getNombre()+".");
            return;
        }

        if (!base.hayBuquesEnReparacion()){
            base.setFondos(base.getFondos()-buque.calcularCosteReparacion());
            buque.setEstado(new EstadoEnReparacion());
            System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : pasa a estar en reparacion por "+buque.calcularCosteReparacion());
        } else {
            System.out.println("Ya hay buques en reparacion.");
        }
    }

    @Override
    public void finalizarReparacion(Buque buque, BaseNaval base) {}

    @Override
    public void solicitarExpress(Buque buque, BaseNaval base) {}

    @Override
    public void hundir(Buque buque, BaseNaval base) {}

    @Override
    public void desmantelar(Buque buque, BaseNaval base, String motivo) {
        System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : ha sido desmantelado.");
        buque.setEstado(new EstadoInactivo(motivo));
    }

    @Override
    public boolean esOperativo() {return true;}
}
