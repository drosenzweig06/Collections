import java.util.NoSuchElementException;

/**
 * Linked List
 *
 * @author Daniel Rosenzweig
 * @version 10/31/2023
 */
public class MyLinkedListCopy <E extends Comparable<E>>
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
    public MyLinkedListCopy()
    {
        head = null;
        size = 0;
    }
    
    /**
     * Returns element at specified index.
     */
    public E get(int index) throws NoSuchElementException {
        if(size <= index) {
            throw new NoSuchElementException();
        } else {
            Node <E> current = head;
            
            for(int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
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
        if(current == null) {
            return null;
        }
        return remove(index);
    }
    
    /**
     * Removes and returns element at specified index.
     */
    public E remove(int index) throws NoSuchElementException {
        if(size <= index || index < 0) {
            throw new NoSuchElementException();
        } else if(index == 0) {
            return removeHead();
        } else {
            Node <E> current = head;
        
            for(int i = 0; i < index - 1;i++) {
                current = current.getNext();
            }
            Node <E> toRemove = current.getNext();
            
            if(toRemove.getNext() == null) { // if removing tail
                tail = current;
            }
            Node <E> temp = toRemove;
            current.setNext(temp.getNext());
            toRemove.setData(null);
            size--;
            return temp.getData();
        }
    }
    
    /**
     * Inserts element at specified index.
     */
    public void add(int index, E element) throws NoSuchElementException {
        if(size < index||index < 0) {
            throw new NoSuchElementException();
        } else {
            Node <E> current = head;
            Node <E> newnode = new Node(element);
            
            for(int i = 0; i < index - 1;i++) {
                current = current.getNext();
            }
            if(index == 0 || size == 0) {
                addHead(element);
            } else if(size == index) {
                addTail(element);
            } else {
                Node <E> next = current.getNext();
                newnode.setNext(next);
                current.setNext(newnode);
                size++;
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
        if(size <= index || index < 0) {
            throw new NoSuchElementException();
        } else if(index == 0) {
            removeHead();
            addHead(element);
        } else {
            Node <E> current = head;
            Node <E> newnode = new Node<E>(element);
            
            for(int i = 0; i < index;i++) {
                current = current.getNext();
            }
            
            Node<E> nextnode = current.getNext();
            
            if(index == size - 1) {
                tail = newnode;
            } else {
                newnode.setNext(nextnode.getNext());
            }
            
            current.setNext(newnode);
            nextnode.setData(null);
            nextnode.setNext(null);
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
        if(isEmpty()) {
            return list;
        }
        list = list + current.getData();
        current = current.getNext();
        while(current != null) {
            list = list + "," + current.getData();
            current = current.getNext();
        }
        return list;
    }
}
