package com.wei;

/**
 * 旋转正方形数组
 *
 * @author 为为
 * @create 9/5
 */
public class SpinNum {

    public static void print(int[][] arr) {
        int rx = 0;
        int ry = 0;
        int lx = arr[0].length - 1;
        int ly = arr[0].length - 1;
        while (rx < lx) {
            core(arr, rx, ry, lx, ly);
            rx = ++ry;
            lx = --ly;

        }
    }

    public static void core(int[][] arr, int rx, int ry, int lx, int ly) {
        int tiems = lx - rx;
        for (int i = 0; i < tiems; i++) {
            int temp = arr[rx][ry + i];
            arr[rx][ry + i] = arr[lx - i][ry];
            arr[lx - i][ry] = arr[lx][ly - i];
            arr[lx][ly - i] = arr[rx + i][ly];
            arr[rx + i][ly] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        print(arr);
    }
}