import java.util.*;

/**
 * Write a description of class Stacks here.
 *
 * @author Daniel Rosenzweig
 * @version 10/3/2023
 */
public class MyStackLL<E>
{
    // instance variables - replace the example below with your own
    private int size;
    private Node<E> head;
    
    /**
     * Constructor for objects of class Stacks
     */
    public MyStackLL() {
        size = 0;
        head = null;
    }
    
    /**
     * Adds an element to the stack
     */
    public void push(E data) {
        Node newnode = new Node(data);
        if(head == null) {
            head = newnode;              
            size++;
        } else {
            newnode.setNext(head);
            head = newnode;
            size++;
        }
    }
    
    /**
     * Pops the element on the top off the stack and throws an IndexOutOfBoundsError
     * if the stack is empty
     */
    public E pop() throws EmptyStackException{
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            Node<E> temphead = current;
            temphead.setNext(null);
            size--;
            return temphead.getData();
        }
    }
    
    /**
     * Checks if the stack is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the top value
     */
    public E top() {
        Node<E> current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData();
    }
    
    /**
     * Returns the size
     */
    public int size() {
        return size;
    }
    
    /**
     * Checks if the array is full
     */
    public boolean isFull() {
        return false;
    }
    
    public boolean openChars(String open) {
        String openchar = "{[(";
        String closechar = "}])";
        for(int i = 0; i < open.length(); i++) {
            if(openchar.indexOf(open.substring(i,i+1)) != -1) {
                return true;
            } else if(openchar.indexOf(open.substring(i,i+1)) == closechar.
            indexOf(open.substring(i,i+1))) {
                pop();
                return false;
            } else {
                return false;
            }
            }
        }
    }
    
    /**
     * Returns the stack
     */
    public String toString() {
        Node current = head;
        String list = "";
        while(current.getNext() != null) {
            list += current.getData() + " ,";
            current = current.getNext();
        }
        return list;
    }
}
