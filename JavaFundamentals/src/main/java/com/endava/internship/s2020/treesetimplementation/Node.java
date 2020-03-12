package com.endava.internship.s2020.treesetimplementation;

public class Node<T extends Comparable<T>> {
    private int count = 0;
    private boolean boolRemove;
    private boolean boolAdd;

    protected T student;
    protected Node left;
    protected Node right;
    protected Node parent;
    protected Node root;

    Node() {
    }

    Node(T student) {
        this.student = (T) student;
        parent = null;
        right = null;
        left = null;
    }

    public Node getRoot() {
        return root;
    }

    public Student getStudent() {
        return (Student) student;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }

    int getSize() {
        return count;
    }

    boolean isEmptyTree() {
        return root == null;
    }

    boolean containsObject(Object obj) {
        return containsRecursive(root, (T) obj);
    }

    private boolean containsRecursive(Node current, T student) {
        if (current == null) {
            return false;
        }
        if (student.equals(current.student)) {
            return true;
        } else if (student.compareTo((T) current.student) < 0) {
            return containsRecursive(current.left, student);
        } else if (student.toString().compareTo(current.student.toString()) > 0)
            return containsRecursive(current.right, student);
        return true;
    }

    //adding object in tree
    boolean addObject(Student student) {
        root = addRecursive(root, (T) student);
        count++;
        return boolAdd;
    }

    private Node addRecursive(Node current, T student) {
        if (current == null) {
            boolAdd = true;
            return new Node(student);
        }

        if (student.toString().compareTo(current.student.toString()) < 0) {
            current.left = addRecursive(current.left, student);
            current.left.parent = current;
        } else if (student.toString().compareTo(current.student.toString()) > 0) {
            current.right = addRecursive(current.right, student);
            current.right.parent = current;
        } else {
            count--;
            boolAdd = false;
            return current;
        }
        return current;
    }

    boolean deleteObject(Object student) {
        root = deleteRecursive(root, student);
        count--;
        return boolRemove;
    }

    private Node deleteRecursive(Node current, Object student) {
        if (current == null) {
            boolRemove = false;
            count++;
            return null;
        }
        boolRemove = true;
        if (student.equals(current.student)) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            current.student = findSmallestValue(current.right);
            return current;
        }
        if (student.toString().compareTo(current.student.toString()) < 0) {
            current.left = deleteRecursive(current.left, student);
            return current;
        }
        current.right = deleteRecursive(current.right, student);
        return current;
    }

    private Student findSmallestValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return (Student) root.student;
    }

    void clearTree() {
        root = null;
        count = 0;
    }
}
