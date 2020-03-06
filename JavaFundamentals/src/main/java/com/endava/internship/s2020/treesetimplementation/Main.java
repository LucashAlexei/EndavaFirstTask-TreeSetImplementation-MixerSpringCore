package com.endava.internship.s2020.treesetimplementation;

import java.time.LocalDate;
import java.util.Iterator;
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

        StudentSet treeSet = new StudentSet();

        treeSet.add(st3);
        treeSet.add(st3);
        treeSet.add(st3);
        //treeSet.add(st4);
        //treeSet.add(st5);
        treeSet.add(st);
        treeSet.add(st2);
        treeSet.add(st6);
        treeSet.add(st4);

        Iterator<Student> iter = treeSet.iterator();
        while(iter.hasNext()) {
            j++;
            System.out.println(j +") "+iter.next());
        }

        System.out.println("TreeSet Size: " + treeSet.size());

        TreeSet<Student> tmp = new TreeSet<>();
        tmp.add(st3);
        tmp.add(st);
        tmp.add(st5);
        tmp.add(st2);
        treeSet.add(st3);
        //adding tmp collection in treeSet
        System.out.println("Count before: " + treeSet.size());
        treeSet.addAll(tmp);
        System.out.println("Count after: " + treeSet.size());
        //iterator output
        System.out.println("\n");

        Iterator<Student> iter2 = treeSet.iterator();
        j=0;
        while(iter2.hasNext()) {
            j++;
            System.out.println(j +") "+iter2.next());
        }

        System.out.println("\nTreeSet Size: " +  treeSet.size());
        System.out.println("\nContains obj? " + treeSet.contains(st2));

        System.out.println("\nRemoving student: "+st4.toString());
        System.out.println(treeSet.remove(st4));

        Student arr[] = treeSet.toArray();
        System.out.println("\ntoArray");
        for(Student i: arr){
            k++;
            System.out.println(k + ")" + i);
        }

        System.out.println("Empty? " + treeSet.isEmpty());

        System.out.println("Clearing: ");
        treeSet.clear();

        System.out.println("TreeSet Size: " + treeSet.size());
        System.out.println("Empty? " + treeSet.isEmpty());

        Iterator<Student> iter3 = treeSet.iterator();
        j=0;
        while(iter3.hasNext() ) {
            j++;
            System.out.println(j +")"+iter3.next());
        }
    }
}

