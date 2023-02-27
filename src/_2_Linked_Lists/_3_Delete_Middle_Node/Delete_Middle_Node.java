package _2_Linked_Lists._3_Delete_Middle_Node;
// QUESTION
// Implement an algorithm to delete a node in the middle (i.e., any node but
// the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
// that node.
// EXAMPLE
// lnput:the node c from the linked list a->b->c->d->e->f
// Result: nothing is returned, but the new linked list looks like a->b->d->e->f
// SOLUTION
// In this p roblem, you are not given access to the head of the linked list. You only have access to that node.
// The solution is simply to copy the data from the next node over to the current node, and then to delete the
// next node.
public class Delete_Middle_Node {
    boolean deleteNode(LinkedListNode n) {
        if(n.next != null && n.next.next != null){ // check if next and next-next nodes exist
            n.data = n.next.data;
            n.next = n.next.next;
            return true;
        }
        return false;
    }

    // TEST
    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode(1);
        LinkedListNode b = new LinkedListNode(2);
        LinkedListNode c = new LinkedListNode(3);
        LinkedListNode d = new LinkedListNode(4);
        LinkedListNode e = new LinkedListNode(5);
        LinkedListNode f = new LinkedListNode(6);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);

        System.out.println("Before deleting middle node: ");
        System.out.println(a.printForward());

        Delete_Middle_Node deleter = new Delete_Middle_Node();
        boolean success = deleter.deleteNode(c);

        if (success) {
            System.out.println("After deleting middle node: ");
            System.out.println(a.printForward());
        } else {
            System.out.println("Could not delete middle node.");
        }
    }
}
