import java.util.List;

/**
 * Clase que actúa como Controlador del programa.
 * Gestiona el flujo de datos entre la interfaz y el modelo.
 *
 * @author Adrián Sande Domínguez
 * @version 7.1
 */
public class Controller {

    /** Instancia global para gestionar la interfaz del menú. */
    static View vistaMenu = new View();

    /** Instancia del modelo que sirve para guardar los datos de los coches en memoria. */
    Model baseDatos = new Model();

    /**
     * Punto de partida por donde arranca la aplicación.
     * Inicia el menú principal en la pantalla del usuario.
     *
     * @param args Parámetros de la terminal (actualmente sin uso).
     */
    public static void main(String[] args) {

        vistaMenu.mostrarMenu();
    }

    /**
     * Ordena al almacén dar de alta un vehículo nuevo y comprueba si quedó registrado.
     *
     * @param modelo La marca del automóvil.
     * @param matricula La placa del automóvil.
     * @return Retorna true si el proceso se completó con éxito.
     */
    public boolean registrarCoche(String modelo, String matricula) {

        Coche nuevo = baseDatos.crearCoche(modelo, matricula);

        return nuevo == baseDatos.obtenerCoche(matricula);
    }

    /**
     * Procesa la solicitud de la pantalla para dar de baja un automóvil.
     *
     * @param matricula La placa enviada desde la sección visual.
     * @return El coche eliminado o null si no existe.
     */
    public Coche eliminarCoche(String matricula) {

        return baseDatos.quitarCoche(matricula);
    }

    /**
     * Solicita al almacén modificar el velocímetro de un vehículo.
     *
     * @param matricula La placa del vehículo.
     * @param nuevaVelocidad Nueva velocidad.
     * @return Velocidad final.
     */
    public int modificarVelocidad(String matricula, Integer nuevaVelocidad) {

        return baseDatos.cambiarVelocidad(matricula, nuevaVelocidad);
    }

    /**
     * Consulta la velocidad actual de un vehículo.
     *
     * @param matricula Matrícula del vehículo.
     * @return Velocidad actual.
     */
    public int obtenerVelocidad(String matricula) {

        return baseDatos.obtenerVelocidad(matricula);
    }

    /**
     * Ordena avanzar el coche una cantidad de metros.
     *
     * @param matricula Matrícula del coche.
     * @param metros Metros recorridos.
     * @return El coche actualizado.
     */
    public Coche avanzarMetros(String matricula, double metros) {

        return baseDatos.avanzarMetros(matricula, metros);
    }

    /**
     * Ordena cargar gasolina a un coche.
     *
     * @param matricula Matrícula del coche.
     * @param litros Litros a cargar.
     * @return El coche actualizado.
     */
    public Coche cargarGasolina(String matricula, double litros) {

        return baseDatos.cargarGasolina(matricula, litros);
    }

    /**
     * Trae la colección completa de automóviles del parking.
     *
     * @return Lista completa de coches.
     */
    public List<Coche> obtenerListaCoches() {

        return baseDatos.obtenerListaParking();
    }
}