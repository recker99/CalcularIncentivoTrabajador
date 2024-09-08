package PruebasUnitarias;  

import AppTrabajadores.Empleado;  
import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import static org.junit.Assert.*;  

public class calcularIncentivoJUnitTest {  

    public calcularIncentivoJUnitTest() {  
    }  

    @Before  
    public void setUp() {  
        // Configuración inicial si es necesaria  
    }  

    @After  
    public void tearDown() {  
        // Limpieza después de cada prueba si es necesaria  
    }  

    @Test  
    public void testCalcularIncentivoMasculinoConHijos() {  
        Empleado e = new Empleado("12345678-9", "Juan", "Pérez", 'M', 50, 350000, 2);  
        int expectedIncentivo = (int) (e.getSueldoBase() * 18 / 100); // 18% de incentivo  
        assertEquals(expectedIncentivo, e.calcularIncentivo());  
    }  

    @Test  
    public void testCalcularIncentivoFemeninoSinHijos() {  
        Empleado e = new Empleado("98765432-1", "Ana", "Gómez", 'F', 45, 320000, 0);  
        int expectedIncentivo = (int) (e.getSueldoBase() * 10 / 100); // 10% de incentivo  
        assertEquals(expectedIncentivo, e.calcularIncentivo());  
    }  

    @Test
    public void testCalcularIncentivoFemeninoConHijos() {
        Empleado e = new Empleado("12345678-9", "Ana", "Perez", 'F', 45, 350000, 2);
        int incentivo = e.calcularIncentivo();
        assertEquals(70000, incentivo); // 20% de 350000
    }


   @Test
    public void testCalcularIncentivoFemeninoConMuchosHijos() {
        Empleado e = new Empleado("55667788-9", "Laura", "Martínez", 'F', 45, 500000, 4);
        int incentivo = e.calcularIncentivo();
        assertEquals(125000, incentivo); // 25% de 500000
    }


    @Test  
    public void testCalcularIncentivoSinIncentivo() {  
        Empleado e = new Empleado("99887766-5", "Pedro", "Ramírez", 'M', 35, 250000, 1);  
        int expectedIncentivo = 0; // 0% de incentivo  
        assertEquals(expectedIncentivo, e.calcularIncentivo());  
    }  

    
}