package dataStructures;

/**
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 * 
 * @author Ankit.Garg
 *
 */
public class LinkListReversalForEachNNodes {

	Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Function to reverse the linked list */
	Node reverse(Node node, int count) {
		Node prev = null;
		int localCount = count;
		Node current = node;
		Node next = null;
		while (current != null && localCount > 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			localCount--;
		}

		if (current != null) {
			node.next = reverse(current, count);
		}
		return prev;
	}

	// prints content of double linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		LinkListReversalForEachNNodes list = new LinkListReversalForEachNNodes();
		list.head = new Node(85);
		list.head.next = new Node(15);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);
		list.head.next.next.next.next = new Node(21);
		list.head.next.next.next.next.next = new Node(22);

		System.out.println("Given Linked list");
		list.printList(list.head);
		list.head = list.reverse(list.head, 2);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(list.head);
	}
}