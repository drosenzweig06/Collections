
/**
 * Write a description of class TestLinkedList here.
 *
 * @author Daniel Rosenzweig
 * @version 10/4/2023
 */
public class TestLinkedList
{
    public static void test()
    {
        MyLinkedList newlist = new MyLinkedList();
        newlist.addHead(2);
        newlist.addHead(3);
        newlist.size();
        newlist.addTail(4);
        newlist.addTail(6);
        newlist.removeHead();
        System.out.println(newlist.get(1));
        newlist.set(1,8);
        System.out.println(newlist.get(1));
        newlist.remove(1);
        newlist.add(1,50);
    }
}
