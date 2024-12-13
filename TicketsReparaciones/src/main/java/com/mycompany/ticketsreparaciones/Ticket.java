package com.mycompany.ticketsreparaciones;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase que representa un ticket de reparación en el sistema.
 * Los tickets tienen un número único, nivel de dificultad y una prioridad asociada.
 * 
 * Los niveles de prioridad determinan el orden en que los tickets son procesados:
 * - ALTA: Para dificultades mayores a 70.
 * - MEDIA: Para dificultades entre 40 y 70.
 * - BAJA: Para dificultades menores a 40.
 * 
 */
public class Ticket implements Comparable<Ticket> {
    /**
     * Contador estático para asignar un número único a cada ticket.
     */
    private static final AtomicInteger contador = new AtomicInteger(1);

    /**
     * Número único del ticket.
     */
    private final int numeroTicket;

    /**
     * Nivel de dificultad del ticket (1-100).
     */
    private final int nivelDificultad;

    /**
     * Prioridad del ticket (ALTA, MEDIA, BAJA).
     */
    private final Prioridad prioridad;

    /**
     * Enumeración que define los niveles de prioridad de los tickets.
     */
    public enum Prioridad {
        ALTA, MEDIA, BAJA
    }

    /**
     * Constructor de la clase Ticket.
     * Inicializa un ticket asignándole un número único, nivel de dificultad y su correspondiente prioridad.
     *
     * @param nivelDificultad Nivel de dificultad del ticket (1-100).
     */
    public Ticket(int nivelDificultad) {
        this.numeroTicket = contador.getAndIncrement(); // Asigna un número único al ticket
        this.nivelDificultad = nivelDificultad;

        // Determina la prioridad del ticket según su nivel de dificultad
        if (nivelDificultad > 70) {
            this.prioridad = Prioridad.ALTA;
        } else if (nivelDificultad >= 40) {
            this.prioridad = Prioridad.MEDIA;
        } else {
            this.prioridad = Prioridad.BAJA;
        }
    }

    /**
     * Obtiene el número único del ticket.
     *
     * @return Número del ticket.
     */
    public int getNumeroTicket() {
        return numeroTicket;
    }

    /**
     * Obtiene el nivel de dificultad del ticket.
     *
     * @return Nivel de dificultad del ticket.
     */
    public int getNivelDificultad() {
        return nivelDificultad;
    }

    /**
     * Obtiene la prioridad del ticket.
     *
     * @return Prioridad del ticket.
     */
    public Prioridad getPrioridad() {
        return prioridad;
    }

    /**
     * Compara este ticket con otro en función de su prioridad.
     * 
     *
     * @param otro Ticket a comparar.
     * @return Un valor negativo, cero o positivo dependiendo de la comparación de prioridades.
     */
    @Override
    public int compareTo(Ticket otro) {
        return this.prioridad.compareTo(otro.prioridad); // Mayor prioridad primero
    }

    /**
     * Devuelve una representación en forma de cadena del ticket.
     *
     * @return Cadena que describe el ticket, incluyendo su número, dificultad y prioridad.
     */
    @Override
    public String toString() {
        return "Ticket{" +
                "numero=" + numeroTicket +
                ", dificultad=" + nivelDificultad +
                ", prioridad=" + prioridad +
                '}';
    }
}
