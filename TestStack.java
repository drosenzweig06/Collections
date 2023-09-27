
/**
 * Write a description of class TestStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestStack
{
    public void testStack() {
        MyStack testStack = new MyStack();
        testStack.push(5);
        System.out.println(testStack.pop());
        testStack.push(10);
        System.out.println(testStack.isEmpty());
        System.out.println(testStack.isFull());
        System.out.println(testStack.size());
        System.out.println(testStack.top());
        System.out.println(testStack.toString());
    }
}
