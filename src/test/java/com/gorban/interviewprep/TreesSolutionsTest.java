package com.gorban.interviewprep;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreesSolutionsTest {

    TreesSolutions trees = new TreesSolutions();

    @Test
    void maxDepth() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(3);
        treeNode.left = new TreesSolutions.TreeNode(9);
        treeNode.right = new TreesSolutions.TreeNode(20);
        treeNode.right.left = new TreesSolutions.TreeNode(15);
        treeNode.right.right = new TreesSolutions.TreeNode(7);
        assertEquals(3, trees.maxDepth(treeNode));
    }

    @Test
    void preorderTraversal() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(1);
        treeNode.right = new TreesSolutions.TreeNode(2);
        treeNode.right.left = new TreesSolutions.TreeNode(3);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1,2,3));
        assertEquals(expectedList, trees.preorderTraversal(treeNode));
    }

    @Test
    void preorderTraversal2() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(1);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1));
        assertEquals(expectedList, trees.preorderTraversal(treeNode));
    }

    @Test
    void preorderTraversal3() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode();
        List<Integer> expectedList = new ArrayList<>();
        assertEquals(expectedList, trees.preorderTraversal(treeNode));
    }

    @Test
    void preorderTraversal4() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(1);
        treeNode.left = new TreesSolutions.TreeNode(2);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1,2));
        assertEquals(expectedList, trees.preorderTraversal(treeNode));
    }

    @Test
    void preorderTraversal5() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(1);
        treeNode.right = new TreesSolutions.TreeNode(2);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1,2));
        assertEquals(expectedList, trees.preorderTraversal(treeNode));
    }

    @Test
    void preorderTraversal6() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(3);
        treeNode.left = new TreesSolutions.TreeNode(1);
        treeNode.right = new TreesSolutions.TreeNode(2);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(3,1,2));
        assertEquals(expectedList, trees.preorderTraversal(treeNode));
    }

    @Test
    void inorderTraversal() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(1);
        treeNode.right = new TreesSolutions.TreeNode(2);
        treeNode.right.left = new TreesSolutions.TreeNode(3);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1,3,2));
        assertEquals(expectedList, trees.inorderTraversal(treeNode));
    }

    @Test
    void postorderTraversal() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(1);
        treeNode.right = new TreesSolutions.TreeNode(2);
        treeNode.right.left = new TreesSolutions.TreeNode(3);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(3,2,1));
        assertEquals(expectedList, trees.postorderTraversal(treeNode));
    }

    @Test
    void levelOrder() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(3);
        treeNode.left = new TreesSolutions.TreeNode(9);
        treeNode.right = new TreesSolutions.TreeNode(20);
        treeNode.right.left = new TreesSolutions.TreeNode(15);
        treeNode.right.right = new TreesSolutions.TreeNode(7);
        List<List<Integer>> expectedList = new ArrayList<>(Arrays.asList(Arrays.asList(3), Arrays.asList(9,20), Arrays.asList(15,7)));
        assertEquals(expectedList, trees.levelOrder(treeNode));
    }

    @Test
    void isSymmetric() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(1);
        treeNode.left = new TreesSolutions.TreeNode(2);
        treeNode.right = new TreesSolutions.TreeNode(2);
        treeNode.left.left = new TreesSolutions.TreeNode(3);
        treeNode.left.right = new TreesSolutions.TreeNode(4);
        treeNode.right.left = new TreesSolutions.TreeNode(4);
        treeNode.right.right = new TreesSolutions.TreeNode(3);
        assertTrue(trees.isSymmetric(treeNode));
    }

    @Test
    void isSymmetric2() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(1);
        treeNode.left = new TreesSolutions.TreeNode(2);
        treeNode.right = new TreesSolutions.TreeNode(2);
        treeNode.left.right = new TreesSolutions.TreeNode(3);
        treeNode.right.right = new TreesSolutions.TreeNode(3);
        assertFalse(trees.isSymmetric(treeNode));
    }

    @Test
    void isSymmetric3() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(1);
        treeNode.left = new TreesSolutions.TreeNode(0);
        assertFalse(trees.isSymmetric(treeNode));
    }

    @Test
    void isSymmetric4() {
        assertTrue(trees.isSymmetric(null));
    }

    @Test
    void isSymmetric5() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(1);
        assertTrue(trees.isSymmetric(treeNode));
    }

    @Test
    void isSymmetric6() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(1);
        treeNode.right = new TreesSolutions.TreeNode(2);
        assertFalse(trees.isSymmetric(treeNode));
    }

    @Test
    void isSymmetric7() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(2);
        treeNode.left = new TreesSolutions.TreeNode(3);
        treeNode.right = new TreesSolutions.TreeNode(3);
        treeNode.left.left = new TreesSolutions.TreeNode(4);
        treeNode.left.right = new TreesSolutions.TreeNode(5);
        treeNode.right.left = new TreesSolutions.TreeNode(4);
        treeNode.right.right = new TreesSolutions.TreeNode(5);
        assertFalse(trees.isSymmetric(treeNode));
    }

    /*
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
     */

    @Test
    void hasPathSum() {
        TreesSolutions.TreeNode treeNode = new TreesSolutions.TreeNode(5);
        treeNode.left = new TreesSolutions.TreeNode(4);
        treeNode.right = new TreesSolutions.TreeNode(8);
        treeNode.left.left = new TreesSolutions.TreeNode(11);
        treeNode.right.left = new TreesSolutions.TreeNode(13);
        treeNode.right.right = new TreesSolutions.TreeNode(4);
        treeNode.left.left.left = new TreesSolutions.TreeNode(7);
        treeNode.left.left.right = new TreesSolutions.TreeNode(2);
        treeNode.right.right.right = new TreesSolutions.TreeNode(1);
        assertTrue(trees.hasPathSum(treeNode, 22));
    }
}