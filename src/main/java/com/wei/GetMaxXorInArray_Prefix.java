package com.wei;

/**
 * 求子数组中最大的异或和
 *
 * @author 为为
 * @create 10/16
 */
public class GetMaxXorInArray_Prefix {

    /**
     * 三层for循环 得到每一个子数组的异或和 求出最大
     *
     * @param arr
     * @return
     */
    public static int GetMax1(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int res = 0;
            res ^= arr[i];
            //每一位单独的数字；
            max = Math.max(res, max);
            for (int start = 0; start <= i; start++) {
                res = 0;
                for (int k = start; k <= start; k++) {
                    res ^= arr[k];
                }
                //start - i 上最大的结果
                max = Math.max(res, max);
            }
        }
        return max;
    }

    /**
     * 双层for循环
     * 用dp数组记录零到每个位置的异或和
     * 用 a ^ b = c 的条件
     * 得出     c ^ a = b
     * c ^ b = a 的结论
     *
     * @param arr
     * @return
     */
    public static int GetMax2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        //遍历的总异或和
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
            max = Math.max(res, max);
            //start - i 上所有子数组的异或和
            for (int start = 1; start <= i; start++) {
                // start - i 上的异或和
                int ret = dp[start - 1] ^ res;
                max = Math.max(max, ret);
            }
            //记录当前i位置的总异或和
            dp[i] = res;
        }
        return max;
    }

    /**
     * 用前缀树解决 只需遍历一遍
     *
     * @param arr
     * @return
     */
    public static int getMaxXor(int[] arr) {
        int max = Integer.MIN_VALUE;
        //当前i位置的总异或和
        int res = 0;
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.addTree(0);
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
            max = Math.max(max, prefixTree.getMaxXor(res));
            prefixTree.addTree(res);
        }
        return max;
    }

    /**
     * 前缀树节点
     */
    public static class Node {
        private Node[] next = new Node[2];
    }

    public static class PrefixTree {
        private Node head = new Node();

        /**
         * 建立前缀树
         *
         * @param num
         */
        public void addTree(int num) {
            Node current = head;
            for (int i = 31; i >= 0; i--) {
                //&1 为了只保留最后一位数字 其余归0
                int temp = ((num >> i) & 1);
                //依次建立节点
                current.next[temp] = current.next[temp] == null ? new Node() : current.next[temp];
                current = current.next[temp];
            }
        }

        /**
         * 输入一个i位置的总异或和
         * 返回一个0 - i 位置的最大异或和
         * @param num
         * @return
         */
        public int getMaxXor(int num) {
            Node current = head;
            int res = 0;
            for (int i = 31; i >= 0; i--) {
                //&1 为了只保留最后一位数字 其余归0
                int temp = ((num >> i) & 1);
                //符号位期望走和符号位相同的数 ，其余 期望走 ^1 之后的值
                int best = (i == 31) ? temp : (temp ^ 1);
                //实际选的值
                best = current.next[best] != null ? best : (best ^ 1);
                //设置每一位的数值
                res |= ((best ^ temp) << i);
                current = current.next[best];
            }
            return res;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(getMaxXor(arr));
    }
}