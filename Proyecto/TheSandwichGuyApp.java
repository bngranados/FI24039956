package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TheSandwichGuyApp extends JFrame {

    private Juego juego;
    private JTextArea cajaArea;

    public TheSandwichGuyApp() {
        // 1. Inicializar el modelo (llama a Juego y crea las 52 cartas)
        juego = new Juego();

        // Configuración básica de la ventana
        setTitle("The Sandwich Guy - Avance 1 (Boceto)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLayout(new BorderLayout(15, 15)); 

        // 2. Panel Principal para las Estructuras de Datos
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(2, 2, 20, 20)); // Grid 2x2 para las 4 secciones
        
        // Crear y agregar las cuatro secciones requeridas como boceto:
        
        // a) CAJA (Muestra las 52 cartas de juego.getCaja())
        cajaArea = setupSection(gamePanel, "Caja (Lista Doble - Baraja Completa)", juego.getCaja());
        
        // b) MAZO (Boceto)
        setupSection(gamePanel, "Mazo (Pila de Cartas)", null);
        
        // c) MANO (Boceto)
        setupSection(gamePanel, "Mano (Lista Circular - 8 cartas máx.)", null);
        
        // d) POZO (Boceto)
        setupSection(gamePanel, "Pozo (Cola de Cartas)", null);

        add(gamePanel, BorderLayout.CENTER);

        // 3. Panel de Opciones (Botones de boceto)
        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        optionsPanel.add(new JButton("Barajar y Repartir")); 
        optionsPanel.add(new JButton("Ordenar Mano"));
        optionsPanel.add(new JButton("Validar Sándwich"));
        optionsPanel.add(new JButton("Guardar Partida"));
        optionsPanel.add(new JButton("Cargar Partida"));
        add(optionsPanel, BorderLayout.SOUTH);

        // Ajustar y mostrar la ventana
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Método auxiliar para crear un panel de sección y mostrar cartas.
     */
    private JTextArea setupSection(JPanel parent, String title, List<Carta> cartas) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title)); 

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Si la lista de cartas no es nula (es decir, es la CAJA), muestra el contenido
        if (cartas != null) {
            for (Carta carta : cartas) {
                textArea.append(carta.toString() + "\n");
            }
            textArea.setCaretPosition(0); // Scroll al inicio
        } else {
            // Mensaje de boceto para las secciones Mazo, Mano y Pozo
            textArea.setText("Esta sección estará vacía o se llenará con la partida.\n"
                           + "Contenido: [ ]");
        }
        
        panel.add(scrollPane, BorderLayout.CENTER);
        parent.add(panel);
        return textArea;
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación
        SwingUtilities.invokeLater(() -> new TheSandwichGuyApp());
    }
}