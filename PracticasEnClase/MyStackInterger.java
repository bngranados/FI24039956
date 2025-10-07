package PracticasEnClase;

import java.util.ArrayList;

public class MyStackInterger implements MyStackIntegerInterface {
    
    private ArrayList<Integer> myList = new ArrayList<Integer>();

    private int capacity = 5;

    public void push(int num) {
        if (myList.size() < capacity) {
        System.out.println("\n push:" + num);
        myList.add(num);
        print();

        } else {    
            System.out.println("\n 'push' failed: Stack overflow!!"); // Pila se desborda due to capacity limit
            return;
        }
    }
    
    public int pop(){
        if (myList.isEmpty()) {
        int num = myList.removeLast();
        System.out.println("\n pop:" + num);
        return num;

        } else {
            System.out.println( "\n 'pop' failed: Stack underflow!!");
        }
        return -1;
        
    }

    public int peek(){
        int num = myList.getLast();
        System.out.println("\n peek:" + num);
        return num;
    }

    public boolean Empty(){
        boolean isEmpty = myList.isEmpty();
        System.out.println("\n boolean:" + isEmpty);
        return isEmpty;
    }

    public int size(){
    int count = myList.size();
    System.out.println("\n size:" + count);
    return count;
    }
private void print(){
    System.out.println("\n Stack:");
    System.out.println(myList);
}

public static void main(String[] args) {
    MyStackInterger myStack = new MyStackInterger();
    //myStack.push(7);
    //myStack.push(5);
    //myStack.push(10);

    int last = myStack.pop();
    System.out.println("\n val: " + last);

    last = myStack.peek();

    boolean isEmpty = myStack.Empty();
    System.out.println("\n empty: " + isEmpty);

    int length = myStack.size();
    System.out.println("\n length: " + length);

    myStack.pop();
    myStack.pop();
    myStack.pop(); // Exception: Stack underflow!!
    myStack.peek(); // Exception: Stack underflow!!

    myStack.push(25);
    myStack.push(1);
    myStack.push(6);
    myStack.push(100);
    myStack.push(10);// Exception: Stack overflow!!

}

}