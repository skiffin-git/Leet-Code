package _2_Linked_Lists._6_Palindrome;

public class Palindrome_Practice {
    boolean isPlaindrome(LinkedListNode head){
        LinkedListNode reversed = reverseLinkedList(head);
        return isEqualLinkedLists(head, reversed);
    }
    LinkedListNode reverseLinkedList(LinkedListNode node){
        LinkedListNode head = null;
        while(node != null){
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    boolean isEqualLinkedLists(LinkedListNode l1, LinkedListNode l2){
        while(l1 != null && l2 != null){
            if(l1.data != l2.data){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
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
        Palindrome_Practice p = new Palindrome_Practice();

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
