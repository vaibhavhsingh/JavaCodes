package com.ds.problems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	static class Node {
		String key;
		String value;
		Node next;
		Node prev;

		Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node head;
	private Node tail;
	private int size = 0;
	private Map<String, Node> map = new HashMap<String, Node>();

	private LRUCache(int size) {
		this.size = size;
	}

	public void addItem(String key, String value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			Node prev = node.prev;
			prev = node.next;
			node.next = head;
			head = node;
		}
		if (map.size() == this.size) {
			// deleteLast();
		}
		Node node = map.get(key);
		if (node == null) {
			node = new Node(key, value);

		}
	}
}
