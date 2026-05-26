import java.util.Scanner;
import java.util.List;

/**
 * Clase que se encarga de mostrar la información en pantalla (Vista).
 * Crea un menú de texto en la consola para hablar con el usuario,
 * pedirle datos y enseñarle los resultados que calcula el controlador.
 *
 * @author Adrián Sande Domínguez
 * @version 7.1
 */
public class View {

    /**
     * Muestra el menú principal en la consola y lee las opciones del usuario.
     */
    public void mostrarMenu() {

        Controller controlador = new Controller();

        Scanner teclado = new Scanner(System.in);

        int opcionSeleccionada = 0;

        do {

            System.out.println("\n   GESTIÓN DE PARKING ");
            System.out.println("1. Añadir Coche");
            System.out.println("2. Quitar Coche");
            System.out.println("3. Avanzar coche (metros)");
            System.out.println("4. Añadir velocidad");
            System.out.println("5. Mostrar velocidad");
            System.out.println("6. Lista de coches en el parking");
            System.out.println("7. Cargar gasolina");
            System.out.println("8. Salir");

            System.out.print("Seleccione una opción: ");

            try {

                opcionSeleccionada =
                        Integer.parseInt(teclado.nextLine());

            } catch (NumberFormatException e) {

                opcionSeleccionada = 0;
            }

            switch (opcionSeleccionada) {

                case 1:

                    System.out.println("\n--- Agregar Coche ---");

                    System.out.print("Añade el modelo: ");
                    String modeloCoche = teclado.nextLine();

                    System.out.print("Añade la matricula: ");
                    String matriculaCoche = teclado.nextLine();

                    boolean registrado =
                            controlador.registrarCoche(
                                    modeloCoche,
                                    matriculaCoche
                            );

                    if (registrado) {

                        System.out.println(
                                "¡Coche aparcado con éxito!"
                        );

                    } else {

                        System.out.println("¡Error!");
                    }

                    break;

                case 2:

                    System.out.println("\n--- Quitar Coche ---");

                    System.out.print(
                            "Introduce la matrícula del coche: "
                    );

                    String matriculaQuitar =
                            teclado.nextLine();

                    Coche cocheQuitado =
                            controlador.eliminarCoche(
                                    matriculaQuitar
                            );

                    if (cocheQuitado != null) {

                        System.out.println(
                                "El coche con matrícula "
                                        + matriculaQuitar
                                        + " ha sido retirado."
                        );

                    } else {

                        System.out.println(
                                "Error: No se encontró ningún coche."
                        );
                    }

                    break;

                case 3:

                    System.out.println("\n--- Avanzar Coche ---");

                    System.out.print("Introduce la matrícula: ");

                    String matriculaAvanzar =
                            teclado.nextLine();

                    System.out.print(
                            "Introduce los metros a avanzar: "
                    );

                    double metros =
                            Double.parseDouble(
                                    teclado.nextLine()
                            );

                    Coche cocheAvanzado =
                            controlador.avanzarMetros(
                                    matriculaAvanzar,
                                    metros
                            );

                    if (cocheAvanzado != null) {

                        System.out.println(
                                "Metros recorridos: "
                                        + cocheAvanzado.metros
                        );

                        System.out.println(
                                "Kilómetros recorridos: "
                                        + cocheAvanzado.kilometros
                        );

                        System.out.println(
                                "Gasolina que queda: "
                                        + cocheAvanzado.gasolina
                                        + " litros"
                        );

                    } else {

                        System.out.println(
                                "El coche no está en el parking."
                        );
                    }

                    break;

                case 4:

                    System.out.println("\n--- Cambiar Velocidad ---");

                    System.out.print("Introduce la matrícula: ");

                    String matriculaVelocidad =
                            teclado.nextLine();

                    System.out.print(
                            "Introduce la nueva velocidad: "
                    );

                    Integer nuevaVelocidadInput =
                            Integer.parseInt(
                                    teclado.nextLine()
                            );

                    int velocidadNueva =
                            controlador.modificarVelocidad(
                                    matriculaVelocidad,
                                    nuevaVelocidadInput
                            );

                    if (velocidadNueva != -1) {

                        System.out.println(
                                "Velocidad actualizada: "
                                        + velocidadNueva
                                        + " km/h."
                        );

                    } else {

                        System.out.println(
                                "No se encontró ningún coche."
                        );
                    }

                    break;

                case 5:

                    System.out.println(
                            "\n--- Mostrar velocidad del coche ---"
                    );

                    System.out.print(
                            "Introduce la matrícula del coche: "
                    );

                    String matriculaConsulta =
                            teclado.nextLine();

                    int velocidadActual =
                            controlador.obtenerVelocidad(
                                    matriculaConsulta
                            );

                    if (velocidadActual != -1) {

                        System.out.println(
                                "Velocidad actual del coche: "
                                        + velocidadActual
                                        + " km/h."
                        );

                    } else {

                        System.out.println(
                                "Coche no encontrado."
                        );
                    }

                    break;

                case 6:

                    System.out.println(
                            "\n--- Coches en el parking ---"
                    );

                    List<Coche> listaCoches =
                            controlador.obtenerListaCoches();

                    if (listaCoches.isEmpty()) {

                        System.out.println(
                                "El parking está vacío."
                        );

                    } else {

                        for (Coche ch : listaCoches) {

                            System.out.println(
                                    "Modelo: " + ch.modelo
                                            + " | Matrícula: "
                                            + ch.matricula
                                            + " | Velocidad: "
                                            + ch.velocidad
                                            + " km/h"
                                            + " | Recorrido: "
                                            + ch.kilometros
                                            + " km"
                                            + " | Gasolina: "
                                            + ch.gasolina
                                            + " litros"
                            );
                        }

                        System.out.println(
                                "----------------------------"
                        );
                    }

                    break;

                case 7:

                    System.out.println(
                            "\n--- Cargar gasolina ---"
                    );

                    System.out.print(
                            "Introducir matrícula: "
                    );

                    String matriculaGasolina =
                            teclado.nextLine();

                    System.out.print(
                            "Introduce litros a cargar: "
                    );

                    double litros =
                            Double.parseDouble(
                                    teclado.nextLine()
                            );

                    Coche cocheGasolina =
                            controlador.cargarGasolina(
                                    matriculaGasolina,
                                    litros
                            );

                    if (cocheGasolina != null) {

                        System.out.println(
                                "Gasolina actual: "
                                        + cocheGasolina.gasolina
                                        + " l"
                        );

                    } else {

                        System.out.println(
                                "Coche no encontrado."
                        );
                    }

                    break;

                case 8:

                    System.out.println(
                            "\nSaliendo del programa..."
                    );

                    break;

                default:

                    System.out.println(
                            "No válida."
                    );

                    break;
            }

        } while (opcionSeleccionada != 8);

        teclado.close();
    }
}