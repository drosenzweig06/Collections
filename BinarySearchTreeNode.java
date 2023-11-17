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
        if (element.compareTo(data) < 0) {
            if (left == null) {
                return null;
            } else {
                return left.search(element);
            }
        } else {
            if (right == null) {
                return null;
            } else {
                return right.search(element);
            }
        }
    }
    
    public E getMin() {
        if (left == null) {
            return data;
        } else {
            return left.getMin();
        }
    }
    
    public E getMax() {
        if (right == null) {
            return data;
        } else {
            return right.getMin();
        }
    }
    
    public String toString() {
        String toReturn = "";
        if (left != null) {
            toReturn += left.toString() + ", ";
        } 
        if (right != null) {
            toReturn += right.toString() + ", ";
        }
        
        return toReturn;
    }
    
    public int getDepth() {
        int ldepth = 0;
        int rdepth = 0;
        if (!(left == null)) {
            ldepth = left.getDepth();
        } 
        if (!(right == null)) {
            rdepth = right.getDepth();
        }
        return Math.max(ldepth, rdepth) + 1;
    }
    
    // public E remove(E element) {
        
    // }
}
