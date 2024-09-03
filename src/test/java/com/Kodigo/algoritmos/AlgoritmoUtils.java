package com.Kodigo.algoritmos;

import java.util.Random;

public class AlgoritmoUtils {

    /**
     * Genera un arreglo de enteros con valores aleatorios.
     *
     * @param size El tamaño del arreglo.
     * @param rango El rango máximo de los valores aleatorios (0 a rango - 1).
     * @return El arreglo generado con valores aleatorios.
     */
    public static int[] generarArregloAleatorio(int size, int rango) {  // Cambio de nombre de la variable
        Random random = new Random();
        int[] arreglo = new int[size];
        for (int i = 0; i < size; i++) {
            arreglo[i] = random.nextInt(rango);
        }
        return arreglo;
    }

    /**
     * Imprime los elementos del arreglo.
     *
     * @param arreglo El arreglo que se desea imprimir.
     */
    public static void imprimirArreglo(int[] arreglo) {
        for (int valor : arreglo) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    /**
     * Verifica si un arreglo está ordenado en orden ascendente.
     *
     * @param arreglo El arreglo que se desea verificar.
     * @return true si el arreglo está ordenado, false en caso contrario.
     */
    public static boolean estaOrdenado(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i - 1] > arreglo[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Ordena un arreglo utilizando el algoritmo de ordenamiento burbuja.
     *
     * @param arreglo El arreglo que se desea ordenar.
     */
    public static void ordenarArreglo(int[] arreglo) {
        int n = arreglo.length;
        boolean intercambiado;

        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambia arreglo[j] y arreglo[j + 1]
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    intercambiado = true;
                }
            }
            // Si no hubo intercambios en la pasada, el arreglo ya está ordenado
            if (!intercambiado) {
                break;
            }
        }
    }
}