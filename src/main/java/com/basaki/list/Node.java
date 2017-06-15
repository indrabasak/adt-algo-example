package com.basaki.list;

/**
 * The <code>Node</code>
 *
 * @author Indra Basak
 */
public class Node<T extends Comparable<?>> {

    private T fData;

    private Node<T> fNext;

    public Node(T data) {
        fData = data;
    }

    public T getData() {
        return fData;
    }

    public Node<T> getNext() {
        return fNext;
    }

    public void setNext(Node<T> next) {
        fNext = next;
    }

    @Override
    public String toString() {
        return fData.toString();
    }
}
