package com.yangweiyao.java.thread.realization;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 16:15
 * @Description 通过实现Runnable实现线程
 **/
public class ThreadRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 通过实现Runnable实现线程，适合不需要处理返回值的场景");
    }

}
