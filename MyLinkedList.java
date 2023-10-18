import java.util.NoSuchElementException;

/**
 * Write a description of class MyLinkedList here.
 *
 * @author Daniel Rosenzweig
 * @version 10/3/2023
 */
public class MyLinkedList <E>
{
    //instance variable that tracks the size/number of nodes
    private int size;
    //instance variable that tracks the head of the list
    private Node<E> head;
    //instance variable that tracks the tail of the list
    private Node<E> tail;
    /**
     * Constructor class MyLinkedList; Sets size to 0 and head to null
     */
    public MyLinkedList()
    {
        head = null;
        size = 0;
    }
    
    /**
     * Method get
     *
     * @param index A parameter
     * @return The return value
     */
    public E get(int index) throws NoSuchElementException {
        Node <E> current = head;
        
        if(size <= index) {
            throw new NoSuchElementException();
        } else {
            for(int i = 0; i < index - 1;i++) {
                current = current.getNext();
            }
        }
        return current;
    }
    
    public E remove(int index) throws NoSuchElementException {
        Node <E> current = head;
    
        if(size <= index) {
            throw new NoSuchElementException();
        } else {
            for(int i = 0; i < index - 1;i++) {
                current = current.getNext();
            }
        }
    }
    
    public void add(int index, E element) {
        Node <E> current = head;
        current.setData(element);
    
        if(size <= index) {
            throw new NoSuchElementException();
        } else {
            for(int i = 0; i < index - 1;i++) {
                current = current.getNext();
            }
        }
    }
    
    /**
     * Adds a new head and shifts the current head over
     */
    public void addHead(E data) {
        Node newnode = new Node(data);
        //Checks to see if the head node contains any data
        if(head == null) {
            head = newnode;              
        } else {
            newnode.setNext(head);
            head = newnode;
        }
        size++;
    }

    /**
     * Takes in an element and creates and adds a node to the end
     */
    public void addTail(E data) {
        if(head == null) {
            addHead(data);
        } else {
            size++;
            Node newnode = new Node(data);
            Node current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newnode);
        }
    }

    /**
     * Removes the current head and sets the next node to the head
     * 
     * Returns the element that was originally stored in the head
     */
    public E removeHead() throws IndexOutOfBoundsException {
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
     * Returns the data of the current head
     * 
     * 
     */
    public E getHead() throws NoSuchElementException {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getData();
    }

    /**
     * Returns whether the head is empty or not
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the size
     */
    public int size() {
        return size;
    }

    /**
     * Returns the data of the current nodes
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
