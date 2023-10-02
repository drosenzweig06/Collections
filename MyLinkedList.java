import java.util.NoSuchElementException;

/**
 * Write a description of class MyLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyLinkedList
{
    // instance variables - replace the example below with your own
    private int size;
    private Node head;

    /**
     * Constructor for objects of class MyLinkedList
     */
    public MyLinkedList()
    {
        head = null;
        size = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addHead(int data) {
        Node newnode = new Node(data);
        if(head == null) {
            head = newnode;              
            size++;
        }
        else {
            newnode.setNext(head);
            head = newnode;
            size++;
        }
    }
    
    public void addTail(int data) {
        if(head == null){
            addHead(data);
        }
        else {
            size++;
            Node newnode = new Node(data);
            Node current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newnode);
        }
    }
    
    public int removeHead() throws IndexOutOfBoundsException {
        if(head == null) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node temphead = head;
            head = head.getNext();
            temphead.setNext(null);
            size--;
            return temphead.getData();
        }
    }
    
    public int getHead() throws NoSuchElementException {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getData();
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int size() {
        return size;
    }
    
    public String toString() {
            Node current = head;
            String list = "";
            while(current.getNext() != null) {
                list += current.getData() + " ,";
            }
            return list;
    }
}
