package CP1.Recursividad;

public class Numbers {

    private static final double N = 25.0; 

    // No se modifica el metodo. La formula es la implementacion directa.
    // Referencia: https://en.wikipedia.org/wiki/Metallic_mean
    public static double formula(double z) {
        return new Numbers().round((z + Math.sqrt(4 + Math.pow(z, 2))) / 2);
    }

    public static double recursive(double z) {
        // IMPROVEMENT: Calculo de la razon f(z, 25) / f(z, 24)
        // Referencia: https://en.wikipedia.org/wiki/Metallic_mean (Aplicacion de limite)
        return new Numbers().round(fRecursive((int)z, (int)N) / fRecursive((int)z, (int)N - 1));
    }

    public static double iterative(double z) {
        // UPDATE: Calculo de la razon usando la funcion auxiliar iterativa
        // Referencia: https://en.wikipedia.org/wiki/Metallic_mean (Aplicacion de limite)
        return new Numbers().round(fIterative((int)z, (int)N) / fIterative((int)z, (int)N - 1));
    }

    // ERROR & IMPROVEMENT: Funcion auxiliar recursiva.
    // ERROR corregido: Caso base f(z, 0) y f(z, 1) deben retornar 1, no z.
    // IMPROVEMENT: Uso de tipo long para evitar overflow numerico.
    // Referencia: https://en.wikipedia.org/wiki/Metallic_mean (Definicion de la sucesion)
    private static double fRecursive(int z, int n) {
        return (double)fRecursiveLong(z, n);
    }

    private static long fRecursiveLong(int z, int n) {
        if (n <= 1) { 
            return 1L; // Correccion del caso base
        }
        // f(z, n) = z * f(z, n - 1) + f(z, n - 2)
        return (long) z * fRecursiveLong(z, n - 1) + fRecursiveLong(z, n - 2);
    }

    // UPDATE: Implementacion iterativa de la sucesion f(z, n).
    // Referencia: Algoritmo de sucesion de Fibonacci implementado iterativamente. https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
    private static double fIterative(int z, int n) {
        if (n <= 1) return 1.0; 

        long fn_minus_2 = 1; // f(z, 0)
        long fn_minus_1 = 1; // f(z, 1)
        long current_fn = 0;

        for (int i = 2; i <= n; i++) {
            current_fn = (long) z * fn_minus_1 + fn_minus_2;
            
            fn_minus_2 = fn_minus_1;
            fn_minus_1 = current_fn;
        }

        return (double)current_fn;
    }

    private double round(double value) {
        var ROUND = 10000000000.0;
        return Math.round(value * ROUND) / ROUND;
    }

    public static void main(String[] args) {
        String[] metallics = {
                "Platinum", // [0]
                "Golden", // [1]
                "Silver", // [2]
                "Bronze", // [3]
                "Copper", // [4]
                "Nickel", // [5]
                "Aluminum", // [6]
                "Iron", // [7]
                "Tin", // [8]
                "Lead", // [9]
        };
        for (var z = 0; z < metallics.length; z++) {
            System.out.println("\n[" + z + "] " + metallics[z]);
            System.out.println(" ↳ formula(" + z + ")   ≈ " + formula(z));
            System.out.println(" ↳ recursive(" + z + ") ≈ " + recursive(z));
            System.out.println(" ↳ iterative(" + z + ") ≈ " + iterative(z));
        }
    }
}