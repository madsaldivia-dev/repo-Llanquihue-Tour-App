# 🌋 Llanquihue Tour App

Aplicación desarrollada en **Java 23** para la gestión de tours turísticos de la zona de Llanquihue. El sistema permite cargar información desde un archivo de texto, listar los tours disponibles y realizar búsquedas por rango de precios.

## 📋 Descripción

El proyecto utiliza un archivo externo (`Tours.txt`) para almacenar los datos de los tours. Al ejecutar la aplicación, los datos son leídos y convertidos en objetos de la clase `Tour`.

Posteriormente, el sistema permite:

- Mostrar todos los tours registrados.
- Buscar tours dentro de un rango de precios definido.
- Validar datos durante la lectura del archivo.
- Manejar errores de lectura sin detener la ejecución del programa.

## 🧠 Conceptos aplicados

- **Programación Orientada a Objetos (POO)**.
- **Encapsulamiento** mediante atributos privados, getters y setters.
- **Colecciones** utilizando `ArrayList`.
- **Lectura de archivos** con `BufferedReader`.
- **Manejo de excepciones** mediante `try-catch`.
- **Validación de datos** antes de crear los objetos.
- **Separación por capas** utilizando los paquetes `ui`, `data` y `model`.

## 🗂️ Estructura del proyecto

```text
src/
├── ui/
│   └── Main.java
├── data/
│   └── GestorDatos.java
└── model/
    └── Tour.java

resources/
└── Tours.txt
```

## ✅ Funcionalidades

### Mostrar tours

La aplicación carga todos los tours almacenados en el archivo y los muestra por pantalla.

### Buscar tours por precio

Permite filtrar los tours según un rango de precios definido en el código.

Ejemplo:

```java
int precioMinimo = 10000;
int precioMaximo = 20000;
```

## ✅ Validaciones implementadas

Durante la lectura del archivo se realizan las siguientes validaciones:

| Validación | Acción |
|------------|---------|
| Línea vacía | Se omite |
| Cantidad incorrecta de campos | Se muestra mensaje y continúa la lectura |
| Precio no numérico | Se captura la excepción y continúa la lectura |
| Precio menor o igual a 0 | Se descarta el registro |

Estas validaciones permiten que una línea incorrecta no impida la carga de las demás líneas válidas.

## ⚠️ Manejo de excepciones

La aplicación utiliza:

- `IOException` para errores de lectura de archivos.
- `NumberFormatException` para errores de conversión del precio.

En ambos casos se muestra un mensaje descriptivo sin detener completamente la ejecución.

## 📄 Formato del archivo Tours.txt

El archivo debe contener una línea por cada tour utilizando el siguiente formato:

```text
Nombre;Tipo;Precio
```

Ejemplo:

```text
Tour Volcán Osorno;Aventura;15000
Lago Todos los Santos;Naturaleza;18000
Puerto Varas Histórico;Cultural;12000
```

## 🚀 Cómo ejecutar

### Requisitos

- JDK 23 o superior.
- IntelliJ IDEA.

### Pasos

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que exista el archivo `resources/Tours.txt`.
3. Ejecutar la clase `Main`.
4. Revisar la salida generada en la consola.

## 🖥️ Ejemplo de salida

```text
=== TODOS LOS TOURS ===

===== TOUR =====
Nombre: Tour Volcán Osorno
Tipo: Aventura
Precio: $15000
================

===== TOUR =====
Nombre: Puerto Varas Histórico
Tipo: Cultural
Precio: $12000
================

**********************************

=== TOURS ENTRE $10000 Y $20000 ===

===== TOUR =====
Nombre: Tour Volcán Osorno
Tipo: Aventura
Precio: $15000
================
```

## 👩‍💻 Autora

**Madeleine Alizet Vergara Saldivia**

Estudiante de Analista Programador Computacional.
Proyecto desarrollado para la asignatura de Programación Orientada a Objetos utilizando Java 23.
