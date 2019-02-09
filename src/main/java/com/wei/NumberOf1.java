package com.wei;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 *
 * @author 为为
 * @create 9/18
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int i = 1;
        int result = 0;
        int temp = n;
        if (n < 0) {
            temp = Math.abs(n);
        }
        while (temp >= Math.pow(2, i)) {
            i++;
        }
        int[] arr = new int[32];
        for (int j = i - 1; j >= 0 && temp!=0; j--) {
            if (temp > Math.pow(2, j)) {
                arr[arr.length - j-1] = 1;
                temp = (int) (temp - Math.pow(2, j));
            }else if (temp == Math.pow(2, j)) {
                arr[arr.length - j-1] = 1;
                break;
            }
        }
        if( n < 0){
            for(int j = 0;j<arr.length;j++){
                if(arr[j]==1){
                    arr[j] =0;
                }else if(arr[j ]== 0){
                    arr[j] = 1;
                }
            }
            arr[arr.length-1] = arr[arr.length-1] +1;
            for(int j = arr.length-1; j >=0;j--){
                if(arr[j] == 1 || arr[j] ==0 ){
                    break;
                }
                arr[j] = 0;
                arr[j-1] = arr[j-1]+1;
            }
        }
       for(int j = 0; j <arr.length ; j++){
           System.out.print(arr[j]);
           if(arr[j] == 1){
                result++;
            }
       }
        System.out.println();

        return result;
    }
    public static void main(String[] args) {
        int length = Integer.toBinaryString(-2220000).replaceAll("0", "").trim().length();
        String s = Integer.toBinaryString(-2220000);
        System.out.println(new NumberOf1().NumberOf1(-2220000));
        System.out.println(length);
        System.out.println(s);
    }
}