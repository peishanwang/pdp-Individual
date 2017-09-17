package Assignment1;
import java.util.*;

public class RandomCourse {


	public static String getCourse() {
		String[] courses = {"Reading", "Listening", "Speaking", "Writing"};
		Random ran = new Random();
		return courses[ran.nextInt(4)];
	}

	public static void main(String[] args) {
		System.out.println(getCourse());
	}
}