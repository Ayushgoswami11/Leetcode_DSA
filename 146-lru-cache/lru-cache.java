import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail nodes to avoid edge-case boundary checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        // Move accessed node to head (Most Recently Used)
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (map.size() >= capacity) {
                // Evict Least Recently Used (node right before dummy tail)
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNodeToHead(newNode);
        }
    }

    // Helper: Remove node from DLL
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Add node right after dummy head
    private void addNodeToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Helper: Move existing node to head
    private void moveToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }
}