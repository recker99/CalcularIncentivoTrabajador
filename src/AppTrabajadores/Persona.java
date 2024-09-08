/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppTrabajadores;  

/**  
 * Clase que representa a una persona.  
 * Contiene atributos básicos como rut, nombre, apellido, sexo y edad.  
 * Proporciona métodos para acceder y modificar estos atributos.  
 *   
 * @author Casa  
 */  
public class Persona {  
    // Atributos de la clase Persona  
    private String rut;      // RUT de la persona  
    private String nombre;   // Nombre de la persona  
    private String apellido; // Apellido de la persona  
    private char sexo;      // Sexo de la persona (M/F)  
    private int edad;       // Edad de la persona  

    // Constructor sin parámetros  
    public Persona() {  
    }  

    // Constructor con parámetros  
    public Persona(String rut, String nombre, String apellido, char sexo, int edad) {  
        this.rut = rut;  
        this.nombre = nombre;  
        this.apellido = apellido;  
        this.sexo = sexo;  
        this.edad = edad;  
    }  

    // Métodos getter y setter  
    public String getRut() {  
        return rut;  
    }  

    public void setRut(String rut) {  
        this.rut = rut;  
    }  

    public String getNombre() {  
        return nombre;  
    }  

    public void setNombre(String nombre) {  
        this.nombre = nombre;  
    }  

    public String getApellido() {  
        return apellido;  
    }  

    public void setApellido(String apellido) {  
        this.apellido = apellido;  
    }  

    public char getSexo() {  
        return sexo;  
    }  

    public void setSexo(char sexo) {  
        this.sexo = sexo;  
    }  

    public int getEdad() {  
        return edad;  
    }  

    public void setEdad(int edad) {  
        if (edad < 0) {  
            throw new IllegalArgumentException("La edad no puede ser negativa.");  
        }  
        this.edad = edad;  
    }  

    @Override  
    public String toString() {  
        return "Persona{" +  
                "rut='" + rut + '\'' +  
                ", nombre='" + nombre + '\'' +  
                ", apellido='" + apellido + '\'' +  
                ", sexo=" + sexo +  
                ", edad=" + edad +  
                '}';  
    }  
}