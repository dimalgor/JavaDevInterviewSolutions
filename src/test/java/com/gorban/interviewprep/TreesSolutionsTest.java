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
}