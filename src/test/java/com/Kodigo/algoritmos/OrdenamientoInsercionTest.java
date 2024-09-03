package com.Kodigo.algoritmos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OrdenamientoInsercionTest {

    @Test
    public void testOrdenamientoInsercion() {
        int[] arreglo = {64, 34, 25, 12, 22, 11, 90};
        int[] esperado = {11, 12, 22, 25, 34, 64, 90};
        OrdenamientoInsercion.ordenar(arreglo);
        assertArrayEquals(esperado, arreglo, "El arreglo no está correctamente ordenado.");
    }

    @Test
    public void testOrdenamientoInsercionArregloVacio() {
        int[] arreglo = {};
        int[] esperado = {};
        OrdenamientoInsercion.ordenar(arreglo);
        assertArrayEquals(esperado, arreglo, "El arreglo vacío debe permanecer vacío.");
    }

    @Test
    public void testOrdenamientoInsercionArregloConUnElemento() {
        int[] arreglo = {1};
        int[] esperado = {1};
        OrdenamientoInsercion.ordenar(arreglo);
        assertArrayEquals(esperado, arreglo, "El arreglo con un solo elemento debe permanecer igual.");
    }

    @Test
    public void testOrdenamientoInsercionArregloOrdenado() {
        int[] arreglo = {1, 2, 3, 4, 5};
        int[] esperado = {1, 2, 3, 4, 5};
        OrdenamientoInsercion.ordenar(arreglo);
        assertArrayEquals(esperado, arreglo, "El arreglo ya ordenado debe permanecer igual.");
    }
}