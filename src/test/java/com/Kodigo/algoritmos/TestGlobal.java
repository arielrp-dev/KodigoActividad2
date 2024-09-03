package com.Kodigo.algoritmos;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestGlobal {

    private static final int[] TAMANIOS = {100, 1000, 10000}; // Tamaños de los arreglos para el benchmark
    private static final int RANGO = 10000;       // Rango máximo de los valores aleatorios
    private static final int ITERACIONES = 1000; // Número de veces que se ejecutará cada algoritmo
    public static void main(String[] args) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Resultados Benchmark");

        int filaIndex = 0;
        Row header = sheet.createRow(filaIndex++);
        header.createCell(0).setCellValue("Algoritmo");
        header.createCell(1).setCellValue("Tamaño");
        header.createCell(2).setCellValue("Tiempo (ns)");

        long inicio;
        long fin;

        // Ejecutar benchmarks para cada tamaño de arreglo
        for (int tamano : TAMANIOS) {
            long tiempoBurbuja = 0;
            long tiempoInsercion = 0;
            long tiempoSeleccion = 0;
            long tiempoBusquedaSecuencial = 0;
            long tiempoBusquedaBinaria = 0;
            for (int i = 1; i <= ITERACIONES; i++) {
                // Generar un arreglo aleatorio
                int[] arreglo = AlgoritmoUtils.generarArregloAleatorio(tamano, RANGO);

                // Benchmark Ordenamiento Burbuja
                int[] arregloBurbuja = Arrays.copyOf(arreglo, arreglo.length);
                inicio = System.nanoTime();
                OrdenamientoBurbuja.ordenar(arregloBurbuja);
                fin = System.nanoTime();
                tiempoBurbuja += (fin - inicio);

                // Benchmark Ordenamiento Inserción
                int[] arregloInsercion = Arrays.copyOf(arreglo, arreglo.length);
                inicio = System.nanoTime();
                OrdenamientoInsercion.ordenar(arregloInsercion);
                fin = System.nanoTime();
                tiempoInsercion += (fin - inicio);

                // Benchmark Ordenamiento Selección
                int[] arregloSeleccion = Arrays.copyOf(arreglo, arreglo.length);
                inicio = System.nanoTime();
                OrdenamientoSeleccion.ordenar(arregloSeleccion);
                fin = System.nanoTime();
                tiempoSeleccion += (fin - inicio); // Convertir de nanosegundos a milisegundos

                // Generar un objetivo aleatorio
                int objetivo = arreglo[(int) (Math.random() * arreglo.length)];

                // Benchmark Búsqueda Secuencial
                inicio = System.nanoTime();
                BusquedaSecuencial.buscar(arreglo, objetivo);
                fin = System.nanoTime();
                tiempoBusquedaSecuencial += (fin - inicio);

                // Benchmark Búsqueda Binaria
                AlgoritmoUtils.ordenarArreglo(arreglo); // Asegúrate de que el arreglo esté ordenado
                inicio = System.nanoTime();
                BusquedaBinaria.buscar(arreglo, objetivo);
                fin = System.nanoTime();
                tiempoBusquedaBinaria += (fin - inicio); // Convertir de nanosegundos a milisegundos
            }

            tiempoBurbuja = tiempoBurbuja / (ITERACIONES);    // Promedio de tiempo de ejecución
            agregarResultado(sheet, filaIndex++, "Ordenamiento Burbuja", tamano, tiempoBurbuja);

            tiempoInsercion = tiempoInsercion / (ITERACIONES); // Promedio de tiempo de ejecución
            agregarResultado(sheet, filaIndex++, "Ordenamiento Inserción", tamano, tiempoInsercion);

            tiempoSeleccion = tiempoSeleccion / (ITERACIONES); // Promedio de tiempo de ejecución
            agregarResultado(sheet, filaIndex++, "Ordenamiento Selección", tamano, tiempoSeleccion);

            tiempoBusquedaSecuencial = tiempoBusquedaSecuencial / (ITERACIONES);    // Promedio de tiempo de ejecución
            agregarResultado(sheet, filaIndex++, "Búsqueda Secuencial", tamano, tiempoBusquedaSecuencial);

            tiempoBusquedaBinaria = tiempoBusquedaBinaria / (ITERACIONES);  // Promedio de tiempo de ejecución
            agregarResultado(sheet, filaIndex++, "Búsqueda Binaria", tamano, tiempoBusquedaBinaria);
        }

        // Guardar el archivo de Excel
        try (FileOutputStream fileOut = new FileOutputStream("benchmark_resultados.xlsx")) {
            workbook.write(fileOut);
        }
        workbook.close();
        System.out.println("Resultados guardados en 'benchmark_resultados.xlsx'");
    }

    private static void agregarResultado(Sheet sheet, int filaIndex, String algoritmo, int tamano, long tiempo) {
        Row fila = sheet.createRow(filaIndex);
        fila.createCell(0).setCellValue(algoritmo);
        fila.createCell(1).setCellValue(tamano);
        fila.createCell(2).setCellValue(tiempo);
    }
}
