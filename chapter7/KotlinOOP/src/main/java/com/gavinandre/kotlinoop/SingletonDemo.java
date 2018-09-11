package com.gavinandre.kotlinoop;

class SingletonDemo {
    private static SingletonDemo instance;

    /**
     * private
     */
    private SingletonDemo() {
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }
}