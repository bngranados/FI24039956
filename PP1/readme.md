#  Documentacion de Practica

## Informacion Personal

* **Nombre:** Nazareth Granados
* **Carnet:** FI24039956

---

##  Fuentes y Recursos

A continuacion, se listan paginas web y *snippets* de codigo consultados para la practica:

### Snippets de Codigo
1. [VS Code Snippets: Autocomplete Tips](https://medium.com/@dimterion/vs-code-snippets-autocomplete-tips-3434e7bf519f)
2. [Dudas WP: Code Snippets](https://www.dudaswp.com/code-snippets/)
3. [Stack Overflow: Busqueda de Code Snippets](https://stackoverflow.com/search?q=code+snippets&s=f537855b-f030-4354-bf10-955ae635e534)

### Aprendizaje de Markdown
* [Gemini: Uso de Markdown](https://gemini.google.com/app/e815c6a27bd3d510?hl=es)

---

##  Preguntas de Analisis

### 1. ¿Es posible implementar una solucion equivalente pero de comportamiento iterativo?

**Respuesta:** Si. Cualquier solucion **recursiva** puede ser implementada de manera **iterativa**. Esto se logra utilizando **bucles** (`while` o `for`) y **variables auxiliares** que simulan el estado de la recursion.

---

### 2. ¿Cree que hay alguna otra manera recursiva de generar el mismo resultado?

**Respuesta:** Si. Se pueden emplear **variantes recursivas** como:

* **Pasar parametros acumulativos:** Utilizando un argumento adicional en la funcion que almacena el resultado parcial.
* **Recursion de cola (Tail Recursion):** Una forma que, en algunos lenguajes o compiladores, puede ser optimizada para ejecutarse de manera tan eficiente como una solucion iterativa.

---

### 3. ¿Que relacion observa entre el algoritmo para invertir un numero natural (calculando y utilizando los cocientes y residuos de las divisiones) con las estrategias para pasar de una base numerica a otra?

**Respuesta:** Ambos procesos comparten la **misma estrategia fundamental**: la **extraccion de digitos mediante divisiones sucesivas**.

* **Invertir un numero:** Se usa el **residuo** ($\%$) para obtener el **digito menos significativo** y el **cociente** ($/$) para reducir el numero.
* **Cambio de base:** Se utiliza el **residuo** ($\%$) de la division por la nueva base para obtener los **digitos** de la representacion, y el **cociente** ($/$) para la siguiente iteracion.

La relacion clave es que las operaciones de **modulo** y **division entera** son la base para "descomponer" un numero en sus componentes posicionales.