package com.wei;

import java.util.LinkedList;
/**
 * 窗口内最大值
 *
 * @author 为为
 * @create 10/9
 */
public class GetMaxInWindow {

    public static int[] getMaxNum(int[] arr, int size) {

        int[] ret = new int[arr.length - size + 1];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                list.pollLast();
            }
            list.addLast(i);
            if (list.peekFirst() == i - size) {
                list.pollFirst();
            }
            if (i >= size - 1) {
                ret[index++] = arr[list.peekFirst()];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 3, 1, 6, 7};
        getMaxNum(arr, 3);
    }
}