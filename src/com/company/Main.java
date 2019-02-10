package com.company;

public class Main {

    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();
        list.add(1);
        list.add(2);
        System.out.println(list);
        list.set(1, 50);
        System.out.println(list);
        System.out.println(list.get(0));
        list.add(40);
        list.add(70);
        list.add(0, 100);
        list.add(2, 200);
        list.add(5, 300);
        list.add(7, 400);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains(70));
        list.clear();
        System.out.println(list.isEmpty());
    }
}
