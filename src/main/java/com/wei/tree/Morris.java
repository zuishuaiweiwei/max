package com.wei.tree;
/**
 * Mirris遍历二叉树
 * 当前节点为cur
 * cur无左孩子 向右移动
 * cur有左孩子，找到cur左树上最右的节点 记为MostRight，
 * 如果mostRight的right 指向null 让其 指向cur cur向左移动
 * 如果mostRight的right 指向cur 让其指向null cur 向右移动
 *
 * @author 为为
 * @create 10/10
 */
public class Morris {
    public static class Node {
        private int data;
        private Node left;
        private Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 遍历
     *
     * @param head
     */
    public static void morris(Node head) {
        //当前节点
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;
            //如果有左子数 没有直接向右移动
            if (mostRight != null) {
                //找到最右的节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else if (mostRight.right == cur) {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    /**
     * 先序打印
     *
     * @param head
     */
    public static void morrisPre(Node head) {
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.print(cur.data + " ");
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.print(cur.data + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * 中序打印
     *
     * @param head
     */
    public static void morrisMid(Node head) {
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.data + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * 后序打印
     *返回两次时打印左子数右边界
     * 退出时打印整棵树的右边界
     * @param head
     */
    public static void morrisLast(Node head) {
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else if (mostRight.right == cur) {
                    mostRight.right = null;
                    print(cur.left);
                }
            }
            cur = cur.right;
        }
        print(head);
    }

    /**
     * 反转右子树
     * @param head
     */
    public static Node reverse(Node head) {
        Node cur = head;
        Node temp = head.right;
        head.right = null;
        while (temp != null) {
            head = temp;
            temp = temp.right;
            head.right = cur;
            cur = head;
        }
        return head;
    }

    public static void print(Node head) {
        if (head.right == null) {
            System.out.print(head.data + " ");
            return;
        }
        //反转 返回头节点
        head = reverse(head);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
        //恢复原样
        reverse(head);
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

        morrisPre(node1);
        morrisMid(node1);
        morrisLast(node1);
    }
}