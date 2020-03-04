package com.endava.internship.s2020.treesetimplementation;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String []args){

        int j = 0, k = 0;

        Student st  = new Student("Maxim", LocalDate.of(1998,12,8),"Student");
        Student st2 = new Student("Vasili", LocalDate.of(1996,12,20),"Developer");
        Student st3 = new Student("Alexei", LocalDate.of(1997,2,15),"Engineer");
        Student st4 = new Student("Alexei", LocalDate.of(1999,1,25),"Manager");
        Student st5 = new Student("Anton", LocalDate.of(1998,5,22),"Friend");
        Student st6 = new Student("Alexei", LocalDate.of(1998,4,15),"Apple");

        StudentSet<Student> treeSet = new StudentSet<>();
        treeSet.add(st);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);
        treeSet.add(st6);

        TreeSet<Student> tmp = new TreeSet();
        tmp.add(st);
        tmp.add(st5);
        //adding tmp collection in treeSet
        treeSet.addAll(tmp);

        //iterator output
        Iterator<Student> iter = treeSet.iterator();
        while(iter.hasNext() ) {
                j++;
                System.out.println(j +")"+iter.next());
        }

        System.out.println("\nSize: "+ treeSet.size());
        System.out.println("\nContains obj? " + treeSet.contains(st2));

        System.out.println("\nRemoving student: "+st4.toString());
        treeSet.remove(st4);


        Student arr[] = (Student[]) treeSet.toArray();
        System.out.println("\ntoArray");
        for(Student i: arr){
            k++;
            System.out.println(k + ")" + i);
        }

        System.out.println("Empty? " + treeSet.isEmpty());
        System.out.println(treeSet.size());
        //System.out.println(treeSet.iterator());

        treeSet.clear();
        System.out.println(treeSet.size());

        j=0;
        Iterator<Student> iter2 = treeSet.iterator();
        while(iter2.hasNext() ) {
            j++;
            System.out.println(j +")"+iter2.next());
        }
    }
}

