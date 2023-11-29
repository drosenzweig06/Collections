/**
 * Write a description of class BinarySearchTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinarySearchTree<E extends Comparable<E>>
{
    private int size; //tracks the number of nodes in the tree
    private BinarySearchTreeNode<E> root;
    /**
     * Constructor for objects of class BinarySearchTree
     */
    public BinarySearchTree()
    {
        root = null;
        size = 0;
    }
    
    /**
     * Inserts element into BST.
     */
    public void insert(E element) {
        if (root == null) {
            root = new BinarySearchTreeNode<E>(element);
            size++;
        } else {
            root.insert(element);
            size++;
        }
    }
    
    /**
     * Searches for and returns matching element.
     */
    public E search(E element) {
        if (root == null) {
            return null;
        } else {
            return root.search(element);
        }
    }
    
    /**
     * Returns minimum element in BST.
     */
    public E getMin() {
        if (isEmpty()) {
            return null;
        } else {
            return root.getMin();
        }
    }
    
    /**
     * Returns maximum element in BST.
     */
    public E getMax() {
        if (isEmpty()) {
            return null;
        } else {
            return root.getMax();
        }
    }
    
    /**
     * Indicates whether BST is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns number of elements in BST.
     */
    public int size(){
        return size;
    }
    
    /**
     * Method toString
     *
     * @return returns a string that contains all the elements in the BST
     */
    public String toString() {
        return root.toString();
    }
    
    /**
     * Method getDepth
     *
     * @return returns the depth of the BST 
     */
    public int getDepth() {
        return root.getDepth();
    }
    
    /**
     * Method removeMin
     * Removes and returns the minimum element
     */
    public E removeMin() {
        if (isEmpty()) {
            return null;
        } else {
            E toReturn = root.getMin();
            root.removeMin();
            return toReturn;
        }
    }
    
    /**
     * Method removeMax
     * Removes and returns the maximum element.
     */
    public E removeMax() {
        if (isEmpty()) {
            return null;
        } else {
            E toReturn = root.getMax();
            root.removeMax();
            return toReturn;
        }
    }
    
    /**
     * Method remove
     * Removes and returns matching element.
     */
    public E remove(E element) {
        if (search(element) == null) {
            return null;
        } else {
            E returnSearch = search(element);
            root = root.remove(element);
            size--;
            return returnSearch;
        }
    }
}
