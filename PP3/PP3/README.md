# PP3 – Lista Circular Doblemente Enlazada

## Datos Personales
| **Nombre:** Brenda Nazaret Granados Ramírez |
|---------------------------------------------|
| **Carnét:** FI24039956 |

---

## IDE Utilizado
- Visual Studio Code  
- Java SE 21 & JDK 21

---

## Páginas Consultadas
* **Documentación oficial de Java sobre listas enlazadas:**
    * https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
    * https://www.geeksforgeeks.org/java/linked-list-in-java/
    * https://www.w3schools.com/java/java_linkedlist.asp
* **Explicación conceptual sobre listas circulares:**
    * https://www.geeksforgeeks.org/dsa/introduction-to-circular-doubly-linked-list/
    * https://medium.com/@chetanshingare2991/mastering-linked-lists-doubly-circular-and-doubly-circular-implementations-in-kotlin-16e77a7ecaa3
    * https://www.wscubetech.com/resources/dsa/circular-doubly-linked-list

---

## Prompts de Chatbot de IA Utilizados  
* Debido a que se me ha complicado bastante el curso, pregunté directamente para el desarrollo de la lógica para este tipo de listas y tambien para mejorar mi entendimiento hacia la materia dada.
[https://gemini.google.com/app/322a13d8a21f3487?hl=es]

---

## Respuestas Personales

### 1. Si tuviera que implementar una estructura tipo Cola (Queue), ¿qué tipo de lista utilizaría y por qué? ¿Y para una Pila (Stack)?

Para una **Cola (Queue)** utilizaría una **Lista Simplemente Enlazada que mantenga una referencia al nodo final (`tail`)**.
* **Razón:** La **Cola** opera bajo el principio **FIFO** (First-In, First-Out). Al tener la referencia `tail`, tanto la eliminación del inicio (`head`) como la inserción en el final (`tail`) se realizan en un tiempo constante (**O(1)**). Esta es la implementación más ligera y eficiente para una cola.

Para una **Pila (Stack)** también utilizaría una **Lista Simplemente Enlazada**.
* **Razón:** El comportamiento **LIFO** (Last-In, First-Out) solo necesita que las operaciones de insertar y eliminar se realicen en el mismo extremo (la cabeza). Una lista simplemente enlazada es suficiente, ya que ambas operaciones en la cabeza son inherentemente rápidas (**O(1)**) y no requiere punteros dobles ni circularidad.

---

### 2. Ventaja y desventaja de usar una lista creada por usted mismo en vez de las que ofrece Java

**Ventaja:**
Se tiene **control total** sobre el funcionamiento interno, lo que permite **adaptar la estructura a necesidades específicas** (como la lista circular doblemente enlazada) y **optimizarla** para casos de uso concretos. También fomenta un entendimiento profundo de los fundamentos de las estructuras de datos.

**Desventaja:**
Es más **propenso a errores (bugs)** en la gestión de punteros, requiere más tiempo de desarrollo y pruebas, y es **menos eficiente** que las implementaciones altamente optimizadas, probadas y mantenidas del Java Collections Framework (como `java.util.LinkedList`). Además, no se integra automáticamente con el ecosistema de Java (ej., la Stream API).