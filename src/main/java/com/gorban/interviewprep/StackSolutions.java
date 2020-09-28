package com.gorban.interviewprep;

import java.util.Iterator;
import java.util.Stack;

public class StackSolutions {

    public Stack<Integer> sortStack(Stack<Integer> unsortedStack) {
        Stack<Integer> sortedStack = new Stack<>();

        int max = Integer.MIN_VALUE;
        for (Integer i : unsortedStack) {
            for (int j = 0; j < unsortedStack.size(); j++) {
                if (unsortedStack.get(j) > max && !sortedStack.contains(unsortedStack.get(j))) {
                    max = unsortedStack.get(j);
                }
            }
            sortedStack.push(max);
            max = Integer.MIN_VALUE;
        }

        return sortedStack;
    }

    public static class MyStack {
        private int defaultCapacity = 10;
        private int min = Integer.MAX_VALUE;
        private int length = 0;

        private int[] arr;

        public MyStack() {
            arr = new int[this.defaultCapacity];
        }


        public MyStack(int capacity) {
            arr = new int[capacity];
        }

        public void push(int value) {
            if (length < defaultCapacity) {
                arr[length++] = value;
                if (value < min) {
                    min = value;
                }
            }
        }

        public int pop() {
            int val = 0;
            if (length >= 1) {
                int pos = length - 1;
                val = arr[pos];
                arr[pos] = 0;
                length--;
                if (val == min) {
                    min = Integer.MAX_VALUE;
                    for (int i = length - 1; i >= 0; i--) {
                        if (arr[i] < min) {
                            min = arr[i];
                        }
                    }
                }
            }
            return val;
        }

        public int getMin() {
            return min;
        }
    }

    public static class StackOfPlates {
        private int stackThreshold = 3;
        private int stacksAmount = 2;
        private MyStack[] stacksArr;

        public StackOfPlates(int stacksAmount) {
            stacksArr = new MyStack[stacksAmount];
            for (int i = 0; i < stacksAmount; i++) {
                stacksArr[i] = new MyStack(stackThreshold);
            }
        }

        public int getStackAmount() {
            return stacksAmount;
        }

        public void pushStackAt(int stackIndex, int stackValue) {
            if (stackIndex < stacksAmount) {
                if (stacksArr[stackIndex].length < stackThreshold) {
                    stacksArr[stackIndex].push(stackValue);
                } else {
                    stacksArr[stackIndex + 1].push(stackValue);
                }
            }
        }

        public int popStackAt(int stackIndex) {
            int returnedVal = 0;
            if (stackIndex < stacksAmount) {
                returnedVal = stacksArr[stackIndex].pop();
            }
            return returnedVal;
        }
    }

    public static class QueueOnStacks<T> {

        private Stack<T> newestStack;
        private Stack<T> oldestStack;

        public QueueOnStacks() {
            newestStack = new Stack<T>();
            oldestStack = new Stack<T>();
        }

        public int getSize() {
            return newestStack.size() + oldestStack.size();
        }

        public void add(T item) {
            newestStack.push(item);
        }

        public T peek() {
            if (oldestStack.isEmpty()) {
                refreshStacks();
            }
            return oldestStack.peek();
        }

        private void refreshStacks() {
            while (!newestStack.isEmpty()) {
                oldestStack.push(newestStack.pop());
            }
        }

        public T remove() {
            if (oldestStack.isEmpty()) {
                refreshStacks();
            }
            return oldestStack.pop();
        }
    }

}
