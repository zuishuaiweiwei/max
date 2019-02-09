package com.wei.sort;

/**
 * 堆排序
 * @author 为为
 * @create 9/4
 */
public class HeapSort {


    public static void heapSort(int[] arr) {


        //先变成大根堆
        for (int j = arr.length - 1; j > 0; j--) {
            heapInsert(arr, j);
        }

        //得到最大的数 放到最后面
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        //变化交换后的堆
        while (heapSize > 0) {
            heapFly(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 变成大根堆
     *
     * @param arr
     * @param i
     */
    public static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     * 元素变化后 从新排序变成大根堆
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapFly(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int max = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            if (arr[index] < arr[max]) {
                swap(arr, index, max);
                index = max;
                left = 2 * index + 1;

            } else {
                break;
            }
        }

    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void show(int[] arr) {
        for (int p : arr) {
            System.out.print(p + "  ");
        }
        System.out.println("\n");
    }

    public static int [] randomArr(int size){
        int[] arr = new int[size];
        for(int i = 0;i<arr.length;i++){

            arr[i]=(int) (Math.random() * 31);
        }
        return arr;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
        int[] arr = randomArr(10);
        heapSort(arr);
        show(arr);

        }
    }

}
