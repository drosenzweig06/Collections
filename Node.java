
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node
{
    // instance variables - replace the example below with your own
    private int data;
    private Node next;

    /**
     * Constructor for objects of class Node
     */
    public Node(int data)
    {
        this.data = data;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getData()
    {
        return data;
    }
    
    public Node getNext()
    {
        return next;
    }
    
    public void setNext(Node a)
    {
        next = a;
    }
    
    public void setData(int a)
    {
        data = a;
    }
}
