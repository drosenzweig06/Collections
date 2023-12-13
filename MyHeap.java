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
    
    /**
     * Indicates whether heap is empty.
     */
    public boolean isEmpty() {
        return(lastNode == -1);
    }

    /**
     * Adds element to heap.
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
     * Gets minimum element from heap.
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
     *  Removes and returns minimum element from heap.
     */
    public E removeMin()
    {
        if (isEmpty()) {
            return null;
        } else {
            E toReturn = getMin();
            elemArray[0] = elemArray[lastNode];
            elemArray[lastNode] = null;
            int child = lastNode;
            int current = 0;
            lastNode--;
            
            while((current * 2 + 1 < size() //checks the indexs of both the left and the right
            && elemArray[current].compareTo(elemArray[(current*2) + 1]) > 0)
            || (current * 2 + 2 < size() && elemArray[current].compareTo(elemArray[(current*2) + 2]) > 0)) {
                E temp = elemArray[current];
                
                if (elemArray[(current*2) + 1].compareTo(elemArray[(current*2) + 1]) <= 0) {
                    elemArray[current] = elemArray[(current*2) + 1];
                    elemArray[(current*2) + 1] = temp;
                    current = (current*2) + 1;
                } else {
                    elemArray[current] = elemArray[(current*2) + 2];
                    elemArray[(current*2) + 2] = temp;
                    current = (current*2) + 2;
                }
            }
            return toReturn;
        }
    }
    
    /**
     * Returns number of elements in heap
     */
    public int size()
    {
        return lastNode + 1;
    }
    
    /**
     * Returns the contents of the heap for testing purposes.
     */
    public String toString()
    {
        return Arrays.toString(elemArray);
    }
}
