
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node<E>
{
    // instance variables - replace the example below with your own
    private E data;
    private Node<E> next;

    /**
     * Constructor for objects of class Node; Takes data inputed by the user
     */
    public Node(E data)
    {
        this.data = data;
    }

    /**
     * Returns data of node
     */
    public E getData()
    {
        return data;
    }

    /**
     * returns the next node
     */
    public Node<E> getNext()
    {
        return next;
    }

    /**
     * Sets the next node to the inputed element
     */
    public void setNext(Node<E> node)
    {
        next = node;
    }

    /**
     * Sets the data of the node to the inputed element
     */
    public void setData(E element)
    {
        data = element;
    }
}
