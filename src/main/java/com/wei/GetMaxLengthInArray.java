package com.wei;

/**
 * 一个数组中有正负数 求最长子数组的和小于等于aim的长度
 *
 * @author 为为
 * @create 10/25
 */
public class GetMaxLengthInArray {

    public static int core(int[] arr, int aim) {
        int maxLength = 0;
        //当前位置为头能累加的最小和
        int[] min_sum = new int[arr.length];
        //累加最小和的位置
        int[] min_index = new int[arr.length];
        //初始化
        min_sum[min_sum.length - 1] = arr[arr.length - 1];
        min_index[min_index.length - 1] = arr.length - 1;
        //得到每个位置的最小和
        for (int i = arr.length - 1 - 1; i >= 0; i--) {
            min_sum[i] = min_sum[i + 1] > 0 ? arr[i] : min_sum[i + 1] + arr[i];
            min_index[i] = min_sum[i + 1] > 0 ? i : min_index[i + 1];
        }
        int R = 0;
        int sum = 0;
        //遍历最小和数组
        for (int start = 0; start < min_sum.length; start++) {
            while (R<arr.length && sum + min_sum[start] <= aim) {
                sum += min_sum[start];
                start = min_index[start] + 1;
            }
            sum -= R > start ? arr[start] : 0;
            maxLength = Math.max(maxLength, start - R);
            R = Math.max(R, start + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {-3, 1, 2, 1, 1, 2};
        System.out.println(core(arr, 3));
    }
}