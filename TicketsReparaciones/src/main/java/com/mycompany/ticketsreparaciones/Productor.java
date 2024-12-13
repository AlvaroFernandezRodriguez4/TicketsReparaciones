package com.mycompany.ticketsreparaciones;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Clase que representa un productor en el sistema.
 * El productor genera tickets con niveles de dificultad aleatorios y los coloca en la cola.
 */
public class Productor implements Runnable {
    private final BlockingQueue<Ticket> cola; // Cola compartida donde se colocan los tickets
    private final int cantidadTickets; // Cantidad total de tickets a generar

    /**
     * Constructor de la clase Productor.
     *
     * @param cola            Cola de tickets compartida.
     * @param cantidadTickets Número total de tickets a generar.
     */
    public Productor(BlockingQueue<Ticket> cola, int cantidadTickets) {
        this.cola = cola;
        this.cantidadTickets = cantidadTickets;
    }

    /**
     * Método ejecutado por el hilo productor.
     * Genera tickets con niveles de dificultad aleatorios y los coloca en la cola.
     */
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < cantidadTickets; i++) {
            // Generar una dificultad aleatoria para el ticket
            int dificultad = random.nextInt(100) + 1;
            Ticket ticket = new Ticket(dificultad);
            try {
                // Colocar el ticket en la cola prioritaria
                cola.put(ticket);
                System.out.println("Producido: " + ticket);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


