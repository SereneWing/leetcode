package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanghongkai on 2017/1/6.
 */
public class P003_longest_substring {
    public static int lengthOfLongestSubstring(String s) {
        int size = s.length();
        if(size<=1) {
            return size;
        }
        Set<Character> set = new HashSet<Character>();
        int start = 0;
        int length;
        int maxLength = 0;
        for (int i = 0; i < size; i++) {
            Character character = s.charAt(i);
            if (set.contains(character)) {
                length = i - start;
                if (length > maxLength) {
                    maxLength = length;
                }
                for (int j=start;j<i;j++) {
                    Character temp = s.charAt(j);
                    if (!temp.equals(character)) {
                        set.remove(temp);
                    } else {
                        start = j+1;
                        break;
                    }
                }
            } else {
                set.add(s.charAt(i));
            }
        }
        length = size - start;
        if (length > maxLength) {
            maxLength = length;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
