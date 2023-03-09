package _3_Stacks_and_Queues._1_Three_in_One;

import java.util.EmptyStackException;

// QUESTION
// Describe how you could use a single array to implement three stacks
// SOLUTION
// Approach 1: Fixed Division
// We can divide the array in three equal parts and allow the individual stack to grow in that limited space.
// Note: We will use the notation "[" to mean inclusive of an end point and "(" to mean exclusive of an end
// point.
// For stack 1, we will use [0, n/3).
// For stack 2, we will use [ n/3 , 2n/3 ) .
// For stack 3, we will use [ 2n/3 , n) .
public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapcacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize){
        stackCapcacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    // push
    public void push(int stackNum, int value) throws StackOverflowError {
        if(isFull(stackNum)){
            throw new StackOverflowError();
        }
        // increment stack pointer and then update top value
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    // pop
    public int pop(int stackNum) {
        if(isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex]; // get top
        values[topIndex] = 0; // clear
        sizes[stackNum]--; // shrink
        return value;
    }

    // peek
    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    // return if stuck is empty
    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }

    // return if stack is full
    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapcacity;
    }

    // return index of the top of the stack
    public int indexOfTop(int stackNum){
        int offset = stackNum * stackCapcacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    // TEST
    public static void main(String[] args) {
        FixedMultiStack stack = new FixedMultiStack(3);

        // Push elements onto the first stack
        stack.push(0, 1);
        stack.push(0, 2);
        stack.push(0, 3);

        // Push elements onto the second stack
        stack.push(1, 4);
        stack.push(1, 5);
        stack.push(1, 6);

        // Push elements onto the third stack
        stack.push(2, 7);
        stack.push(2, 8);
        stack.push(2, 9);

        // Test peek and pop on each stack
        System.out.println("Peek stack 1: " + stack.peek(0)); // should print 3
        System.out.println("Pop stack 1: " + stack.pop(0)); // should print 3
        System.out.println("Peek stack 2: " + stack.peek(1)); // should print 6
        System.out.println("Pop stack 2: " + stack.pop(1)); // should print 6
        System.out.println("Peek stack 3: " + stack.peek(2)); // should print 9
        System.out.println("Pop stack 3: " + stack.pop(2)); // should print 9

        // Test if stacks are empty
        System.out.println("Stack 1 is empty: " + stack.isEmpty(0)); // should print false
        System.out.println("Stack 2 is empty: " + stack.isEmpty(1)); // should print false
        System.out.println("Stack 3 is empty: " + stack.isEmpty(2)); // should print false

        // Test if stacks are full
        System.out.println("Stack 1 is full: " + stack.isFull(0)); // should print false
        System.out.println("Stack 2 is full: " + stack.isFull(1)); // should print false
        System.out.println("Stack 3 is full: " + stack.isFull(2)); // should print false

        // Push more elements onto the first stack to make it full
        stack.push(0, 4);
        stack.push(0, 5);
        stack.push(0, 6);

        // Test if stack 1 is full now
        System.out.println("Stack 1 is full: " + stack.isFull(0)); // should print true

        // Try to push an element onto stack 1 when it is full
        try {
            stack.push(0, 7);
        } catch (StackOverflowError e) {
            System.out.println("Caught StackOverflowError: " + e.getMessage()); // should print "null"
        }
    }
}
