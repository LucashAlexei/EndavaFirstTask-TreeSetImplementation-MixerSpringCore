package com.endava.internship.s2020.treesetimplementation;

import java.util.*;

public class StudentSet<A> implements Set<A> {

    //private Set<Student> treeSet = new TreeSet<Student>();
    int count = 0;
    boolean boolCont;
    boolean boolAddAll;

    private A[] setTree = (A[]) new Object[16];

    StudentSet() {
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }


    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < setTree.length; i++) {
            if (setTree[i] != null) {
                //System.out.println("collection: " + setTree[i].hashCode() + " o: " + o.hashCode());
                if (o.equals (setTree[i])) {
                    boolCont = true;
                    break;
                } else
                    boolCont = false;
            }
        }
        return boolCont;
    }

    @Override
    public Iterator<A> iterator() {

        LinkedList<Student> list = new LinkedList<>();
        for (int i = 0; i < setTree.length; i++) {
            if (setTree[i] != null) {
                list.add((Student) setTree[i]);
            }
        }
        Iterator<Student> iter = list.iterator();
        list.sort(Comparator.comparing(Student::getName).thenComparing(Student::getDateOfBirth));

//        while (iter.hasNext()){
//            System.out.println("Iter: "+iter.next());
//        }
        return (Iterator<A>) iter;
    }

    @Override
    public A[] toArray() {
        Student arr[] = new Student[count];
        LinkedList<Student> list = new LinkedList<>();
        for (int i = 0; i < count+1; i++) {
            if (setTree[i] != null) {
                list.add((Student) setTree[i]);
            }
        }

        list.sort(Comparator.comparing(Student::getName).thenComparing(Student::getDateOfBirth));
        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);

        return (A[]) arr;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(A student) {
        for (int i = 0; i < count; i++) {
            if (setTree[i].equals(student)) {
                return false;
            }
        }
        setTree[count] = student;
        count++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(contains(o)) {
            for (int i = 0; i < setTree.length; i++) {
                    if (setTree[i].equals(o)) {
                        setTree[i] = null;
                        count--;
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends A> collection) {
        for (A st : collection) {
            for (int i = 0; i < count; i++) {
                if (setTree[i].equals(st)) {
                    return boolAddAll = false;
                }
            }
            setTree[count++] = st;
            boolAddAll = true;
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
        count = 0;
        Arrays.fill(setTree, null);
    }

}

