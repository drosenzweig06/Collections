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
    
    public void insert(E element) {
        if (element.compareTo(data) <= 0) {
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
        } else if(element.compareTo(data) > 0) {
            if (right == null) {
                return null;
            } else {
                return right.search(element);
            }
        } else {
            return data;
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
    
    public BinarySearchTreeNode<E> removeMin() {
        if (left == null && right == null) {
            data = null;
            return null;
        } else if(left == null) {
            data = null;
            return right;
        } else {
            left = left.removeMin();
            return this;
        }
    }
    
    public BinarySearchTreeNode<E> removeMax() {
        if (left == null && right == null) {
            data = null;
            return null;
        } else if(right == null) {
            data = null;
            return left;
        } else {
            right = right.removeMax();
            return this;
        }
    }
    
    public BinarySearchTreeNode<E> remove(E element) {
        if (element.compareTo(data) > 0) {
            if (right == null) {
                return this;
            } else {
                right = right.remove(element);
                return this;
            }
        } else if (element.compareTo(data) < 0) {
            if (left == null) {
                return this;
            } else {
                left = left.remove(element);
                return this;
            }
        } else {
            if (left == null && right == null) {
                data = null;
                return null;
            } else if (left == null && right != null) {
                data = null;
                return right;
            } else if (left != null && right == null) {
                data = null;
                return left;
            } else {
                data = right.getMin();
                right = right.removeMin();
                return this;
            }
        }
    }
    
    public String toString() {
        String toReturn = "";
        
        if (left != null) {
            toReturn += left.toString() + ", ";
        } 
        
        toReturn += data.toString();
        
        if (right != null) {
            toReturn += ", " + right.toString();
        }
        return toReturn;
    }
}
