package com.wei;

/**
 * 数组中全是正数
 * 求累加和等于aim的最长子数组
 * @author 为为
 * @create 10/18
 */
public class GetMaxLengthOfPositiveNumberSubArrayEqualsAim {

    /**
     * 利用全是正数的特性 以一个位置开头最大只有一种情况的和等于aim
     * 双指针
     * @param arr
     * @param aim
     * @return
     */
    public static int positiveNum(int[] arr, int aim) {
        int l = 0;
        int r = 0;
        int sum = arr[0];
        int res = Integer.MIN_VALUE;
        while (r < arr.length) {
            if (sum == aim) {
                res = Math.max(res, r - l + 1);
                sum -= arr[l++];
            } else if (sum < aim) {
                if (++r == arr.length) {
                    break;
                }
                sum += arr[r];
            } else if (sum > aim) {
                sum -= arr[l++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 1, 1, 1, 1, 1};
        System.out.println(positiveNum(arr, 5));
    }
}