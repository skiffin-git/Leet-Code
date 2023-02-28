package _2_Linked_Lists._5_Sum_Lists;
// QUESTION
// You have two numbers represented by a linked list, where each node contains a single
// digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
// function that adds the two numbers and returns the sum as a linked list.
// EXAMPLE
// Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
// Output: 2 -> 1 -> 9. That is, 912.
// FOLLOW UP
// Suppose the digits are stored in forward order. Repeat the above problem.
// Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
// Output: 9 -> 1 -> 2. That is, 912.
public class Sum_Lists {
    LinkedListNode addlists(LinkedListNode l1, LinkedListNode l2) {
        boolean carry = false;

        LinkedListNode head = l1;
        while(true){
            if(carry){
                l1.data += l2.data + 1;
                carry = false;
            }else{
                l1.data += l2.data;
            }
            if(l1.data / 10 != 0) {
                carry = true;
                l1.data %= 10;
            }

            // check if both lists are last nodes
            if(l1.next == null && l2.next == null){
                break;
            }

            // if one is shorter, add temp node with 0
            if(l1.next == null){
                l1.next = new LinkedListNode(0);
            }
            if(l2.next == null){
                l2.next = new LinkedListNode(0);
            }

            // next nodes
            l1 = l1.next;
            l2 = l2.next;
        }
        return head;
    }

    // TEST
    public static void main(String[] args) {
        // create linked lists for testing
        LinkedListNode l1 = new LinkedListNode(7);
        l1.next = new LinkedListNode(1);
        l1.next.next = new LinkedListNode(6);

        LinkedListNode l2 = new LinkedListNode(5);
        l2.next = new LinkedListNode(9);
        l2.next.next = new LinkedListNode(2);

        // test addlists method
        Sum_Lists sum_lists = new Sum_Lists();
        LinkedListNode result = sum_lists.addlists(l1, l2);

        // print output
        while (result != null) {
            System.out.print(result.data + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}
