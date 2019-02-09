package com.wei;

/**
 * 找出无序数组中第k小的数
 * 1 分组，排序 得到中位数数组
 * 2 中位数数组排序
 * 3 得到所有中位数组成数组的中位数
 * 4 用这个值当作划分值 进行类似荷兰国旗问题的步骤
 * 5 如果相等区域的坐标和k相等或包含 返回这个数
 * 如果 不等 递归调用左边和右边 直到找到
 *
 * @author 为为
 * @create 10/8
 */
public class BFPRT {

    public static int Bfprt(int[] arr, int k) {

        return core(arr, 0, arr.length - 1, k);
    }

    /**
     * 核心
     *
     * @param arr
     * @param begin
     * @param end
     * @param k
     * @return
     */
    public static int core(int[] arr, int begin, int end, int k) {
        if (begin == end) {
            return arr[begin];
        }
        int num = getNum(arr, begin, end);
        //进行荷兰国旗步骤 返回相等区域的左右坐标
        int[] partition = partition(arr, num);
        if (partition[0] <= k && partition[1] >= k) {
            return arr[partition[0]];
        } else if (k < partition[0]) {
            return core(arr, 0, partition[0] - 1, k);
        } else {
            return core(arr, partition[1] + 1, arr.length - 1, k);
        }

    }

    /**
     * 得到中位数的中位数
     *
     * @param arr
     * @return
     */
    public static int getNum(int[] arr, int begin, int end) {
        arr = copyArray(arr);
        int p = 5;
        int ff = end - begin + 1;
        int offset = ff % 5 == 0 ? 0 : 1;
        int[] mid = new int[ff / 5 + offset];
        for (int i = 0; i < mid.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mid[i] = getMidNum(arr, beginI, Math.min(end, endI));
        }
        return core(mid, 0, mid.length - 1, mid.length / 2);

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] copyArray(int [] arr){
        int[] copy = new int[arr.length];
        for(int i = 0; i < arr.length;i++){
            copy[i] = arr[i];
        }
        return copy;
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[min] > arr[j] ? j : min;
            }
            swap(arr, i, min);
        }
        return arr;
    }

    /**
     * 排序
     *
     * @param arr
     * @param num 参考数
     */
    public static int[] partition(int[] arr, int num) {
        arr = copyArray(arr);

        int[] ret = new int[2];
        int begin = 0;
        int end = arr.length - 1;
        int cur = 0;
        while (cur != end) {
            if (arr[cur] < num) {
                swap(arr, cur++, begin++);
            } else if (arr[cur] > num) {
                swap(arr, cur, end--);
            } else {
                cur++;
            }
        }
        ret[0] = begin;
        ret[1] = end - 1;
        return ret;
    }

    /**
     * 获得中位数数组
     *
     * @param arr
     * @return
     */
    public static int getMidNum(int[] arr, int begin, int end) {
        arr = copyArray(arr);

        int[] temp = new int[end - begin + 1];
        int j = 0;
        for (int i = begin; i <= end; i++) {
            temp[j++] = arr[i];
        }
        temp = sort(temp);
        return temp[temp.length / 2];
    }

    public static void main(String[] args) {

        int []arr = new int[]{2,3,2,5,88,76,34,25,45,56,23};
        System.out.print(Bfprt(arr, 5));

    }
}