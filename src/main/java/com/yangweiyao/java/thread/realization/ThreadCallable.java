package com.yangweiyao.java.thread.realization;

import java.util.concurrent.Callable;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 16:17
 * @Description
 **/
public class ThreadCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + ": 通过实现Callable实现线程，并且可以处理返回值以及异常";
    }

}
