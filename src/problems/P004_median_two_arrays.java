package problems;

/**
 * Created by wanghongkai on 2017/1/7.
 *
 * 问题：给出两个正序整形数组，找出中位数
 *
 * 思路：用4个指针：每个数组前后各一个，从两边同步逼近两个数组。对于总个数是奇数或者偶数，最后选择不同的中位数计算方案
 *
 */
public class P004_median_two_arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int target = (total - 1) / 2;
        boolean isSingle = (total % 2 == 1);
        int array = 0;
        double result = 0;
        for (int count = 0; count <= target; count++) {
            if (index1 == m) {
                index2++;
                array = 1;
            } else if (index2 == n) {
                index1++;
                array = 0;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
                array = 0;
            } else {
                index2++;
                array = 1;
            }
        }
        if (array == 0) {
            result = nums1[index1 - 1];
        } else {
            result = nums2[index2 - 1];
        }
        if (!isSingle) {
            if (index1 == m) {
                result = (result + nums2[index2]) / 2;
            } else if (index2 == n) {
                result = (result + nums1[index1]) / 2;
            } else if (nums1[index1] < nums2[index2]) {
                result = (result + nums1[index1]) / 2;
            } else {
                result = (result + nums2[index2]) / 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
