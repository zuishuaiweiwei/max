package com.wei.test;

/**
 * 有0到99的数和一个0-99的随机重复数 在101个数中找到重复的数
 * @author 为为
 * @create 8/31
 */
public class Test01 {

    public static void main(String[] args){

        int [] arr = new int[101];
        for(int i = 0; i<arr.length;i++){
            arr[i]=i;
        }
        int random =(int) Math.floor(Math.random()*100);
        System.out.println("随机数为"+random);
        arr[100]=random;
        int temp;
        for(int i =0;i<10000;i++){
            int a =(int) Math.floor(Math.random()*101);
            int b =(int) Math.floor(Math.random()*101);
            temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        /*

        //方式1
        for(int i =0;i<arr.length;i++){
            for(int j = i+1 ;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    System.out.println("方式1---重复的数为："+arr[i]);
                }
            }
        }

        //方式2
        int sum=0;
        for(int i =0;i<arr.length;i++){
            sum+=arr[i];
        }
        for(int i=0;i<=99;i++){
            sum-=i;
        }
        System.out.println("方式2--重复的数为："+sum);
   */
        //方式3
        for(int i =1;i<arr.length;i++){
            arr[0]= arr[0] ^ arr[i];
        }
        for(int i =0;i<100;i++){
            arr[0] = arr[0] ^ i;
        }

        System.out.println("方式3--重复的数为："+arr[0]);
    }
}