
/**
 * Write a description of class BinarySearchTreeNode here.
 *
 * @author Daniel Rosenzweig
 * @version (a version number or a date)
 */
public class BinarySearchTreeNode<E extends Comparable<E>>
{
    private E data;
    private BinarySearchTreeNode<E> right;
    private BinarySearchTreeNode<E> left;
    
    /**
     * Constructor for objects of class BinarySearchTreeNode
     */
    public BinarySearchTreeNode(E data)
    {
        left = null;
        right = null;
        this.data = data;
    }
    
    public BinarySearchTreeNode<E> getLeft() {
        return left;
    }
    
    public BinarySearchTreeNode<E> getRight() {
        return right;
    }
    
    public E getData() {
        return data;
    }
    
    public void setLeft(BinarySearchTreeNode<E> left) {
        this.left = left; 
    }
    
    public void setRight(BinarySearchTreeNode<E> right) {
        this.right = right; 
    }
    
    public void setData(E data) {
        this.data = data;
    }
    
    public void insert(E element) {
        if (element.compareTo(data) < 0) {
            if (left == null) {
                left = new BinarySearchTreeNode<E>(element);
            } else {
                left.insert(element);
            }
        } else {
            if (right == null) {
                right = new BinarySearchTreeNode<E>(element);
            } else {
                right.insert(element);
            }
        }
    }
    
    public E search(E element) {
        if(element.compareTo(data) < 0) {
            if(left == null) {
                return null;
            } else {
                return left.search(element);
            }
        } else {
            if(right == null) {
                return null;
            } else {
                return right.search(element);
            }
        }
    }
    
    // public E getMin() {
    
    // }
    
    // public E getMax() {
        
    // }
}
