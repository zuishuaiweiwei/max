package com.wei;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author 为为
 * @create 9/18
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String []args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
       ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
       ListNode node5 = new ListNode(5);
        node1.next =node2;
        node2.next =node3;
        node3.next =node4;
        node4.next =node5;

        node1 = new ReverseList().ReverseList(node1);
        while(node1!=null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
    public  ListNode ReverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode ret ;
        ListNode temp ;
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
         ret = stack.pop();
         temp = ret;
        while(!stack.isEmpty()){
            ListNode pop = stack.pop();
            pop.next = null;
            temp.next = pop;
            temp = pop;
        }
        return ret;
    }
}