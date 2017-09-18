/**
 * Created by peishan on 2017/9/12.
 */
package Assignment1;
import java.io.InputStream;
import java.util.*;

/**
 * ReverseNumber calculate the reverse number of an integer.
 *
 * The input must be an integer, and the return number is a Long because the output might be greater
 * than the largest integer.
 *
 * @author Peishan Wang
 */
public class ReverseNumber {
    /**
     * Calculates the reverse number of an integer.
     *
     * @param systemIn the input stream
     * @return the reversed number of the input integer
     * @throws InputMismatchException if input is not an integer
     */
    public long getRevNum(InputStream systemIn) {
        Scanner sc = new Scanner(systemIn);
        int input;
        long output = 0;
        try {
            input = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Your input should be an integer.");
        }
        int absInput = Math.abs(input);
        while (absInput != 0) {
            output *= 10;
            output += absInput % 10;
            absInput /= 10;
        }
        return output *= input < 0 ? -1 : 1;
    }
    /**
     * Calculates the reverse number of an integer.
     *
     * @return the reversed number of the input integer received from user's input in console
     * @throws InputMismatchException if input is not an integer
     */
    public long getRevNum() {
        System.out.println("Please enter an integer :");
        return getRevNum(System.in);
    }

    /**
     * Call the reverse number function and print the result
     *
     */
    public static void main(String args[]) {
        ReverseNumber rn = new ReverseNumber();
        System.out.println(rn.getRevNum());
    }
}
