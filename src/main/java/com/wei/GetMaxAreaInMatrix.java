package com.wei;

import java.util.Stack;

/**
 * 二维数组中面积最大的连续1;
 * 用单调栈
 *
 * @author 为为
 * @create 10/10
 */
public class GetMaxAreaInMatrix {

    public static int core(int[][] arr) {
        int res = 0;
        int[] ret = new int[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ret[j] = arr[i][j] == 0 ? 0 : ret[j] + 1;
            }
            res = Math.max(res, getNum(ret));
        }

        return res;
    }

    public static int getNum(int[] arr) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                Integer num = stack.pop();
                Integer k = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, arr[num] * (i - k - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer num = stack.pop();
            Integer k = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, arr[num] * (arr.length - k - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1, 1},
                    {1, 1, 1, 1},
                    {1, 1, 1, 0}
        };
        System.out.println(core(arr));
    }
}