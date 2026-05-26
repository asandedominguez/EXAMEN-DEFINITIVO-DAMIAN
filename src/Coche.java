/**
 * Representa un vehículo de tipo Coche.
 * Permite gestionar la información básica del vehículo.
 *
 * @author Adrián Sande Domínguez
 * @version 7.1
 */
public class Coche {

    /** matrícula */
    public String matricula;

    /** modelo */
    public String modelo;

    /** velocidad */
    public Integer velocidad;

    /** kilometraje */
    public int kilometros;

    /** metros recorridos */
    public double metros;

    /** litros de gasolina */
    public double gasolina;

    /**
     * Constructor del coche.
     *
     * @param modelo Modelo del coche.
     * @param matricula Matrícula del coche.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.kilometros = 0;
        this.metros = 0.0;
        this.gasolina = 50.0;
    }
}