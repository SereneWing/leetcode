package problems;

/**
 * Created by wanghongkai on 2017/1/17.
 * <p>
 * 问题：判断一个数是否为回文数，不使用额外的空间
 * <p>
 * 思路：截取数的前半部分，翻转后和后半部分比较是否相等。由于只有一半长度，不用考虑溢出的问题。需要注意负数返回false，小于10的非负数返回true
 */
public class P009_palindrome_number {
    public static boolean isPalindrome(int x) {
        if (x >= 0) {
            if (x < 10) {
                return true;
            }
            int y = x;
            int length = 0;
            while (y != 0) {
                y = y / 10;
                length++;
            }
            int half = length / 2;
            int num = 1;
            int left = 0;
            int right = 0;
            while (half-- > 0) {
                num *= 10;
            }
            right = x % num;
            if (length % 2 == 1) {
                num *= 10;
            }
            left = x / num;
            while (left != 0) {
                y = y * 10 + left % 10;
                left /= 10;
            }
            return y == right;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123111));
    }
}
