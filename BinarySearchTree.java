
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
    
    public void insert(E element) {
        if (root == null) {
            root = new BinarySearchTreeNode<E>(element);
            size++;
        } else {
            root.insert(element);
            size++;
        }
    }
    
    public E search(E element) {
        if (root == null) {
            return null;
        } else {
            return root.search(element);
        }
    }
    
    public E getMin() {
        if (isEmpty()) {
            return null;
        } else {
            return root.getMin();
        }
    }
    
    public E getMax() {
        if (isEmpty()) {
            return null;
        } else {
            return root.getMax();
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
}
