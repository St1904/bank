package util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {
    //class for testing

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        AppConfig appConfig = new AppConfig();
        JdbcTemplate jdbcTemplate = appConfig.jdbcTemplate(appConfig.dataSource());

        jdbcTemplate.execute("insert into user (login, password) values ('vasya', '11')");
    }
}
