package com.endava.internship.s2020.treesetimplementation;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {

    public static void main(String []args){

        Student st  = new Student("Maxim", LocalDate.of(1998,12,8),"Student");
        Student st2 = new Student("Vasili", LocalDate.of(1996,12,20),"Developer");
        Student st3 = new Student("Alexei", LocalDate.of(1997,2,15),"Engineer");
        Student st4 = new Student("Alexei", LocalDate.of(1999,1,25),"Manager");
        Student st6 = new Student("Alexei", LocalDate.of(1998,4,15),"Apple");

        Student st5 = new Student("Anton", LocalDate.of(1998,5,22),"Friend");

        StudentSet treeSet = new StudentSet();
        treeSet.add(st);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st6);

        TreeSet<Student> tmp = new TreeSet();
        tmp.add(st);
        tmp.add(st5);

        treeSet.addAll(tmp);

        //iterator output
        Iterator<Student> iter = treeSet.iterator();
        while(iter.hasNext() ) {
                System.out.println(iter.next());
        }

        System.out.println("Size: "+ treeSet.size());
        System.out.println(treeSet.contains(st2));

        Student arr[] = treeSet.toArray();
        for(Student i: arr){
            System.out.println("toArray: " + i);
        }
        System.out.println("Empty? " + treeSet.isEmpty());
        //treeSet.toArray();

        //treeSet.print();
        //System.out.println(treeSet.iterator());
    }
}
