package es.guillearana.model;

import java.util.Objects;

/**
 * Clase que representa a una Persona con atributos como nombre, apellidos, edad e idPersona.
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    private int idPersona;

    /**
     * Retorna una representación en forma de cadena de la persona.
     *
     * @return una cadena con los valores de nombre, apellidos, edad y idPersona.
     */
    @Override
    public String toString() {
        return "Persona [nombre=" + this.nombre + ", apellidos=" + this.apellidos + ", edad=" + this.edad + ", idPersona=" + this.idPersona + "]";
    }

    /**
     * Genera un código hash basado en los atributos apellidos, edad y nombre.
     *
     * @return el código hash de la persona.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.apellidos, this.edad, this.nombre);
    }

    /**
     * Compara si dos objetos son iguales.
     * Dos personas son iguales si tienen el mismo nombre, apellidos y edad.
     *
     * @param obj el objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Persona other = (Persona) obj;
        return Objects.equals(this.apellidos, other.apellidos) && this.edad == other.edad && Objects.equals(this.nombre, other.nombre);
    }

    /**
     * Constructor que inicializa los atributos nombre, apellidos y edad.
     *
     * @param nombre     El nombre de la persona.
     * @param apellidos  Los apellidos de la persona.
     * @param edad       La edad de la persona.
     */
    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    /**
     * Constructor que inicializa los atributos idPersona, nombre, apellidos y edad.
     *
     * @param idPersona  El ID único de la persona.
     * @param nombre     El nombre de la persona.
     * @param apellidos  Los apellidos de la persona.
     * @param edad       La edad de la persona.
     */
    public Persona(int idPersona, String nombre, String apellidos, int edad) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    /**
     * Obtiene el ID de la persona.
     *
     * @return el ID de la persona.
     */
    public int getIdPersona() {
        return this.idPersona;
    }

    /**
     * Establece el ID de la persona.
     *
     * @param idPersona el nuevo ID de la persona.
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return el nombre de la persona.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre el nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos de la persona.
     *
     * @return los apellidos de la persona.
     */
    public String getApellidos() {
        return this.apellidos;
    }

    /**
     * Establece los apellidos de la persona.
     *
     * @param apellidos los nuevos apellidos de la persona.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return la edad de la persona.
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Establece la edad de la persona.
     *
     * @param edad la nueva edad de la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
