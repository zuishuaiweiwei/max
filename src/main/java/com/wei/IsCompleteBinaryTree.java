package com.wei;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 是否为完全二叉树
 * 按行遍历
 * 有右无左 false
 * 出现有左无右之后所有的节点都是叶节点 true 否则 false
 *
 * @author 为为
 * @create 10/15
 */
public class IsCompleteBinaryTree {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(head);
        boolean flag = false;
        while (!queue.isEmpty()) {
            head = queue.poll();
            Node left = head.left;
            Node right = head.right;
            if (flag && (left != null || right != null) || (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null || right == null) {
                flag = true;
            }
        }
        return true;
    }
}