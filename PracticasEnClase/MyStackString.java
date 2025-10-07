package PracticasEnClase;

import java.util.ArrayList;

class MyStackString implements MyStackInterface<String> {
    
    private ArrayList<Integer> myList = new ArrayList<Integer>();


    public void push(String str) {
        throw new UnsupportedOperationException("Unimplemented method 'push'");
    }
    
    public String pop(){
    throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    public String peek(){
    throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    public boolean Empty(){
    throw new UnsupportedOperationException("Unimplemented method 'Empty'");
    }

    public int size(){
        throw new UnsupportedOperationException("Unimplemented method 'size'");

    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    
}