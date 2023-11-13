import java.util.NoSuchElementException;

/**
 * Linked List
 *
 * @author Daniel Rosenzweig
 * @version 10/31/2023
 */
public class MyLinkedList <E extends Comparable<E>>
{
    //instance variable that tracks the size/number of nodes
    private int size;
    //instance variable that tracks the head of the list
    private Node<E> head;
    //instance variable that tracks the tail of the list
    private Node<E> tail;
    /**
     * Constructor class MyLinkedList
     */
    public MyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Method getNode
     * Uses double linked list to find the quickest way to get to the desired
     * node
     * @param index of the node
     * @return returns the node at that index
     */
    public Node<E> getNode(int index) {
        if(index <= (int)size/2) {
            Node <E> current = head;
            
            for(int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current;
        } else {
            Node <E> current = tail;
            
            for(int i = size; i > index;i--) {
                current = current.getPrev();
            }
            return current;
        }
    }
    
    /**
     * Returns element at specified index.
     * Throws NoSuchElementException if the index does not exist
     */
    public E get(int index) throws NoSuchElementException {
        if(index < 0 || size <= index) {
            throw new NoSuchElementException();
        } else {
            return getNode(index).getData();
        }
    }
    
     /**
     * Removes and returns first occurrence of matching element.
     */
    public E remove(E element) {
        Node<E> current = head;
        int index = 0;
        
        while(current != null && current.getData().compareTo(element) != 0) {
            current = current.getNext();
            index++;
        }
        return remove(index);
    }
    
    /**
     * Removes and returns element at specified index.
     */
    public E remove(int index) throws NoSuchElementException {
        if(index < 0 || index >= size) {
            throw new NoSuchElementException();
        } else if (index == 0) {
            return removeHead();
        } else {
            Node <E> toRemove = getNode(index);
            
            if(toRemove.getNext() == null) { // if removing tail
                tail = toRemove.getPrev();
                tail.setNext(null);
            } else {
                toRemove.getPrev().setNext(toRemove.getNext());
                toRemove.getNext().setPrev(toRemove.getPrev());
            }
            
            E tempData = toRemove.getData();
            toRemove.setNext(null);
            toRemove.setPrev(null);
            toRemove.setData(null);
            size--;
            return tempData;
        }
    }
    
    /**
     * Inserts element at specified index.
     */
    public void add(int index, E element) throws NoSuchElementException {
        if(index < 0 || index >= size) {
            throw new NoSuchElementException();
        } else {
            if(index == 0 || size == 0) {
                addHead(element);
            } else if(size == index) {
                addTail(element);
            } else {
                Node<E> newnode = new Node<E>(element);
                Node<E> next = getNode(index);
                size++;
                newnode.setNext(next);
                newnode.setPrev(next.getPrev());
                next.setPrev(newnode);
                newnode.getPrev().setNext(newnode);
            }
        }
    }
    
    /**
     * Adds element to end of list.
     */
    public void add(E element) {
        addTail(element);
    }
    
    /**
     * Replaces existing element at specified index.
     */
    public void set(int index, E element) throws NoSuchElementException{
        if(index < 0 || index >= size) {
            throw new NoSuchElementException();
        } else if(index == 0) {
            removeHead();
            addHead(element);
        } else {
            Node<E> current = getNode(index);
            current.setData(element);
        }
    }
    
    /**
     * Inserts element into list.
     */
    public void insertSorted(E element) {
        Node <E> current = head;
        int index = 0;
        
        while(current != null && current.getData().compareTo(element) < 0) {
            current = current.getNext();
            index++;
        }
        add(index, element);
    }

    /**
     * Adds a new head and shifts the current head over
     */
    public void addHead(E data) {
        Node newnode = new Node(data);
        // Checks to see if the head node contains any data
        if(head == null) {
            head = newnode;
            tail = head;
        } else {
            newnode.setNext(head);
            head.setPrev(newnode);
            head = newnode;
        }
        size++;
    }

    /**
     * Takes in an element and creates and adds a node to the end
     */
    public void addTail(E data) {
        if(isEmpty()) {
            addHead(data);
        } else {
            Node <E> newnode = new Node(data);
            newnode.setPrev(tail);
            tail.setNext(newnode);
            tail = newnode;
            size++;
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
        String list = "";
        
        if(isEmpty()) {
            return list;
        }
        
        Node<E> current = head;
        list = list + current.getData();
        current = current.getNext();
        
        while(current != null) {
            list = list + "," + current.getData();
            current = current.getNext();
        }
        return list;
    }
}
