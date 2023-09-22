/**
 * Write a description of class Queue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Queue
{
    // instance variables - replace the example below with your own
    private int[] queue;
    private int front;
    private int size;
    private int sizeofmemory;

    /**
     * Constructor for objects of class Queue
     */
    public Queue(int length)
    {
        sizeofmemory = length;
        size = 0;
        front = 0;
        queue = new int[sizeofmemory];
    }
    public void enqueue(int element){
        if(isFull() == false){
            queue[(size + front) % queue.length] = element;
            size++;
        }
        else{
           System.out.println("Sorry your queue is full"); 
        }
    }
    public int dequeue(){
        int num = 0;
        if(isEmpty() == false){
            front++;
            size--;
            num = queue[(front-1) % queue.length];
        }
        return num;
    }
    public boolean isEmpty(){
        boolean isEmpty = false;
        if(size == 0){
            isEmpty = true;
        }
        return isEmpty;
    }
    public int front(){
        return queue[front % queue.length];
    }
    public int size(){
        return size;
    }
    public boolean isFull(){
        if(size >= queue.length - 1){
            System.out.println(queue.length);
            return true;
        }
        return false;
    }
    public String toString(){
        String array = "";
        for(int i = 0; i < queue.length; i++)
        {
            if(queue[i] != 0){
                array += queue[i] + ",";
            }
        }
        return array;
    }
}

