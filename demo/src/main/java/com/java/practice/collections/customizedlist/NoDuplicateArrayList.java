package com.java.practice.collections.customizedlist;

import java.util.ArrayList;

public class NoDuplicateArrayList<E> extends ArrayList<E> {
    @Override
    public boolean add(E e) {
        if (this.contains(e)) {
            return false;
        }
        return super.add(e);
    }

    public static void main(String[] args) {
        NoDuplicateArrayList<String> noDuplicateArrayList = new NoDuplicateArrayList<>();
        noDuplicateArrayList.add("A");
        noDuplicateArrayList.add("A");
        noDuplicateArrayList.add("B");
        noDuplicateArrayList.add("B");
        noDuplicateArrayList.add("C");
        noDuplicateArrayList.add("C");

        System.out.println(noDuplicateArrayList);
    }
}