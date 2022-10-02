import java.util.LinkedList;

/*
Claire Winogrodzki
My implementation of stack data structure using a linked list.
1/26/2021
 */

public class Stack<T> {

    private LinkedList<T> l;
    private int size = 0;

    public Stack() {
        this.l = new LinkedList<>();
    }

    /**
     * a second constructor that initializes the stack with a given element
     * @param element - initialize the stack with element
     */
    public Stack(T element) {
        LinkedList l = new LinkedList();
        l.add(element);
        size++;
    }

    /**
     * Current size of the stack or number of elements available in the stack
     * @return size
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adding an element to the top of the stack
     * @param element - to be added to top of stack
     */
    public void push(T element) {
        l.addFirst(element);
        size++;
    }

    /**
     * Removing the top element from the stack
     * @return the popped element
     */
    public T pop() {
        T item = l.element();
        l.remove();
        size--;
        return item;
    }

    /**
     * Getting the top element of the stack without removing it
     * @return top element in the stack
     */
    public T peek() {
        T item = l.peekFirst();
        return item;
    }
}
