import java.util.ArrayList;
import java.util.List;

/**
 * Clase que guarda y gestiona los datos de la aplicación.
 * Funciona como una lista en memoria para controlar los coches del parking.
 *
 * @author Adrián Sande Domínguez
 * @version 7.1
 */
public class Model {

    /** Lista donde se guardan todos los coches que están en el parking. */
    static ArrayList<Coche> listaParking = new ArrayList<>();

    /**
     * Crea un coche nuevo y lo mete en la lista del parking.
     *
     * @param modelo Marca o modelo del coche.
     * @param matricula Matrícula única del coche.
     * @return El objeto coche que se acaba de crear.
     */
    public Coche crearCoche(String modelo, String matricula) {

        Coche aux = new Coche(modelo, matricula);

        listaParking.add(aux);

        return aux;
    }

    /**
     * Busca un coche en el parking usando su matrícula.
     *
     * @param matricula La matrícula del coche a buscar.
     * @return El coche encontrado, o null si no existe.
     */
    public Coche obtenerCoche(String matricula) {

        Coche aux = null;

        for (Coche e : listaParking) {

            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }

        return aux;
    }

    /**
     * Saca un coche del parking si se encuentra su matrícula.
     *
     * @param matricula La matrícula del coche que se va a quitar.
     * @return El coche que se ha quitado, o null si no estaba en la lista.
     */
    public Coche quitarCoche(String matricula) {

        Coche cocheEncontrado = obtenerCoche(matricula);

        if (cocheEncontrado != null) {

            listaParking.remove(cocheEncontrado);

            return cocheEncontrado;
        }

        return null;
    }

    /**
     * Cambia la velocidad de un coche que ya está registrado.
     *
     * @param matricula La matrícula del coche.
     * @param v La nueva velocidad que va a tener.
     * @return La velocidad final del coche tras el cambio.
     * @throws NullPointerException Si el coche no existe en la lista.
     */
    public int cambiarVelocidad(String matricula, Integer v) {

        Coche coche = obtenerCoche(matricula);

        if (coche != null) {

            coche.velocidad = v;

            return coche.velocidad;
        }

        return -1;
    }

    /**
     * Suma metros recorridos al contador del coche y descuenta gasolina.
     *
     * @param matricula La matrícula del coche que avanza.
     * @param metrosAvanzados Metros recorridos.
     * @return El coche actualizado, o null si no existe.
     */
    public Coche avanzarMetros(String matricula, double metrosAvanzados) {

        Coche aux = obtenerCoche(matricula);

        if (aux != null) {

            aux.metros += metrosAvanzados;

            aux.kilometros = (int) (aux.metros / 1000);

            // Consumo simple basado en la velocidad
            aux.gasolina -= (aux.velocidad * 0.01);

            if (aux.gasolina < 0) {
                aux.gasolina = 0;
            }
        }

        return aux;
    }

    /**
     * Añade litros de gasolina al coche.
     *
     * @param matricula La matrícula del coche.
     * @param litros Litros de gasolina a cargar.
     * @return El coche actualizado, o null si no existe.
     */
    public Coche cargarGasolina(String matricula, double litros) {

        Coche aux = obtenerCoche(matricula);

        if (aux != null) {

            aux.gasolina += litros;
        }

        return aux;
    }

    /**
     * Mira a qué velocidad va un coche según su matrícula.
     *
     * @param matricula La matrícula del coche a consultar.
     * @return La velocidad actual en km/h.
     * @throws NullPointerException Si el coche no existe en la lista.
     */
    public int obtenerVelocidad(String matricula) {

        Coche coche = obtenerCoche(matricula);

        if (coche != null) {
            return coche.velocidad;
        }

        return -1;
    }

    /**
     * Devuelve la lista completa con todos los coches del parking.
     *
     * @return Una lista que contiene todos los coches guardados.
     */
    public List<Coche> obtenerListaParking() {

        return listaParking;
    }
}