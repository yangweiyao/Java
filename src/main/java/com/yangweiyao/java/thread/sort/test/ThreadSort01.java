package com.yangweiyao.java.thread.sort.test;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 18:12
 * @Description 线程的顺序是不确定的
 **/
public class ThreadSort01 {

    public static void main(String[] args) {

        Thread thread_1 = new Thread(() -> System.out.println("thread_1"));
        Thread thread_2 = new Thread(() -> System.out.println("thread_2"));
        Thread thread_3 = new Thread(() -> System.out.println("thread_3"));

        /*
            调用Thread的start()方法启动线程时，线程的执行顺序是不确定的。
            也就是说，在同一个方法中，连续创建多个线程后，调用线程的start()方法的顺序并不能决定线程的执行顺序。
         */
        thread_1.start();
        thread_2.start();
        thread_3.start();
    }

}
