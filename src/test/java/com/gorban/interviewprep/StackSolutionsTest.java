package com.gorban.interviewprep;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class StackSolutionsTest {
    StackSolutions stackSolutions = new StackSolutions();

    @Test
    public void getMinStackValue(){
        StackSolutions.MyStack stack = new StackSolutions.MyStack();
        stack.push(5);
        assertEquals(5, stack.getMin());
        stack.push(7);
        stack.push(9);
        stack.push(4);
        stack.push(6);
        assertEquals(4, stack.getMin());
        assertEquals(6, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals(5, stack.getMin());
    }

    @Test
    public void stackOfPlates(){
        StackSolutions.StackOfPlates stackOfPlates = new StackSolutions.StackOfPlates(2);
        stackOfPlates.pushStackAt(0, 1);
        stackOfPlates.pushStackAt(0, 2);
        stackOfPlates.pushStackAt(0, 3);
        stackOfPlates.pushStackAt(0, 4);
        assertEquals(2, stackOfPlates.getStackAmount());
        assertEquals(3, stackOfPlates.popStackAt(0));
        assertEquals(4, stackOfPlates.popStackAt(1));
    }

    @Test
    public void checkQueueOnStacks(){
        StackSolutions.QueueOnStacks<Integer> queueOnStacks = new StackSolutions.QueueOnStacks<>();
        queueOnStacks.add(1);
        assertEquals(1, queueOnStacks.getSize());
        queueOnStacks.add(2);
        queueOnStacks.add(3);
        assertEquals(1, queueOnStacks.peek());
        queueOnStacks.add(4);
        assertEquals(1, queueOnStacks.remove());
        assertEquals(2, queueOnStacks.peek());
    }

    @Test
    public void checkQueueOnStacks2() {
        StackSolutions.QueueOnStacks<String> queueOnStacks = new StackSolutions.QueueOnStacks<>();
        queueOnStacks.add("alpha");
        assertEquals(1, queueOnStacks.getSize());
        queueOnStacks.add("beta");
        queueOnStacks.add("gamma");
        assertEquals("alpha", queueOnStacks.peek());
        queueOnStacks.add("teta");
        assertEquals("alpha", queueOnStacks.remove());
        assertEquals("beta", queueOnStacks.peek());
    }

    @Test
    void sortStack() {
        Stack<Integer> unsortedStack = new Stack<>();
        unsortedStack.push(1);
        unsortedStack.push(3);
        unsortedStack.push(2);
        Stack<Integer> sortedStack = stackSolutions.sortStack(unsortedStack);
        Stack<Integer> expectedStack = new Stack<>();
        expectedStack.push(3);
        expectedStack.push(2);
        expectedStack.push(1);
        assertTrue(Arrays.equals(expectedStack.toArray(), sortedStack.toArray()));
    }
}