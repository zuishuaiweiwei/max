package com.wei;

import java.util.ArrayList;
import java.util.List;

/**最大值
 * 每个节点都有一个值
 * 子节点不能和直接父节点一起出现
 * 求最大值
 * @author 为为
 * @create 10/13
 */
public class GetMaxHuoYueInTree {

    public static class Node{
        private List<Node> nexts = new ArrayList();
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Type{
        /**
         * 出现的活跃值
         */
        private int t_value;
        /**
         * 未出现的活跃值
         */
        private int f_value;
        public Type(int t_huo, int f_huo) {
            this.t_value = t_huo;
            this.f_value = f_huo;

        }
    }

    /**
     * 返回这个节点 出现和未出现的两种值
     * 交给父过程判断来或者不来
     * @param head
     * @return
     */
    public static Type process(Node head){
        if(head == null){
            return new Type(0,0);
        }
        int t_value = head.value;
        int f_value = 0;
        for(int i =0; i<head.nexts.size(); i++){
            Type type = process(head.nexts.get(i));
            t_value += type.f_value;
            f_value += Math.max(type.t_value,type.f_value);
        }
        return new Type(t_value,f_value);
    }
    public static void main(String []args){
        Node node1 = new Node(4);
        Node node2 = new Node(1);
        Node node3 = new Node(4);
        Node node4 = new Node(1);
        Node node5 = new Node(2);
        Node node6 = new Node(3);
        node1.nexts.add(node2);
        node1.nexts.add(node3);
        node2.nexts.add(node4);
        node4.nexts.add(node5);
        node4.nexts.add(node6);
        Type process = process(node1);
        System.out.println(process.f_value);
        System.out.println(process.t_value);

    }
}