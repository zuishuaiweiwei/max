package com.wei;

/**现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 n<=39
 * @author 为为
 * @create 9/17
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        if(n ==1)
        {
            return 0;
        }
        else if(n == 1)
        {
            return 1;
        }
        int a = 0;
        int b = 1;
        for(int i = 2;i<=n;i++)
        {
            int c = b;
            b = b + a;
            a = c;
        }
        return b;
    }
    public static void main(String [] args){

    }
}