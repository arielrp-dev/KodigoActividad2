package com.Kodigo.algoritmos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BusquedaBinariaTest {

    @Test
    public void testBusquedaBinariaEncontrarElemento() {
        int[] arreglo = {64, 34, 25, 12, 22, 11, 90};
        AlgoritmoUtils.ordenarArreglo(arreglo); // Asegúrate de que el arreglo esté ordenado
        int objetivo = 25;
        int resultado = BusquedaBinaria.buscar(arreglo, objetivo);
        assertEquals(2, resultado, "El índice del valor 25 debe ser 2.");
    }

    @Test
    public void testBusquedaBinariaElementoNoEncontrado() {
        int[] arreglo = {64, 34, 25, 12, 22, 11, 90};
        AlgoritmoUtils.ordenarArreglo(arreglo); // Asegúrate de que el arreglo esté ordenado
        int objetivo = 23;
        int resultado = BusquedaBinaria.buscar(arreglo, objetivo);
        assertEquals(-1, resultado, "El valor 23 no debe encontrarse en el arreglo.");
    }

    @Test
    public void testBusquedaBinariaArregloVacio() {
        int[] arreglo = {};
        int objetivo = 1;
        int resultado = BusquedaBinaria.buscar(arreglo, objetivo);
        assertEquals(-1, resultado, "El valor en un arreglo vacío debe retornar -1.");
    }

    @Test
    public void testBusquedaBinariaArregloConUnElemento() {
        int[] arreglo = {1};
        int objetivo = 1;
        int resultado = BusquedaBinaria.buscar(arreglo, objetivo);
        assertEquals(0, resultado, "El valor 1 debe encontrarse en el índice 0.");

        objetivo = 2;
        resultado = BusquedaBinaria.buscar(arreglo, objetivo);
        assertEquals(-1, resultado, "El valor 2 no debe encontrarse en el arreglo.");
    }
}