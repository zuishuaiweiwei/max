package com.wei.sort;

import java.util.Stack;

/**
 * 栈作为队列结构
 * @author 为为
 * @create 9/4
 */
public class StackIsQueue {

    private Stack data = new Stack();
    private Stack help = new Stack();

    public void add(int i) {
        data.add(i);
    }

    public int poll() {

        if (!help.empty()) {
            return (int) help.pop();
        }
        if (data.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException(" 队列空");
        }
        while (!data.empty()) {
            int pop = (int) data.pop();
            help.add(pop);
        }
        int ret = (int) help.pop();

        return ret;
    }

    public static void main(String[] args) {
        StackIsQueue queue = new StackIsQueue();
        //queue.poll();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        int size = queue.data.size();
        for (int i = 0; i < size; i++) {
            int poll = queue.poll();
            System.out.println(poll);
        }
    }
}