import java.lang.module.ModuleDescriptor;
import java.util.List;

/**
 * Clase que actúa como Controlador del programa.
 * Gestiona el flujo de datos entre la interfaz y el modelo.
 * * @author Adrián Sande Domínguez
 * @version 6.9
 */
public class Controller {

    /** Instancia global para gestionar la interfaz del menú. */
    static View vistaMenu = new View();

    /** Instancia del modelo que sirve para guardar los datos de los coches en memoria. */
    Model baseDatos = new Model();

    /**
     * Punto de partida por donde arranca la aplicación.
     * Inicia el menú principal en la pantalla del usuario.
     * * @param args Parámetros de la terminal (actualmente sin uso).
     */
    public static void main(String[] args) {
        vistaMenu.mostrarMenu();
    }

    /**
     * Ordena al almacén dar de alta un vehículo nuevo y comprueba si quedó registrado.
     * * @param modelo La marca del automóvil.
     * @param matricula La placa del automóvil.
     * @return Retorna true si el proceso se completó con éxito;
     * Retorna el valor false en caso de haber fallado.
     */
    public boolean registrarCoche(String modelo, String matricula){
        Coche nuevo = baseDatos.crearCoche(modelo, matricula);
        if (nuevo == baseDatos.obtenerCoche(matricula)) {
            return true;
        }
        return false;
    }

    /**
     * Procesa la solicitud de la pantalla para dar de baja un automóvil del parking mediante su placa.
     * * @param matricula La placa enviada desde la sección visual.
     * @return Los datos del objeto Coche que se ha borrado para decidir qué notificar,
     * o un valor nulo si el automóvil no está en el sistema.
     */
    public Coche eliminarCoche(String matricula) {
        Coche cocheQuitado = baseDatos.quitarCoche(matricula);
        return cocheQuitado;
    }

    /**
     * Procesa la solicitud de la pantalla para simular el desplazamiento en kilómetros de un automóvil.
     * * @param matricula La placa del automóvil que se va a poner en movimiento.
     * @return El objeto Coche con sus valores actualizados, o un valor nulo si no se localiza.
     */
    public Coche actualizarKilometros(String matricula) {
        Coche cocheActualizado = baseDatos.hacerAvanzarCoche(matricula);
        return cocheActualizado;
    }

    /**
     * Solicita al almacén de datos modificar el velocímetro de un vehículo.
     * * @param matricula La placa del vehículo que se quiere modificar.
     * @param nuevaVelocidad El nuevo valor que registrará el velocímetro.
     * @return El ritmo de circulación final.
     * @throws NullPointerException En caso de introducir una placa que no pertenezca a ningún vehículo guardado.
     */
    public int modificarVelocidad(String matricula, Integer nuevaVelocidad) {
        int velocidadResultante = baseDatos.cambiarVelocidad(matricula, nuevaVelocidad);
        return velocidadResultante;
    }

    /**
     * Consulta en el almacén de datos el ritmo de circulación de un vehículo.
     * * @param matricula La placa del vehículo.
     * @return El ritmo actual de circulación expresado en kilómetros por hora.
     * @throws NullPointerException En caso de introducir una placa que no pertenezca a ningún vehículo guardado.
     */
    public int obtenerVelocidad(String matricula) {
        return baseDatos.obtenerVelocidad(matricula);
    }

    /**
     * Trae la colección completa de automóviles que están dentro del estacionamiento desde el modelo.
     * * @return Una colección tipo List que agrupa todos los elementos Coche del estacionamiento.
     */
    public List<Coche> obtenerListaCoches() {
        return baseDatos.obtenerListaParking();
    }
}