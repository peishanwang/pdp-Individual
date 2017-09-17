/**
 * Created by peishan on 2017/9/12.
 */
package Assignment1;
import java.io.InputStream;
import java.util.*;

public class ReverseNumber {

    public String getRevNum(InputStream systemIn) {
        Scanner sc = new Scanner(systemIn);
        String str = sc.nextLine();
        if (str.equals("")) {
            throw new IllegalArgumentException("There is no input argument");
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException("Input number is in the wrong format");
        }
        char[] charSet = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (charSet[0] == '-') sb.append('-');
        for (int i = charSet.length - 1; i > 0; i--) {
            sb.append(charSet[i]);
        }
        if (charSet[0] != '-') sb.append(charSet[0]);
        return(sb.toString());
    }

    public String getRevNum() {
        return getRevNum(System.in);
    }

    public static void main(String args[]) {
        ReverseNumber rn = new ReverseNumber();
        System.out.println(rn.getRevNum());
    }
}
