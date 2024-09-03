package com.Kodigo.algoritmos;

public class BusquedaSecuencial {

    /**
     * Realiza una búsqueda secuencial en un arreglo.
     *
     * @param arreglo El arreglo en el que se realiza la búsqueda.
     * @param objetivo El valor que se está buscando en el arreglo.
     * @return El índice del valor en el arreglo, o -1 si no se encuentra.
     */
    public static int buscar(int[] arreglo, int objetivo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == objetivo) {
                return i; // Retorna el índice donde se encontró el valor
            }
        }
        return -1; // Retorna -1 si el valor no se encuentra en el arreglo
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] datos = {3, 5, 7, 9, 11};
        int objetivo = 7;

        // Imprime el arreglo
        System.out.println("Arreglo:");
        AlgoritmoUtils.imprimirArreglo(datos);

        int resultado = buscar(datos, objetivo);

        if (resultado != -1) {
            System.out.println("El valor " + objetivo + " se encontró en el índice " + resultado);
        } else {
            System.out.println("El valor " + objetivo + " no se encontró en el arreglo.");
        }
    }
}
