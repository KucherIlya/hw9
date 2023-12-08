package goit.homeworks;

public class MyHashMap<K, V> {
    private Node<K, V>[] buckets;
    private int capacity;
    private int size;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        capacity = 16; // стандартний розмір
        buckets = new Node[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        var newNode = new Node<>(key, value);
        var current = buckets[index];

        if (current == null) {
            buckets[index] = newNode;
            size++;
        } else {
            while (true) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    current.next = newNode;
                    size++;
                    return;
                }
                current = current.next;
            }
        }
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];
        Node<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        buckets = new Node[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    private int getBucketIndex(Object key) {
        return key.hashCode() % capacity;
    }
}
