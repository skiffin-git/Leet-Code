package _2_Linked_Lists._0_LinkedListNode;

public class LinkedListNode0 {
	public LinkedListNode0 next;
	public LinkedListNode0 prev;
	public LinkedListNode0 last;
	public int data;
	public LinkedListNode0(int d, LinkedListNode0 n, LinkedListNode0 p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}
	
	public LinkedListNode0(int d) {
		data = d;
	}	
	
	public LinkedListNode0() { }

	public void setNext(LinkedListNode0 n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(LinkedListNode0 p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}
}