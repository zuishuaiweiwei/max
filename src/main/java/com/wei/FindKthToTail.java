package com.wei;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author 为为
 * @create 9/18
 */
public class FindKthToTail {

    public static class Node {
        private int val;
        private Node next = null;

        Node(int val) {
            this.val = val;
        }
    }


    /**
     * 先全部入栈
     * 出栈k次
     * @param head
     * @param k
     * @return
     */
    public Node FindKthToTail(Node head, int k) {
        if(head ==null){
            return null;
        }
        Stack<Node> stack = new Stack<>();
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
       Node pop = null;
        if(k > stack.size()){
            return null;
        }
        for(int i = 0 ;i < k ;i++){
             pop = stack.pop();
        }
        return pop;
    }

    /**
     * 一个快指针一个慢指针
     * 快指针先走k步
     * 然后一起走
     * 快指针为null
     * 慢指针就为倒数第k个数
     * @param head
     * @param k
     * @return
     */
    public Node FindKthToTail2(Node head, int k) {
        Node fast = head;
        Node slow = head;
        for(int i = 0; i<k ;i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String []args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next =node2;
        node2.next =node3;
        node3.next =node4;
        node4.next =node5;

        Node listNode = new FindKthToTail().FindKthToTail(node1, 2);
        Node listNode1 = new FindKthToTail().FindKthToTail2(node1, 2);
        System.out.println(listNode.val);
        System.out.println(listNode1.val);
    }
}