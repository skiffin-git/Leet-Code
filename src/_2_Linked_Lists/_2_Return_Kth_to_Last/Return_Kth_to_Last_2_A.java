package _2_Linked_Lists._2_Return_Kth_to_Last;
// QUESTION
// Implement an algorithm to find the kth to last element of a singly linked list.
//
// EXPLANATION
// We will approach this problem both recursively and non-recursively. Remember that recursive solutions are
// often cleaner but less optimal. For example, in this problem, the recursive implementation is about half the
// length of the iterative solution but also takes 0( n) space, where n is the number of elements in the linked
// list.
//
// Note that for this solution, we have defined k such that passing in k = 1 would return the last element, k
// 2 would return to the second to last element, and so on. It is equally acceptable to define k such that k
// = 0 would return the last element.
//
// Solution #1: If linked list size is known
// If the size of the linked list is known, then the kth to last element is the ( length - k)th element. We can
// just iterate through the linked list to find this element. Because this solution is so trivial, we can almost be
// sure that this is not what the interviewer intended.
//
// Solution #2: Recursive
// This algorithm recursive through the linked list. When it hits the end, the method passes back a counter set
// to 0. Each parent call adds 1 to this counter. When the counter equals k, we know we have reached the kth
// to last element of the linked list.
// Implementing this is short and sweet-provided we have a way of"passing back" an integer value through
// the stack. Unfortunately, we can't pass back a node and a counter using normal return statements. So how
// do we handle this?
//    Approach A: Don't Return the Element.
//    One way to do this is to change the problem to simply printing the kth to last element. Then, we can pass
//    back the value of the counter simply through return values.
//
import _2_Linked_Lists._1_Remove_Dups.LinkedListNode;

public class Return_Kth_to_Last_2_A {
   // kth is count from last node, not from beginning
   public static int printKthToLast(LinkedListNode head, int k){
      // we go to the end of list
      if(head == null){
         // we only get here once
         return 0;
      }
      // when we got to the end of the list, we start count, and later count all elements
      int index = printKthToLast(head.next, k) + 1;
      // when we encounter kth element from last, we print it
      if(index == k){
         System.out.println(k + "th to last node is " + head.data);
      }
      // after we reached the end, we go to the next element with recursion
      // so we get here from last node to first
      return index;
   }

   // TEST
   public static void main(String[] args) {
      LinkedListNode node1 = new LinkedListNode(1);
      LinkedListNode node2 = new LinkedListNode(2);
      LinkedListNode node3 = new LinkedListNode(3);
      LinkedListNode node4 = new LinkedListNode(4);
      LinkedListNode node5 = new LinkedListNode(5);

      node1.next = node2;
      node2.next = node3;
      node3.next = node4;
      node4.next = node5;

      // Test printing the 2nd to last element
      int k = 2;
      System.out.println("Printing " + k + "th to last element:");
      int result = printKthToLast(node1, k);

      // Test printing the last element
      k = 1;
      System.out.println("Printing " + k + "th to last element:");
      result = printKthToLast(node1, k);

      // Test printing an element that's out of bounds
      k = 6;
      System.out.println("Printing " + k + "th to last element:");
      result = printKthToLast(node1, k);
   }

}
