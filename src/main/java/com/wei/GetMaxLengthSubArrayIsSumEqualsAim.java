package com.wei;

import java.util.TreeMap;

/**
 * 求一个数组最长子数组 要求数组的和为aim
 *
 * @author 为为
 * @create 10/12
 */
public class GetMaxLengthSubArrayIsSumEqualsAim {


    public static int core(int[] arr, int aim) {
        int maxLength = 0;
        //遍历位置的和
        int sum = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            //如果这个sum - aim 不是第一次出现
            if (treeMap.containsKey(sum - aim)) {
                //返回当前位置减去第一次出现sum - aim 的位置
                maxLength = Math.max(maxLength, i - treeMap.get(sum - aim));
            }
            //如果sum第一次出现
            if(!treeMap.containsKey(sum)){
                treeMap.put(sum,i);
            }
        }
        return maxLength;
    }

    public static int xor(int[] arr) {
        int ans = 0;
        int xor = 0;
        int [] dp =new int [arr.length];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            System.out.print(xor+" ");
            //如果异或的值出现过
            if (treeMap.containsKey(xor)) {
                Integer index = treeMap.get(xor);
                dp[i] = index == -1 ? 1 : dp[index] + 1;
            }
            if( i > 0){
                dp[i] = Math.max(dp[i -1],dp[ i ]);
            }
            treeMap.put(xor,i);
            ans = Math.max(ans , dp[i]);

        }
        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 1, 1, 7, 5};
        int[] arr2 ={1,2,3,4,3,2,1};
        System.out.println(core(arr, 2));
        System.out.print(xor(arr2));
    }
}