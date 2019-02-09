package com.wei.test;

/**
 * 1到100的质数
 * @author 为为
 * @create 8/31
 */
public class Test04 {

    public static void main(String[] args){
        /*
        //方式1
        wei:
        for(int i =1; i<=100;i++){
            for(int j=2; j<i-1 ; j++){
                    if(i%j==0){
                        continue wei;
                    }
            }
           // System.out.println("质数有："+i);
        }


        //方式2
        //将第二层循环条件变为数的平方根
        wei:
        for(int i =2; i<=100;i++){
            for(int j=2; j< Math.sqrt(i) ; j++){
                if(i%j==0){
                    continue wei;
                }
            }
            System.out.println("质数有："+i);
        }
*/
        //方式3
        //将第二层循环条件变为数的平方根
        //
        int[] nums = new int[20];
        int num= 0;
        wei:
        for(int i =2; i<=10000;i++){

            for(int j=0; j<num ; j++){
                if(i % nums[j]==0){
                    continue wei;
                }
            }
            if(num==nums.length-1){
                int[] temp = new int[nums.length * 2];
                for(int a = 0;a<num;a++){
                    temp[a] = nums[a];
                }
                 nums  = temp;
            }
            nums[num]=i;
            num++;
        }

        for(int i = 0;i<num;i++){
            System.out.println(nums[i]);
        }


    }
}