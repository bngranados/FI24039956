package PP2;

import java.util.ArrayList;

public class Pila_PP2 {

    private ArrayList<Character> myList = new ArrayList<>();
    private final int capacity = 10000;

    public void push(Character character) {
        if (myList.size() < capacity) {
            myList.add(character); 
        } else {    
            System.out.println(" 'push' failed: Stack overflow!!");
        }
    }

    public Character pop() {
        if (!myList.isEmpty()) {
            return myList.remove(myList.size() - 1); 
        } else {
            System.out.println(" 'pop' failed: Stack underflow!!");
            return null;
        }
    }

    public Character peek() {
        if (!myList.isEmpty()) {
            return myList.get(myList.size() - 1);
        } else {
            System.out.println(" 'peek' failed: Stack underflow!!");
            return null;
        }
    }

    public boolean Empty() {
        return myList.isEmpty();
    }

    public int size() {
        return myList.size();
    }
}