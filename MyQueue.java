/**
 * Write a description of class Queue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyQueue<E>
{
    // instance variables - replace the example below with your own
    private E[] queue;
    private int front;
    private int size;
    private int back;
    /**
     * Constructor for objects of class Queue
     */
    public MyQueue() {
        size = 0;
        front = 0;
        back = -1;
        queue = (E[])new Object[5];
    }
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
    public E dequeue() {
        if(isEmpty() == false){
            front = (front + 1) % queue.length;
            size--;
            return queue[front];
        }
        else{
            return queue[-1];
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E front() {
        return queue[front % queue.length];
    }
    public int size() {
        return size;
    }
    public boolean isFull() {
        if(size >= queue.length - 1){
            System.out.println(queue.length);
            return true;
        }
        return false;
    }
    public String toString() {
        String array = "";
        for(int i = 0; i < queue.length; i++)
        {
            array += queue[i] + ",";
        }
        return array;
    }
}

