package Proyecto;

import java.util.ArrayList;
import java.util.List;

public class Juego {

  
    private List<Carta> caja = new ArrayList<>();

    public Juego() {
        inicializarBaraja();
    }


    private void inicializarBaraja() {
        String[] palos = {"♥", "♦", "♠", "♣"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] nombres = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Jota", "Quina", "Ka"};
        
        for (String palo : palos) {
            
            for (int i = 0; i < valores.length; i++) {
                String valor = valores[i];
                String nombre = nombres[i];
                int numero = i + 1; 
                Carta carta = new Carta(palo, valor, nombre, numero);
                caja.add(carta); 
            }
        }
    }

    public List<Carta> getCaja() {
        return caja;
    }
}
