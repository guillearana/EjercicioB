package es.guillearana.model;

import java.util.Objects;

public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    private int idPersona;

    public String toString() {
        return "Persona [nombre=" + this.nombre + ", apellidos=" + this.apellidos + ", edad=" + this.edad + ", idPersona=" + this.idPersona + "]";
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.apellidos, this.edad, this.nombre});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Persona other = (Persona)obj;
            return Objects.equals(this.apellidos, other.apellidos) && this.edad == other.edad && Objects.equals(this.nombre, other.nombre);
        }
    }

    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Persona(int idPersona, String nombre, String apellidos, int edad) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public int getIdPersona() {
        return this.idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}