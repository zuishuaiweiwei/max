package com.wei;

import java.util.Scanner;

/**
 * @author 为为
 * @create 11/12
 */
public class IntegerInversion {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int aim = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }
        System.out.println(process(m,aim));
    }
    public static Integer process(int n,int m) {
        if(n<1 || m<1){
            return 0;
        }
        int sum = 0;
        if(n == m){
            sum++;
        }
        sum+=process(n-1,m);
        sum+=process(n-1,m-n);
        return sum;
    }
}