package com.wei;

/**
 * @author 为为
 * @create 10/17
 */
public class NStepsInKPosition {
    /**
     * 走steps步之后 停留在aim位置有几种方式
     * <p>
     * 暴力递归
     *
     * @param N     1-N的位置
     * @param cur   起始位置
     * @param steps 剩余步数
     * @param aim   目标位置
     * @return
     */
    public static int process(int N, int cur, int steps, int aim) {
        if (N < 2 || cur > N || steps < 0 || aim > N) {
            return 0;
        }
        if (steps == 0) {
            return cur == aim ? 1 : 0;
        }
        int res = 0;
        if (cur == 0) {
            res += process(N, cur + 1, steps - 1, aim);
        } else if (cur == N) {
            res += process(N, cur - 1, steps - 1, aim);
        } else {
            res += process(N, cur + 1, steps - 1, aim) + process(N, cur - 1, steps - 1, aim);
        }
        return res;
    }

    /**
     * 动态规划版本
     *
     * @param N
     * @param cur
     * @param steps
     * @param aim
     * @return
     */
    public static int dynamicPlanning(int N, int cur, int steps, int aim) {
        int[][] dp = new int[steps + 1][N + 1];
        dp[0][aim] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j > 0 && j < N) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[dp.length - 1][cur];
    }

    public static void main(String[] args) {
        System.out.println(process(5, 1, 3, 2));
        System.out.println(dynamicPlanning(5, 1, 3, 2));
    }
}