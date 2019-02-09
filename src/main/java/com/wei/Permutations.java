package com.wei;

/**数字不重复的全排列
 * @author 为为
 * @create 9/24
 */
public class Permutations {

    public static void core(char[] arr, int i, int p) {
        if (i == p) {
            for (char temp : arr) {
                System.out.print(temp);
            }
            System.out.println();
            return;
        } else {
            for (int k = i; k <= p; k++) {
                swap(arr, k, i);
                core(arr, i + 1, p);
                swap(arr, k, i);
            }
        }
    }

    public static void swap(char[] arr, int i, int p) {
        char temp = arr[i];
        arr[i] = arr[p];
        arr[p] = temp;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        core(arr, 0, arr.length - 1);
    }
}