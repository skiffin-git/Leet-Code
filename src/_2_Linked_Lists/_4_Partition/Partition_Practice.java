package _2_Linked_Lists._4_Partition;

import _2_Linked_Lists._3_Delete_Middle_Node.LinkedListNode;

import java.util.LinkedList;

public class Partition_Practice {
    LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while (node != null){
            LinkedListNode next = node.next;
            node.next = null;
            if(node.data < x){
                if(beforeStart == null){
                    beforeStart = node;
                    beforeEnd = node;
                }else {
                    beforeEnd.next = node;
                    beforeEnd = beforeEnd.next;
                }
            }else{
                if(afterStart == null){
                    afterStart = node;
                    afterEnd = node;
                }else{
                    afterEnd.next = node;
                    afterEnd = afterEnd.next;
                }
            }
            node = next;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
    // TEST
    public static void main(String[] args) {
        // create a linked list: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
        _2_Linked_Lists._3_Delete_Middle_Node.LinkedListNode head = new _2_Linked_Lists._3_Delete_Middle_Node.LinkedListNode(3);
        head.next = new _2_Linked_Lists._3_Delete_Middle_Node.LinkedListNode(5);
        head.next.next = new _2_Linked_Lists._3_Delete_Middle_Node.LinkedListNode(8);
        head.next.next.next = new _2_Linked_Lists._3_Delete_Middle_Node.LinkedListNode(5);
        head.next.next.next.next = new _2_Linked_Lists._3_Delete_Middle_Node.LinkedListNode(10);
        head.next.next.next.next.next = new _2_Linked_Lists._3_Delete_Middle_Node.LinkedListNode(2);
        head.next.next.next.next.next.next = new _2_Linked_Lists._3_Delete_Middle_Node.LinkedListNode(1);

        int x = 5; // set the partition value

        // create a Partition object and partition the linked list
        Partition_Practice partition = new Partition_Practice();
        LinkedListNode result = partition.partition(head, x);

        // print the result
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
