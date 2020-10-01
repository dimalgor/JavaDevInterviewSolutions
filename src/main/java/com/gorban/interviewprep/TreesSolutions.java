package com.gorban.interviewprep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreesSolutions {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return checkDepth(root);
    }

    private int checkDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = checkDepth(node.left);
        int rightDepth = checkDepth(node.right);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return list;
    }

//    Input: root = [1,null,2,3]
//    Output: [1,3,2]

    //      1
    //    /   \
    // null    2
    //        /
    //       3

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null){
            traverseTreeInOrder(root, list);
            return list;
        }
        return list;
    }

    private void traverseTreeInOrder(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        traverseTreeInOrder(node.left, list);
        list.add(node.val);
        traverseTreeInOrder(node.right, list);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null){
            traverseInPostOrder(root, list);
            return list;
        }

        return list;
    }

    private void traverseInPostOrder(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        traverseInPostOrder(node.left, list);
        traverseInPostOrder(node.right, list);
        list.add(node.val);
    }

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        int val;

        public TreeNode() {
        }

        ;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
