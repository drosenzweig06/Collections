
/**
 * Write a description of class Castaway here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Castaway implements Comparable<Castaway>
{
    private String lastName;
    private String firstName;
    private int score;
    private String gender;
    /**
     * Constructor for objects of class Castaway
     */
    public Castaway(String lastName, String firstName, int score, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.score = score;
        this.gender = gender;
    }

    /**
     * 
     */
    public int compareTo(Castaway other) {
        if(lastName.equals(other.lastName)) {
            return firstName.compareTo(other.firstName);
        } else {
            return lastName.compareTo(other.lastName);
        }
    }
    
    public boolean equals(Castaway other) {
        if(compareTo(other) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public String toString() {
        String list = firstName + "," + lastName;
        return list;
    }
}