package com.yangweiyao.java.thread.sort.test;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 18:15
 * @Description 线程的顺序，Thread.join()方法能够确保线程的执行顺序
 **/
public class ThreadSort02 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread_1 = new Thread(() -> System.out.println("thread_1"));
        Thread thread_2 = new Thread(() -> System.out.println("thread_2"));
        Thread thread_3 = new Thread(() -> System.out.println("thread_3"));

        thread_1.start();
        /*
         * 类的main()方法中，调用子线程的join()方法，会阻塞main()方法的执行，当子线程执行完成后，main()方法会继
         * 续向下执行，启动第二个子线程，并执行子线程的业务逻辑，以此类推(实际上让主线程等待子线程执行完成)
         *  if (millis == 0) {
                while (isAlive()) {
                    // 调用线程的wait()方法时，会使主线程处于等待状态，等待子线程执行完成后再次向下执行。
                    wait(0);
                }
            }
         */
        thread_1.join();

        thread_2.start();
        thread_1.join();

        thread_3.start();
        thread_1.join();
    }

}
