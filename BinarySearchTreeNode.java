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
            toReturn += left.toString();
        } 
        toReturn += data + ",";
        if (right != null) {
            toReturn += right.toString();
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
    
    public E removeMin() {
        if (left == null) {
            return data;
        } else {
            return left.getMax();
        }
    }
    
    public E removeMax() {
        if (right == null) {
            return data;
        } else {
            return right.getMax();
        }
    }
    
    public BinarySearchTreeNode<E> remove(E element) {
        if (element.compareTo(data) > 0) {
            if (right == null) {
                return right;
            } else {
                right = right.remove(element);
                return right;
            }
        } else if (element.compareTo(data) < 0) {
            if (left == null) {
                return left;
            } else {
                left = left.remove(element);
                return left;
            }
        } else {
            if (left == null && right == null) {
                data = null;
                return null;
            } else if (right == null) {
                data = null;
                return left;
            } else if (left == null) {
                data = null;
                return right;
            } else {
                data = left.getMax();
                left.removeMax();
                return left;
            }
        }
    }
    /**     * Prints elements as stored in the tree
     *
     * @param maxElementWidth The maximum space allowed for the string form
     *                        of the element.
     */
    public void printTree(int maxElementWidth) {
        int maxSize = (int) Math.pow(2, (getDepth() + 1));
        String[] elements = new String[maxSize];

        // Build array of elements
        printTree(elements, 0, maxElementWidth);

        // Print element properly spaced
        int fullWidth = (int) Math.pow(2, getDepth()) * (maxElementWidth + 1);
        for (int i = 0; i < getDepth() + 1; i++) {
            String connectionsLevel = "";
            String elementsLevel = "";

            for (int j = (int) Math.pow(2, i) - 1; j < (int) Math.pow(2, i + 1) - 1; j++) {

                // Process arrows for this level
                String arrow = "  ";
                int elementLength = arrow.length();
                if (elements[j] != null) {
                    if (j % 2 == 1) { // Odd is left child
                        arrow = " /";
                    } else { // Even is right child
                        arrow = "\\ ";
                    }
                }

                // Center within maxElementWidth
                String leftPadStr = ""; // Default
                String rightPadStr = ""; // Default
                int leftPadNum = (fullWidth / (int) Math.pow(2, i) - elementLength) / 2;
                int rightPadNum = fullWidth / (int) Math.pow(2, i) - elementLength - leftPadNum;
                if (leftPadNum > 0) {
                    leftPadStr = String.format("%" + leftPadNum + "s", " ");
                }
                if (rightPadNum > 0) {
                    rightPadStr = String.format("%" + rightPadNum + "s", " ");
                }
                connectionsLevel += leftPadStr + arrow + rightPadStr;

                // Process elements for this level
                elementLength = 0;
                if (elements[j] != null) {
                    elementLength = elements[j].toString().length();
                }

                // Center within maxElementWidth
                leftPadStr = ""; // Default
                rightPadStr = ""; // Default
                leftPadNum = (fullWidth / (int) Math.pow(2, i) - elementLength) / 2;
                rightPadNum = fullWidth / (int) Math.pow(2, i) - elementLength - leftPadNum;
                if (leftPadNum > 0) {
                    leftPadStr = String.format("%" + leftPadNum + "s", " ");
                }
                if (rightPadNum > 0) {
                    rightPadStr = String.format("%" + rightPadNum + "s", " ");
                }

                if (elements[j] != null) {
                    elementsLevel += leftPadStr + elements[j] + rightPadStr;
                } else {
                    elementsLevel += leftPadStr + rightPadStr;
                }
            }

            if (i > 0) { // Do not print arrows for root
                System.out.println(connectionsLevel);
            }
            System.out.println(elementsLevel);
        }
    }

    // build array of element strings
    private void printTree(String[] elements, int nodeNum, int maxElementWidth) {
        elements[nodeNum] = elements.toString();
        if (elements[nodeNum].length() > maxElementWidth) {
            elements[nodeNum] = elements[nodeNum].substring(0, maxElementWidth);
        }
        if (left != null) {
            left.printTree(elements, (nodeNum + 1) * 2 - 1, maxElementWidth);
        }
        if (right != null) {
            right.printTree(elements, (nodeNum + 1) * 2, maxElementWidth);
        }
    }
    
}
