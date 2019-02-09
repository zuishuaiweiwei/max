package com.wei;

/**
 * 是否为平衡二叉树
 *
 * @author 为为
 * @create 10/13
 */
public class IsBalanceTree {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Type {
        private int left;
        private int right;

        public Type(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public static class NewType {
        private int h;
        private boolean isB;
        public NewType(int h, boolean isB) {
            this.h = h;
            this.isB = isB;
        }
    }

    public static boolean core(Node head){
        Type process = process(head);
        if(Math.abs(process.left - process.right) > 1){
            return false;
        }else {
            return true;
        }
    }
    public static boolean newCore(Node head){
        return newProcess(head).isB;
    }

    /**方法1
     * 这样必须完全遍历整棵树 浪费资源
     * @param head
     * @return
     */
    public static Type process(Node head) {
        if (head == null) {
            return new Type(0, 0);
        }
        Type left = process(head.left);
        Type right = process(head.right);
        int maxLeft = Math.max(left.left, left.right) + 1;
        int maxRight = Math.max(right.left, right.right) + 1;
        return new Type(maxLeft,maxRight);
    }

    /**方法2
     * 传入一个头节点
     * 一次递归左边和右边
     * 有一个为false 直接返回
     * @param head
     * @return
     */
    public static NewType newProcess(Node head) {
        if (head == null) {
            return new NewType(0,true);
        }
        NewType left = newProcess(head.left);
        if(!left.isB){
            return new NewType(0,false);
        }
        NewType right = newProcess(head.right);
        if(!right.isB){
            return new NewType(0,false);
        }
        if(Math.abs(left.h - right.h) > 1){
            return new NewType(0,false);
        }
        return   new NewType(Math.max(left.h,right.h) + 1,true);
    }

    public static void main(String []args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6= new Node(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = node5;
        node5.left = node6;
        System.out.println(core(node1));
        System.out.println(newCore(node1));
    }
}