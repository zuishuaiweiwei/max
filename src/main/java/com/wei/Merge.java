package com.wei;

import java.util.LinkedList;
import java.util.Queue;

/**输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * @author 为为
 * @create 9/18
 */
public class Merge {
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
       ListNode node6 = new ListNode(6);
       ListNode node7 = new ListNode(7);
       ListNode node8 = new ListNode(8);
        node1.next =node5;
        node5.next =node6;
        node6.next =node8;

        node2.next =node3;
        node3.next =node4;
        node4.next =node7;

         node1 = new Merge().Merge(node1, node2);
        while(node1!=null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        Queue<ListNode> queue1 = new LinkedList<>();
        Queue<ListNode> queue2 = new LinkedList<>();
        while(list1!=null){
                queue1.offer(list1);
                list1 = list1.next;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode temp = head;
        while(list2!=null){
            queue2.offer(list2);
            list2 = list2.next;
        }
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            ListNode peek1 = queue1.peek();
            ListNode peek2 = queue2.peek();
            if(peek1.val < peek2.val){
                head.next = queue1.poll();
                head = head.next;
            }else if(peek2.val < peek1.val){
                head.next = queue2.poll();
                head = head.next;
            }else{
                head.next = queue2.poll();
                head = head.next;
            }
        }
        while(queue1.isEmpty() && !queue2.isEmpty()){
            head.next = queue2.poll();
            head = head.next;
        }
        while(!queue1.isEmpty() && queue2.isEmpty()){
            head.next = queue1.poll();
            head = head.next;
        }
        return temp.next;
    }
}