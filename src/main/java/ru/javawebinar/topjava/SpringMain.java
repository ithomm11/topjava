package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        System.out.println("Hello");
//        String s1 = "Cc";
//        String s2 = "BbB";
//        String s3 = "AaA";
//
//        System.out.println(s1.compareTo(s2));
//        System.out.println(s2.compareTo(s1));
//        System.out.println(s2.compareTo(s2));

//        List<String>

        // java 7 automatic resource management (ARM)
//        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
//            for(String name : appCtx.getBeanDefinitionNames())
//                System.out.println(name);
////            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
//            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
//            adminUserController.create(new User(null, "userName", "email@mail.ru", "password", Role.ADMIN));
//            adminUserController.create(new User(null, "A", "email1@mail.ru", "password", Role.USER));
//            adminUserController.create(new User(null, "A", "email2@mail.ru", "password", Role.USER));
//            adminUserController.create(new User(null, "A", "email3@mail.ru", "password", Role.USER));
//
//            adminUserController.create(new User(null, "C", "email4@mail.ru", "password", Role.USER));
//
//            adminUserController.create(new User(null, "B", "email5@mail.ru", "password", Role.USER));
//            adminUserController.create(new User(null, "B", "email6@mail.ru", "password", Role.USER));
//            adminUserController.create(new User(null, "B", "email7@mail.ru", "password", Role.USER));
//
//            for(User user : adminUserController.getAll())
//                System.out.println(user.getName());
    }
}
