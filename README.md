# KodigoActividad2

# Implementación y Análisis de Algoritmos de Búsqueda y Ordenamiento en Java

## Descripción del Proyecto

Este proyecto consiste en la implementación de varios algoritmos de búsqueda y ordenamiento en Java, así como en el análisis de su complejidad y rendimiento. Los algoritmos implementados incluyen búsqueda secuencial, búsqueda binaria, ordenamiento burbuja, ordenamiento por inserción y ordenamiento por selección. Además, se realizan pruebas de rendimiento y se generan reportes en un archivo Excel para comparar los diferentes algoritmos.

## Estructura del Proyecto

El proyecto está organizado utilizando Apache Maven para gestionar las dependencias y la estructura del proyecto. A continuación se muestra la estructura de archivos y directorios:

/KodigoActividad2
│
├── pom.xml
│
├── /src
│   ├── /main
│   │   ├── /java
│   │   │   └── /com
│   │   │       └── /kodigo
│   │   │           └── /algoritmos
│   │   │               ├── BusquedaSecuencial.java
│   │   │               ├── BusquedaBinaria.java
│   │   │               ├── OrdenamientoBurbuja.java
│   │   │               ├── OrdenamientoInsercion.java
│   │   │               ├── OrdenamientoSeleccion.java
│   │   │               └── AlgoritmoUtils.java
│   │   │
│   │   └── /resources
│   │       └── log4j2.xml
│   │
│   └── /test
│       ├── /java
│       │   └── /com
│       │       └── /kodigo
│       │           └── /algoritmos
│       │               ├── AlgoritmoUtils.java
│       │               ├── BusquedaSecuencialTest.java
│       │               ├── BusquedaBinariaTest.java
│       │               ├── OrdenamientoBurbujaTest.java
│       │               ├── OrdenamientoInsercionTest.java
│       │               ├── OrdenamientoSeleccionTest.java
│       │               └── TestGlobal.java
│       │
│       └── /resources
│           └── benchmark_data.xlsx
│
└── /docs
    ├── README.md
    └── Reporte.md


## Algoritmos Implementados

1. **Búsqueda Secuencial**: Algoritmo que recorre secuencialmente una lista para encontrar un elemento.
2. **Búsqueda Binaria**: Algoritmo eficiente para encontrar un elemento en una lista ordenada, dividiendo repetidamente el espacio de búsqueda a la mitad.
3. **Ordenamiento Burbuja**: Algoritmo de ordenamiento simple que compara pares de elementos adyacentes y los intercambia si están en el orden incorrecto.
4. **Ordenamiento por Inserción**: Algoritmo de ordenamiento que construye la lista ordenada elemento a elemento.
5. **Ordenamiento por Selección**: Algoritmo de ordenamiento que divide la lista en dos partes: la parte ordenada y la parte desordenada, y selecciona repetidamente el elemento mínimo de la parte desordenada.

## Instrucciones para Ejecutar el Proyecto

### Prerrequisitos

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [Apache Maven 3.6+](https://maven.apache.org/download.cgi)

### Compilación y Ejecución

1. Clona este repositorio:

    ```bash
    git clone https://github.com/tuusuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. Compila el proyecto utilizando Maven:

    ```bash
    mvn clean install
    ```

3. Ejecuta el archivo `TestGlobal.java` para realizar las pruebas de rendimiento y generar el archivo Excel con los resultados:

    ```bash
    mvn exec:java -Dexec.mainClass="com.tuempresa.algoritmos.TestGlobal"
    ```

### Pruebas

Para ejecutar las pruebas unitarias, usa el siguiente comando:

```bash
mvn test
```

### Resultados
Los resultados del benchmark se almacenan en el archivo benchmark_resultados.xlsx. Este archivo contiene los tiempos de ejecución de cada algoritmo para diferentes tamaños de datos, lo que permite comparar su rendimiento.
