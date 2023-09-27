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
    public void push(E element) throws IndexOutOfBoundsException {
        if(isFull() == false){
            stack[size] = element;
            size++;
        }
        else{
           throw new IndexOutOfBoundsException();
        }
    }
    public E pop() {
        if(isEmpty() == false){
            size--;
            return stack[size];
        }
        else{
            return stack[-1];
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E top() {
         return stack[size - 1];
    }
    public int size() {
        return size;
    }
    public boolean isFull() {
        boolean isFull = false;
        if((size - 1) >= stack.length - 1)
        {
            isFull = true;
        }
        return isFull;
    }
    public String toString() {
        String array = "";
        for(int i = 0; i < size; i++){
            array += stack[i] + ",";
        }
        return array;
    }
}


