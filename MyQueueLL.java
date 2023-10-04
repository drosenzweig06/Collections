/**
 * This class is used to create a queue
 *
 * Daniel Rosenzweig
 */
public class MyQueueLL<E>
{
    //instance variable that tracks the size/number of nodes
    private int size;
    //instance variable that tracks the head of the node
    private Node<E> head;
    
    /**
     * Constructor for objects of class Queue
     * initiazilzes all three instance variables and makes an array of elements 
     */
    public MyQueueLL() {
        size = 0;
        head = null;
    }
    
    /**
     * Enqueues an element
     */
    public void enqueue(E data) {
        Node newnode = new Node(data);
        if(head == null) {
            head = newnode;              
        } else {
            Node current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newnode);
        }
    }
    
    /**
     * Dequeues an element to the array and throws an IndexOutOfBoundsException
     * if the array is empty
     */
    public E dequeue() {
        if(head == null) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temphead = head;
            head = head.getNext();
            temphead.setNext(null);
            size--;
            return temphead.getData();
        }
    }
    
    /**
     * Checks if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the element at the head
     */
    public Node<E> front() {
        return head;
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
        return false;
    }
    
    /**
     * Returns the queue
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

