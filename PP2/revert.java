package PP2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class revert {

    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) {
        Pila_PP2 charStack = new Pila_PP2();

        try {
            readAndPushToStack(charStack);
            System.out.println("Archivo '" + INPUT_FILE + "' leído y pila llenada.");
            
            writeReversedFile(charStack);
            System.out.println("Contenido invertido escrito en '" + OUTPUT_FILE + "'.");

        } catch (IOException e) {
            System.err.println("Error de I/O: " + e.getMessage());
        }
    }

    private static void readAndPushToStack(Pila_PP2 stack) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
            int charCode;
            while ((charCode = reader.read()) != -1) {
                stack.push((char) charCode);
            }
        }
    }

    private static void writeReversedFile(Pila_PP2 stack) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            while (!stack.Empty()) {
                Character character = stack.pop();
                if (character != null) { 
                    writer.write(character);
                }
            }
        }
    }
}