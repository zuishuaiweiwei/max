package com.wei;

/**递归分治找到最大数
 * @author 为为
 * @create 9/3
 */
public class GetMax {

    public static int getMax(int [] arr,int l,int r){
        if(l == r){
            return arr[l];
        }
        //int mid= (l+r)/2;
        int mid = l+((r-l)>>1);
        int left = getMax(arr, l , mid);
        int right = getMax(arr, mid + 1, r);

        return left>right?left:right;
    }
    public static void main(String[] args){
        int [] arr ={1,2,3,5,6,1,9,99};

        int max = getMax(arr,0,arr.length-1);
        System.out.println(max);
    }
}