package com.wei;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * @author 为为
 * @create 9/18
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        print(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, list);
        return (ArrayList<Integer>) list;
    }

    public ArrayList print(int[][] arr, int x1, int y1, int x2, int y2, List result) {

        if (x1 < x2 && y1 < y2) {
            for (int i = y1; i < y2; i++) {
                result.add(arr[x1][i]);
            }
            for (int i = x1; i < x2; i++) {
                result.add(arr[i][y2]);
            }
            for (int i = y2; i > y1; i--) {
                result.add(arr[x2][i]);
            }
            for (int i = x2; i > x1; i--) {
                result.add(arr[i][y1]);
            }
            print(arr, ++x1, ++y1, --x2, --y2, result);
        } else if (x1 < x2 && y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                result.add(arr[i][y1]);
            }
        } else if (x1 == x2 && y1 < y2) {
            for (int i = y1; i <= y2; i++) {
                result.add(arr[x1][i]);
            }
        } else if (x1 == x2 && y1 == y2) {
            result.add(arr[x1][y1]);
        } else {
            return (ArrayList) result;
        }
        return (ArrayList) result;
    }

    public static void main(String[] args) {
        //1 2 3 6 9 8 7 4 5
        //int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        //1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        //int [][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //1 2 3 4 5 10 15 20 25 24 23 22 21 16 11 6 7 8 9 14 19 18 17 12 13
        //int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        //1 2 3 4 5 10 15 14 13 12 11 6 7 8 9
        //int [][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        //1 2 3 6 9 12 15 14 13 10 7 4 5 8 11
        int [][]arr = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
        ArrayList<Integer> list = new PrintMatrix().printMatrix(arr);
        for (Integer ret : list) {
            System.out.print(ret + " ");
        }
    }
}