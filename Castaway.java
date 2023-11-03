
/**
 * Write a description of class Castaway here.
 *
 * Daniel Rosenzweig
 * 11/2/23
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
     * Compares last names first and first names second
     */
    @Override
    public int compareTo(Castaway other) {
        if(lastName.equals(other.lastName)) {
            return firstName.compareTo(other.firstName);
        } else {
            return lastName.compareTo(other.lastName);
        }
    }
    
    /**
     * Returns a boolean on whether or not the names are equal
     */
    public boolean equals(Castaway other) {
        return compareTo(other) == 0;
    }
    
    public String toString() {
       return firstName + "," + lastName;
    }
}