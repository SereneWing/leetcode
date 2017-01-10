package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghongkai on 2017/1/10.
 */
public class P007_reverse_integer {
    public static int reverse1(int x) {
        int length = 0;
        boolean negative = x < 0;
        int temp = x;
        while (temp != 0) {
            temp /= 10;
            length++;
        }
        int result = 0;
        int last = 0;
        temp = x;
        while (length-- > 0) {
            if (length == 0) {
                last = result;
            }
            result = result * 10 + temp % 10;
            if (length == 0 && result / 10 != last) {
                return 0;
            }
            temp /= 10;

        }
        return result;
    }

    public static int reverse2(int x) {
        long input = new Long(x);
        boolean negative = input < 0;
        if (negative) {
            input = -input;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb = sb.reverse();
        long result = Long.parseLong(sb.toString());
        if ((negative && -result < Integer.MIN_VALUE) || (!negative && result > Integer.MAX_VALUE)) {
            return 0;
        }
        if (negative) {
            result = -result;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(reverse2(-123));
    }
}
