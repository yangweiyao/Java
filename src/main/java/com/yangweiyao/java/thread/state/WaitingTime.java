package com.yangweiyao.java.thread.state;

import java.util.concurrent.TimeUnit;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 16:41
 * @Description 验证线程的 TIMED_WAITING 状态
 * @see java.lang.Thread.State
 **/
public class WaitingTime implements Runnable {

    @Override
    public void run() {
        while (true) {
            // 循环调用TimeUnit.SECONDS.sleep来验证线程的 TIMED_WAITING 状态
            waitSecond(200);
        }
    }

    public static void waitSecond(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
