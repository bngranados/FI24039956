package PP4;

import java.util.Arrays;
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    //       INSERT

    public void insert(int value) {

        // Actualizar
        int pos = 0;
        int max = _tree.length;

        while (pos < max) {

            if (_tree[pos] == null) {
                _tree[pos] = value;
                break;

            } else {
                int actual = _tree[pos];

                if (value < actual) {
                    pos = 2 * pos + 1;      
                } else if (value > actual) {
                    pos = 2 * pos + 2;     
                } else {
                    break;                 
                }
            }
        }

        System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));
    }


    public void inOrderTraversal() { // left -> root -> right
        System.out.print(" ↳ inOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            index = stack.pop();
            System.out.print(_tree[index] + " ");
            index = 2 * index + 2;
        }
        System.out.println();
    }


    //   PRE-ORDER
 
    public void preOrderTraversal() { // root -> left -> right
        System.out.print(" ↳ preOrderTraversal → ");

        // Actualizar
        Stack<Integer> pila = new Stack<>();

        if (_tree[0] != null) {
            pila.push(0);
        }

        while (!pila.isEmpty()) {

            int actual = pila.pop();
            System.out.print(_tree[actual] + " ");

            int hijoIzq = 2 * actual + 1;
            int hijoDer = 2 * actual + 2;

            if (hijoDer < _tree.length && _tree[hijoDer] != null) {
                pila.push(hijoDer);
            }
            if (hijoIzq < _tree.length && _tree[hijoIzq] != null) {
                pila.push(hijoIzq);
            }
        }

        System.out.println();
    }


    //  POST-ORDER

    public void postOrderTraversal() { // left -> right -> root
        System.out.print(" ↳ postOrderTraversal → ");

        // Actualizar
        Stack<Integer> pila = new Stack<>();
        Integer ultimo = null;
        int nodo = 0;

        while (!pila.isEmpty() || (nodo < _tree.length && _tree[nodo] != null)) {

            while (nodo < _tree.length && _tree[nodo] != null) {
                pila.push(nodo);
                nodo = 2 * nodo + 1; // ir al hijo izquierdo
            }

            int peek = pila.peek();
            int derecho = 2 * peek + 2;

            if (derecho >= _tree.length || _tree[derecho] == null || (ultimo != null && ultimo == derecho)) {
                System.out.print(_tree[peek] + " ");
                ultimo = peek;
                pila.pop();
            } else {
                nodo = derecho;
            }
        }

        System.out.println();
    }

    // =====================
   
    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);
        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal(); // 1 2 3 4 5 6 7
        tree.preOrderTraversal(); // 4 2 1 3 6 5 7
        tree.postOrderTraversal(); // 1 3 2 5 7 6 4
    }
}
