package com.yangweiyao.java.thread.realization.test;


import com.yangweiyao.java.thread.realization.ThreadCallable;
import com.yangweiyao.java.thread.realization.ThreadExtends;
import com.yangweiyao.java.thread.realization.ThreadRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 16:19
 * @Description 3种实现线程方式
 **/
public class ThreadRealizationTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread thread_1 = new ThreadExtends("THREAD_EXTENDS");
        thread_1.start();

        Thread thread_2 = new Thread(new ThreadRunnable(), "THREAD_RUNNABLE");
        thread_2.start();

        FutureTask<String> futureTask = new FutureTask<>(new ThreadCallable());
        Thread thread_3 = new Thread(futureTask, "THREAD_CALLABLE");
        thread_3.start();
        System.out.println(futureTask.get());

    }

}
