package com.wei;

/**旋转打印方形数组
 * @author 为为
 * @create 9/5
 */
public class SpinPrintNum {

    public  void  print(int [][] arr){
        int[] R ={0,0};
        int[] L ={arr.length-1,arr[arr.length-1].length-1};
        while(R[0]<L[0]){
            core(arr,R,L);
            R[0]++;
            R[1]++;
            L[0]--;
            L[1]--;
            if(R[0]==L[0]){
                System.out.println(arr[R[1]][L[1]]);
            }
        }

    }
    public void core(int[][] arr,int [] R,int L []){
        int rx = R[0];
        int ry = R[1];
        int lx = L[0];
        int ly = L[1];
        while(ry < L[1]){
            System.out.println(arr[rx][ry++]);
        }
        while(rx < L[0]){
            System.out.println(arr[rx++][ry]);
        }
        while(ly > R[0]){
            System.out.println(arr[lx][ly--]);
        }
        while(lx > R[1]){
            System.out.println(arr[lx--][ly]);
        }
    }
    public static  void main(String[] args){
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        new SpinPrintNum().print(arr);
    }
}