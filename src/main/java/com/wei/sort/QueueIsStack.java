package com.wei.sort;

import java.util.LinkedList;
import java.util.Queue;

/**队列作为栈结构
 * @author 为为
 * @create 9/4
 */
public class QueueIsStack {

    private static Queue data = new LinkedList();
    private static Queue help = new LinkedList();

    public void push(int i){
        data.add(i);
    }
    public int pop (){
        if(data.size()==0){
            throw new ArrayIndexOutOfBoundsException(" 栈空");
        }
        while(data.size()>1){
            int poll = (int) data.poll();
            help.add(poll);
        }
        int ret = (int) data.poll();
        Queue temp = data;
        data = help;
        help = temp;
        return ret;
    }

    public static void main(String[] args){
        QueueIsStack stack = new QueueIsStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int size = data.size();
        for(int i =0;i<size;i++){
            int pop = stack.pop();
            System.out.println(pop);
        }
    }
}