package com.endava.internship.s2020.treesetimplementation;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        int j = 0;

        Student st = new Student("Maxim", LocalDate.of(1998, 12, 8), "Student");
        Student st2 = new Student("Vasili", LocalDate.of(1996, 12, 20), "Developer");
        Student st3 = new Student("Alexei", LocalDate.of(1997, 2, 15), "Engineer");
        Student st4 = new Student("Alexei", LocalDate.of(1999, 1, 25), "Manager");
        Student st5 = new Student("Anton", LocalDate.of(1998, 5, 22), "Friend");
        Student st6 = new Student("Alexei", LocalDate.of(1998, 4, 15), "Apple");

        StudentSet<Student> treeSet = new StudentSet<>();

        treeSet.add(st);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);
        treeSet.add(st6);
        treeSet.add(st6);
        treeSet.add(st6);
        treeSet.add(st4);

        System.out.println("Adding student: " + st2 + " : " + treeSet.add(st2));
        System.out.println("Adding student: " + st2 + " : " + treeSet.add(st2));

        Iterator<Student> iter = treeSet.iterator();
        while (iter.hasNext()) {
            j++;
            System.out.println(j + ") " + iter.next());
        }

        System.out.println("TreeSet Size: " + treeSet.size());

        TreeSet<Student> tmp = new TreeSet<>();
        tmp.add(st3);
        tmp.add(st);
        tmp.add(st5);

        System.out.println("Size before: " + treeSet.size());
        treeSet.addAll(tmp);
        System.out.println("Size after: " + treeSet.size());

        System.out.println("\n");
        Iterator<Student> iter2 = treeSet.iterator();
        j = 0;
        while (iter2.hasNext()) {
            j++;
            System.out.println(j + ") " + iter2.next());
        }

        System.out.println("\nTreeSet Size: " + treeSet.size());
        System.out.println("\nContains obj? " + treeSet.contains(st2));

        System.out.println("\nRemoving student: " + st5.toString());
        System.out.println(treeSet.remove(st5));
        System.out.println(treeSet.remove(st5));
        System.out.println("Size: " + treeSet.size());
        // treeSet.print();
        Iterator<Student> iter5 = treeSet.iterator();
        j = 0;
        while (iter5.hasNext()) {
            j++;
            System.out.println(j + ")" + iter5.next());
        }
        System.out.println("\ntoArray");
        Student arr[] = treeSet.toArray();
        for (int k = 0; k < arr.length; k++) {
            System.out.println((k + 1) + ")" + arr[k]);
        }

        System.out.println("\nEmpty? " + treeSet.isEmpty());

        System.out.println("Clearing: ");
        treeSet.clear();

        System.out.println("TreeSet Size: " + treeSet.size());
        System.out.println("Empty? " + treeSet.isEmpty());

        Iterator<Student> iter3 = treeSet.iterator();
        j = 0;
        while (iter3.hasNext()) {
            j++;
            System.out.println(j + ")" + iter3.next());
        }
    }
}

