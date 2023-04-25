package com.yangweiyao.lambda;

import com.yangweiyao.lambda.bean.UserInfo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-25 10:14
 * @Description
 **/
public class StreamApiTest {

    private static final Map<Long, List<UserInfo>> MAP = new HashMap<>(4);
    private static final List<UserInfo> USER_INFOS = new ArrayList<>(4);

    public static void main(String[] args) {

        System.out.println("\n=============== 过滤filter ===============");
        // 过滤age大于18的元素
        USER_INFOS.stream().filter(userInfo -> userInfo.getAge() > 18).forEach(System.out::println);

        System.out.println("\n=============== 截断limit ===============");
        // 截止2个元素，即只返回前面2个元素
        USER_INFOS.stream().limit(2).forEach(System.out::println);

        System.out.println("\n=============== 跳过skip ===============");
        // 跳过、绕过2个元素，即跳过前面2个元素，只取后面元素，与limit互补
        USER_INFOS.stream().skip(2).forEach(System.out::println);

        System.out.println("\n=============== 去重distinct ===============");
        // 去除重复元素，前提需重写元素的equals、hashCode()
        USER_INFOS.stream().distinct().forEach(System.out::println);

        System.out.println("\n=============== 映射新的元素map ===============");
        // 获取所有用户姓名并去重
        List<String> names = USER_INFOS.stream().map(UserInfo::getName).distinct().collect(Collectors.toList());
        System.out.println(names);

        System.out.println("\n=============== flatMap ===============");
        // 将List<UserInfo>转成stream，然后获取用户姓名
        // flatMap()将流中每个值转换成另一个流，然后把所有流连接成一个流
        Collection<List<UserInfo>> values = MAP.values();
        System.out.println(values.stream().flatMap(Collection::stream).map(UserInfo::getName).distinct().collect(Collectors.toList()));

        System.out.println("\n=============== 排序（正序）sorted ===============");
        // 按年龄正序，默认正序（从小到大）
        USER_INFOS.stream().sorted(Comparator.comparing(UserInfo::getAge)).distinct().forEach(System.out::println);
        System.out.println("\n=============== 排序（倒序）sorted ===============");
        // reversed() 倒序
        USER_INFOS.stream().sorted(Comparator.comparing(UserInfo::getAge).reversed()).distinct().forEach(System.out::println);

        System.out.println("\n=============== noneMatch ===============");
        // 判断所有用户是否都成年 age>=18
        // allMatch() 当所有元素都满足条件才返回true
        boolean flag = USER_INFOS.stream().allMatch(userInfo -> userInfo.getAge() >= 18);
        System.out.println("判断所有用户是否都成年:" + flag); // true

        System.out.println("\n=============== allMatch ===============");
        // 判断所有用户是否到退休年龄 age>=60
        // noneMatch() 当所有元素都不满足条件才返回true
        boolean flag_n = USER_INFOS.stream().noneMatch(userInfo -> userInfo.getAge() < 60);
        System.out.println("判断所有用户是否到退休年龄:" + flag_n); // false

        System.out.println("\n=============== findFirst ===============");
        // 寻找第一个元素，如果存在（ifPresent），则打印用户信息
        Optional<UserInfo> userInfo = USER_INFOS.stream().findFirst();
        userInfo.ifPresent(System.out::println);

        System.out.println("\n=============== findAny ===============");
        // 返回任意元素，注：只是为了最快返回任意元素，不具备有随机性
        Optional<UserInfo> randomUser = USER_INFOS.stream().findAny();
        randomUser.ifPresent(System.out::println);

        System.out.println("\n=============== max ===============");
        // 获取薪资最高的用户信息
        Optional<UserInfo> max = USER_INFOS.stream().max(Comparator.comparing(UserInfo::getSalary));
        max.ifPresent(System.out::println);

        System.out.println("\n=============== min ===============");
        // 获取薪资最低的用户信息
        Optional<UserInfo> min = USER_INFOS.stream().min(Comparator.comparing(UserInfo::getSalary));
//        Optional<UserInfo> min = USER_INFOS.stream().map(UserInfo::getSalary).min(Double::compareTo);
        min.ifPresent(System.out::println);

        System.out.println("\n=============== reduce ===============");
        // 获取所有用户薪资总和
        // reduce 将流中元素反复结合起来得到新值
        Optional<Double> reduce = USER_INFOS.stream().map(UserInfo::getSalary).reduce(Double::sum);
        double sum = USER_INFOS.stream().mapToDouble(UserInfo::getSalary).sum();
        System.out.println(sum); // 精度丢失
        reduce.ifPresent(System.out::println); // 精度丢失
    }


    static {

        UserInfo userInfo = new UserInfo("张三", 18, 5000.0);
        UserInfo userInfo2 = new UserInfo("李四", 30, 3666.5);
        UserInfo userInfo3 = new UserInfo("王五", 55, 5999.6);
        UserInfo userInfo4 = new UserInfo("赵六", 22, 78885.1);
        UserInfo userInfo5 = new UserInfo("张三", 18, 5000.0);

        List<UserInfo> userInfos_1 = new ArrayList<>(2);
        userInfos_1.add(userInfo);
        userInfos_1.add(userInfo2);
        MAP.put(1L, userInfos_1);
        List<UserInfo> userInfos_2 = new ArrayList<>(4);
        userInfos_2.add(userInfo3);
        userInfos_2.add(userInfo4);
        userInfos_2.add(userInfo5);
        MAP.put(2L, userInfos_2);

        USER_INFOS.add(userInfo);
        USER_INFOS.add(userInfo2);
        USER_INFOS.add(userInfo3);
        USER_INFOS.add(userInfo5);
        USER_INFOS.add(userInfo4);

    }

}
