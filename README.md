# Tickets-Reparaciones

# Gestión de Tickets y Reparadores en Java
## Descripción del Proyecto

Este proyecto simula un sistema de gestión de tickets de reparación en un taller utilizando hilos y la estructura concurrente `PriorityBlockingQueue` en Java. Los tickets se generan con diferentes niveles de dificultad y prioridad, mientras que los reparadores intentan resolverlos en función de sus niveles de habilidad. La concurrencia asegura que los tickets se procesen de manera eficiente y en el orden correcto.

## Características

- **Cola Prioritaria Concurrente:** Utiliza PriorityBlockingQueue para gestionar tickets según su prioridad (ALTA, MEDIA o BAJA).

- **Productores y Consumidores:** Implementación de hilos productores para generar tickets e hilos consumidores para procesarlos.

- **Asignación Dinámica:** Los tickets se asignan a reparadores de forma dinámica, teniendo en cuenta su habilidad y probabilidad de éxito.

- **Gestión de Prioridades:** Los tickets de mayor dificultad se procesan antes que los de menor dificultad.

# Estructura del Proyecto

## Clases principales:

### Ticket:

Representa un ticket con un número único, nivel de dificultad (1-100) y prioridad (ALTA, MEDIA, BAJA).
Se utiliza un sistema de prioridades para determinar el orden de procesamiento.

### Reparador:

Representa un técnico con un nombre, apellidos y nivel de habilidad (1-100).
Los reparadores están ordenados por su nivel de habilidad para maximizar la eficiencia.

### Productor:

Hilo encargado de generar tickets aleatorios y colocarlos en la cola prioritaria.

### Consumidor:

Hilo encargado de tomar los tickets de la cola y asignarlos a los reparadores en orden.

### Main:

Clase principal que inicializa la cola, los reparadores y los hilos, y gestiona el flujo de la aplicación.

## Ejecución

1. Clona el repositorio.
2. Abre el proyecto en tu entorno de desarrollo favorito.
3. Compila y ejecuta la aplicación.
4. Observa en la consola cómo los reparadores procesan los tickets según sus niveles de habilidad y las prioridades de los tickets.

## Clases que hemos usado

- Clase **PriorityBlockingQueue**: Utilizada para mantener el orden de prioridad de los tickets en un entorno concurrente.
- Clase **Random**: Genera valores aleatorios para los niveles de dificultad de los tickets y probabilidad de éxito de los reparadores.
- Clase **Threads**: Los hilos controlan la producción y consumo de tickets en paralelo.

## Tabla con métodos de interés

| Modificador y Tipo         | Método y Descripción                                                                        |
| -------------------------- | ------------------------------------------------------------------------------------------- |
| boolean                    | add(E e)                                                                                   |
|                            | Inserta un elemento en la cola respetando el orden de prioridad.                           |
| E                          | take()                                                                                     |
|                            | Obtiene y elimina el primer elemento disponible en la cola.                                |
| int                        | nextInt(int bound)                                                                          |
|                            | Genera un número aleatorio dentro de un rango específico.                                  |
| void                       | start()                                                                                   |
|                            | Inicia un hilo para ejecutar un proceso concurrente.                                       |


## Casos de Uso

1. Taller de Reparación: Simula un taller donde los técnicos resuelven tickets de reparación según su nivel de habilidad y las prioridades establecidas.
2. Gestión de Soporte Técnico: Aplicable a sistemas de soporte donde las solicitudes deben priorizarse y asignarse dinámicamente a los técnicos.
3. Procesamiento de Tareas Concurrentes: Útil en entornos donde múltiples tareas deben ser procesadas según su urgencia.

## Ejemplo de Uso

```java
// Inicializar una cola prioritaria concurrente
PriorityBlockingQueue<Ticket> colaTickets = new PriorityBlockingQueue<>();

// Crear reparadores con diferentes niveles de habilidad
List<Reparador> reparadores = Arrays.asList(
    new Reparador("Juan Pérez", 30),
    new Reparador("Ana López", 50),
    new Reparador("Luis Gómez", 70),
    new Reparador("María Fernández", 90),
    new Reparador("Pedro Ramírez", 100)
);

// Crear hilos de productor y consumidor
Thread productor = new Thread(new Productor(colaTickets, 20));
Thread consumidor = new Thread(new Consumidor(colaTickets, reparadores));

// Ejecutar los hilos
productor.start();
consumidor.start();

```

## Conclusión

Este proyecto demuestra cómo gestionar tareas concurrentes con diferentes niveles de prioridad en Java utilizando herramientas avanzadas como PriorityBlockingQueue. Es una solución eficiente y escalable para escenarios donde la concurrencia y la priorización son esenciales.
