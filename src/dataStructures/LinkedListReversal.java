package dataStructures;

/**
 * Reverse a linked list * @author Admin
 *
 */
public class LinkedListReversal {

	class Node {
		int x;
		Node next;

		Node() {
			x = 0;
			next = null;
		}

		Node(int val) {
			x = val;
			next = null;
		}
	}

	class Llist {
		Node node;

		Llist(int val) {
			node = new Node(val);
		}

		public void addToList(int val) {
			Node temp = node;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(val);
		}

		public void show() {
			Node temp = node;
			while (temp != null) {
				System.out.print(temp.x + " -> ");
				temp = temp.next;
			}
			System.out.println("");
		}

		public void reverse() {
			Node curr, next, before;
			curr = node;
			before = null;
			while (curr != null) {
				next = curr.next;
				curr.next = before;
				before = curr;
				curr = next;

			}
			node = before;
		}
	}

	public static void main(String[] args) {
		LinkedListReversal v = new LinkedListReversal();
		Llist llist = v.new Llist(6);
		llist.addToList(5);
		llist.addToList(4);
		llist.addToList(3);
		llist.addToList(2);
		llist.show();
		llist.reverse();
		llist.show();
	}
}
