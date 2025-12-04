package e1;

import java.util.ArrayList;
import java.util.List;

public class BaseNaval {
    private final String nombre;
    private List<Buque> buques;
    private int fondos;


    public BaseNaval(String nombre, int fondos) {
        this.nombre = nombre;
        this.fondos = fondos;
        buques = new ArrayList<Buque>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getFondos() {
        return fondos;
    }
    public void setFondos(int fondos) {
        this.fondos = fondos;
    }

    public List<Buque> getBuques() {
        return buques;
    }
    public void addBuque(Buque buque) {
        buques.add(buque);
    }
    public void removeBuque(Buque buque, BaseNaval base) {
        if (buques.contains(buque)) {
            buques.remove(buque);
            System.out.println("El buque " + buque.getNombre() + " ha sido eliminado de la base.");
        } else {
            System.out.println("El buque " + buque.getNombre() + " no se encuentra en la base.");
        }
    }

    public String lsBuquesActivos() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("BUQUES ACTIVOS EN LA BASE: ").append(nombre).append("\n");
        resultado.append("----------------------------------\n");

        boolean hayActivos = false;
        for (Buque buque : buques) {
            if (buque.getEstado().esOperativo()) {
                hayActivos = true;
                resultado.append(buque.getNombre()).append(" | ")
                        .append(buque.getTipo()).append(": ")
                        .append(buque.getEstado()).append("\n");
            }
        }

        if (!hayActivos) {
            resultado.append("No hay buques activos en la base.\n");
        }

        return resultado.toString();
    }
    public String cuentas() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Fondos actuales: ").append(fondos).append("€\n");

        int proxIngresos = 0;
        for (Buque buque : buques) {
            if (buque.getEstado() instanceof EstadoEnEjercicio) {
                proxIngresos += buque.calcularRecompensa();
            }
        }
        resultado.append("Proximos ingresos: ").append(proxIngresos).append("€\n");

        int proxGastos = 0;
        for (Buque buque : buques) {
            if (buque.getEstado() instanceof EstadoEsperaReparacion) {
                proxGastos += buque.calcularCosteReparacion();
            }
        }
        resultado.append("Proximos gastos: ").append(proxGastos).append("€\n");

        System.out.print(resultado.toString()); // Imprimir el resultado en consola
        return resultado.toString();
    }

    public String lsBuquesInactivos() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("BUQUES INACTIVOS EN LA BASE: ").append(nombre).append("\n");
        resultado.append("----------------------------------\n");

        boolean hayInactivos = false;
        for (Buque buque : buques) {
            if (buque.getEstado() instanceof EstadoInactivo) {
                hayInactivos = true;
                resultado.append(buque.getNombre())
                        .append(" | ").append(buque.getTipo())
                        .append(": ").append(buque.getEstado())
                        .append(" Motivo: ").append(((EstadoInactivo) buque.getEstado()).getMotivo())
                        .append(" | Misiones: ").append(buque.getNumMisiones()).append("\n");
            }
        }

        if (!hayInactivos) {
            resultado.append("No hay buques activos en la base.\n");
        }

        System.out.print(resultado.toString()); // Imprimir el resultado en consola
        return resultado.toString();
    }

    public boolean hayBuquesEnReparacion() {
        for (Buque buque : buques) {
            if (buque.getEstado() instanceof EstadoEnReparacion) {
                return true;
            }
        }
        return false;
    }


}