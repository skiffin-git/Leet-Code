package _2_Linked_Lists._1_Remove_Dups;
// QUESTION
// Write code to remove duplicates from an unsorted linked list.
//
// EXPLANATION
// In order to remove duplicates from a linked list, we need to be able to track duplicates. A simple hash table
// will work well here.
// In the below solution, we simply iterate through the linked list, adding each element to a hash table. When
// we discover a duplicate element, we remove the element and continue iterating. We can do this all in one
// pass since we are using a linked list.

import org.jetbrains.annotations.NotNull;

import java.util.*;
public class Remove_Dups {
    void deleteDups(LinkedListNode n){
        // set will remember elements of n
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        // go through linked list
        while (n != null){
            // if found repeat
            if(set.contains(n.data)){
                // remove dup by assigning current to next
                previous.next = n.next;
            } else {
                // update set
                set.add(n.data);
                // remember current as previous
                previous = n;
            }
            // go to next node
            n = n.next;
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

        Remove_Dups remover = new Remove_Dups();
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

