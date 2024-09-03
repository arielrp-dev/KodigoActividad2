package com.Kodigo.algoritmos;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestGlobal {

    private static final int[] TAMANIOS = {100, 500, 1000, 5000, 10000}; // Tamaños de los arreglos para el benchmark
    private static final int RANGO = 1000;       // Rango máximo de los valores aleatorios
    private static final int ITERACIONES = 100; // Número de veces que se ejecutará cada algoritmo
    public static void main(String[] args) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Resultados Benchmark");

        int filaIndex = 0;
        Row header = sheet.createRow(filaIndex++);
        header.createCell(0).setCellValue("Algoritmo");
        header.createCell(1).setCellValue("Tamaño");
        header.createCell(2).setCellValue("Tiempo (ms)");

        long inicio;
        long fin;

        // Ejecutar benchmarks para cada tamaño de arreglo
        for (int tamano : TAMANIOS) {

            // Generar un arreglo aleatorio
            int[] arreglo = AlgoritmoUtils.generarArregloAleatorio(tamano, RANGO);

            // Benchmark Ordenamiento Burbuja
            long tiempoBurbuja = 0;
            for (int i = 1; i < ITERACIONES; i++) {
                arreglo = AlgoritmoUtils.generarArregloAleatorio(tamano, RANGO);
                int[] arregloBurbuja = Arrays.copyOf(arreglo, arreglo.length);
                inicio = System.nanoTime();
                OrdenamientoBurbuja.ordenar(arregloBurbuja);
                fin = System.nanoTime();
                tiempoBurbuja += (fin - inicio);
            }

            tiempoBurbuja = tiempoBurbuja / ITERACIONES;    // Promedio de tiempo de ejecución
            agregarResultado(sheet, filaIndex++, "Ordenamiento Burbuja", tamano, tiempoBurbuja);

            // Benchmark Ordenamiento Inserción
            long tiempoInsercion = 0;
            for (int i = 1; i < ITERACIONES; i++) {
                arreglo = AlgoritmoUtils.generarArregloAleatorio(tamano, RANGO);
                int[] arregloInsercion = Arrays.copyOf(arreglo, arreglo.length);
                inicio = System.nanoTime();
                OrdenamientoInsercion.ordenar(arregloInsercion);
                fin = System.nanoTime();
                tiempoInsercion += (fin - inicio);
            }

            tiempoInsercion = tiempoInsercion / ITERACIONES; // Convertir de nanosegundos a milisegundos
            agregarResultado(sheet, filaIndex++, "Ordenamiento Inserción", tamano, tiempoInsercion);

            long tiempoSelecion = 0;
            for (int i = 1; i < ITERACIONES; i++) {

            }
            // Benchmark Ordenamiento Selección
            int[] arregloSeleccion = Arrays.copyOf(arreglo, arreglo.length);
            inicio = System.nanoTime();
            OrdenamientoSeleccion.ordenar(arregloSeleccion);
            fin = System.nanoTime();
            long tiempoSeleccion = (fin - inicio) / 1_000_000; // Convertir de nanosegundos a milisegundos
            agregarResultado(sheet, filaIndex++, "Ordenamiento Selección", tamano, tiempoSeleccion);

            // Benchmark Búsqueda Secuencial
            int objetivo = arreglo[(int) (Math.random() * arreglo.length)];
            inicio = System.nanoTime();
            BusquedaSecuencial.buscar(arreglo, objetivo);
            fin = System.nanoTime();
            long tiempoBusquedaSecuencial = (fin - inicio) / 1_000_000; // Convertir de nanosegundos a milisegundos
            agregarResultado(sheet, filaIndex++, "Búsqueda Secuencial", tamano, tiempoBusquedaSecuencial);

            // Benchmark Búsqueda Binaria
            AlgoritmoUtils.ordenarArreglo(arreglo); // Asegúrate de que el arreglo esté ordenado
            inicio = System.nanoTime();
            BusquedaBinaria.buscar(arreglo, objetivo);
            fin = System.nanoTime();
            long tiempoBusquedaBinaria = (fin - inicio) / 1_000_000; // Convertir de nanosegundos a milisegundos
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
