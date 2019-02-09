package com.wei;

import java.util.Stack;

/**用两个栈来实现一个队列，完成队列的Push和Pop操作。
 *  队列中的元素为int类型。
 * @author 为为
 * @create 9/17
 */
public class StackIsQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String []args){
        StackIsQueue queue = new StackIsQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}