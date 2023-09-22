package com.yangweiyao.java.thread.state;

/**
 * @author yangweiyao@tydic.com
 * @date 2023/09/22 11:30
 * @description
 **/
public class ThreadStateChanged {

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(ThreadStateChanged::testMethod, "a");

        Thread b = new Thread(ThreadStateChanged::testMethod, "b");

        a.start();

        /**
         * main 线程休息的时间，要保证在线程争夺锁的时间内，
         * 不要等到前一个线程锁都释放了你再去争夺锁，此时还是得不到 BLOCKED 状态的
         * a:TIMED_WAITING
         * b:BLOCKED
         */
//        Thread.sleep(1000L);

//        a.join(); // a: TIMED_WAITING -> RUNNABLE -> TERMINATED
        b.start();

        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    // 同步方法争夺锁
    private static synchronized void testMethod() {
        try {
            // sleep不会释放锁
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
