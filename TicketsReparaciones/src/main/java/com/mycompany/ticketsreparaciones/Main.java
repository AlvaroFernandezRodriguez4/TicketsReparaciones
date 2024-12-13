package com.mycompany.ticketsreparaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Clase principal del programa que simula un sistema de gestión de tickets de reparación.
 * Inicializa los reparadores, la cola de tickets y los hilos de productor y consumidor.
 * 
 * Los tickets se procesan en base a su nivel de prioridad y son asignados
 * dinámicamente a los reparadores en función de su nivel de habilidad.
 * 
 */
public class Main {
    /**
     * Método principal del programa.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        PriorityBlockingQueue<Ticket> colaTickets = new PriorityBlockingQueue<>();
        List<Reparador> reparadores = new ArrayList<>();

        // Inicialización de los reparadores con diferentes niveles de habilidad
        reparadores.add(new Reparador("Marisol Gutiérrez", 30));
        reparadores.add(new Reparador("Miguel Batracio", 50));
        reparadores.add(new Reparador("Hermenegildo Romero", 70));
        reparadores.add(new Reparador("Leticia Barranco", 90));
        reparadores.add(new Reparador("Manuel Zafra", 100));

        reparadores.sort(null); // Ordenar reparadores por nivel de habilidad (menor a mayor)

        // Creación de los hilos para la producción y el consumo de tickets
        Thread productor = new Thread(new Productor(colaTickets, 20));
        Thread consumidor = new Thread(new Consumidor(colaTickets, reparadores));

        productor.start(); // Inicia el hilo productor
        consumidor.start(); // Inicia el hilo consumidor
    }
}


