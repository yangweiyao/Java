package com.yangweiyao.lambda;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-24 17:41
 * @Description
 **/
public class LambdaTest {

    public static void main(String[] args) {
//        String text = handlerString(new MyFunc<String>() {
//            @Override
//            public String getValue(String s) {
//                return s.toUpperCase();
//            }
//        }, "java");
        String text = handlerString(String::toUpperCase, "java");
        text = handlerString(s -> s.substring(0, 2), text);
        System.out.println(text);
    }

    public static String handlerString(MyFunc<String> myFunc, String text) {
        return myFunc.getValue(text);
    }

}
