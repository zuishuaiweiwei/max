package com.wei;

import java.util.LinkedList;

/**一个数组的有多少个子数组中最大值减去最小值 小于等于 一个值
 * @author 为为
 * @create 10/9
 */
public class AmountInSubArrayOfMaxSubMinEqualsAim {

    public static int getNum(int[] arr, int num) {
        int res = 0;
        LinkedList<Integer> max = new LinkedList();
        LinkedList<Integer> min = new LinkedList();
        int L = 0;
        int R = 0;
        while (L < arr.length) {
            while (R < arr.length) {
                while (!max.isEmpty() && max.peekLast() <= arr[R]) {
                    max.pollLast();
                }
                max.addLast(R);
                while (!min.isEmpty() && min.peekLast() >= arr[R]) {
                    min.pollLast();
                }
                min.addLast(R);
                if (arr[max.peekFirst()] - arr[min.peekFirst()] > num) {
                    break;
                }
                R++;
            }
            if (max.peekFirst() == L) {
                max.pollFirst();
            }
            if (min.peekFirst() == L) {
                min.pollFirst();
            }
            res += R - L ;
            L++;
        }
        return res;
    }

    /**
     * 暴力方法
     * @param arr
     * @param num
     * @return
     */
    public static int getNum1(int[] arr, int num) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (isVail(arr, i, j, num)) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 子数组的最大值减去最小值是否小于等于aim
     * @param arr
     * @param start
     * @param end
     * @param num
     * @return
     */
    public static boolean isVail(int[] arr, int start, int end, int num) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max - min <= num;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(getNum(arr, 1));
        System.out.println(getNum1(arr, 1));
    }
}