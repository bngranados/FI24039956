# Practica Programada 2 (PP2) - Inversion de Archivo con Pila (Stack)

## Datos Personales
| **Nombre:** Brenda Nazaret Granados Ramirez |

| **Carnet:**  FI24039956 |

---

## Recursos y Soporte Utilizado

### Paginas Web y Documentacion

Para el desarrollo de la practica programada 2 se utilizaron los recursos brindados por el profesor en su repositorio PP2, asi como la documentacion oficial de Java SE 21.

* **Documentacion oficial de Java (Oracle/OpenJDK):** Se consulto la API de `java.io` (para `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`) y la documentacion de `java.util.ArrayList` para la implementacion de la pila propia.
* [Enlace de apoyo de la documentacion de Character](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html)
* [Enlace de apoyo de la documentacion de Stack](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Stack.html)
* [Enlace de apoyo para BufferedReader (Java 8, el concepto es similar en 21)](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html)
* [Enlace de apoyo para FileReader (Java 8, el concepto es similar en 21)](https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html)
* [Enlace de apoyo para BufferedWriter](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/BufferedWriter.html)
* [Enlace de apoyo para FileWriter](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/FileWriter.html)

## IDE Utilizado
- Visual Studio Code en **Java SE 21 & JDK 21**

---

## Preguntas de Analisis

### 1. ¿Cree que exista otra forma de efectuar la inversion del contenido de un archivo sin necesidad de usar una pila? Si si, indique como (sin necesidad de codigo).

Si, existen al menos dos formas comunes de invertir el contenido de un archivo sin usar explicitamente la estructura de pila (`Stack`):

1.  **Usando una Lista (ArrayList o LinkedList):** Se puede leer el archivo caracter por caracter y almacenar todo el contenido en un `ArrayList<Character>`. Una vez que la lista esta completa, se recorre la lista **de atras hacia adelante** (desde el indice `size() - 1` hasta el indice `0`) y se escribe cada caracter en el archivo de salida. El `ArrayList` simula el almacenamiento, y el bucle inverso simula la operacion LIFO de la pila.

2.  **Usando la Recursividad (Llamadas a Funciones):** El proceso de lectura y escritura se puede envolver en una funcion recursiva.
    * La funcion lee un caracter.
    * Si hay mas caracteres, se llama a si misma (la llamada recursiva se apila).
    * Cuando la funcion alcanza el final del archivo (caso base), comienza a **retornar** a las llamadas anteriores.
    * En el paso de **retorno** (cuando la llamada se desapila), la funcion escribe el caracter leido. Esto naturalmente invierte el orden de lectura y escritura.

---

### 2. ¿En que ejemplo de la vida real (no informatico) se puede ver reflejado el uso de una pila?

El ejemplo mas claro de la vida real que refleja el uso de una pila (LIFO: Last-In, First-Out) es una **pila de platos** en una cafeteria o la cocina.

* **Push (Apilar):** Cuando se lava un plato y se coloca en la cima de la pila. (El ultimo plato que entra).
* **Pop (Desapilar):** Cuando una persona toma un plato para usarlo, siempre toma el que esta en la cima. (El ultimo plato que entro es el primero en salir).

**Analisis:** Los platos que se colocaron primero quedan abajo y son los ultimos en ser usados, mientras que el plato que se coloco mas recientemente es el que esta disponible de inmediato.


