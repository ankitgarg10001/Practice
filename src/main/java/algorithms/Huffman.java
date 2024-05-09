package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {
	static class Node implements Comparable<Node> {
		Character character;
		int frequency;
		Node left = null, right = null;

		@Override
		public int compareTo(Node o) {
			return frequency - o.frequency;
		}

		@Override
		public String toString() {
			return "Node [character=" + character + ", frequency=" + frequency + ", left=" + left + ", right=" + right
					+ "]";
		}

	}

	static HashMap<Character, String> codes = new HashMap<>();

	public static void main(String[] args) {
		String s = "Time complexity of the algorithm discussed in above post is O(nLogn). If we know that the given array is sorted (by non-decreasing order of frequency), we can generate Huffman codes in O(n) time. Following is a O(n) algorithm for sorted input.";
		HashMap<Character, Integer> count = new HashMap<>();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			int freq = 0;
			if (count.containsKey(c[i])) {
				freq = count.get(c[i]);
			}
			count.put(c[i], ++freq);
		}
		PriorityQueue<Node> huffmanTree = new PriorityQueue<>();
		count.forEach((key, val) -> {
			Node n = new Node();
			n.character = key;
			n.frequency = val;
			huffmanTree.add(n);
		});

		while (huffmanTree.size() != 1) {
			Node left = huffmanTree.poll();
			Node right = huffmanTree.poll();
			Node root = new Node();
			root.frequency = left.frequency + right.frequency;
			root.left = left;
			root.right = right;
			root.character = null;
			huffmanTree.add(root);
		}
		initializeCodes(huffmanTree.poll(), "");

	}

	private static void initializeCodes(Node root, String code) {
		if (root.left == null && root.right == null) {
			codes.put(root.character, code);
			System.out.println(root.character + " : " + code);
		} else {
			if (root.left != null)
				initializeCodes(root.left, code + "0");
			if (root.right != null)
				initializeCodes(root.right, code + "1");
		}
	}
}
