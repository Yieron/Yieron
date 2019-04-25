package com.helloandroid.yieron.yieron.utils;

class SingleTon {
    private static final SingleTon ourInstance = new SingleTon();

    static SingleTon getInstance() {
        return ourInstance;
    }

    private SingleTon() {
    }
}
