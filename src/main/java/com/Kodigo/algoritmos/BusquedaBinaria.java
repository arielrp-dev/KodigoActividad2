package com.Kodigo.algoritmos;

public class BusquedaBinaria {

    /**
     * Realiza una búsqueda binaria en un arreglo ordenado.
     *
     * @param arreglo El arreglo en el que se realiza la búsqueda. Debe estar ordenado.
     * @param objetivo El valor que se está buscando en el arreglo.
     * @return El índice del valor en el arreglo, o -1 si no se encuentra.
     */
    public static int buscar(int[] arreglo, int objetivo) {
        // Verifica si el arreglo está ordenado
        if (!AlgoritmoUtils.estaOrdenado(arreglo)) {
            throw new IllegalArgumentException("El arreglo debe estar ordenado para realizar la búsqueda binaria.");
        }

        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arreglo[medio] == objetivo) {
                return medio; // Retorna el índice donde se encontró el valor
            }

            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1; // Busca en la mitad derecha
            } else {
                derecha = medio - 1; // Busca en la mitad izquierda
            }
        }

        return -1; // Retorna -1 si el valor no se encuentra en el arreglo
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] datos = {1, 3, 5, 7, 9, 11};
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