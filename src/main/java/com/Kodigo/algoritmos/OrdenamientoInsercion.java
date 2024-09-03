package com.Kodigo.algoritmos;

public class OrdenamientoInsercion {

    /**
     * Ordena un arreglo utilizando el algoritmo de ordenamiento por inserción.
     *
     * @param arreglo El arreglo que se desea ordenar.
     */
    public static void ordenar(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            int clave = arreglo[i];
            int j = i - 1;

            // Mueve los elementos del arreglo que son mayores que clave a una posición adelante
            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = clave;
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] datos = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Arreglo original:");
        AlgoritmoUtils.imprimirArreglo(datos);

        ordenar(datos);

        System.out.println("Arreglo ordenado:");
        AlgoritmoUtils.imprimirArreglo(datos);
    }
}
