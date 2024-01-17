
/**
 * Write a description of class HashNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HashNode
{
    // instance variables - replace the example below with your own
    private String value;
    private String key;
    private Node next;

    /**
     * Constructor for objects of class HashNode
     */
    public HashNode()
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
    
    public void setValue(String a) {
        value = a;
    }
    
    public void setKey(String a) {
        key = a;
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
