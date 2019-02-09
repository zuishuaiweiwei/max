package com.wei;

/**
 * 字符串是否包含子串
 * KMP算法
 * @author 为为
 * @create 9/25
 */
public class Kmp {

    public static int Kmp(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] aim = str2.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = nextArray(aim);
        while (i < arr1.length && j < aim.length) {
            if (arr1[i] == aim[j]) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == aim.length ? i - j : -1;
    }

    /**
     * 返回数组每个位置的最大前缀和后缀相等的值
     * @param arr
     * @return
     */
    public static int[] nextArray(char[] arr) {
        int[] ret = new int[arr.length];
        if (arr.length == 1) {
            ret[0] = -1;
            return ret;
        }
        ret[0] = -1;
        //跳到的位置
        int i = 0;
        //遍历的位置
        int now = 2;
        while (now < arr.length) {
            if (arr[now - 1] == arr[i]) {
                ret[now++] = ++i;
            } else if (i > 0) {
                i = ret[i];
            } else {
                ret[now++] = 0;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String str = "ababcabscs";
        String aim = "bs";
        System.out.println(Kmp(str,aim));
    }
}