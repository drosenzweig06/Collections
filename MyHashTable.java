import java.util.*;
/**
 * Write a description of class MyHashTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHashTable<K,V>
{
    // instance variables - replace the example below with your own
    private int size;
    private int tableSize;
    private HashNode<K,V>[] array;

    /**
     * Constructor for objects of class MyHashTable
     */
    public MyHashTable()
    {
        size = 0;
        tableSize = 10;
        array = (HashNode<K,V>[])new HashNode[tableSize];
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void put(K key, V value)
    {
        int index = hash(key);
        if(array[index] == null) {
            array[index] = new HashNode(key, value);
        } else {
            HashNode<K,V> head = array[index];
            array[index] = new HashNode(key,value);
            array[index].setNext(head);
        }
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
class HashNode<K,V>
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

