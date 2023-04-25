package com.yangweiyao.java.thread.fork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-25 14:47
 * @Description
 **/
public class ForkJoinPoolTest {

    private static final Integer MAX = 200;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        // 简单的Join/Fork计算过程，将1—1亿数字相加
        ForkJoinTask<Long> taskFuture =  pool.submit(new MyForkJoinTask(1L, 100000000L));
        try {
            long result = taskFuture.get();
            System.out.println("result = " + result + ", cost = " + (System.currentTimeMillis() - start) / 1000);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.out);
        }
    }

    static class MyForkJoinTask extends RecursiveTask<Long> {

        // 子任务开始计算的值
        private final Long startValue;

        // 子任务结束计算的值
        private final Long endValue;

        public MyForkJoinTask(Long startValue, Long endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        protected Long compute() {
            if(endValue - startValue < MAX) {
                System.out.println(Thread.currentThread().getName() + "：startValue = " + startValue + ";endValue = " + endValue);
                long totalValue = 0;
                for(long index = this.startValue; index <= this.endValue; index++) {
                    totalValue += index;
                }
                return totalValue;
            } else {
                // 进行任务拆分，拆分成两个任务
                MyForkJoinTask subTask1 = new MyForkJoinTask(startValue, (startValue + endValue) / 2);
                subTask1.fork();
                MyForkJoinTask subTask2 = new MyForkJoinTask((startValue + endValue) / 2 + 1 , endValue);
                subTask2.fork();
                return subTask1.join() + subTask2.join();
            }
        }
    }

}
