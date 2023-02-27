package _2_Linked_Lists._4_Partition;

import _2_Linked_Lists._3_Delete_Middle_Node.LinkedListNode;

// QUESTION
// Write code to partition a linked list around a value x, such that all nodes less than x come
// before all nodes greater than or equal to x. If x is contained within the list the values of x only need
// to be after the elements less than x (see below). The partition element x can appear anywhere in the
// "right partition"; it does not need to appear between the left and right partitions.
// EXAMPLE
// Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
// Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
// SOLUTION
// If this were an array, we would need to be careful about how we shifted elements. Array shifts are very
// expensive.
// However, in a linked list, the situation is much easier. Rather than shifting and swapping elements, we can
// actually create two different linked lists: one for elements less than x, and one for elements greater than or
// equal to x.
// We iterate through the linked list, inserting elements into our before list or our after list. Once we reach
// the end of the linked list and have completed this splitting, we merge the two lists.
// This approach is mostly "stable" in that elements stay in their original order, other than the necessary movement
// around the partition. The code below implements this approach.
public class Partition {
    LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while(node != null){
            LinkedListNode next = node.next;
            node.next = null;
            if(node.data < x) {
                /* Insert node into end of before list*/
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    // add new node to list                         Start |         Start |
                    beforeEnd.next = node;                      //        |->node1        |-> node1 -> node2
                    // remember last node                           End   |         End   -------------^
                    beforeEnd = beforeEnd.next;                 //  1st iter
                }
            } else{
                if(afterStart == null){
                    afterStart = node;
                    afterEnd = afterStart;
                } else{
                    // Insert node into end of after list
                    afterEnd.next = node;
                    afterEnd = afterEnd.next;
                }
            }
            node = next;
        }
        if(beforeStart == null){
            return afterStart;
        }
        // merge
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    // TEST
    public static void main(String[] args) {
        // create a linked list: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
        LinkedListNode head = new LinkedListNode(3);
        head.next = new LinkedListNode(5);
        head.next.next = new LinkedListNode(8);
        head.next.next.next = new LinkedListNode(5);
        head.next.next.next.next = new LinkedListNode(10);
        head.next.next.next.next.next = new LinkedListNode(2);
        head.next.next.next.next.next.next = new LinkedListNode(1);

        int x = 5; // set the partition value

        // create a Partition object and partition the linked list
        Partition partition = new Partition();
        LinkedListNode result = partition.partition(head, x);

        // print the result
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
