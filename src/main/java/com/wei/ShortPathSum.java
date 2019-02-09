package com.wei;

/**最短路径和
 * @author 为为
 * @create 9/24
 */
public class ShortPathSum {

    /**
     * 暴力递归
     * @param arr
     * @param i
     * @param k
     * @return
     */
    public static int core(int [][]arr,int i,int k){
        if(i ==arr.length-1 && k == arr[0].length-1){
            return arr[i][k];
        }
        if(i == arr.length-1 ){
            return arr[i][k]+core(arr,i,k+1);
        }
        if(k==arr[0].length-1){
            return arr[i][k] + core(arr,i+1,k);
        }
        int right = core(arr,i,k+1);
        int down = core(arr,i+1,k);
        return arr[i][k]+Math.min(right,down);
    }

    /**
     * 动态规划版本
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int core2(int[][] arr,int i,int j){
        int[][] ints = new int[arr.length][arr[0].length];
        ints[ints.length-1][ints[0].length-1] = arr[arr.length-1][arr[0].length-1];
        for(int k =ints[0].length-2 ;k >=0;k--){
            ints[ints.length-1][k] =arr[ints.length-1][k]+ ints[ints.length-1][k+1];
        }
        for(int k =ints.length-2 ;k >= 0;k--){
            ints[k][ints[0].length-1] =arr[k][ints[0].length-1]+ ints[k+1][ints[0].length-1];
        }
        return process(arr,ints,arr.length-2,arr[0].length-2);
    }
    public static int process(int [][] arr,int[][] ints,int i,int j){
        if(i ==0 && j==0){
            return arr[i][j]+Math.min(ints[i+1][j],ints[i][j+1]);
        }
        int jj =j;
        int ii =i;
        for(;j >= 0 ; j--){
            ints[i][j] = arr[i][j] + Math.min(ints[i][j+1],ints[i+1][j]);
        }
        j =jj;
        for(i = i-1;i >= 0 ; i--){
            ints[i][j] =arr[i][j] + Math.min(ints[i+1][j],ints[i][j+1]);
        }
        i = ii;
        return process(arr,ints,--i,--j);
    }
    public static void main(String[] args){
        int[][] arr = {{1,1,1},{1,2,3},{0,2,2}};
        System.out.println(core(arr,0,0));
        System.out.println(core2(arr,0,0));
    }
}