package Apple_Questions_LeetCode._2_Max_Stack;

import java.util.*;
class MaxStack {
    private LinkedListNode node;
    private ArrayList<LinkedListNode> maxArr;
    int size;
    int max;

    public MaxStack() {
        maxArr = new ArrayList<LinkedListNode>();
        size = 0;
    }

    public void push(int x) {
        if(node == null){
            // create list
            node = new LinkedListNode(x);

            // remember max
            maxArr.add(node);
            max = node.data;

            size++;
        }else{
            // update list
            node.prev = node; // update prev
            node.next = new LinkedListNode(x); // create next node
            node = node.next; // update next
            size++;
            // remember max
            if(node.data >= max){
                maxArr.add(node);
            }
        }
    }
    public int pop() {
        // update max
        if (node.data == max) {
            maxArr.remove(maxArr.size() - 1);
            max = maxArr.get(maxArr.size() - 1).data;
        }
        // update list
        int value = node.data;
        node = node.prev;
        node.next = null;
        return value;
    }


    public int top() {
        return node.data;
    }

    public int peekMax() {
        return max;
    }

    public int popMax() {
        LinkedListNode temp = maxArr.get(maxArr.size() - 1);
        int value = temp.data;
        // update list
        temp.prev.next = temp.next;
        // update max
        maxArr.remove(maxArr.size()-1);
        max = maxArr.get(maxArr.size() - 1).data;
        return value;
    }
}