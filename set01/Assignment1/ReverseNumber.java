/**
 * Created by peishan on 2017/9/12.
 */
package Assignment1;
import java.io.InputStream;
import java.util.*;

public class ReverseNumber {

    public long getRevNum(InputStream systemIn) {
        Scanner sc = new Scanner(systemIn);
        int input;
        long output = 0;
        try {
            input = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("You input should be an integer.");
        }
        int absInput = Math.abs(input);
        while (absInput != 0) {
            output *= 10;
            output += absInput % 10;
            absInput /= 10;
        }
        return output *= input < 0 ? -1 : 1;
    }

    public long getRevNum() {
        return getRevNum(System.in);
    }

    public static void main(String args[]) {
        ReverseNumber rn = new ReverseNumber();
        System.out.println(rn.getRevNum());
    }
}
