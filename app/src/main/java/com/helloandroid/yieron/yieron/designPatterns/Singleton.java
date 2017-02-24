package com.helloandroid.yieron.yieron.designPatterns;

/**
 * 作者：yindong on 2017/2/24.
 * 邮箱：yieron@163.com
 * 版本：v1.0
 */

//懒汉式单例类.在第一次调用的时候实例化自己
public class Singleton {
    /**
     * 单例模式有以下特点：
     * 　　1、单例类只能有一个实例。
     * 　　2、单例类必须自己创建自己的唯一实例。
     * 　　3、单例类必须给所有其他对象提供这一实例。
     */

    //懒汉式
    /*
    private Singleton() {
    }

    private static Singleton single = null;

    public static Singleton getInstance() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }
    */
    //懒汉式优化
    //静态内部类
    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static final Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }


    //饿汉式
    /*
    private Singleton() {
    }

    private static final Singleton single = new Singleton();

    public static Singleton getInstance() {
        return single;
    }
    */
}
