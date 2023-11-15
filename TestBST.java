
/**
 * Write a description of class TestBST here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestBST
{

    /**
     * Constructor for objects of class TestBST
     */
    public void test()
    {
        BinarySearchTree testtree = new BinarySearchTree();
        testtree.insert(8);
        testtree.insert(5);
        testtree.insert(3);
        testtree.insert(6);
        System.out.println(testtree.isEmpty());
        System.out.println(testtree.getMin());
        System.out.println(testtree.size());
        testtree.insert(10);
        testtree.insert(16);
        testtree.insert(11);
        testtree.insert(4);
        testtree.insert(32);
        testtree.insert(28);
        testtree.insert(8);
        System.out.println(testtree.isEmpty());
        System.out.println(testtree.getMin());
        System.out.println(testtree.size());
    }
}
