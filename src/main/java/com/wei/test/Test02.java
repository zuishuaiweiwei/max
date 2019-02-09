package com.wei.test;

/**
 * 0 - 99 随机排布的数 随机替换一个重复数 找出重复的数
 * @author 为为
 * @create 8/31
 */
public class Test02 {

    public static void main(String[] args){
        int arr[] = new int[100];
        for(int i =0 ;i<arr.length;i++){
            arr[i]=i;
        }
        int random = (int) Math.floor(Math.random() * 100);
        System.out.println("随机数为："+random);
        int position = (int) Math.floor(Math.random() * 100);
        arr[position]=random;



        int temp=0;
        for(int i =0;i<500;i++){
            int a = (int) Math.floor(Math.random() * 100);
            int b = (int) Math.floor(Math.random() * 100);
            temp = arr[a];
            arr[a] = arr[b];
            arr[b] =temp;
        }
       //==================================
        //方式1
        for(int i=0;i<arr.length;i++){
            for(int j =i+1 ;j<arr.length;j++){
                if(arr[j]==arr[i]){
                    System.out.println("方式1---随机数为："+arr[i]);
                }
            }
        }

        //方式2
        int[] ret = new int[100];
        for(int i =0;i<arr.length;i++){
            ret[arr[i]]++;
            if(ret[i]==2){
                System.out.println("方式2---随机数为："+i);
            }
        }

    }
}