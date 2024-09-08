package AppTrabajadores;  

import java.util.ArrayList;  
import java.util.InputMismatchException;  
import java.util.Scanner;  

public class Menu {  

    private ArrayList<Empleado> empleados;  
    private Scanner scanner;  

    public Menu() {  
        empleados = new ArrayList<>();  
        scanner = new Scanner(System.in);  
    }  

    public static void main(String[] args) {  
        Menu menu = new Menu();  
        menu.iniciar();  
    }  

    public void iniciar() {  
        int opcion = 0;  
        do {  
            System.out.println("Bienvenido al menú de Empleados");  
            mostrarMenu();  
            try {  
                opcion = scanner.nextInt();  
                scanner.nextLine(); // Limpiar el buffer  
                manejarOpcion(opcion);  
            } catch (InputMismatchException e) {  
                System.out.println("Entrada no válida. Por favor, ingresa un número.");  
                scanner.nextLine(); // Limpiar el buffer  
            }  
        } while (opcion != 0);  
        System.out.println("Adios");  
    }  

    private void mostrarMenu() {  
        System.out.println("1.- Agregar Empleado");  
        System.out.println("2.- Buscar Empleado");  
        System.out.println("3.- Eliminar Empleado");  
        System.out.println("4.- Listar Empleados");  
        System.out.println("5.- Calculo incentivo");  
        System.out.println("6.- Resumen de pago");  
        System.out.println("0.- Salir");  
    }  

    private void manejarOpcion(int opcion) {  
        switch (opcion) {  
            case 1:  
                agregarEmpleado();  
                break;  
            case 2:  
                buscarEmpleado();  
                break;  
            case 3:  
                eliminarEmpleado();  
                break;  
            case 4:  
                listarEmpleados();  
                break;  
            case 5:  
                calcularIncentivo();  
                break;  
            case 6:  
                mostrarIncentivo();  
                break;  
            case 0:  
                // Salir, ya se maneja en el bucle  
                break;  
            default:  
                System.out.println("Opción no válida, por favor intenta de nuevo.");  
        }  
    }  

    private void agregarEmpleado() {  
        System.out.println("Ingrese rut del empleado: ");  
        String rut = scanner.nextLine();  

        System.out.println("Ingrese el nombre del empleado (mayor a 5 letras): ");  
        String nombre = scanner.nextLine();  
        while (nombre.length() < 5) {  
            System.out.println("Nombre debe ser mayor a 5 letras. Ingrese nuevamente: ");  
            nombre = scanner.nextLine();  
        }  

        System.out.println("Ingrese el apellido del empleado: ");  
        String apellido = scanner.nextLine();  

        System.out.println("Ingrese sexo como (M - (Masculino) / F - (Femenino)): ");  
        char sexo = scanner.nextLine().toUpperCase().charAt(0);  

        System.out.println("Ingrese edad del empleado: ");  
        int edad = scanner.nextInt();  
        while (edad <= 18 || edad > 70) {  
            System.out.println("El empleado debe tener entre 19 y 70 años. Ingrese nuevamente: ");  
            edad = scanner.nextInt();  
        }  

        System.out.println("Ingrese sueldo base del empleado: ");  
        int sueldoBase = scanner.nextInt();  

        System.out.println("Ingrese cantidad de hijos: ");  
        int cantHijos = scanner.nextInt();  

        // Crear el empleado y agregarlo  
        Empleado nuevoEmpleado = new Empleado(rut, nombre, apellido, sexo, edad, sueldoBase, cantHijos);  
        empleados.add(nuevoEmpleado);  
        System.out.println("Empleado agregado exitosamente.");  
    }  

    private void buscarEmpleado() {  
        System.out.println("Ingrese rut a buscar:");  
        String rut = scanner.nextLine();  
        // Lógica para buscar al empleado  
    }  

    private void eliminarEmpleado() {  
        System.out.println("Ingrese rut para eliminar:");  
        String rut = scanner.nextLine();  
        // Lógica para eliminar el empleado  
    }  

    private void listarEmpleados() {  
        System.out.println("Lista de empleados:");  
        for (Empleado empleado : empleados) {  
            System.out.println(empleado); // Asegúrate de que la clase Empleado tenga un método toString  
        }  
    }  

    private void calcularIncentivo() {
        System.out.println("Cálculo de incentivo:");
        for (Empleado e : empleados) {
            int incentivo = e.calcularIncentivo();
            System.out.println("Empleado: " + e.getNombre() + " " + e.getApellido() + " - Incentivo: " + incentivo);
        }
    }
 

    private void mostrarIncentivo() {  
        // Lógica para mostrar el incentivo  
    }  
}