package CP2;

public class CustomQueue {

    private QueueNode _head;

    public CustomQueue() {
        _head = null;
    }

    public void enqueue(int index) {
        var node = new QueueNode(index);

        // Actualizar

        if (_head == null) {
            _head = node;
        } else {
            QueueNode current = _head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
    }

    public int dequeue() {
        var index = -1;

        // Actualizar

        if (_head != null) {
            index = _head.getIndex();
            _head = _head.getNext();
        }

        return index;
    }

    public int getSize() {
        var size = 0;

        // Actualizar
        
        QueueNode current = _head;
        while (current != null) {
            size++;
            current = current.getNext();
        }

        return size;
    }

    public String getIndexes() {
        var builder = new StringBuilder();
        for (var index = dequeue(); index > -1; index = dequeue()) {
            builder.append(" " + index);
        }
        return builder.toString();
    }
}