public class inverso {

    public static int invertir(int n, int invertido) {
        if (n == 0) {
            return invertido;
        }
        return invertir(n / 10, invertido * 10 + n % 10);
    }

    public static void main(String[] args) {
        int numero = 12345;
        int resultado = invertir(numero, 0);
        System.out.println("Número original: " + numero);
        System.out.println("Número invertido: " + resultado);
    }
}
