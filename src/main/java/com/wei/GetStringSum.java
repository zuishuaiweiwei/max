package com.wei;

import java.util.Stack;

/**
 * 计算字符串类型的数学式子
 *
 * @author 为为
 * @create 10/14
 */
public class GetStringSum {

    public static int core(String str) {
        return process(str.toCharArray(), 0)[0];
    }

    public static int[] process(char[] str, int index) {

        Stack<String> stack = new Stack<>();
        int i = index;
        int pre = 0;
        while (i < str.length && str[i] != ')') {
            //如果是数字
            if (str[i] >= '0' && str[i] <= '9') {
                pre = pre * 10 + str[i] - '0';
                i++;
            }
            //如果是 + - * /
            else if (str[i] != '(') {
                addSum(stack, pre);
                stack.push(String.valueOf(str[i]));
                pre = 0;
                i++;
            }
            //如果是（
            else {
                int[] process = process(str, i + 1);
                pre = process[0];
                i = process[1] + 1;
            }
        }
        addSum(stack, pre);
        return new int[]{getSum(stack), i};
    }

    /**
     * 遇到符号计算
     *
     * @param stack
     * @param num
     */
    public static void addSum(Stack<String> stack, int num) {
        if (stack.size() == 0) {
            stack.push(String.valueOf(num));
        } else {
            if (stack.peek().equals("*")) {
                stack.pop();
                int pre = Integer.parseInt(stack.pop());
                pre *= num;
                stack.push(String.valueOf(pre));
            } else if (stack.peek().equals("/")) {
                stack.pop();
                int pre = Integer.parseInt(stack.pop());
                pre /= num;
                stack.push(String.valueOf(pre));
            } else {
                stack.push(String.valueOf(num));
            }
        }
    }

    public static int getSum(Stack<String> stack) {
        Stack<String> res = new Stack<>();
        while (!stack.isEmpty()) {
            res.push((stack.pop()));
        }
        boolean flag = true;
        boolean isNum = true;
        int ret = 0;
        while (!res.isEmpty()) {
            if (isNum) {
                int num = Integer.parseInt(res.pop());
                if (flag) {
                    ret += num;
                } else {
                    ret -= num;
                }
                isNum = !isNum;
            } else {
                if (res.peek().equals("+")) {
                    flag = true;
                } else {
                    flag = false;
                }
                res.pop();
                isNum = !isNum;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String str = "1+2+(2+2)*5";
        System.out.println(core(str));

    }
}