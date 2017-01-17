package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghongkai on 2017/1/10.
 *
 * 问题：倒转一个整数
 *
 * 思路：用long存放该整数，倒转以后判断是否超出Integer的范围
 *
 * 更优解法：如果倒转之后会溢出，说明原来的数有10位（2147483647）
 *         假设一个正数倒转“后9位”以后没有超过214748364，但当加上第10位时却溢出了，那么第10位必须大于等于7，
 *         这种情况下，原数超过了2147483647，在Integer的范围外。所以一个正数倒转后9位没溢出，则肯定不会溢出
 *         负数同理
 *         因此，只需要在每次倒转以后判断(y > INT_MAX/10 || y < INT_MIN/10)，true则溢出
 *
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
