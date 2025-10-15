package Proyecto;



public class Carta {

  private final String palo;  
  private final String color;   
  private final String valor;   
  private final String nombre;  
  private final int numero;     


  public Carta(String palo, String valor, String nombre, int numero) {
    this.palo = palo;
    this.valor = valor;
    this.nombre = nombre;
    this.numero = numero;
    this.color = (palo.equals("♥") || palo.equals("♦")) ? "rojo" : "negro";
  }


  public String getPalo() {
    return palo;
  }

  public String getColor() {
    return color;
  }

  public String getValor() {
    return valor;
  }

  public String getNombre() {
    return nombre;
  }

  public int getNumero() {
    return numero;
  }

  // Representación textual (para consola o depuración)
  @Override
  public String toString() {
    return "[" + valor + "|" + palo + "] " + nombre + " (" + color + ")";
  }

  // Método de prueba individual
  public static void main(String[] args) {
    Carta carta = new Carta("♥", "A", "As", 1);
    System.out.println(carta);
  }
}