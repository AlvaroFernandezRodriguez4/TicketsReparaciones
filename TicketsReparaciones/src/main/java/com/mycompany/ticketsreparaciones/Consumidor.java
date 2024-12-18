package com.mycompany.ticketsreparaciones;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Clase que representa un consumidor en el sistema. Los consumidores toman los
 * tickets de la cola y los asignan a los reparadores.
 *
 * Los tickets son procesados en orden de prioridad y los reparadores intentan
 * resolverlos en base a su nivel de habilidad.
 *
 */
public class Consumidor implements Runnable {

    private final BlockingQueue<Ticket> cola; // Cola compartida para obtener tickets
    private final List<Reparador> reparadores; // Lista de reparadores ordenados por habilidad

    /**
     * Constructor de la clase Consumidor.
     *
     * @param cola Cola de tickets compartida.
     * @param reparadores Lista de reparadores disponibles.
     */
    public Consumidor(BlockingQueue<Ticket> cola, List<Reparador> reparadores) {
        this.cola = cola;
        this.reparadores = reparadores;
    }

    /**
     * Método ejecutado por el hilo consumidor. Procesa los tickets en la cola
     * asignándolos a los reparadores disponibles.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // Extraer el ticket con mayor prioridad de la cola
                /*El método take() de la interfaz BlockingQueue se utiliza para 
                recuperar y eliminar la cabecera de esta cola. Si la cola está 
                vacía, esperará hasta que haya un elemento disponible.*/
                Ticket ticket = cola.take();
                System.out.println("\nProcesando: " + ticket);

                boolean resuelto = false;

                for (Reparador reparador : reparadores) {
                    if (puedeResolver(reparador, ticket)) {
                        System.out.println(reparador.getNombreApellidos() + " resolvió el ticket " + ticket.getNumeroTicket());
                        resuelto = true;
                        break;
                    } else {
                        System.out.println(reparador.getNombreApellidos() + " no pudo resolver el ticket " + ticket.getNumeroTicket());
                    }
                }

                // Si el ticket no ha sido resuelto, volver a ponerlo en la cola
                if (!resuelto) {
                    System.out.println("Ningún reparador pudo resolver el ticket " + ticket.getNumeroTicket() + ". Volviendo a ponerlo en la cola.");
                    cola.put(ticket); 
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Determina si un reparador puede resolver un ticket, basado en su
     * habilidad y dificultad del ticket.
     *
     * La probabilidad de éxito se calcula comparando el nivel del reparador con
     * el nivel de dificultad del ticket, ajustado con un valor base.
     *
     * @param reparador Reparador que intenta resolver el ticket.
     * @param ticket Ticket a resolver.
     * @return true si el reparador puede resolver el ticket; false en caso
     * contrario.
     */
    private boolean puedeResolver(Reparador reparador, Ticket ticket) {
        Random random = new Random();
        // Cálculo de probabilidad ajustada para garantizar un mínimo de posibilidad
        int probabilidad = reparador.getNivelReparacion() - ticket.getNivelDificultad() + 50;
        return random.nextInt(100) < Math.max(probabilidad, 10);
    }
}
