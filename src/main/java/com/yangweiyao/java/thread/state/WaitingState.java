package com.yangweiyao.java.thread.state;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 16:43
 * @Description
 **/
public class WaitingState implements Runnable {

    @Override
    public void run() {
        while (true) {
            synchronized (WaitingState.class) {
                try {
                    WaitingState.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
