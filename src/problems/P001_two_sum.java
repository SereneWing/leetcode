package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanghongkai on 2017/1/6.
 *
 * 问题：求一个整数数组中是否存在两个数字之和为目标数
 *
 * 思路：使用一次遍历的Map
 */
public class P001_two_sum {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length * 2);
        for(int i = 0; i < numbers.length; i++){
            int temp = target-numbers[i];
            if(map.containsKey(temp)) {
                return new int[]{map.get(temp),i};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {3,2,4};
        int[] result = twoSum(numbers, 6);
        System.out.println(result[0]+" "+result[1]);
    }
}
