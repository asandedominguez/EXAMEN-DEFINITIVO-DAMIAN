import java.util.Scanner;
import java.util.List;

/**
 * Clase que se encarga de mostrar la información en pantalla (Vista).
 * Crea un menú de texto en la consola para hablar con el usuario,
 * pedirle datos y enseñarle los resultados que calcula el controlador.
 * * @author Adrián Sande Domínguez
 * @version 6.9
 */
public class View {

    /**
     * Muestra el menú principal en la consola y lee las opciones del usuario.
     * Controla que el programa se repita hasta que se pida salir, evita que
     * se cierre por meter texto en vez de números y envía los datos al controlador.
     */
    public void mostrarMenu() {
        Controller controlador = new Controller();
        Scanner teclado = new Scanner(System.in);
        int opcionSeleccionada = 0;

        do {
            System.out.println("\n=== GESTIÓN DE PARKING ===");
            System.out.println("1. Agregar Coche");
            System.out.println("2. Quitar Coche");
            System.out.println("3. Avanzar Coche");
            System.out.println("4. Añadir velocidad");
            System.out.println("5. Mostrar velocidad del coche");
            System.out.println("6. Coches en el parking");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcionSeleccionada = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                opcionSeleccionada = 0;
            }

            switch (opcionSeleccionada) {
                case 1:
                    System.out.println("\n--- Agregar Coche ---");
                    System.out.print("Introduce el modelo: ");
                    String modeloCoche = teclado.nextLine();
                    System.out.print("Introduce la matricula: ");
                    String matriculaCoche = teclado.nextLine();

                    boolean registrado = controlador.registrarCoche(modeloCoche, matriculaCoche);
                    if (registrado) {
                        System.out.println("¡Coche aparcado con éxito!");
                    } else {
                        System.out.println("¡FALLO FATAL!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Quitar Coche ---");
                    System.out.print("Introduce la matrícula del coche para quitar: ");
                    String matriculaQuitar = teclado.nextLine();

                    Coche cocheQuitado = controlador.eliminarCoche(matriculaQuitar);
                    if (cocheQuitado != null) {
                        System.out.println("Éxito: El coche con matrícula " + matriculaQuitar + " ha sido retirado.");
                    } else {
                        System.out.println("Error: No se encontró ningún coche con la matrícula " + matriculaQuitar + " en el parking.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Avanzar Coche ---");
                    System.out.print("Introduce la matrícula: ");
                    String matriculaAvanzar = teclado.nextLine();

                    Coche cocheEnMarcha = controlador.actualizarKilometros(matriculaAvanzar);
                    if (cocheEnMarcha != null) {
                        System.out.println("¡Avanzado! Kilómetros actuales de: " + cocheEnMarcha.kilometros);
                    } else {
                        System.out.println("El coche con matrícula " + matriculaAvanzar + " no está en el parking.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Cambiar Velocidad ---");
                    System.out.print("Introduce la matrícula: ");
                    String matriculaVelocidad = teclado.nextLine();
                    System.out.print("Introduce la nueva velocidad: ");

                    Integer nuevaVelocidadInput = teclado.nextInt();
                    teclado.nextLine(); // Limpia el buffer

                    int velocidadNueva = controlador.modificarVelocidad(matriculaVelocidad, nuevaVelocidadInput);
                    if (velocidadNueva != -1) {
                        System.out.println(" Velocidad actualizada con éxito a: " + velocidadNueva + " km/h.");
                    } else {
                        System.out.println(" Error: No se encontró ningún coche con la matrícula " + matriculaVelocidad);
                    }
                    break;

                case 5:
                    System.out.println("\n--- Mostrar velocidad del coche ---");
                    System.out.print("Introduce la matrícula del coche: ");
                    String matriculaConsulta = teclado.nextLine();

                    int velocidadActual = controlador.obtenerVelocidad(matriculaConsulta);
                    System.out.println("Velocidad actual del coche: " + velocidadActual + " km/h.");
                    break;

                case 6:
                    System.out.println("\n--- Coches en el parking ---");
                    List<Coche> listaCoches = controlador.obtenerListaCoches();
                    if (listaCoches.isEmpty()) {
                        System.out.println("El parking está vacío.");
                    } else {
                        for (Coche ch : listaCoches) {
                            System.out.println("Modelo: " + ch.modelo + " | Matrícula: " + ch.matricula + " | Velocidad: " + ch.velocidad + " km/h" + " | Recorrido: " + ch.kilometros + " km");
                        }
                        System.out.println("----------------------------");
                    }
                    break;

                case 7:
                    System.out.println("\nSaliendo del programa... ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige un número del 1 al 7.");
                    break;
            }

        } while (opcionSeleccionada != 7);

        teclado.close();
    }
}