package _2_Linked_Lists._0_LinkedListNode;

public class LinkedListNode {
    public LinkedListNode next;
    public int data;
    public LinkedListNode(int d, LinkedListNode n){
        data = d;
        next = n;
    }
    public LinkedListNode(int d){ data = d; }

}
