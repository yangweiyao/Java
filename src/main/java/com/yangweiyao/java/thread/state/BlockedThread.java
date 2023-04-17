package com.yangweiyao.java.thread.state;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 16:52
 * @Description BlockedThread主要是在synchronized代码块中的while(true)循环中调用TimeUnit.SECONDS.sleep(long)方法来验证线程的
 * BLOCKED状态。当启动两个BlockedThread线程时，首先启动的线程会处于TIMED_WAITING状态，后启动的线程会处于BLOCKED状态
 **/
public class BlockedThread implements Runnable {

    @Override
    public void run() {
        synchronized (BlockedThread.class) {
            while (true) {
                WaitingTime.waitSecond(100);
            }
        }
    }

}
