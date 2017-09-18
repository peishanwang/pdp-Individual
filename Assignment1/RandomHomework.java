package Assignment1;
import java.util.*;

/**
 * RandomHomework will randomly choose, and then print to the console, one of the four possible course names.
 * The names of four courses are stored in an String array.
 *
 * @author Peishan Wang
 */
public class RandomHomework {

	/**
	 * Randomly choose a course from four courses.
	 * @return Any one of the four courses
	 */
	public static String getCourse() {
		String[] courses = {"Reading", "Listening", "Speaking", "Writing"};
		Random ran = new Random();
		return courses[ran.nextInt(4)];
	}

	/**
	 * Print the output of a randomly-choose course
	 */
	public static void main(String[] args) {
		System.out.println(getCourse());
	}
}