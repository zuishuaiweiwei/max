package com.wei;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author 为为
 * @create 9/18
 */
public class ReOrderArray {

    public static void main(String[] args) {
        new ReOrderArray().reOrderArray(new int[]{1, 2, 3, 4, 5});

    }

    /**
     * 不是直接交换两个位置
     * 是依次和前面的位置交换 可以保证相对位置不变
     * @param arr
     * @param index
     * @param i
     */
    public static void swap(int[] arr, int index, int i) {
        for (; i > index; i--) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
    }

    public void reOrderArray(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        int index = 0;
        //找到第一个偶数的位置
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                index = i;
                break;
            }
        }
        //找到奇数
        for (int i = index + 1; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                //依次交换位置
                swap(array, index, i);
                index++;
            }
        }
        for (int ret : array) {
            System.out.print(ret);
        }
    }
}