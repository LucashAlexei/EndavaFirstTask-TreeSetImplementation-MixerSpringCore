package com.endava.internship.s2020.treesetimplementation;

public class NodeIterator<T> {
    private Node node = new Node();
    private Node left = node.getLeft();
    private Node right = node.getRight();
    private Node parent = node.getParent();
    private T student = (T) node.getStudent();
    private Node root;
    private Node next;

    NodeIterator(Node node) {
        root = node;
        treeIterator(root);
    }

    private void treeIterator(Node root) {
        next = root;
        if (next == null)
            return;
        while (next.left != null)
            next = next.left;
    }

    boolean hasNextRoot() {
        return next != null;
    }

    Student nextRoot() {
        Node tmp = next;
        if (next.right != null) {
            next = next.right;
            while (next.left != null)
                next = next.left;
            return (Student) tmp.student;
        }
        while (true) {
            if (next.parent == null) {
                next = null;
                return (Student) tmp.student;
            }
            if (next.parent.left == next) {
                next = next.parent;
                return (Student) tmp.student;
            }
            next = next.parent;
        }
    }
}

