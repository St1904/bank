package util;

import dao.api.UserDAO;
import dao.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import service.RegisterService;
import service.RegisterServiceImpl;

@SpringBootApplication
public class Application {
    //class for testing DB

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        AppConfig appConfig = new AppConfig();
        JdbcTemplate jdbcTemplate = appConfig.jdbcTemplate(appConfig.dataSource());

//        jdbcTemplate.execute("insert into user (login, password) values ('vasya', '11')");
        UserDAO userDAO = new UserDAO(jdbcTemplate, appConfig.dataSource());
//        System.out.println(userDAO.checkByLogin("St"));
//        System.out.println(userDAO.checkByLogin("St1"));
        RegisterService registerService = new RegisterServiceImpl(userDAO);
        System.out.println(registerService.checkLoginIsNotUsed("St"));
        System.out.println(registerService.checkLoginIsNotUsed("St1"));
        System.out.println(registerService.addUser(new User("St", "1111")));

    }
}
