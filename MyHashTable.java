import java.util.*;
/**
 * Write a description of class MyHashTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHashTable
{
    // instance variables - replace the example below with your own
    private int size;
    private String[] array;

    /**
     * Constructor for objects of class MyHashTable
     */
    public MyHashTable()
    {
        size = 0;
        array = new String[10];
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void put(String key, String value)
    {
        int index = hash(key);
        array[index] = value;
        size++;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String get(String key)
    {
        int index = hash(key);
        return array[index];
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String remove(String key)
    {
        int index = hash(key);
        String value = array[index];
        array[index] = null;
        if(value != null) {
            size--;
        }
        return value;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public String toString() {
        return Arrays.toString(array);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private int hash(String key) {
        int product = 1;
        
        for(int i = 0; i < key.length(); i++) {
            product = product * key.charAt(i);
        }
        product = Math.abs(product);
        return product%10;
    }
}
