package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanghongkai on 2017/1/6.
 *
 * 问题：求一个字符串的最长的不为空的子串
 *
 * 思路：将已遍历的字符串放到set里，记录set的范围，从头开始遍历字符串，当遇到相同字符时，记录当前长度，更新set范围，
 *      将重复的字符串之前的字符删除
 *
 * 更优解法：用HashMap记录键值对（字符，位置），遍历时遇到相同字符时，判断该字符是否在范围内，如果是，直接替换，记录当前长度
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
