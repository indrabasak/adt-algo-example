package com.basaki.list;

public class LinkedList<T extends Comparable<?>> {
    private Node<T> fHead;

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(4);
        list.add(7);
        list.add(4);
        list.add(7);
        list.add(8);

        list.print();
        list.remove(7);
        System.out.println();
        list.print();
    }

    public boolean add(T data) {
        boolean retVal = false;

        if (data == null) {
            return retVal;
        }

        Node<T> newNode = new Node<T>(data);
        if (fHead == null) {
            fHead = newNode;
            retVal = true;
        } else {
            Node<T> curNode = fHead;
            while (curNode.getNext() != null) {
                curNode = curNode.getNext();
            }
            curNode.setNext(newNode);
            retVal = true;
        }

        return retVal;
    }

    public boolean remove(T data) {
        boolean found = false;

        if (data != null) {
            Node<T> prevNode = fHead;
            Node<T> curNode = fHead;
            while (curNode != null && !found) {
                if (curNode.getData().equals(data)) {
                    prevNode.setNext(curNode.getNext());
                    found = true;

                } else {
                    prevNode = curNode;
                    curNode = curNode.getNext();
                }
            }
        }

        return found;
    }

    public Node<T> getHead() {
        return fHead;
    }

    public void print() {
        Node<T> curNode = fHead;
        while (curNode != null) {
            System.out.print(curNode + " --> ");
            curNode = curNode.getNext();
        }
        System.out.print("NULL");
    }
}
