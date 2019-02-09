package com.wei;

import java.util.HashMap;

/**
 * 找零钱
 * 数组中的数可以用任意次 和等于aim
 * 有几种方式找零钱
 *
 * @author 为为
 * @create 10/17
 */
public class AnyNumInArrayEqualsAim {

    public static int getNum(int[] arr, int aim) {
        if (aim == 0 || arr.length < 1) {
            return 1;
        }
        return process1(arr, 0, aim);
    }

    /**
     * 暴力递归
     * 思路 arr[0] 最多可以有几张 则 1 到 length的钱需要得到 aim - arr[0] * 张数 的钱
     * 递归得到最后结果
     *
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        //递归来到最后 如果还需要0 则这个方式可以 否则不行
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    /**
     * 暴力递归优化
     * map相当于缓存
     */
    private static HashMap<String, Integer> map = new HashMap<>();

    public static int process2(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                int nextAim = aim - arr[index] * i;
                String str = String.valueOf(index) + "_" + String.valueOf(nextAim);
                //如果key已经存在 则 这个部分返回多少种方式已经计算过一次了，避免重复计算
                if (map.containsKey(str)) {
                    res += map.get(str);
                } else {
                    res += process2(arr, index + 1, nextAim);
                }
            }
            //设置缓存
            map.put(String.valueOf(index) + "_" + String.valueOf(aim), res);
        }
        return res;
    }

    /**
     * 动态规划版本
     *
     * @param arr
     * @param aim
     * @return
     */
    public static int dynamicPlanning(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[dp.length - 1][0] = 1;
        for (int i = dp.length - 1 - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = dp[i + 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[0][aim];

    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5};
        //System.out.println(getNum(arr, 9));
        System.out.println(dynamicPlanning(arr, 10));
    }
}