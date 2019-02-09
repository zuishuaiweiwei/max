package com.wei;

/**在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author 为为
 * @create 9/17
 */
public class Solution {

    public boolean Find(int target, int [][] array) {
        int i =0;
        int j =array[i].length-1;

        while(i>=0 && j >= 0&&i<array.length && j<array[0].length ){
            int temp = array[i][j];
            if(temp < target){
                i++;
            }else if(temp > target){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[]args){
        int [][] arr ={{1,2,3},
                       {4,5,6},
                       {7,8,9},
                       {10,11,12} };
        System.out.println(new Solution().Find(1,arr));
    }
}