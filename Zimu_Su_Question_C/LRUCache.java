package Zimu_Su_Question_C;

import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.cache = new HashMap<Integer, Node>();
    }

    /**
     * Put a node into the cache.
     * If the cache is full, remove the LRU node and put the new one.
     * Otherwise simply attach the new one at the end of the cache, representing the
     * most recently used node.
     * 
     * @param node The node to be inserted.
     */
    public void put(Node node) {
        if (head == null && tail == null) {
            head = node;
            tail = node;
            size++;
        } else {
            if (!cache.containsKey(node.getKey())) {
                if (size + 1 > capacity) {
                    cache.remove(head.getKey());
                    head = head.getNext();
                    head.setPrev(null);
                    size--;
                }
            } else {
                Node temp = cache.get(node.getKey());
                Node prev = temp.getPrev();
                Node next = temp.getNext();

                prev.setNext(next);
                next.setPrev(prev);
                size--;
            }

            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
            size++;
        }

        cache.put(node.getKey(), node);
    }

    /**
     * Gets the value of the node by the key of the node.
     * 
     * @param key The key of the node to be find.
     * @return The value of the target node. If target node is not in cache, a value
     *         of -1 is returned.
     */
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node temp = cache.get(key);
            Node prev = temp.getPrev();
            Node next = temp.getNext();

            if (prev != null) {
                prev.setNext(next);
            } else {
                head = next;
            }

            if (next != null) {
                next.setPrev(prev);
            } else {
                tail = prev;
            }

            if (temp.getExpireTime() != -1 && temp.getExpireTime() < System.currentTimeMillis()) {
                cache.remove(key);
                size--;

                return -1;
            }

            temp.setPrev(tail);
            tail.setNext(temp);
            tail = temp;

            return temp.getVal();
        } else {
            // return -1 to indicate the key doesn't exist in cache.
            return -1;
        }
    }

    public int getHead() {
        return head.getVal();
    }

    public int getTail() {
        return tail.getVal();
    }

    public int getSize() {
        return size;
    }
}

class Node {
    private int key, val;
    private Node prev;
    private Node next;
    private long expireTime;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.expireTime = -1;
    }

    public Node(int key, int val, long expireTime) {
        this.key = key;
        this.val = val;
        this.expireTime = System.currentTimeMillis() + expireTime;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node n) {
        this.prev = n;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public long getExpireTime() {
        return expireTime;
    }
}
