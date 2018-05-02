package edu.mum.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
        UserService userDao = (UserService) ctx.getBean("userServiceImpl");

        User eta = new User();
        eta.setEmail("ts.enkhtulga@gmail.com");
        eta.setFirstName("Enkhtulga");
        eta.setLastName("Tseveenkhuu");
        eta.setAdmin(true);
        eta.setRanking(1);
        userDao.save(eta);

        User user1 = userDao.findByEmail("ts.enkhtulga@gmail.com");

        System.out.println("******** User ********");
        System.out.println(user1.getFirstName() + user1.getLastName());

    }

}