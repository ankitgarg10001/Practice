package tree;

class Node {
	int value;
	Node left;
	Node right;

	public Node(int val) {
		value = val;
	}
}

public class Tree {
	Node root = null;

	public void insert(int value, Node node) {
		if (node == null) {
			Node n = new Node(value);
			root = n;
		} else if (node.value > value) {
			if (node.left == null) {
				Node n = new Node(value);
				node.left = n;
			} else {
				insert(value, node.left);
			}
		} else {
			if (node.right == null) {
				Node n = new Node(value);
				node.right = n;
			} else {
				insert(value, node.right);
			}
		}
	}

	public void preorder(Node node) {
		if (node == null)
			return;
		System.out.println(node.value);
		preorder(node.left);
		preorder(node.right);
	}

	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.println(node.value);
		inorder(node.right);
	}

	public void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		System.out.println(node.value);
		postOrder(node.right);
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(5, tree.root);
		tree.insert(2, tree.root);
		tree.insert(8, tree.root);
		tree.insert(1, tree.root);
		tree.insert(3, tree.root);
		tree.insert(6, tree.root);
		tree.insert(9, tree.root);
		tree.inorder(tree.root);
	}
}
