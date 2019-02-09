package com.wei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 单调栈
 * 在无序数组中找到 左右两边离的最近的大于本身的值
 *
 * @author 为为
 * @create 10/10
 */
public class MonotonyStack {

    public static class Pri {
        private Integer left;
        private Integer right;

        public Pri(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 栈设置为从大到小 ，
     * 所以如果入栈的值大于栈顶元素，
     * 栈顶元素左边最近的大于它的就是它的下面的元素 ，右边就是让他出栈的元素
     * <p>
     * 遍历完栈里面如果还有元素 右边没有最大 左边的最大就是它下面的元素
     *
     * @param arr
     * @return
     */
    public static Map core(int[] arr) {
        //单调栈
        Stack<Integer> stack = new Stack<>();
        //返回结构
        HashMap<Integer, Integer[]> map = new HashMap<>(16);
        for (int i = 0; i < arr.length; i++) {
            //如果栈不为空 栈顶元素小于 aim
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                if (!stack.isEmpty()) {
                    map.put(stack.pop(), new Integer[]{stack.isEmpty() ? null : arr[stack.peek()], arr[i]});
                } else {
                    map.put(stack.pop(), new Integer[]{null, arr[i]});
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), new Integer[]{stack.isEmpty() ? null : arr[stack.peek()], null});
        }
        return map;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 9, 6, 9, 1};
        Map map = core(arr);
        Integer[] value = (Integer[]) map.get(4);
        System.out.println(value[0]);
        System.out.println(value[1]);
    }
}