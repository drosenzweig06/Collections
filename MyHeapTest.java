
/**
 * Write a description of class MyHeapTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHeapTest
{
    public void test() {
        MyHeap<Integer> test = new MyHeap<Integer>();
        System.out.println(test.isEmpty());
        System.out.println(test.getMin());
        System.out.println(test.size());
        test.add(15);
        test.add(10);
        test.add(5);
        test.add(20);
        System.out.println(test.isEmpty());
        System.out.println(test.getMin());
        System.out.println(test.size());
        System.out.println(test.toString());
        test.removeMin();
        test.removeMin();
    }
}
