package e1;

public class EstadoInactivo implements EstadoBuque{

    private String motivo;

    public EstadoInactivo(String motivo) {this.motivo = motivo;}

    public String getMotivo() {return motivo;}

    public void setMotivo(String motivo) {this.motivo = motivo;}

    @Override
    public String toString() {return "DESMANTELADO";}

    @Override
    public void empezarEjercicio(Buque buque, BaseNaval base) {}

    @Override
    public void finalizarEjercicio(Buque buque, BaseNaval base) {}

    @Override
    public void solicitarReparacion(Buque buque, BaseNaval base) {}

    @Override
    public void reparar(Buque buque, BaseNaval base) {}

    @Override
    public void solicitarExpress(Buque buque, BaseNaval base) {}

    @Override
    public void finalizarReparacion(Buque buque, BaseNaval base) {}

    @Override
    public void hundir(Buque buque, BaseNaval base) {}

    @Override
    public void desmantelar(Buque buque, BaseNaval base, String motivo) {}

    @Override
    public boolean esOperativo() {return false;}
}
