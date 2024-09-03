package com.Kodigo.algoritmos;

public class OrdenamientoBurbuja {

    /**
     * Ordena un arreglo utilizando el algoritmo de ordenamiento burbuja.
     *
     * @param arreglo El arreglo que se desea ordenar.
     */
    public static void ordenar(int[] arreglo) {
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