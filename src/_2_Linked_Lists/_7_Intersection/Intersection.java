package _2_Linked_Lists._7_Intersection;
// QUESTION
// Given two (singly) linked lists, determine if the two lists intersect. Return the
// intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
// kth node of the first linked list is the exact same node (by reference) as the jth node of the second
// linked list, then they are intersecting.
// Let's draw a picture of intersecting linked lists to get a better feel for what is going on.
// Here is a picture of intersecting linked lists:
// 3 -> 1 -> 5 -> 9 |
//                  |-> 7 -> 2 -> 1
//           4 -> 6 |
// And here is a picture of non-intersecting linked lists:
// 3 -> 1 -> 5 -> 9 -> 7 -> 2 -> 1
//           4 -> 6 -> 7 -> 2 -> 1
// We should be careful here to not inadvertently draw a special case by making the linked lists the same
// length.
// Let's first ask how we would determine if two linked lists intersect.
//
// Determining if there's an intersection.
// How would we detect if two linked lists intersect? One approach would be to use a hash table and just
// throw all the linked lists nodes into there. We would need to be careful to reference the linked lists by their
// memory location, not by their value.
// There's an easier way though. Observe that two intersecting linked lists will always have the same last node.
// Therefore, we can just traverse to the end of each linked list and compare the last nodes.
// How do we find where the intersection is, though?
//
// Finding the intersecting node.
// One thought is that we could traverse backwards through each linked list. When the linked lists"split'; that's
// the intersection. Of course, you can't really traverse backwards through a singly linked list.
// If the linked lists were the same length, you could just traverse through them at the same time. When they
// collide, that's your intersection.
// #3 -> #1 -> 5 -> 9 |
//                    |-> 7 -> 2 -> 1
//             4 -> 6 |
// When they're not the same length, we'd like to just"chop off"-or ignore-those excess (gray) nodes.
// How can we do this? Well, if we know the lengths of the two linked lists, then the difference between those
// two linked lists will tell us how much to chop off.
// We can get the lengths at the same time as we get the tails of the linked lists (which we used in the first step
// to determine if there's an intersection).
//
// Putting it all together.
// We now have a multistep process.
// 1. Run through each linked list to get the lengths and the tails.
// 2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
// 3. Set two pointers to the start of each linked list.
// 4. On the longer linked list, advance its pointer by the difference in lengths.
// 5. Now, traverse on each linked list until the pointers are the same.
public class Intersection {

    LinkedListNode findIntersection(LinkedListNode l1, LinkedListNode l2){
        LinkedListNode tailList1 = null, tailList2 = null,
                headList1 = l1, headList2 = l2, longer, shorter;
        int sizeList1 = 0, sizeList2 = 0, sizeDiff;

        // check if lists have nodes
        if(l1 == null || l2 == null){
            return null;
        }

        // find size and tail of l1
        while(l1 != null){
            sizeList1++;
            tailList1 = l1;
            l1 = l1.next;
        }

        // find size and tail of l2
        while(l2 != null){
            sizeList2++;
            tailList2 = l2;
            l2 = l2.next;
        }

        // Compare the tails
        if(tailList1 != tailList2){
            return null;
        }

        // find difference of size
        sizeDiff = Math.abs(sizeList1 - sizeList2);

        // assign longer and shorter
        if(sizeList1 >= sizeList2){
            longer = headList1;
            shorter = headList2;
        }else{

            longer = headList2;
            shorter = headList1;
        }

        // Advance longer list by the difference of size
        for (int i = 0; i < sizeDiff; i++){
            longer = longer.next;
        }

        // Find merge node
        while(longer != null){
            if(longer == shorter){
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        System.out.println("ERROR: could not find merge node");
        return null;
    }

    // TEST
    public static void main(String[] args) {
        // Creating the intersecting linked lists
        LinkedListNode n1 = new LinkedListNode(3);
        LinkedListNode n2 = new LinkedListNode(1);
        LinkedListNode n3 = new LinkedListNode(5);
        LinkedListNode n4 = new LinkedListNode(9);
        LinkedListNode n5 = new LinkedListNode(7);
        LinkedListNode n6 = new LinkedListNode(2);
        LinkedListNode n7 = new LinkedListNode(1);
        LinkedListNode n8 = new LinkedListNode(4);
        LinkedListNode n9 = new LinkedListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        n8.next = n9;
        n9.next = n5;

        Intersection intersection = new Intersection();

        LinkedListNode intersectionNode = intersection.findIntersection(n1, n8);

        if(intersectionNode == n5){
            System.out.println("Success: Found intersection node!");
        }else{
            System.out.println("Error: Could not find intersection node");
        }

        // Creating the non-intersecting linked lists
        LinkedListNode n10 = new LinkedListNode(3);
        LinkedListNode n11 = new LinkedListNode(1);
        LinkedListNode n12 = new LinkedListNode(5);
        LinkedListNode n13 = new LinkedListNode(9);
        LinkedListNode n14 = new LinkedListNode(7);
        LinkedListNode n15 = new LinkedListNode(2);
        LinkedListNode n16 = new LinkedListNode(1);

        LinkedListNode n17 = new LinkedListNode(4);
        LinkedListNode n18 = new LinkedListNode(6);
        LinkedListNode n19 = new LinkedListNode(7);
        LinkedListNode n20 = new LinkedListNode(2);
        LinkedListNode n21 = new LinkedListNode(1);

        n10.next = n11;
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;
        n15.next = n16;

        n17.next = n18;
        n18.next = n19;
        n19.next = n20;
        n20.next = n21;

        intersectionNode = intersection.findIntersection(n10, n17);

        if(intersectionNode == null){
            System.out.println("Success: No intersection found!");
        }else{
            System.out.println("Error: Found intersection node when there is none!");
        }
    }
}
