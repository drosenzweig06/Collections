import java.util.*;

/**
 * Write a description of class Stacks here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyStack<E>
{
    // instance variables - replace the example below with your own
    private int size;
    private E[] stack;
    
    /**
     * Constructor for objects of class Stacks
     */
    public MyStack() {
        size = 0;
        stack = (E[])new Object[5];
    }
    
    /**
     * Adds an element to the stack
     */
    public void push(E element) throws IndexOutOfBoundsException {
        if(isFull() == false){
            stack[size] = element;
            size++;
        }
        else{
           throw new IndexOutOfBoundsException();
        }
    }
    
    /**
     * Pops the element on the top off the stack and throws an IndexOutOfBoundsError
     * if the stack is empty
     */
    public E pop() throws EmptyStackException{
        if(isEmpty() == false){
            size--;
            return stack[size];
        }
        else{
            throw new EmptyStackException();
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
         return stack[size - 1];
    }
    
    /**
     * Returns the size of the array
     */
    public int size() {
        return size;
    }
    
    /**
     * Checks if the array is full
     */
    public boolean isFull() {
        boolean isFull = false;
        if((size - 1) >= stack.length - 1)
        {
            isFull = true;
        }
        return isFull;
    }
    
    /**
     * Returns the stack
     */
    public String toString() {
        String array = "";
        for(int i = 0; i < size; i++){
            array += stack[i] + ",";
        }
        return array;
    }
}


