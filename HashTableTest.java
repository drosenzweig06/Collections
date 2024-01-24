
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
        a.put("A", "a");        
        a.put("K", "k");
        System.out.print(a.toString().equals(
        "[null, null, null, null, null, K->k|A->a, null, null, null, null]"
        ) + " ");
    }
    
    public static boolean isSubset(Integer[] arr1, Integer[] arr2) {
        MyHashTable<Integer, Integer> a = new MyHashTable();
        boolean toReturn;
        Integer[] superset;
        Integer[] subset;
        if (arr1.length > arr2.length) {
            superset = arr1;
            subset = arr2;
        } else {
            superset = arr2;
            subset = arr1;
        }
        for (int i = 0; i < superset.length; i++) {
            a.put(i, i);
        }
        for (int j = 0; j < subset.length; j++) {
            if (a.get(j,j) == null) {
                toReturn = false;
            } else {
                toReturn = true;
            }
        }
        return toReturn;
    }
    
    public static boolean containsDuplicate(int[] arr1) {
        
    }
}

