package _3_Stacks_and_Queues._1_Three_in_One;

import java.util.EmptyStackException;

// Practice
public class ThreeInOne {
    int stackCapacity;
    int numOfStacks = 3;
    private  int[] sizes;
    private int[] values;

    public ThreeInOne(int sizeOfStacks){
        stackCapacity = sizeOfStacks;
        values = new int[stackCapacity * numOfStacks];
        sizes = new int[numOfStacks];
    }

    public void push(int indexOfStack, int value){
        if(isFull(indexOfStack)){
            throw new StackOverflowError();
        }
        sizes[indexOfStack]++; // important to do this first because topOfStack dependent on size
        values[topOfStack(indexOfStack)] = value;
    }

    public int pop(int indexOfStack){
        if(isEmpty(indexOfStack)){
            throw new EmptyStackException();
        }
        int value = topOfStack(indexOfStack);
        values[topOfStack(indexOfStack)] = 0;
        sizes[indexOfStack]--;
        return value;
    }

    public int peek(int indexOfStack){
        return topOfStack(indexOfStack);
    }

    public boolean isFull(int indexOfStack){
        return sizes[indexOfStack] == stackCapacity;
    }

    public boolean isEmpty(int indexOfStack){
        return sizes[indexOfStack] == 0;
    }

    public int topOfStack(int indexOfStack){
        int offset = stackCapacity * indexOfStack;
        int size = sizes[indexOfStack];
        return offset + size - 1;
    }

    // TEST
    public static void main(String[] args) {
        ThreeInOne stack = new ThreeInOne(3);

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
