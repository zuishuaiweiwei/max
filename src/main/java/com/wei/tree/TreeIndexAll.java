package com.wei.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 树的全遍历
 *
 * @author 为为
 * @create 9/6
 */
public class TreeIndexAll {

    /**
     * 节点类型
     */
    public static class Node {
        private int data;
        private Node left;
        private Node right;


        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 递归遍历
     *
     * @param node
     */
    public static void print(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "  ");
        print(node.left);
        print(node.right);

    }

    /**
     * 先序遍历
     *
     * @param node
     */
    public static void firstPrint(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.data + "  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void MidPrint(Node node) {

        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {

            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.data + "  ");
                node = node.right;
            }
        }


    }


    /**
     * 后序遍历
     *
     * @param node
     */
    public static void LastPrint(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> ret = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            ret.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!ret.isEmpty()) {
            System.out.print(ret.pop().data + "  ");
        }

    }

    /**
     * 先序序列化
     *
     * @param node
     * @return
     */
    public static String serialiable(Node node) {
        if (node == null) {
            return "#_";
        }
        StringBuffer ret = new StringBuffer(node.data + "_");
        ret.append(serialiable(node.left));
        ret.append(serialiable(node.right));
        return ret.toString();
    }

    /**
     * 先序反序列化
     *
     * @param s
     * @return
     */
    public static Node revSerialiable(String s) {
        String[] arr = s.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }

        Node node = createTreeByQueue(queue);


        return node;

    }

    public static Node createTreeByQueue(Queue<String> queue) {
        String s = queue.poll();
        if ("#".equals(s)) {
            return null;
        }
        Node node = new Node(Integer.parseInt(s));
        node.left = createTreeByQueue(queue);
        node.right = createTreeByQueue(queue);
        return node;
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

        //1  2  4  5  3  6  7
        //4  2  5  1  6  3  7
        //4  5  2  6  7  3  1
        print(node1);
        System.out.println("\n");
        //firstPrint(node1);
        //System.out.println("\n");
        //MidPrint(node1);
        //LastPrint(node1);
//        String s = serialiable(node1);
//        System.out.println(s);
//        Node node = revSerialiable(s);
//        print(node);


    }
}