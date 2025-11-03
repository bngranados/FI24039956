package CP1.Colas;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random; // ERROR: Se debe importar para usar Random!

public class TheQueue<Type> implements TheQueueInterface<Type> {

    private Deque<Type> _queue;

    public TheQueue() {
        _queue = new ArrayDeque<Type>();
    }

    public void enqueue(Type item) {
        _queue.add(item);
    }

    // IMPROVEMENT: Retorna y quita, o null si esta vacia. NO USA CONDICIONALES.
    // Referencia: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Deque.html#poll()
    public Type dequeue() {
        return _queue.poll(); 
    }

    // IMPROVEMENT: Retorna sin quitar, o null si esta vacia. NO USA CONDICIONALES.
    // Referencia: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Deque.html#peek()
    public Type getFront() {
        return _queue.peek(); 
    }

    public boolean isEmpty() {
        return _queue.isEmpty();
    }

    public int getSize() {
        return _queue.size();
    }

// UPDATE: Implementa la logica para vaciar la cola y formar codones de tres nucleotidos cada uno.
// Referencia: Logica de vaciado secuencial de cola, implementando la formacion de codon. https://stackoverflow.com/questions/22067713/how-to-remove-the-first-n-elements-from-a-queue-in-java

public String[] getCodons() {
        int numCodons = _queue.size() / 3;
        String[] codons = new String[numCodons];
        
        // Vacia la cola para formar los codones
        for (int i = 0; i < numCodons; i++) {
            // Llama a dequeue() tres veces. Como dequeue() usa poll(), esto vacia la cola.
            String n1 = (String) dequeue(); 
            String n2 = (String) dequeue(); 
            String n3 = (String) dequeue(); 
            
            // Concatena los tres nucleotidos para formar un codon
            codons[i] = n1 + n2 + n3; 
        }
        return codons;
    }

    public String print() {
        return _queue.toString();
    }

    public static void main(String[] args) {
        var amount = Integer.parseInt(args[0]);
        String[] nucleotides = {
                "A", // [0]
                "C", // [1]
                "G", // [2]
                "T", // [3]
        };
        TheQueueInterface<String> queue = new TheQueue<String>();
        var random = new Random();
        for (; amount > 0; amount--) {
            var index = random.nextInt(4);
            var amino = nucleotides[index];
            queue.enqueue(amino);
        }
        System.out.println("Filled {full}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());
        System.out.println("\ngetCodons() → " + Arrays.toString(queue.getCodons()));
        System.out.println("\nEnd {empty}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());
    }
}