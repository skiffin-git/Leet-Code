package _2_Linked_Lists._1_Remove_Dups;

import java.util.*;
public class Remove_Dups_Practice
{
    void deleteDups(LinkedListNode node){
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = new LinkedListNode();
        while (node != null){
            if(set.contains(node.data)){
                // skip dub
                previous.next = node.next;
            }else{
                // update set
                set.add(node.data);
                // update previous
                previous = node;
            }
            // go to next node
            node = node.next;
        }
    }
    // TEST
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(2);
        head.next.next.next.next = new LinkedListNode(4);

        System.out.println("Before removing duplicates:");
        printLinkedList(head);

        Remove_Dups_Practice remover = new Remove_Dups_Practice();
        remover.deleteDups(head);

        System.out.println("After removing duplicates:");
        printLinkedList(head);
    }

    private static void printLinkedList(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
