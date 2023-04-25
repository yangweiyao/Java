package com.yangweiyao.lambda;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-24 17:40
 * @Description
 **/
@FunctionalInterface
public interface MyFunc<T> {

    T getValue(T t);

}
