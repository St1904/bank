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

        OwnerDAO ownerDAO = applicationContext.getBean(OwnerDAO.class);
        ownerDAO.create(new Owner("Petr", "", "Vasnetsov", 1));

    }
}
