package problems;

/**
 * Created by wanghongkai on 2017/1/16.
 *
 * 问题：将一个字符串转为正数，实现atoi的功能
 *
 * 思路：注意正负号，注意溢出判断
 *
 * 更优解法：优化溢出时的判断，参考p007
 */
public class P008_string_to_integer {
    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        int length = str.length();
        if (length > 0) {
            int index = 0;
            boolean positive = true;
            char first = str.charAt(0);
            if (first == '-') {
                positive = false;
                index++;
            } else if (first == '+') {
                index++;
            }
            if (index >= length) {
                return 0;
            }
            char firstNum = str.charAt(index);
            if (firstNum >= '0' && firstNum <= '9') {
                long result = (int) firstNum - 48;
                while (++index < length) {
                    char next = str.charAt(index);
                    if (next < '0' || next > '9') {
                        break;
                    }
                    result = result * 10 + ((int) next - 48);
                    if (positive && result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if (!positive && -result < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
                return (int) (positive ? result : -result);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] test = new String[]{
                "0",
                "1",
                "-1",
                "  0  ",
                "   1   ",
                "   -1   ",
                "   +1    ",
                "  a1  ",
                "    1a",
                "  +19826385692345982734",
                "  -19826385692345982734",
                "  -",
        };
        for (String s : test) {
            System.out.println(myAtoi(s));
        }
    }
}
