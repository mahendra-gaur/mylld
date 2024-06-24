package com.example.mySimpleCacheWithGenerics.LRU;

public class DoublyLinkedList<K, V> {

    private Node<K, V> head;
    private Node<K, V> tail;

    public void addFirst(Node<K, V> node) {
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void remove(Node<K, V> node) {
        if (node == head) {
            head = head.next;
        } else if (node == tail) {
            tail = tail.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    public Node<K, V> removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        Node<K, V> last = tail;
        remove(last);
        return last;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int size = 0;
        Node<K, V> current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node tempNode = this.head;
        while(tempNode!=null) {
            str.append(","+tempNode.toString());
            tempNode = tempNode.next;
        }
        return str.toString();
    }
}