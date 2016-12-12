package com.sbrf;

import com.sbrf.dao.api.OwnerDAO;
import com.sbrf.dao.model.Owner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    //class for testing DB

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
//        AppConfig appConfig = new AppConfig();
//        JdbcTemplate jdbcTemplate = appConfig.jdbcTemplate(appConfig.dataSource());

//        jdbcTemplate.execute("insert into user (login, password) values ('vasya', '11')");
//        UserDAO userDAO = new UserDAO(jdbcTemplate, appConfig.dataSource());
//        System.out.println(userDAO.checkByLogin("St"));
//        System.out.println(userDAO.checkByLogin("St1"));
//        RegisterService registerService = new RegisterServiceImpl(userDAO);
//        System.out.println(registerService.checkLoginIsNotUsed("St"));
//        System.out.println(registerService.checkLoginIsNotUsed("St1"));
//        System.out.println(registerService.addUser(new User("St", "1111")));
//        UserDAO userDAO = applicationContext.getBean(UserDAO.class);
//        System.out.println(userDAO.checkByLogin("St"));
//        userDAO.create(new User("petya", "123"));

//        System.out.println(userDAO.read(3));

        OwnerDAO ownerDAO = applicationContext.getBean(OwnerDAO.class);
        ownerDAO.create(new Owner("Petr", "", "Vasnetsov", 1));

    }
}
