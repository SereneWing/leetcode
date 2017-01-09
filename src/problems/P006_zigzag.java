package problems;

/**
 * Created by wanghongkai on 2017/1/9.
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
