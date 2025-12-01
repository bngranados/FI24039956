package CP2;

public class CustomStack {

    private StackNode _head;

    public CustomStack() {
        _head = null;
    }

    public void push(String word) {
        var node = new StackNode(word);

        // Actualizar
        node.setNext(_head);
        _head = node;
    }

    public String pop() {
        String word = null;

        // Actualizar
        if (_head != null) {
            word = _head.getWord();
            _head = _head.getNext();
        }

        return word;
    }

    public int size() {
        var length = 0;

        // Actualizar
        StackNode current = _head;
        while (current != null) {
            length++;
            current = current.getNext();
        }

        return length;
    }

    public String getWords() {
        var builder = new StringBuilder("(" + size() + ") [");
        for (var word = pop(); word != null; word = pop()) {
            builder.append(" " + word);
        }
        builder.append(" ]");
        return builder.toString();
    }
}