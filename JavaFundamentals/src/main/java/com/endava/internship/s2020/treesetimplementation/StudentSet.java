package com.endava.internship.s2020.treesetimplementation;

import java.util.*;

public class StudentSet extends Student implements Set<Student> {

    //private Set<Student> treeSet = new TreeSet<Student>();
    int count = 0;
    boolean boolCont;
    boolean boolAdd;
    boolean boolAddAll;
    private transient NavigableMap<Student,Object> map;


    private Student setTree[] = new Student[16];

    StudentSet(){
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    public void print() {
        int i = 0;
        do {
            System.out.println("!: " + setTree[i]);
            i++;
        }while(setTree[i]!=null);
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0;i<setTree.length;i++) {
            if (setTree[i] != null) {
                //System.out.println("collection: " + setTree[i].hashCode() + " o: " + o.hashCode());
                if (o.hashCode() == setTree[i].hashCode()){
                    boolCont = true;
                    break;
                }
                else
                    boolCont = false;
            }
        }
        return boolCont;
    }

    @Override
    public Iterator<Student> iterator() {

        LinkedList<Student> list = new LinkedList<>();
        for(int i=0;i<setTree.length;i++){
            if(setTree[i]!=null){
                list.add(setTree[i]);
            }
        }
        Iterator<Student> iter = list.iterator();
        list.sort(Comparator.comparing(Student::getName).thenComparing(Student::getDateOfBirth));

        while (iter.hasNext()){
            System.out.println("Iter: "+iter.next());
        }
        return iter;
    }

    @Override
    public Student[] toArray() {
        Student arr[] = new Student[count];
        LinkedList<Student> list = new LinkedList<>();
        for(int i=0;i<count;i++){
            if(setTree[i]!=null){
                list.add(setTree[i]);
            }
        }
        list.sort(Comparator.comparing(Student::getName).thenComparing(Student::getDateOfBirth));
        for (int i =0; i < list.size(); i++)
            arr[i] = list.get(i);

        return arr;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Student student) {
        for(int i =0; i<count; i++){
            if(setTree[i].equals(student)){
                return false;
                }
            }
            setTree[count] = student;
            count++;
            return true;
    }

    @Override
    public boolean remove(Object o) {
        for(int i = 0;i<setTree.length;i++){
            if(setTree[i].equals(o)){
                setTree[i]=null;
                count--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        //Ignore this for homework          ?
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Student> collection) {
        System.out.println("count before: " + count);
        for(Student st: collection){
            for(int i =0; i<count; i++){
                if(setTree[i].equals(st)){
                    return boolAddAll=false;
                }
            }
            System.out.println("before: " + count);
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
        Arrays.fill(setTree, null);
    }
}
