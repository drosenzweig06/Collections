
/**
 * Write a description of class HashNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HashNode<K,V>
{
    // instance variables - replace the example below with your own
    private String value;
    private String key;
    private HashNode<K,V> next;

    /**
     * Constructor for objects of class HashNode
     */
    public HashNode(String key, String value)
    {
        this.value = value;
        this.key = key;
    }
    
    public String getValue() {
        return value;
    }
    
    public String getKey() {
        return key;
    }
    
    public HashNode<K,V> getNext()
    {
        return next;
    }
    
    public void setValue(String a) {
        value = a;
    }
    
    public void setKey(String a) {
        key = a;
    }
    
    public void setNext(HashNode<K,V> a) {
        next = a;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        return (key + "->" + value);
    }
}
