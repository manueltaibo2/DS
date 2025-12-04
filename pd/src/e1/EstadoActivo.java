package e1;

public class EstadoActivo implements EstadoBuque{

    @Override
    public String toString() {
        return "ACTIVO";
    }

    @Override
    public void empezarEjercicio(Buque buque, BaseNaval base) {
        System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : ha comenzado un ejercicio.");
        buque.setEstado(new EstadoEnEjercicio());
    }

    @Override
    public void finalizarEjercicio(Buque buque, BaseNaval base) {}

    @Override
    public void solicitarReparacion(Buque buque, BaseNaval base) {
        System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : solicita reparacion, coste estimado = "+ buque.calcularCosteReparacion());
        buque.setEstado(new EstadoEsperaReparacion());
    }

    @Override
    public void reparar(Buque buque, BaseNaval base) {
        if (base.getFondos()>=buque.calcularCosteReparacion()){
            System.out.println("Fondos insuficientes para reparar: "+buque.getNombre()+".");
            return;
        }
        if(base.hayBuquesEnReparacion()) {
            System.out.println("Hay buques en reparacion, se añade el " + buque.getNombre()+" a la lista de espera de reparacion.");
            buque.setEstado(new EstadoEsperaReparacion());
            return;
        }

        base.setFondos(base.getFondos()-buque.calcularCosteReparacion());
        buque.setEstado(new EstadoEnReparacion());
        System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : pasa a estar en reparacion por "+buque.calcularCosteReparacion());
    }

    @Override
    public void finalizarReparacion(Buque buque, BaseNaval base) {}

    @Override
    public void hundir(Buque buque, BaseNaval base) {}

    @Override
    public void desmantelar(Buque buque, BaseNaval base, String motivo) {
        System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : ha sido desmantelado.");
        buque.setEstado(new EstadoInactivo(motivo));
    }

    @Override
    public void solicitarExpress(Buque buque, BaseNaval base) {
        if (buque.getPeso()==PesoBuque.ULIGERO){
            buque.setEstado(new EstadoEsperaReparacionExpress());
            System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : pasa a estar en espera para reparacion express.");
        } else {
            System.out.println(buque.getNombre()+" | "+ buque.getTipo()+" : demasiado pesado para reparación express.");
        }
    }

    @Override
    public boolean esOperativo() {return true;}
}
