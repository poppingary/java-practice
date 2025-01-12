package com.java.practice.singletondesign;

public class LazyInnerClassSingleton {
    private LazyInnerClassSingleton() {

    }

    private static class SingletonHelper {
        private static final LazyInnerClassSingleton INSTANCE = new LazyInnerClassSingleton();
    }

    public static LazyInnerClassSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public static void main(String[] args) {
        LazyInnerClassSingleton object1 = LazyInnerClassSingleton.getInstance();
        System.out.println(object1.hashCode());

        LazyInnerClassSingleton object2 = LazyInnerClassSingleton.getInstance();
        System.out.println(object2.hashCode());
    }
}