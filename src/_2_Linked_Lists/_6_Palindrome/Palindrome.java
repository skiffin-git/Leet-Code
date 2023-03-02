package _2_Linked_Lists._6_Palindrome;
// QUESTION
// Implement a function to check if a linked list is a palindrome.
// SOLUTION #1
// To approach this problem, we can picture a palindrome like 0 - > 1 - > 2 - > 1 - > 0. We know that,
// since it's a palindrome, the list must be the same backwards and forwards. This leads us to our first solution.
// Our first solution is to reverse the linked list and compare the reversed list to the original list. If they're the
// same, the lists are identical.
// Note that when we compare the linked list to the reversed list, we only actually need to compare the first
// half of the list. If the first half of the normal list matches the first half of the reversed list, then the second half
// of the normal list must match the second half of the reversed list.
public class Palindrome {
    boolean isPlaindrome(LinkedListNode head){
        LinkedListNode reversed = reverseLinkedList(head);
        return isEqual(head, reversed);
    }

    LinkedListNode reverseLinkedList(LinkedListNode node){
        LinkedListNode head = null;
        while(node != null){
            // temp node has same data, but no next
            LinkedListNode n = new LinkedListNode(node.data);
            // assign next to head
            n.next = head;
            // now assign head to n (old head is still there and equals null)
            head = n;
            // go to next node in loop
            node = node.next;
        }
        // we can return head because it is always beginning
        return head;
    }

    boolean isEqual(LinkedListNode l1, LinkedListNode l2){
        while(l1 != null && l2 != null){
            if(l1.data != l2.data){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    // TEST
    public static void main(String[] args) {
        // Create a linked list that represents a palindrome
        LinkedListNode head = new LinkedListNode(0);
        head.next = new LinkedListNode(1);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(1);
        head.next.next.next.next = new LinkedListNode(0);

        // Create an instance of Palindrome class
        Palindrome p = new Palindrome();

        // Test the isPalindrome method with the palindrome linked list
        boolean result = p.isPlaindrome(head);
        System.out.println(result); // Output should be true

        // Create a linked list that is not a palindrome
        LinkedListNode head2 = new LinkedListNode(0);
        head2.next = new LinkedListNode(1);
        head2.next.next = new LinkedListNode(2);
        head2.next.next.next = new LinkedListNode(3);
        head2.next.next.next.next = new LinkedListNode(4);

        // Test the isPalindrome method with the non-palindrome linked list
        boolean result2 = p.isPlaindrome(head2);
        System.out.println(result2); // Output should be false
    }
}
