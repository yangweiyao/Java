package com.yangweiyao.java.thread.state;

/**
 * @author yangweiyao@tydic.com
 * @date 2023/09/22 11:17
 * @description
 **/
public class ThreadState01 {

    /**
     * Thread.State 线程状态
     *  NEW,
     *  RUNNABLE (ready, running),
     *  BLOCKED,
     *  WAITING,
     *  TIMED_WAITING,
     *  TERMINATED;
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {}); // NEW

        /**
         * 连续调用start会报错，或者一个线程执行完毕（此时处于 TERMINATED 状态），再次调用这个线程的 start 方法也会报错
         * if (threadStatus != 0) throw new IllegalThreadStateException();
         */
        thread.start(); // RUNNABLE

        /**
         * 一直等待这个thread线程执行完毕
         * while (isAlive()) {
         *     wait(0);
         * }
         */
        thread.join(); // TERMINATED
        System.out.println(thread.getState());
    }

}
