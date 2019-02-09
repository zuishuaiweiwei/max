package com.wei;

/**二叉树上两个节点的最长距离
 * @author 为为
 * @create 10/13
 */
public class GetMaxLengthOfAnyNode {
    public static class Node{
        private Node left;
        private Node right;
        private int value;
        public Node(int value) {
            this.value = value;
        }
    }
    public static class Type{
        private int deepLength;
        private int maxLength;
        public Type(int deepLength, int maxLength) {
            this.deepLength = deepLength;
            this.maxLength = maxLength;
        }
    }
    public static Type process(Node head){
        if(head == null){
            return new Type(0,0);
        }
        Type left = process(head.left);
        Type right = process(head.right);
        //两边最大的深度
        int maxDeep =Math.max(left.deepLength,right.deepLength);
        //两边最大的长度
        int maxLength = Math.max(left.maxLength,right.maxLength);
        //包括自己的最大长度
        int includeSelf = left.deepLength+right.deepLength +1;
        return new Type(maxDeep + 1,Math.max(includeSelf,maxLength));
    }
    public static void main(String [] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node4.left = node5;
        node5.left = node6;
        node6.left = node7;
        node7.left = node8;

        Type process = process(node1);
        System.out.println(process.maxLength);
    }
}