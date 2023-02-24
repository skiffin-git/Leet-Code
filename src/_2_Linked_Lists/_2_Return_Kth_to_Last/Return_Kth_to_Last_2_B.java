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
// Approach B: Create a Wrapper Class.
// We described earlier that the issue was that we couldn't simultaneously return a counter and an index. If
// we wrap the counter value with simple class (or even a single element array), we can mimic passing by
// reference.
import _2_Linked_Lists._1_Remove_Dups.LinkedListNode;

public class Return_Kth_to_Last_2_B {
   class Index{
      public int value = 0;
   }

   LinkedListNode kthToLastElement(LinkedListNode head, int k){
      Index idx = new Index();
      return kthToLastElement(head, k, idx);
   }

   LinkedListNode kthToLastElement(LinkedListNode head, int k , Index idx){
      if(head == null){
         return null;
      }
      LinkedListNode node = kthToLastElement(head.next, k, idx);
      idx.value = idx.value + 1;
      if(idx.value == k){
         return head;
      }
      return node;
   }

}
