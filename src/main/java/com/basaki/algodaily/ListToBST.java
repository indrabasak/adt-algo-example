package com.basaki.algodaily;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a sorted singly linked list (that is, a linked list made of nodes
 * with no pointers to the previous node) where the elements are
 * already arranged in ascending order. Consvert the linked list to
 * a Binary Search Tree (BST)
 */
public class ListToBST {

    public static class LinkedList {
        private LinkedListNode head;

        public void add(int data) {
            LinkedListNode newNode = new LinkedListNode();
            newNode.data = data;

            if (head == null) {
                head = newNode;
            } else {
                LinkedListNode currNode = head;
                while (currNode.next != null) {
                    currNode = currNode.next;
                }
                currNode.next = newNode;
            }
        }

        public void print() {
            LinkedListNode currNode = head;
            while (currNode != null) {
                System.out.print(currNode.data + " -> ");
                currNode = currNode.next;
            }

            System.out.print("NULL\n");
        }
    }


    public static class LinkedListNode {
        public int data;
        public LinkedListNode next;
    }


    public static class BST {

        private Node root;

        public void add(int data) {
            root = add(root, data);
        }

        private Node add(Node node, int data) {
            if (node == null) {
                Node newNode = new Node();
                newNode.data = data;
                node = newNode;
                return node;
            } else if (node.data > data) {
                return add(node.left, data);
            } else if (node.data < data) {
                return add(node.right, data);
            } else if (node.data == data) {
                return node;
            }

            return node;
        }

        public void printInOrderTraversal() {
            Stack<Node> stack = new Stack<>();
            Node current = root;

            while (!stack.isEmpty() || current != null) {
                if (current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    current = stack.pop();
                    System.out.print(current.data + " --> ");
                    current = current.right;
                }
            }
        }
    }

    public static class Node {
        public int data;
        public Node left;
        public Node right;
    }

    public static BST listToBST(LinkedListNode head) {
        BST bst = new BST();
        LinkedListNode current = head;
        while (current != null) {
            bst.add(current.data);
            current = current.next;
        }

        return bst;
    }

    public static void main(String[] args) {
        // -9 -> -2 -> 3 -> 5 -> 9
        LinkedList list = new LinkedList();
        list.add(-9);
        list.add(-2);
        list.add(3);
        list.add(5);
        list.add(9);

        list.print();

        BST bst = listToBST(list.head);
        bst.printInOrderTraversal();
    }
}
