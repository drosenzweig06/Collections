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
    public V get(K key)
    {
        int index = hash(key);
        return searchBucket(index, key).getValue();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String remove(K key)
    {
        /*
        int index = hash(key);
        V value = array[index];
        array[index] = null;
        if(value != null) {
            size--;
        }
        return value;
        */
    }
    
    private void addToBucket(int index, HashNode<K,V> node) {
        if (array[index] == null) {
            array[index] = node;
        } else {
            HashNode<K,V> head = array[index];
            array[index] = node;
            array[index].setNext(head);
        }
    }
    
    public HashNode<K,V> searchBucket(int index, K key) {
        HashNode<K,V> current = array[index];
        
        if (current != null) {
            while (!(current.getKey().equals(key))) {
                if (current.getNext() == null) {
                    return null;
                } else {
                    current = current.getNext();
                }
            }
        }
        return current;
    }
    
    private void removeFromBucket(int index, HashNode<K,V> previous) {
        if (array[index] == previous) {
            array[index] = array[index].getNext();
            size--;
        } else {
            HashNode<K,V> current = array[index];
            
            while (current.getNext() != previous) {
                current = current.getNext();
            }
            if (current.getNext() == previous) {
                 current.setNext(previous.getNext()); 
                 size--;
            }
        }
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
    private int hash(K key) {
        return key.hashCode()%array.length;
    }
}

class HashNode<K,V>
{
    // instance variables - replace the example below with your own
    private V value;
    private K key;
    private HashNode next;

    /**
     * Constructor for objects of class HashNode
     */
    public HashNode(K key, V value)
    {
        this.value = value;
        this.key = key;
    }
    
    public V getValue() {
        return value;
    }
    
    public K getKey() {
        return key;
    }
    
    public HashNode<K,V> getNext()
    {
        return next;
    }
    
    public void setValue(V a) {
        value = a;
    }
    
    public void setKey(K a) {
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

