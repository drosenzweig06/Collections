
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
        testtree.search(3);
        testtree.search(5);
    }
}
