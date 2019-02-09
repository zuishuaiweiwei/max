package com.wei;

/**
 * 任意累加和等不等于目标值
 *
 * @author 为为
 * @create 9/24
 */
public class IsAnyAddEqualsAimInArray {

    /**
     * 递归版本
     * 每个位置都有加和不加两种情况
     * 递归到最后 看有没有等于aim的值
     * @param arr
     * @param i
     * @param sum
     * @param aim
     * @return
     */
    public static boolean isSum(int[] arr, int i, int sum, int aim) {
        if (i == arr.length) {
            System.out.println(sum);
            return sum == aim;
        }
        return isSum(arr, i + 1, sum, aim) || isSum(arr, i + 1, sum + arr[i], aim);
    }

    /**
     * 动态规划版本
     * @param arr
     * @param i
     * @param sum
     * @param aim
     * @return
     */
    public static boolean isSum2(int[] arr, int i, int sum, int aim) {
        int ret = 0;
        for (int j = 0; j < arr.length; j++) {
            ret += arr[j];
        }
        if(ret < aim){
            return false;
        }
        int[][] temp = new int[arr.length + 1][ret+1];
        temp[arr.length][aim] = 1;
        for (int j = temp.length - 2; j >= 0; j--) {
            core(temp, arr, j);
        }
        return temp[0][0] == 1 ? true : false;
    }

    public static void core(int[][] temp, int[] arr, int j) {
        for (int k = 0; k < temp[0].length; k++) {
            if (k + arr[j] > temp[0].length - 1) {
                if (temp[j + 1][k] == 1) {
                    temp[j][k] = 1;
                }
            } else if (temp[j + 1][k] == 1 | temp[j + 1][k + arr[j]] == 1) {
                temp[j][k] = 1;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5};
        System.out.println(isSum(arr, 0, 0, 10));
        System.out.println(isSum2(arr, 0, 0,10));
    }
}