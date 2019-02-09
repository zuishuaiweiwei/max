package com.wei;

import java.util.HashMap;

/**LUR缓存结构
 * 双向队列+Map
 * Map直接得到内存地址
 * 队列改变优先级
 * @author 为为
 * @create 10/13
 */
public class LUR {
    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class MyLinkedList {
        private Node head;
        private Node last;

        public void add(Node node) {
            if (node == null) {
                return;
            }
            if (head == null) {
                head = node;
                last = node;
                return;
            }
            last.right = node;
            node.left = last;
            last = node;
        }

        public Node remove(Node node) {
            if (head == null || node == null) {
                return null;
            }
            if (last == node) {
                last = last.left;
                last.right = null;
                return node;
            }
            if (head == node) {
                head = head.right;
                head.left = null;
                return node;
            }
            node.left.right = node.right;
            node.right.left = node.left;
            node.left = null;
            node.right = null;
            return node;
        }

        public void change(Node node) {
            if (last == node) {
                return;
            }
            if (head == node) {
                head = node.right;
                node.right = null;
                head.left = null;
                last.right = node;
                node.left = last;
                last = node;
                return;
            }
            node.left.right = node.right;
            node.right.left = node.left;
            node.left = last.right;
            node.right = null;
            last = node;
        }
    }

    public static class MyCache {
        private HashMap<Integer, Node> key_value;
        private HashMap<Node, Integer> value_key;
        private MyLinkedList list;
        int cache = 0;

        public MyCache(int cache) {
            if (cache < 1) {
                System.out.println("cache should more than 0");
                return;
            }
            this.cache = cache;
            key_value = new HashMap();
            value_key = new HashMap();
            list = new MyLinkedList();
        }

        public void set(int key, int value) {

            if (key_value.containsKey(key)) {
                Node node = key_value.get(key);
                node.value = value;
                list.change(node);
            } else {
                Node node = new Node(value);
                list.add(node);
                key_value.put(key, node);
                value_key.put(node, key);
                if (key_value.size() == cache + 1) {
                    node = list.remove(list.head);
                    int removeKey = value_key.get(node);
                    key_value.remove(removeKey);
                    value_key.remove(node.value);
                }

            }
        }

        public Integer get(int key) {
            if (key_value.containsKey(key)) {
                Node node = key_value.get(key);
                list.change(node);
                return node.value;
            }
            return null;
        }

        public Integer remove(int key) {
            if (key_value.containsKey(key)) {
                Node node = key_value.get(key);
                Node remove = list.remove(node);
                key_value.remove(key);
                value_key.remove(remove);
                return remove.value;
            }
            return null;
        }

    }

    public static void main(String[] args) {
        MyCache cache = new MyCache(3);
        cache.set(1, 11);
        cache.set(2, 22);
        cache.set(3, 33);
        cache.set(4, 44);
        cache.get(2);
        System.out.println();
    }
}