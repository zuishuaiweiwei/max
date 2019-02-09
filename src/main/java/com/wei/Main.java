package com.wei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 为为
 * @create 11/12
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        String res = "";
        while (n != 0 && m != 0) {
            long count = 1L;
            for (int i = 0; i < n - 1; i++) {
                count *= n - 1 + m - i;
                count /= (i + 1);
                if (count > k) {
                    break;
                }
            }
            if(count >= k){
                res +="a";
                n--;
            }else{
                res +="z";
                m--;
                k -= count;
            }
        }
        if(k != 1){
            System.out.println(-1);
            return ;
        }
        while(n-- > 0){
            res+="a";
        }
        while(m-- > 0){
            res+="z";
        }
        System.out.println(res);
    }


}