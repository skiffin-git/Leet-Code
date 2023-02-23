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
// This algorithm recurses through the linked list. When it hits the end, the method passes back a counter set
// to 0. Each parent call adds 1 to this counter. When the counter equals k, we know we have reached the kth
// to last element of the linked list.
// Implementing this is short and sweet-provided we have a way of"passing back" an integer value through
// the stack. Unfortunately, we can't pass back a node and a counter using normal return statements. So how
// do we handle this?
// Approach A: Don't Return the Element.
// One way to do this is to change the problem to simply printing the kth to last element. Then, we can pass
// back the value of the counter simply through return values.
import java.util.*;
public class Return_Kth_to_Last {
    public static int solution2(LinkedList<Integer> list, int k){
        int index = 0;
        Iterator<Integer> iter = list.iterator();
        if (iter.hasNext()) {
            list.remove(iter.next());
        }
        if (list.getFirst() == k) {
            index = list.getFirst();
            System.out.println(k + "th to last node is " + list.getFirst());
        }else{
            solution2(list, k);
        }
        return index;
    }

    // TEST
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int k = 2;
        solution2(list, k);
    }
}
