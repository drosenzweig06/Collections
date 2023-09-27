/**
 * This class is used to create a queue
 *
 * Daniel Rosenzweig
 */
public class MyQueue<E>
{
    // instance variables 
    private E[] queue;
    private int front;
    private int size;
    private int back;
    
    /**
     * Constructor for objects of class Queue
     * initiazilzes all three instance variables and makes an array of elements 
     */
    public MyQueue() {
        size = 0;
        front = 0;
        back = -1;
        queue = (E[])new Object[5];
    }
    
    /**
     * Enqueues an element to the array and throws an IndexOutOfBoundsException
     * if the array is full
     */
    public void enqueue(E element) throws IndexOutOfBoundsException {
        if(isFull() == false){
            back = (back + 1) % queue.length;
            queue[back] = element;
            size++;
        }
        else{
           throw new IndexOutOfBoundsException();
        }
    }
    
    /**
     * Dequeues an element to the array and throws an IndexOutOfBoundsException
     * if the array is empty
     */
    public E dequeue() {
        if(isEmpty() == false){
            E temp = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            size--;
            return temp;
        }
        else{
            return queue[-1];
        }
    }
    
    /**
     * Checks if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the element at the front
     */
    public E front() {
        return queue[front % queue.length];
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
        if(size >= queue.length - 1){
            System.out.println(queue.length);
            return true;
        }
        return false;
    }
    
    /**
     * Returns the queue
     */
    public String toString() {
        String array = "";
        for(int i = 0; i < queue.length; i++) {
            if(queue[i] != null) {
                array += queue[i] + ",";
            }
        }
        return array;
    }
}

