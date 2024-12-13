package com.mycompany.ticketsreparaciones;

/**
 * Clase que representa un reparador en el sistema.
 * Los reparadores intentan resolver los tickets en función de su nivel de habilidad.
 */
public class Reparador implements Comparable<Reparador> {
    private final String nombreApellidos;
    private final int nivelReparacion;

    /**
     * Constructor de la clase Reparador.
     *
     * @param nombreApellidos Nombre completo del reparador.
     * @param nivelReparacion Nivel de habilidad del reparador.
     */
    public Reparador(String nombreApellidos, int nivelReparacion) {
        this.nombreApellidos = nombreApellidos;
        this.nivelReparacion = nivelReparacion;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public int getNivelReparacion() {
        return nivelReparacion;
    }

    /**
     * Compara este reparador con otro en función de su nivel de habilidad.
     * Los reparadores con menor nivel se ordenan antes.
     *
     * @param otro Reparador a comparar.
     * @return Un valor negativo, cero o positivo dependiendo de la comparación.
     */
    @Override
    public int compareTo(Reparador otro) {
        return Integer.compare(this.nivelReparacion, otro.nivelReparacion);
    }

    @Override
    public String toString() {
        return "Reparador{" +
                "nombre='" + nombreApellidos + '\'' +
                ", nivelReparacion=" + nivelReparacion +
                '}';
    }
}
