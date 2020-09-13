package com.miaoqi.mashibing.spring;

import org.junit.Test;

import java.util.stream.Stream;

public class MyTest2 {

    @Test
    public void test() {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            // 当前属性是否添加了 @AutoWired 注解
            field.setAccessible(true);
            AutoWired annotation = field.getAnnotation(AutoWired.class);
            if (annotation != null) {
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(userController, o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(userController.getUserService());
    }

}
