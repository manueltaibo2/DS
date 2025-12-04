package e1;

public class EstadoHundido implements EstadoBuque{

    @Override
    public String toString() {
        return "HUNDIDO";
    }

    @Override
    public void empezarEjercicio(Buque buque, BaseNaval base) {}

    @Override
    public void finalizarEjercicio(Buque buque, BaseNaval base) {}

    @Override
    public void solicitarReparacion(Buque buque, BaseNaval base) {}

    @Override
    public void reparar(Buque buque, BaseNaval base) {}

    @Override
    public void finalizarReparacion(Buque buque, BaseNaval base) {}

    @Override
    public void hundir(Buque buque, BaseNaval base) {}

    @Override
    public void desmantelar(Buque buque, BaseNaval base, String motivo) {}

    @Override
    public void solicitarExpress(Buque buque, BaseNaval base) {}

    @Override
    public boolean esOperativo() {return false;}
}
