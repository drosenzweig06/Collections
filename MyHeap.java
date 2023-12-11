import java.util.Arrays;
/**
 * Write a description of class MyHeap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHeap<E extends Comparable<E>>
{
    // instance variables - replace the example below with your own
    private E[] elemArray;
    private int lastNode;

    /**
     * Constructor for objects of class MyHeap
     */
    public MyHeap()
    {
        elemArray = (E[]) new Comparable[16];
        lastNode = -1;
    }
    
    public boolean isEmpty() {
        return(lastNode == -1);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void add(E element)
    {
        if (isEmpty()) {
            elemArray[0] = element;
            lastNode = 0; 
        } else {
            elemArray[lastNode + 1] = element;
            lastNode++;
            int child = lastNode;
            int parent = (child - 1)/2;
            while(elemArray[child].compareTo(elemArray[parent]) < 0) {
                elemArray[child] = elemArray[parent];
                elemArray[parent] = element;
                child = parent;
                parent = (child - 1)/2;
            }
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public E getMin()
    {
        if(isEmpty()) {
            return null;
        } else {
            return elemArray[0];
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public E removeMin()
    {
        if (isEmpty()) {
            return null;
        } else {
            E toReturn = getMin();
            int child = lastNode;
            int parent = (child - 1)/2;
            elemArray[0] = elemArray[lastNode];
            elemArray[lastNode] = null;
            lastNode--;
            int current = 0;
            
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int size()
    {
        return lastNode + 1;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        return Arrays.toString(elemArray);
    }
}
