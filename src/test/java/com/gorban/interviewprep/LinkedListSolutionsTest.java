package com.gorban.interviewprep;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListSolutionsTest {

    LinkedListSolutions linkedList = new LinkedListSolutions();

    @Test
    void test() {
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        assertEquals(2, linkedList.get(1));
        linkedList.deleteAtIndex(1);
        assertEquals(3, linkedList.get(1));
    }

    @Test
    void hasCycle() {
        LinkedListSolutions.ListNode head = new LinkedListSolutions.ListNode(3);
        LinkedListSolutions.ListNode node1= new LinkedListSolutions.ListNode(2);
        LinkedListSolutions.ListNode node2= new LinkedListSolutions.ListNode(0);
        LinkedListSolutions.ListNode node3= new LinkedListSolutions.ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        assertTrue(linkedList.hasCycle(head));
        assertTrue(linkedList.hasCycle2(head));
        assertEquals(2, linkedList.detectCycle(head).val);
    }

    @Test
    void hasCycle2() {
        LinkedListSolutions.ListNode head = new LinkedListSolutions.ListNode(1);
        LinkedListSolutions.ListNode node1= new LinkedListSolutions.ListNode(2);
        head.next = node1;
        node1.next = head;
        assertTrue(linkedList.hasCycle(head));
        assertTrue(linkedList.hasCycle2(head));
        assertEquals(1, linkedList.detectCycle(head).val);
    }

    @Test
    void hasCycle3() {
        LinkedListSolutions.ListNode head = new LinkedListSolutions.ListNode(1);
        assertFalse(linkedList.hasCycle(head));
        assertFalse(linkedList.hasCycle2(head));
        assertNull(linkedList.detectCycle(head));
    }

    @Test
    void hasCycle4() {
        assertFalse(linkedList.hasCycle(null));
        assertFalse(linkedList.hasCycle2(null));
        assertNull(linkedList.detectCycle(null));
    }

    @Test
    void hasCycle5() {
        LinkedListSolutions.ListNode head = new LinkedListSolutions.ListNode(27);
        LinkedListSolutions.ListNode node1= new LinkedListSolutions.ListNode(-12);
        LinkedListSolutions.ListNode node2= new LinkedListSolutions.ListNode(6);
        LinkedListSolutions.ListNode node3= new LinkedListSolutions.ListNode(29);
        LinkedListSolutions.ListNode node4= new LinkedListSolutions.ListNode(-12);
        LinkedListSolutions.ListNode node5= new LinkedListSolutions.ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        assertFalse(linkedList.hasCycle(head));
        assertFalse(linkedList.hasCycle2(head));
        assertNull(linkedList.detectCycle(head));
    }

    @Test
    void hasCycle6() {
        LinkedListSolutions.ListNode head = new LinkedListSolutions.ListNode(9);
        LinkedListSolutions.ListNode node1= new LinkedListSolutions.ListNode(20);
        LinkedListSolutions.ListNode node2= new LinkedListSolutions.ListNode(14);
        LinkedListSolutions.ListNode node3= new LinkedListSolutions.ListNode(14);
        LinkedListSolutions.ListNode node4= new LinkedListSolutions.ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        assertFalse(linkedList.hasCycle(head));
        assertFalse(linkedList.hasCycle2(head));
        assertNull(linkedList.detectCycle(head));
    }

    @Test
    void removeDuplicates() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,5,1,2,1,9,8,6));
        LinkedList<Integer> expectedList = new LinkedList<>(Arrays.asList(1,5,2,9,8,6));
        assertEquals(expectedList, linkedList.removeDuplicates(list));
    }

    @Test
    void removeDuplicates2() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,5,1,2,1,9,8,6));
        LinkedList<Integer> expectedList = new LinkedList<>(Arrays.asList(1,5,2,9,8,6));
        assertEquals(expectedList, linkedList.removeDuplicates2(list));
    }

    @Test
    void removeDuplicates3() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,5,1,2,1,9,8,6));
        LinkedList<Integer> expectedList = new LinkedList<>(Arrays.asList(1,5,2,9,8,6));
        assertEquals(expectedList, linkedList.removeDuplicates3(list));
    }

    @Test
    void nthToLast() {
        LinkedListSolutions.Node head = new LinkedListSolutions.Node();
        head.appendToTail(1);
        head.appendToTail(5);
        head.appendToTail(1);
        head.appendToTail(2);
        head.appendToTail(1);
        head.appendToTail(9);
        head.appendToTail(8);
        head.appendToTail(6);
        LinkedListSolutions.Node nthToLastNode = linkedList.getNthToLast(head, 3);
        assertEquals(9, nthToLastNode.val);
    }

    @Test
    void reverseList() {
        LinkedListSolutions.ListNode head = new LinkedListSolutions.ListNode(1);
        LinkedListSolutions.ListNode node2 = new LinkedListSolutions.ListNode(2);
        LinkedListSolutions.ListNode node3 = new LinkedListSolutions.ListNode(3);
        LinkedListSolutions.ListNode node4 = new LinkedListSolutions.ListNode(4);
        LinkedListSolutions.ListNode node5 = new LinkedListSolutions.ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LinkedListSolutions.ListNode reversed = linkedList.reverseList(head);
        assertEquals(5, reversed.val);
        assertEquals(4, reversed.next.val);
        assertEquals(3, reversed.next.next.val);
        assertEquals(2, reversed.next.next.next.val);
        assertEquals(1, reversed.next.next.next.next.val);
    }

    @Test
    void mergeTwoLists() {
        LinkedListSolutions.ListNode l1 = new LinkedListSolutions.ListNode(1);
        LinkedListSolutions.ListNode l1Node2 = new LinkedListSolutions.ListNode(2);
        LinkedListSolutions.ListNode l1Node3 = new LinkedListSolutions.ListNode(4);
        l1.next = l1Node2;
        l1Node2.next = l1Node3;

        LinkedListSolutions.ListNode l2 = new LinkedListSolutions.ListNode(1);
        LinkedListSolutions.ListNode l2Node2 = new LinkedListSolutions.ListNode(3);
        LinkedListSolutions.ListNode l2Node3 = new LinkedListSolutions.ListNode(4);
        l2.next = l2Node2;
        l2Node2.next = l2Node3;

        LinkedListSolutions.ListNode mergedList = linkedList.mergeTwoLists2(l1,l2);
        assertEquals(1, mergedList.val);
        assertEquals(1, mergedList.next.val);
        assertEquals(2, mergedList.next.next.val);
        assertEquals(3, mergedList.next.next.next.val);
        assertEquals(4, mergedList.next.next.next.next.val);
        assertEquals(4, mergedList.next.next.next.next.next.val);
    }

    @Test
    void isPalindrome() {
        LinkedListSolutions.ListNode list1 = new LinkedListSolutions.ListNode(1);
        LinkedListSolutions.ListNode l1node2 = new LinkedListSolutions.ListNode(2);
        list1.next = l1node2;
        assertFalse(linkedList.isPalindrome(list1));

        LinkedListSolutions.ListNode list2 = new LinkedListSolutions.ListNode(1);
        LinkedListSolutions.ListNode l2node2 = new LinkedListSolutions.ListNode(2);
        LinkedListSolutions.ListNode l2node3 = new LinkedListSolutions.ListNode(2);
        LinkedListSolutions.ListNode l2node4 = new LinkedListSolutions.ListNode(1);
        list2.next = l2node2;
        l2node2.next = l2node3;
        l2node3.next = l2node4;
        assertTrue(linkedList.isPalindrome(list2));

        LinkedListSolutions.ListNode list3 = new LinkedListSolutions.ListNode(1);
        LinkedListSolutions.ListNode l3node2 = new LinkedListSolutions.ListNode(2);
        LinkedListSolutions.ListNode l3node3 = new LinkedListSolutions.ListNode(3);
        LinkedListSolutions.ListNode l3node4 = new LinkedListSolutions.ListNode(2);
        LinkedListSolutions.ListNode l3node5 = new LinkedListSolutions.ListNode(1);
        list3.next = l3node2;
        l3node2.next = l3node3;
        l3node3.next = l3node4;
        l3node4.next = l3node5;
        assertTrue(linkedList.isPalindrome(list3));
    }
}