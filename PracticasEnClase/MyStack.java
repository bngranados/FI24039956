package PracticasEnClase;

import java.util.ArrayList;

public class MyStack<Type> implements MyStackInterface<Type> {
    
    private ArrayList<Integer> myList = new ArrayList<Integer>();

    public void push(Type item) {
    throw new UnsupportedOperationException("Unimplemented method 'push'");
        
    }
    
    public Type pop(){
    throw new UnsupportedOperationException("Unimplemented method 'pop'");
        
    }

    public Type peek(){
    throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    public boolean isEmpty(){
    throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    public int size() {
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    public static void main(String[] args) {
        MyStack<Boolean> myStack = new MyStack<Boolean>();
    }

}
