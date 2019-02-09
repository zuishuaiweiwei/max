package com.wei.sort;

/**
 * 排序
 *
 * @author 为为
 * @create 9/3
 */
public class SomeSort {

    /**
     * 归并排序
     * @param arr
     * @param L
     * @param R
     */
    public static void guiBingIndex(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        int mid = L + ((R - L) >> 1);
        guiBingIndex(arr, L, mid);
        guiBingIndex(arr, mid + 1, R);
        sort(arr, L, mid, R);
    }

    public static void sort(int[] arr, int L, int mid, int R) {
        //创建中间数组
        int[] temp = new int[R - L + 1];
        int j = 0;
        //记录左边指针
        int p1 = L;
        //记录右边指针
        int p2 = mid + 1;
        //如果左边右边都没有越界 比较大小
        while (p1 <= mid && p2 <= R) {

            temp[j++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];

        }
        //必有一个越界
        //当p2越界时 将p1剩下的复制到中间数组
        while (p1 <= mid) {
            temp[j++] = arr[p1++];
        }
        //当p1越界时 将p2剩下的复制到中间数组
        while (p2 <= R) {
            temp[j++] = arr[p2++];
        }
        //复制数组
        for (int i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 1, 2, 0};
        //selectedIndex(arr);
        //maoPaoIndex(arr);
        //insertIndex(arr);
        guiBingIndex(arr, 0, arr.length - 1);
        show(arr);
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectedIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[min] > arr[j] ? j : min;
            }
            swap(arr, i, min);
        }

    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void maoPaoIndex(int[] arr) {
        for (int j = 0; j < arr.length; j++) {

            for (int i = 0; i < arr.length - j; i++) {

                if (i != arr.length - 1) {
                    if (arr[i] > arr[i + 1]) {
                        swap(arr, i, i + 1);
                    }
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertIndex(int[] arr) {

        /*for(int i =1; i<arr.length;i++){

            for(int j = i ; j>0 ; j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j-1,j);
                }
            }
        }*/
        for (int i = 1; i < arr.length; i++) {

            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {

                swap(arr, j, j + 1);

            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void show(int[] arr) {
        for (int ret : arr) {
            System.out.print(ret + " ");
        }
    }
}