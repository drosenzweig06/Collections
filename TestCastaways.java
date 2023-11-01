
/**
 * Write a description of class TestCastaways here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCastaways
{
    /**
     * Tests MyLinkedList's application of Castaway
     */
    public static void test() {
        String[] lastName = {"","Grumby","Howell","Howell","Grant","Hinkley",   
                                                                    "Summers"};
        String[] firstName = {"Gilligan","Jonas","Thurston","Lovey","Ginger",   
                                                            "Roy","Mary Ann"};
        int[] score = {72, 85, 82, 96, 90, 96, 88};
        String[] gender = {"M", "M", "M", "F", "F", "M", "F"};
        MyLinkedList<Castaway> list = new MyLinkedList<Castaway>();
        for(int i = 0; i < lastName.length;i++) {
            list.insertSorted(new Castaway(lastName[i],firstName[i],
                                    score[i], gender[i]));
        }
        System.out.print(list.remove(new Castaway("Howell", "Thurston",
                                                    82,"M")));
        
    }
}
