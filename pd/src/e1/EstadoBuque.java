package e1;

public interface EstadoBuque {
    void empezarEjercicio(Buque buque, BaseNaval base);
    void finalizarEjercicio(Buque buque, BaseNaval base);
    void solicitarReparacion(Buque buque, BaseNaval base);
    void reparar(Buque buque, BaseNaval base);
    void finalizarReparacion(Buque buque, BaseNaval base);
    void hundir(Buque buque, BaseNaval base);
    void desmantelar(Buque buque, BaseNaval base, String motivo);
    void solicitarExpress (Buque buque, BaseNaval base);

    boolean esOperativo();
    String toString();
}
