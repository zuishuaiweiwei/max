package com.wei;

import java.util.ArrayList;

/**
 * 跳表
 *
 * @author 为为
 * @create 10/15
 */
public class MySkipList {

    public static class SkipListNode {
        private Integer value;
        private ArrayList<SkipListNode> nexts = new ArrayList();

        public SkipListNode(Integer value) {
            this.value = value;
        }
    }

    public static class SkipList {
        private SkipListNode head;
        private Integer maxLevel;
        private int size;
        private static final double PROBABLY = 0.5;

        public SkipList() {
            this.head = new SkipListNode(null);
            this.maxLevel = 0;
            this.size = 0;
            head.nexts.add(null);
        }

        public void add(int value) {
            if (!isContain(value)) {
                int level = 1;
                while (Math.random() < PROBABLY) {
                    level++;
                }
                if (level > maxLevel) {
                    while (level > maxLevel) {
                        head.nexts.add(null);
                        maxLevel++;
                    }
                }
                SkipListNode node = new SkipListNode(value);
                SkipListNode current = head;
                int i = maxLevel;
                System.out.println(level);
                do {
                    //返回这一层刚好比value小的node
                    current = findNext(current, value, i);
                    //到指定层数时开始创建节点
                    if (i <= level) {
                        //建立这一层的新node
                        node.nexts.add(0, current.nexts.get(i));
                        //这一层的next指向新node
                        current.nexts.set(i, node);
                    }
                } while (--i > 0);
                node.nexts.add(0, null);
                size++;
            }
        }

        /**
         * 在这一层中找到刚好小于value的SkipListNode
         *
         * @param current 当前SkipListNode
         * @param value   value
         * @param level   层数
         * @return SkipListNode
         */
        public SkipListNode findNext(SkipListNode current, int value, int level) {
            SkipListNode next = current.nexts.get(level);
            while (next != null) {
                if (next.value > value) {
                    break;
                }
                current = next;
                next = next.nexts.get(level);
            }
            return current;
        }

        /**
         * 返回value=aim的节点
         *
         * @param value
         * @return
         */
        public SkipListNode find(int value) {
            int level = maxLevel;
            SkipListNode current = head;
            do {
                current = findNext(current, value, level);
                if (current != null && current.value != null && current.value.equals(value)) {
                    return current;
                }
            }
            while (--level > 0);
            return null;
        }

        /**
         * 删除value为aim的节点
         *
         * @param value
         */
        public void delete(int value) {
            SkipListNode node = find(value);
            int level = maxLevel;
            SkipListNode current = head;
            SkipListNode next = null;
            if (node != null) {
                do {
                    current = findNext(current, value, level);
                    if (node.nexts.size() >= level) {
                        next.nexts.set(level, current.nexts.get(level));
                    }
                    next = current;
                } while (level-- > 0);
            }
            size--;
        }

        /**
         * 是否包含节点
         *
         * @param value
         * @return
         */
        public boolean isContain(int value) {
            return find(value) != null ? true : false;
        }


        public SkipListNode getHead() {
            return head;
        }
    }

    public static void main(String[] args) {
        SkipList list = new SkipList();
        list.add(10);
        list.add(8);
        list.add(5);
        System.out.println(list.isContain(5));
    }
}