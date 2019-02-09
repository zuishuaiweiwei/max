package com.wei;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回
 *
 * @author 为为
 * @create 9/17
 */
public class ReConstructBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 1 && in.length == 1) {
            return new TreeNode(pre[0]);
        }
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        // 取出头节点
        TreeNode head = new TreeNode(pre[0]);
        int headIndex = 0;
        //找到头节点在中序遍历的位置
        for (int i = 0; i < in.length; i++) {
            if (in[i] == head.val) {
                headIndex = i;
                break;
            }
        }
        //树的中序遍历左子树
        int[] inLeft = new int[headIndex];
        //树的中序遍历右子树
        int[] inRight = new int[in.length - headIndex - 1];
        for (int i = 0; i < headIndex; i++) {
            inLeft[i] = in[i];
        }
        int j = 0;
        for (int i = headIndex + 1; i < in.length; i++) {
            inRight[j++] = in[i];
        }
        //树的前序遍历左子树
        int[] preLeft = new int[headIndex];
        //树的前序遍历右子树
        int[] preRight = new int[pre.length - headIndex - 1];
        for (int i = 1; i <= headIndex; i++) {
            preLeft[i - 1] = pre[i];
        }
        j = 0;
        for (int i = headIndex + 1; i < in.length; i++) {
            preRight[j++] = pre[i];
        }
        //递归
        TreeNode left = reConstructBinaryTree(preLeft, inLeft);
        TreeNode right = reConstructBinaryTree(preRight, inRight);
        head.left = left;
        head.right = right;
        return head;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = new ReConstructBinaryTree().reConstructBinaryTree(pre, in);
        System.out.println(treeNode);
    }
}