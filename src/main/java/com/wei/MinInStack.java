package com.wei;

import java.util.Stack;

/**定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1））。
 * @author 为为
 * @create 9/18
 */
public class MinInStack {

    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack();

    public void push(int node) {
        if(minStack.isEmpty()){
            stack.push(node);
            minStack.push(node);
        }
        if(node > minStack.peek()){
            minStack.push(minStack.peek());
        }else{
            minStack.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(!stack.isEmpty()){
            return  stack.peek();
        }
        return -1;
    }

    public int min() {
        if (!stack.isEmpty()){
         return  minStack.peek();
        }
        return -1;
    }
}