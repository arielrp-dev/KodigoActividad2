package com.Kodigo.algoritmos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BusquedaSecuencialTest {

    @Test
    public void testBusquedaSecuencialEncontrarElemento() {
        int[] arreglo = {64, 34, 25, 12, 22, 11, 90};
        int objetivo = 22;
        int resultado = BusquedaSecuencial.buscar(arreglo, objetivo);
        assertEquals(4, resultado, "El índice del valor 22 debe ser 4.");
    }

    @Test
    public void testBusquedaSecuencialElementoNoEncontrado() {
        int[] arreglo = {64, 34, 25, 12, 22, 11, 90};
        int objetivo = 100;
        int resultado = BusquedaSecuencial.buscar(arreglo, objetivo);
        assertEquals(-1, resultado, "El valor 100 no debe encontrarse en el arreglo.");
    }

    @Test
    public void testBusquedaSecuencialArregloVacio() {
        int[] arreglo = {};
        int objetivo = 1;
        int resultado = BusquedaSecuencial.buscar(arreglo, objetivo);
        assertEquals(-1, resultado, "El valor en un arreglo vacío debe retornar -1.");
    }

    @Test
    public void testBusquedaSecuencialArregloConUnElemento() {
        int[] arreglo = {1};
        int objetivo = 1;
        int resultado = BusquedaSecuencial.buscar(arreglo, objetivo);
        assertEquals(0, resultado, "El valor 1 debe encontrarse en el índice 0.");

        objetivo = 2;
        resultado = BusquedaSecuencial.buscar(arreglo, objetivo);
        assertEquals(-1, resultado, "El valor 2 no debe encontrarse en el arreglo.");
    }
}