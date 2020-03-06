package com.endava.internship.s2020.treesetimplementation;

import java.util.*;

public class StudentSet implements Set<Student> {

    int count = 0;
    boolean boolRemove;
    boolean boolAddAll;

    Node root;

    StudentSet() {
    }

    //inner Node class
    static class Node {
        Student student;
        Node left;
        Node right;

        Node(Student student) {
            this.student = student;
            right = null;
            left = null;
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    public int compareObjects(Node current, Object student){
        return student.toString().compareTo(current.student.toString());
    }

    @Override
    public boolean contains(Object o) {
            return containsRecursive(root, o);
    }

    private boolean containsRecursive(Node current, Object student) {
        if (current == null) {
            return false;
        }
        if (student.equals(current.student)) {
            return true;
        }
        else if(compareObjects(current,student) < 0){
            return containsRecursive(current.left, student);
        }
        else if(compareObjects(current,student) > 0)
            return containsRecursive(current.right, student);

        return true;
    }

    public Node addRecursive(Node current, Student student){
        if(current==null){
            return new Node(student);
        }

        int date = student.getDateOfBirth().compareTo(current.student.getDateOfBirth());

        if(compareObjects(current, student)<0){
            current.left = addRecursive(current.left,student);

        }
        else if(compareObjects(current, student)>0){
            current.right = addRecursive(current.right, student);

        }else {
            if (date < 0) {
                current.left = addRecursive(current.left, student);

            } else if (date > 0){
                current.right = addRecursive(current.right, student);
            }
            else{
                count--;
                return current;
            }
        }
        return current;
    }
    @Override
    public boolean add(Student student) {
        root = addRecursive(root, student);
        count++;
        return true;
    }

    public void print(){
        printRecursive(root);
    }

    public void printRecursive(Node root) {
        if (root != null) {
            printRecursive(root.left);
            System.out.println("Tree: "+ root.student);
            printRecursive(root.right);
        }
    }

    private Node deleteRecursive(Node current, Object student) {
        if (current == null) {
            return null;
        }

        if (student.equals(current.student)) {
            count--;
            boolRemove = true;
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
        }
        if (compareObjects(current, student) < 0) {
            boolRemove = false;
            current.left = deleteRecursive(current.left, student);
            return current;
        }
        current.right = deleteRecursive(current.right, student);
        return current;
    }

    @Override
    public boolean remove(Object student) {
        root = deleteRecursive(root, student);
        return boolRemove;
    }

    @Override
    public Iterator<Student> iterator() {
        return new Iterator<Student>() {
            Stack<Student> stack = new Stack<Student>();
            int check = 0;

            @Override
            public boolean hasNext() {
                if(check == 0){
                    iter(root);
                    check++;
                }
                return !stack.empty();
            }

            private void iter(Node root){
                if(root == null){
                    return;
                }
                iter(root.right);
                if(root.student!=null) {
                    stack.push(root.student);
                }
                iter(root.left);
            }

            @Override
            public Student next() {
                return stack.pop();
            }
        };
    }

    @Override
    public Student[] toArray() {
        Student[] array = new Student[count];

        int k=0;
        Iterator<Student> iter2 = this.iterator();
        while(iter2.hasNext()) {
            array[k] = iter2.next();
            k++;
        }
        return (Student[]) array;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Student> collection) {
        for (Student st : collection) {
            addRecursive(root, st);
            count++;
        }

        return boolAddAll;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    public void clearRecursive(Node current){
        if(current == null){
            return;
        }
        clearRecursive(current.right);
        current.student=null;
        clearRecursive(current.left);
    }

    @Override
    public void clear() {
       clearRecursive(root);
       count=0;
    }
}

