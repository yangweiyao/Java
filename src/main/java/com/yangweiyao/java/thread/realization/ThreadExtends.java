package com.yangweiyao.java.thread.realization;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 16:12
 * @Description 通过继承Thread实现线程
 **/
public class ThreadExtends extends Thread {

    public ThreadExtends() {
    }

    public ThreadExtends(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 通过继承Thread实现线程，但继承很宝贵，不推荐这种方式");
    }
}
