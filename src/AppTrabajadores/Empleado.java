package AppTrabajadores;  

import java.util.ArrayList;  

/**  
 * Clase que representa a un empleado, extendiendo de la clase Persona.  
 * Proporciona métodos para agregar, buscar, eliminar, listar empleados y calcular incentivos.  
 *   
 */  
public class Empleado extends Persona {  
    private int sueldoBase;  
    private int cantHijos;  
    private final int incentivo1 = 10; // porcentaje fijo de incentivo  
    private final int incentivo2 = 18;  
    private final int incentivo3 = 20;  
    private final int incentivo4 = 25;  
    private ArrayList<Empleado> listaEmpleados;  

    public Empleado() {  
        super();  
        listaEmpleados = new ArrayList<>();  
    }  

    public Empleado(String rut, String nombre, String apellido, char sexo, int edad, int sueldoBase, int cantHijos) {  
        super(rut, nombre, apellido, sexo, edad);  
        this.sueldoBase = sueldoBase;  
        this.cantHijos = cantHijos;  
        listaEmpleados = new ArrayList<>(); // Iniciar la lista aquí  
    }  

    // Métodos getters y setters  
    public int getSueldoBase() {  
        return sueldoBase;  
    }  

    public void setSueldoBase(int sueldoBase) {  
        this.sueldoBase = sueldoBase;  
    }  

    public int getCantHijos() {  
        return cantHijos;  
    }  

    public void setCantHijos(int cantHijos) {  
        this.cantHijos = cantHijos;  
    }  

    // Métodos de operación sobre empleados  
    public String agregarEmpleado(String rut, String nombre, String apellido, char sexo, int edad, int sueldoBase, int cantHijos) {  
        Empleado nuevoEmpleado = new Empleado(rut, nombre, apellido, sexo, edad, sueldoBase, cantHijos);  
        listaEmpleados.add(nuevoEmpleado);  
        return "Ingreso Exitoso";  
    }  

    public String buscarEmpleado(String rutb) {  
        for (Empleado e : listaEmpleados) {  
            if (e.getRut().equals(rutb)) {  
                return detallesEmpleado(e);  
            }  
        }  
        return "RUT incorrecto o empleado no encontrado.";  
    }  

    public String eliminarEmpleado(String rut) {  
        boolean eliminado = listaEmpleados.removeIf(e -> e.getRut().equals(rut));  
        return eliminado ? "Empleado eliminado." : "No se encontró el empleado.";  
    }  

    public String listarEmpleados() {  
        StringBuilder sb = new StringBuilder();  
        for (Empleado e : listaEmpleados) {  
            sb.append(detallesEmpleado(e)).append("\n");  
        }  
        return sb.length() > 0 ? sb.toString() : "No hay empleados registrados.";  
    }  

    private String detallesEmpleado(Empleado e) {  
        return String.format("Datos del Empleado:\n" +  
                "-----------------------------------------\n" +  
                "Rut: %s\nNombre: %s\nApellido: %s\nSexo: %s\nEdad: %d\nSueldo Base: %d\nCantidad Hijos: %d\n",  
                e.getRut(), e.getNombre(), e.getApellido(), e.getSexo(), e.getEdad(), e.getSueldoBase(), e.getCantHijos());  
    }  

    public void mostrarIncentivo() {  
        System.out.println("#########################################");  
        System.out.println("INFORME DEL EMPLEADO");  
        
        for (Empleado e : listaEmpleados) {  
            System.out.println("#########################################");  
            imprimirDetallesEmpleado(e);  
            calcularIncentivo();  
            System.out.println("####### FIN DATOS EMPLEADO ######");  
        }  
    }  

    private void imprimirDetallesEmpleado(Empleado e) {  
        System.out.println("Rut: " + e.getRut());  
        System.out.println("Nombre: " + e.getNombre());  
        System.out.println("Apellido: " + e.getApellido());  
        System.out.println("Sexo: " + e.getSexo());  
        System.out.println("Edad: " + e.getEdad());  
        System.out.println("Cantidad Hijos: " + e.getCantHijos());  
    }  

       public int calcularIncentivo() {
        double porcentaje = 0;

        if (getSueldoBase() >= 300000) {
            if (getSexo() == 'M' && getEdad() > 45) {
                if (getCantHijos() > 0) {
                    porcentaje = 18;
                }
            } else if (getSexo() == 'F' && getEdad() > 40) {
                if (getCantHijos() == 0) {
                    porcentaje = 10;
                } else if (getCantHijos() > 0 && getCantHijos() <= 3) {
                    porcentaje = 20;
                } else if (getCantHijos() > 3) {
                    porcentaje = 25;
                }
            }
        }
        return (int) (getSueldoBase() * porcentaje / 100);
    }
}


