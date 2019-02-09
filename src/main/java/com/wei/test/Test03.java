package com.wei.test;

import java.util.Scanner;

/**
 * @author 为为
 * @create 8/31
 */
public class Test03 {

    public static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String [] string ={"小孩","青年","成年","迟暮","老人"};
        System.out.println(string[Integer.parseInt(s)/10]);
    }
}