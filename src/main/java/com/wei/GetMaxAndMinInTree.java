package com.wei;

/**
 * 二叉树中最大数和最小数
 *
 * @author 为为
 * @create 10/13
 */
public class GetMaxAndMinInTree {

    public static class Type {
        private int max;
        private int min;

        public Type(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Type core(Node head) {
        if (head == null) {
            return new Type(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Type left = core(head.left);
        Type right = core(head.right);
        return new Type(Math.max(head.value, Math.max(left.max, right.max)), Math.min(head.value, Math.min(left.min, right.min)));
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Type core = core(node1);
        System.out.println(core.max);
        System.out.println(core.min);
    }
}