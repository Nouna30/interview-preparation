package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LRUCache {

    // #146. LRU Cache
    // https://leetcode.com/problems/lru-cache/description
    //
     // NOTES:
    // Use a Map to do a O(1) lookup of the values against a key.
    // For LRU, MRU, keep the values as Nodes of a Doubly Linked List, for fast
    // shifting of the nodes.

    private final Map<Integer, Node> table;
    private final int capacity;

    private Node head; // most recent
    private Node tail; // least recent
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.table = new HashMap<>();
    }

    public int get(int key) {
        Node node = table.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        Node node = table.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }

        if (size == capacity) {
            evict();
        }

        Node fresh = new Node(key, value);
        table.put(key, fresh);
        addToHead(fresh);
        size++;
    }

    private void evict() {
        Node node = tail;

        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
        node.prev = node.next = null;

        table.remove(node.key);
        size--;
    }

    private void moveToHead(Node node) {
        if (node == head) return;
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = node;
    }

    private void removeNode(Node node) {
        if (node.prev == null && node.next == null && node != head && node != tail) return;

        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        node.prev = node.next = null;
    }

    private static class Node {
        final int key;
        int value;
        Node prev;
        Node next;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

