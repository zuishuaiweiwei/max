package com.wei;

/**
 * 二叉树中最大搜索二叉树
 *
 * @author 为为
 * @create 10/13
 */
public class GetMaxSearchTreeInTree {

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static class Type {
        private int size;
        private Node head;
        private int max;
        private int min;

        public Type(int size, Node head, int max, int min) {
            this.size = size;
            this.head = head;
            this.max = max;
            this.min = min;
        }
    }

    public static Type search(Node head) {
        if (head == null) {
            return new Type(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        int self = 0;
        Type left = search(head.left);
        Type right = search(head.right);
        //如果以自己为头的整棵树都是搜索二叉树 二叉树大小 + 1
        if (left.head == head.left && right.head == head.right && left.max < head.data && right.min > head.data) {
            self = right.size + left.size + 1;
        }
        //三种情况最大值
        int maxSize = Math.max(right.size, Math.max(self, left.size));
        //确定搜索二叉树的头节点
        Node retHead = left.size > right.size ? left.head : right.head;
        if (maxSize == self) {
            retHead = head;
        }
        return new Type(maxSize, retHead,
                Math.max(head.data, Math.max(left.max, right.max)),
                Math.max(self, Math.min(left.min, right.min))
        );

    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        Node node3 = new Node(11);
        Node node4 = new Node(4);
        Node node5 = new Node(6);
        Node node6 = new Node(8);
        Node node7 = new Node(12);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
        Type search = search(node1);
        System.out.println(search.size);
    }
}