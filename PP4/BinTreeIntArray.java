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

    public void insert(int value) {
        int current = 0;
        int size = _tree.length;

        while(current < size) {
            if (_tree[current] == null) {
                _tree[current] = value;
                break;
            } else if (value < _tree[current]) {
                //vamos a la izquierda
                current = 2 * current + 1;
            } else if (value > _tree[current]) {
                //vamos a la derecha
                current = 2 * current + 2;
            } else {
                break;
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

     public void preOrderTraversal() { // root -> left -> right
        System.out.print(" ↳ preOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        System.out.print(_tree[index] + " ");
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
                if (index < _tree.length && _tree[index] != null) {
                    System.out.print(_tree[index] + " ");
                }
            }
            index = stack.pop();
            index = 2 * index + 2;
            if (index < _tree.length && _tree[index] != null) {
                System.out.print(_tree[index] + " ");
            }
        }
        System.out.println();
    }

    public void postOrderTraversal() {
        System.out.print(" ↳ postOrderTraversal → ");

        Stack<Integer> stack = new Stack<>();
        Integer lastVisited = null;
        int index = 0;

        while ((!stack.isEmpty()) || (index < _tree.length && _tree[index] != null)) {

            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
                //System.out.println("Index "+index+ ", stack: "+stack, _tree[index]);
            }

            int peek = stack.peek();
            int right = 2 * peek + 2;

            //System.out.println("Aqui estanos con peek "+peek+", right "+right+", lastVisited "+lastVisited+", stack: "+stack);

            if (right >= _tree.length || _tree[right] == null || lastVisited != null && lastVisited == right) {
                System.out.print(_tree[peek] + " ");
                lastVisited = peek;
                stack.pop();
            } else {
                index = right;
            }

            //System.out.println("Despues de procesar peek "+peek+", right "+right+", lastVisited "+lastVisited+", stack: "+stack);
        }

        System.out.println();
    }


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