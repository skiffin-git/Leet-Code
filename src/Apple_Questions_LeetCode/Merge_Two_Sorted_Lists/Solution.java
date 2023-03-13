package Apple_Questions_LeetCode.Merge_Two_Sorted_Lists;

class Solution {

     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode result = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                //System.out.println(head.val);
                l1 = l1.next;
            } else {
                head.next = l2;
                //System.out.println(head.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return result.next;
    }
    // TEST
    public static void main(String[] args) {
        // Create test cases
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = null;
        ListNode l4 = null;

        // Create Solution instance
        Solution sol = new Solution();

        // Test mergeTwoLists() method
        ListNode merged1 = sol.mergeTwoLists(l1, l2); // Expected output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
        ListNode merged2 = sol.mergeTwoLists(l3, l4); // Expected output: null

        // Print results
        System.out.println("Merged list 1: " + merged1.toString());
        System.out.println("Merged list 2: " + merged2);
    }

}
