package sll;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class SLL2 {
	Node head;
	static int size;

	SLL2() {
		head = null;
		size = 0;
	}

	public void insertfirst(int d) {
		Node n = new Node(d);
		n.next = head;
		head = n;
		size++;
	}

	public void traverse() {
		Node h = head;
		while (h != null) {
			System.out.print(h.data + " -> ");
			h = h.next;
		}
		System.out.print("null\n");
	}

	public void counter() {
		if (size > 0)
			System.out.println("Node count: " + size);
		else
			System.out.println("Empty LL");
	}

	public void insertlast(int d) {
		Node n = new Node(d);
		Node h = head;
		if (h.next != null) {
			while (h.next != null) {
				h = h.next;
			}
			h.next = n;
		} else
			head = n;
		size++;
	}

//	public void DeleteData(int d) {
//		if (head != null && head.data == d) {
//			head = head.next;
//		}
//	}

	public void deleteFirst() {
		if (head != null)
			head = head.next;
		size--;
	}

	public void search(int d) {
		Node h = head;
		int c = 0;
		if (h != null) {
			while (h != null) {
				c++;
				if (h.data == d) {
					System.out.println("Data fount at position: " + c);
					break;
				}
				h = h.next;
			}
		}
	}
	
	public void insertInto(int d,int p) {
		if(p<0 && p>size) {
			System.out.println("Cannot insert");
		}
		else if(p==0) {
			Node n=new Node(d);
			n.next=head;
			head=n;
			size++;
		}
		else if(p==size) {
			this.insertlast(d);
		}
		else{
			Node n=new Node(d);
			Node ptr=head;
			int j=0;
			while(j<p) {
				j++;
				ptr=ptr.next;
			}
			n.next=ptr.next;
			ptr.next=n;
			size++;
		}
	}

}

public class SLLCode {

	public static void main(String[] args) {
		SLL2 ll = new SLL2();
		ll.insertfirst(2);
		ll.insertfirst(4);
		ll.insertlast(6);
		ll.insertlast(5);
		ll.traverse();
		ll.counter();
		SLL2 ll2 = new SLL2();
		ll2.insertfirst(23);
		ll2.insertfirst(45);
		ll2.insertlast(62);
		ll2.insertlast(62);
		ll2.insertlast(56);
		ll2.traverse();
		ll2.counter();
		ll2.search(56);
		ll2.deleteFirst();
		ll2.traverse();
		ll2.counter();
		SLL2 ll3 = new SLL2();
		ll3.counter();
		
		SLL2 ll4 = new SLL2();
		ll4.insertInto(3,0);
		ll4.counter();
		ll4.insertInto(7,1);
		ll4.counter();
		ll4.insertInto(5,0);
		ll4.insertInto(9,0);
		ll4.insertInto(9,4);
		ll4.traverse();
		ll4.counter();
	}

}
