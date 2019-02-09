package com.wei;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @author 为为
 * @create 9/17
 */
public class PrintListFromTailToHead {

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if(listNode == null){
            return null;
        }
        while(listNode !=null ){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){

            list.add(stack.pop());
        }
        return  list;
    }
    public static void main(String []args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ArrayList<Integer> list = new PrintListFromTailToHead().printListFromTailToHead(node1);
        for(Integer integer:list){
            System.out.println(integer);
        }
    }
}