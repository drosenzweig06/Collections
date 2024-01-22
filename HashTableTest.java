
/**
 * Write a description of class HashTableTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HashTableTest
{
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void sampleMethod()
    {
        MyHashTable a = new MyHashTable();
        a.put("b", "bruh");
        a.put("a", "apple");
        System.out.println(a.get("a"));
        System.out.println(a.remove("b"));
        System.out.println(a.remove("b"));
        System.out.println(a.size());
        a.put("c", "cat");
        System.out.println(a.isEmpty());
        System.out.println(a.toString());
        a.put("A", "a");        
        a.put("K", "k");
        System.out.print(a.toString().equals(
        "[null, null, null, null, null, K->k|A->a, null, null, null, null]"
        ) + " ");
    }
}
