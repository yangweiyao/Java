package com.yangweiyao.java.thread.state;

/**
 * @author yangweiyao@tydic.com
 * @date 2023/09/22 11:38
 * @description
 **/
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
                while (true) {
                    System.out.println("------------------------>");
                }
        });
        thread.start();

        // 中断线程。这里的中断线程并不会立即停止线程，而是设置线程的中断状态为 true（默认是 false）；
//        thread.interrupt();

        // 测试当前线程是否被中断。线程的中断状态会受这个方法的影响，调用一次可以使线程中断状态变为 true，调用两次会使这个线程的中断状态重新转为 false；
//        Thread.currentThread().isInterrupted();


    }

}
