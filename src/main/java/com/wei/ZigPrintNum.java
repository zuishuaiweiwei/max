package com.wei;


/**
 * Z字形打印数组
 *
 * @author 为为
 * @create 9/5
 */
public class ZigPrintNum {


    public static void print(int[][] arr) {
        int[] U = {0, 0};
        int[] D = {0, 0};
        boolean flag = false;
        while (U[0] != arr.length) {
            core(arr, U, D, flag);
            flag = !flag;
            U[0] = U[1] == arr[0].length - 1 ? ++U[0] : U[0];
            U[1] = U[1] == arr[0].length - 1 ? U[1] : ++U[1];
            D[1] = D[0] == arr.length - 1 ? ++D[1] : D[1];
            D[0] = D[0] == arr.length - 1 ? D[0] : ++D[0];
        }
    }

    public static void core(int[][] arr, int[] U, int[] D, boolean flag) {
        int ur = U[0];
        int ul = U[1];
        int dr = D[0];
        int dl = D[1];

        if (flag) {
            while (ur != dr + 1) {
                System.out.println(arr[ur++][ul--]);
            }
        } else {
            while (dl != ul + 1) {
                System.out.println(arr[dr--][dl++]);

            }
        }

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        print(arr);

    }
}