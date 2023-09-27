
/**
 * Write a description of class TestQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestQueue
{
    public void testQueue() {
        MyQueue testQueue = new MyQueue();
        testQueue.enqueue(5);
        System.out.println(testQueue.dequeue());
        testQueue.enqueue(10);
        System.out.println(testQueue.isEmpty());
        System.out.println(testQueue.isFull());
        System.out.println(testQueue.size());
        System.out.println(testQueue.front());
        System.out.println(testQueue.toString());
    }
}
