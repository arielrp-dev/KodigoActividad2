package com.Kodigo.algoritmos;

public class OrdenamientoSeleccion {

    /**
     * Ordena un arreglo utilizando el algoritmo de ordenamiento por selección.
     *
     * @param arreglo El arreglo que se desea ordenar.
     */
    public static void ordenar(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            // Encuentra el índice del mínimo elemento en el subarreglo sin ordenar
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[minIndex]) {
                    minIndex = j;
                }
            }
            // Intercambia el elemento mínimo encontrado con el primer elemento del subarreglo sin ordenar
            int temp = arreglo[minIndex];
            arreglo[minIndex] = arreglo[i];
            arreglo[i] = temp;
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