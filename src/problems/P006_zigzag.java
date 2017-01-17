package problems;

/**
 * Created by wanghongkai on 2017/1/9.
 *
 * 问题：将一个字符串用锯齿方式排列，并从左至右从上至下依次输出该排列方式下的字符
 *      排列方式大概如下：
 *
 *      a       i       q
 *      b     h j     p r
 *      c   g   k   o   s
 *      d f     l n     t
 *      e       m       u
 *
 * 思路：将结构简化如下：
 *
 *      a   i   q
 *      b h j p r
 *      c g k o s
 *      d f l n t
 *      e   m   u
 *
 *      按这种结构放在二维数组中，另一个二维数组存放对应位置是否有字符，根据标志二维数组进行输出
 *      注意当条件中行数为1时直接输出原字符串即可
 *
 */
public class P006_zigzag {
    public static String convert(String s, int numRows) {
        int size = s.length();
        int width = numRows;
        if(numRows>1) {
            width = size / (2 * numRows - 2) * 2 + 2;
        } else {
            return s;
        }
        boolean[][] hasValue = new boolean[width][numRows];
        char[][] value = new char[width][numRows];
        int position = 0;
        for (int i = 0; i < size; ) {
            for (int j = 0; i < size && j < 2 * numRows - 2; i++, j++) {
                if (j < numRows) {
                    hasValue[position][j] = true;
                    value[position][j] = s.charAt(i);
                } else {
                    hasValue[position + 1][2 * numRows - 2 - j] = true;
                    value[position + 1][2 * numRows - 2 - j] = s.charAt(i);
                }
            }
            position += 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < width; i++) {
                if (hasValue[i][j]) {
                    sb.append(value[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(convert(s, 1));
    }
}
