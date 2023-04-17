package com.yangweiyao.java.thread.state.test;

import com.yangweiyao.java.thread.state.BlockedThread;
import com.yangweiyao.java.thread.state.WaitingState;
import com.yangweiyao.java.thread.state.WaitingTime;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 16:54
 * @Description Thread 运行状态
 **/
public class ThreadStateTest {

    public static void main(String[] args) {

        /*
            "WaitingTimeThread" #11 prio=5 os_prio=0 tid=0x000000001d633000 nid=0x9dc waiting on condition [0x000000001e1ff000]
            java.lang.Thread.State: TIMED_WAITING (sleeping)
         */
        new Thread(new WaitingTime(), "WaitingTimeThread").start();
        /*
            "WaitingState" #12 prio=5 os_prio=0 tid=0x000000001d636000 nid=0x5e04 in Object.wait() [0x000000001e2fe000]
            java.lang.Thread.State: WAITING (on object monitor)
         */
        new Thread(new WaitingState(), "WaitingState").start();

        /*
            "BlockedThread-01" #13 prio=5 os_prio=0 tid=0x000000001d63c800 nid=0x1714 waiting on condition [0x000000001e41e000]
            java.lang.Thread.State: TIMED_WAITING (sleeping)
         */
        new Thread(new BlockedThread(), "BlockedThread-01").start();
        /*
            "BlockedThread-02" #14 prio=5 os_prio=0 tid=0x000000001d642800 nid=0x3558 waiting for monitor entry [0x000000001e51f000]
            java.lang.Thread.State: BLOCKED (on object monitor)
         */
        new Thread(new BlockedThread(), "BlockedThread-02").start();
    }

}
