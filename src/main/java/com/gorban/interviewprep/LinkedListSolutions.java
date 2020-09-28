package com.gorban.interviewprep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class LinkedListSolutions {

    Node tail = null;
    Node head = null;
    int length = 0;
    /**
     * Initialize your data structure here.
     */
    public LinkedListSolutions() {
        head = new Node();
        tail = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node node = head.next;
        if (index == length - 1) {
            return tail.val;
        } else if (index >= length) {
            return -1;
        } else {
            for (int i = 0; i < index; ++i) {
                node = node.next;
            }
            return node.val;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        if (length == 0) {
            tail = node;
        }
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        tail.next = node;
        tail = tail.next;
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == length) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else if (index > length) {
            return;
        } else {
            Node node = new Node(val);
            Node pre = head;
            for (int i = 0; i < index; ++i) {
                pre = pre.next;
            }
            node.next = pre.next;
            pre.next = node;
            length++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= length) {
            return;
        }
        Node pre = head;
        for (int i = 0; i < index; ++i) {
            pre = pre.next;
        }
        if (pre.next == tail) {
            pre.next = null;
            tail = pre;
        } else {
            pre.next = pre.next.next;
        }
        length--;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode cur = head;
        ListNode slowRunner;
        ListNode fastRunner;

        for (int i = 0; i < 10_000; i++) {
            if (cur.next == null) {
                return false;
            }
            if (cur.next.next != null) {
                slowRunner = cur.next.next;
                if (cur.val == slowRunner.val) {
                    return true;
                }
            } else {
                return false;
            }
            if (slowRunner.next != null) {
                fastRunner = slowRunner.next;
                if (cur.val == fastRunner.val && cur.next.val == fastRunner.next.val) {
                    return true;
                }
            } else {
                return false;
            }
            cur = cur.next;
        }
        return false;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public ListNode(int x, ListNode next) {
            val = x;
            next = next;
        }
    }

    public static class Node {
        public int val = 0;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }

        public Node() {}

        public void appendToTail(int val){
            Node tail = new Node(val);
            Node current = this;
            while (current.next != null){
                current = current.next;
            }
            current.next = tail;
        }
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowRunner = head;
        ListNode fastRunner = head;

        slowRunner = slowRunner.next;
        fastRunner = fastRunner.next.next;

        while (fastRunner != null && fastRunner.next != null && slowRunner != fastRunner) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        if (fastRunner == null || fastRunner.next == null) {
            return false;
        }
        return true;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slowRunner = head;
        ListNode fastRunner = head;

        slowRunner = slowRunner.next;
        fastRunner = fastRunner.next.next;
        int index = 0;

        while (fastRunner != null && fastRunner.next != null) {
            index++;
            if (slowRunner == fastRunner){
                if (index == 2) {
                    return slowRunner;
                } else {
                    return fastRunner.next;
                }
            } else {
                slowRunner = slowRunner.next;
                fastRunner = fastRunner.next.next;
            }
        }
        if (fastRunner == null || fastRunner.next == null) {
            return null;
        }
        return null;
    }

    // O(N^2)
    public LinkedList<Integer> removeDuplicates(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size() - 1; j++){
                if(list.get(i) == list.get(j)){
                    list.remove(j);
                }
            }
        }

        return list;
    }

    // O(N)
    public LinkedList<Integer> removeDuplicates2(LinkedList<Integer> list){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++){
            if (set.contains(list.get(i))){
                list.remove(i);
            } else {
                set.add(list.get(i));
            }
        }

        return list;
    }

    // Stream API
    public LinkedList<Integer> removeDuplicates3(LinkedList<Integer> list){
        return list.stream().distinct().collect(Collectors.toCollection(LinkedList::new));
    }

    public Node getNthToLast(Node head, int nthToLast){
        // nthToLast should be less than or equal amount of elements in Node
        if (head == null){
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < nthToLast; i++){
            p1 = p1.next;
        }

        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public ListNode reverseList(ListNode head) {
        ListNode duplicated = head;
        ListNode cur = head;
        ListNode last = head;
        int nodeLength = 0;
        while (duplicated != null){
            nodeLength++;
            duplicated = duplicated.next;
        }

        for (int i = 0; i < nodeLength / 2; i++){
            for (int j = i + 1; j < nodeLength - i; j++){
                last = last.next;
            }
            int temp = cur.val;
            cur.val = last.val;
            last.val = temp;
            cur = cur.next;
            last = cur;
        }

        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(-1);
        ListNode result = mergedList;
        ListNode longerList;
        ListNode shorterList;
        if (getListLength(l1) >= getListLength(l2)){
            longerList = l1;
            shorterList = l2;
        } else {
            longerList = l2;
            shorterList = l1;
        }

        while (longerList != null){
            if (shorterList!=null){
                int val1;
                int val2;
                if (longerList.val <= shorterList.val){
                    val1 = longerList.val;
                    val2 = shorterList.val;
                } else {
                    val1 = shorterList.val;
                    val2 = longerList.val;
                }
                mergedList = new ListNode(val1, new ListNode(val2));
                mergedList = mergedList.next;

                longerList = longerList.next;
                shorterList = shorterList.next;
            } else {
                mergedList.next = longerList;
                longerList = longerList.next;
            }
        }

        return result.next;
    }

    private int getListLength(ListNode list){
        int length = 0;
        while(list != null){
            length++;
            list = list.next;
        }
        return length;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);
        ListNode ptr = merged;
        while(l1 != null || l2 != null){
            int val1;
            int val2;
            if(l1 == null){
                ptr.next = l2;
                break;
            }
            if(l2 == null){
                ptr.next = l1;
                break;
            }
            else{
                val1 = l1.val;
                val2 = l2.val;
            }
            if(l1.val > l2.val){
                ptr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else{
                ptr.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            ptr = ptr.next;
        }
        return merged.next;
    }

    public boolean isPalindrome(ListNode head) {
        int listLength = getLength(head);
        if (listLength <= 1){
            return true;
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < listLength / 2; i++){
            stack.push(head.val);
            head = head.next;
        }

        if (listLength % 2 != 0){
            head = head.next;
        }

        while (head != null){
            if (head.val != stack.pop()){
                return false;
            }
            head = head.next;
        }

        return true;
    }

    private int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }



}
