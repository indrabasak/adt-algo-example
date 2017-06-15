package com.basaki.queue;

public class DoublyLinkedListDeque<T> {
    private Node<T> first;

    private Node<T> last;

    public static void main(String[] args) {
        DoublyLinkedListDeque<String> deque =
                new DoublyLinkedListDeque<String>();
        System.out.println("peek first: " + deque.peekFirst());
        System.out.println("peek last: " + deque.peekLast());
        deque.print();
        deque.removeLast();
        deque.addFirst("Indra");
        deque.print();
        System.out.println("peek first: " + deque.peekFirst());
        System.out.println("peek last: " + deque.peekLast());
        deque.addLast("Basak");
        deque.print();
        System.out.println("peek first: " + deque.peekFirst());
        System.out.println("peek last: " + deque.peekLast());
        deque.addFirst("Mr");
        deque.print();
        deque.addLast("Basak-2");
        deque.print();
        deque.addFirst("Indra-2");
        deque.print();
        System.out.println("peek first: " + deque.peekFirst());
        System.out.println("peek last: " + deque.peekLast());
        deque.removeFirst();
        deque.print();
        deque.removeLast();
        deque.print();

    }

    public void addFirst(T data) {
        Node<T> node = new Node<T>(data);
        if (first == null) {
            first = node;
            last = node;
            return;
        }

        first.previous = node;
        node.next = first;
        first = node;
    }

    public void addLast(T data) {
        Node<T> node = new Node<T>(data);
        if (first == null) {
            first = node;
            return;
        }

        if (last == null) {
            first.next = node;
            last = node;
            return;
        }

        last.next = node;
        node.previous = last;
        last = node;
    }

    public T removeFirst() {
        T data = null;
        if (first == null) {
            data = null;
        } else if (first.next == null) {
            data = first.data;
            first = null;
        } else {
            data = first.data;
            first.next.previous = null;
            first = first.next;
        }

        return data;
    }

    public T removeLast() {
        T data = null;
        if (first == null || last == null) {
            data = null;
        } else {
            data = last.data;
            last.previous.next = null;
            last = last.previous;
        }

        return data;

    }

    public T peekFirst() {
        T data = null;
        if (first != null) {
            data = first.data;
        }

        return data;
    }

    public T peekLast() {

        T data = null;
        if (last != null) {
            data = last.data;
        }

        return data;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void print() {
        Node<T> curNode = first;
        while (curNode != null) {
            System.out.print(curNode + " --> ");
            curNode = curNode.next;
        }
        System.out.print("NULL\n");
    }

    private class Node<P> {
        P data;

        Node<P> next;

        Node<P> previous;

        public Node(P data) {
            this.data = data;
        }

        public String toString() {
            return data.toString();
        }
    }

}
