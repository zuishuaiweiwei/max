package com.wei.sort;

/**
 * @author 为为
 * @create 9/3
 */
public class QuickSort {

    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {

            swap(arr,L+(int)(Math.random()*(R-L)),R);
            int[] sort = sort(arr, L, R);
            quickSort(arr,L,sort[0]-1);
            quickSort(arr,sort[1]+1,R);
        }
    }

    public static int[] sort(int[] arr, int L, int R) {
        int less = L - 1;
        int great = R;
        while (L < great) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr,--great,L);
            } else {
                L++;
            }
        }
        swap(arr,great,R);
        //if(){}
        return new int[]{less+1,great};
    }

    public static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
       /* arr[L] = arr[L] ^ arr[R];
        arr[R] = arr[L] ^ arr[R];
        arr[L] = arr[L] ^ arr[R];*/
    }

    public static void show(int[] arr){
        for(int ret:arr){
            System.out.println(ret);
        }
    }

    public static int [] randomArr(int size){
        int[] arr = new int[size];
        for(int i = 0;i<arr.length;i++){

            arr[i]=(int) (Math.random() * 31);
        }
        return arr;
    }
    public static void main(String[] args) {
        for(int i =0;i<10;i++){
            int[] arr = randomArr(10);
            quickSort(arr, 0, arr.length - 1);
            show(arr);
        }

    }
}