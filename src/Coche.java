/**
 * Representa un vehículo  de tipo Coche.
 * Permite gestionar la información básica de dicho vehiculo: Modelo,
 * matrícula, velocidad y kilometraje.
 * * @author Adrián Sande Domínguez
 * @version 6.9
 */
public class Coche {
    /** matrícula */
    public String matricula;
    /** modelo */
    public String modelo;
    /** velocidad  */
    public Integer velocidad;
    /** kilometraje */
    public int kilometros;
    /**
     * Instancia del coche con sus datos iniciales.
     * Inicia con velocidad 0 y sin recorrido.
     * * @param modelo El modelo del vehículo.
     * @param matricula La matrícula del vehículo.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.kilometros = 0;
    }
}