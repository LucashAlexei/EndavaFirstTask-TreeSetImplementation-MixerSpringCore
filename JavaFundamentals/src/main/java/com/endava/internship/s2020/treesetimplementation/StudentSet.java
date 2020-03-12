package com.endava.internship.s2020.treesetimplementation;

import java.util.*;

public class StudentSet<T> implements Set<T> {
    private Node node = new Node();

    StudentSet() {
    }

    @Override
    public int size() {
        return node.getSize();
    }

    @Override
    public boolean isEmpty() {
        return node.isEmptyTree();
    }

    @Override
    public boolean contains(Object o) {
        return node.containsObject(o);
    }

    @Override
    public boolean add(T student) {
        return node.addObject((Student) student);
    }

    @Override
    public boolean remove(Object student) {
        boolean bool = node.deleteObject(student);
        return bool;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node tmp = node.getRoot();
            private NodeIterator nodeIterator = new NodeIterator(tmp);

            @Override
            public boolean hasNext() {
                return nodeIterator.hasNextRoot();
            }

            @Override
            public T next() {
                return (T) nodeIterator.nextRoot();
            }
        };
    }

    @Override
    public Student[] toArray() {
        Student[] array = new Student[node.getSize()];
        Iterator<T> iter2 = iterator();
        int j = 0;
        while (iter2.hasNext()) {
            array[j] = (Student) iter2.next();
            j++;
        }
        return array;
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
    public boolean addAll(Collection<? extends T> collection) {
        boolean boolAddAll = false;
        for (T st : collection) {
            boolAddAll = node.addObject((Student) st);
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

    @Override
    public void clear() {
        node.clearTree();
    }
}

