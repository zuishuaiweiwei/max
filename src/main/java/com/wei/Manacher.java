package com.wei;

/**
 * 最大回文子串
 *
 * @author 为为
 * @create 9/25
 */
public class Manacher {
    /**
     * 正常写法
     * @param arr
     * @return
     */
    public static int normal(char[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return arr.length;
        }
        int[] radius = new int[arr.length*2+1];
        arr = first(arr);
        int i = 0;
        while (i < arr.length - 1) {
            int j = 1;
            //下标超界
            if (!(i - j >= 0 && i + j < arr.length - 1)) {
                radius[i++] = j;
            }else{
                while (i - j >= 0 && i + j < arr.length  &&arr[i - j] == arr[i + j]) {
                    j++;
                }
                radius[i++] = j;
            }
        }
        int ret = -1;
        for (int p : radius) {
            if (p > ret) {
                ret = p;
            }
        }
        return ret/2;
    }

    public static int Manacher(char [] arr){
        //回文半径值
        int[] radius = new int[arr.length*2+1];
        //最右回文的位置
        int max = -1;
        //最右是以那个位置为中心的
        int res = -1;
        int ret = Integer.MIN_VALUE;
        //加上辨识符号
        arr = first(arr);
        for(int i = 0;i < arr.length;i++){
            radius[i] = max > i ?Math.min(radius[2 * res - i],max - i) : 1;
            while(i + radius[i] < arr.length && i - radius[i] > -1){
                if(arr[i + radius[i]] == arr[ i - radius[i]]){
                    radius[i]++;
                }else{
                    break;
                }
            }
            if(i + radius[i] > max){
                max = i + radius[i];
                res = i;
            }
            ret = Math.max(ret,radius[i]/2);
        }
        return ret  ;
    }

    /**
     * 数组的每一位两边加上辨识符号
     * 偶数和奇数的差异抵消
     * @param arr
     * @return
     */
    public static char[] first(char[] arr) {
        char[] chars = new char[arr.length * 2 + 1];
        int j = 0;
        for (int i = 0; i != chars.length; i++) {
           chars[i]  = ( i & 1) == 0 ? '#' :arr[j++];
        }
        return chars;

    }

    public static void main(String[] args) {
        String str = "aasdf1a1a1fdsaa";
        System.out.println(normal(str.toCharArray()));
        System.out.println(Manacher(str.toCharArray()));
    }
}