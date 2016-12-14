package com.sbrf;

import com.sbrf.dao.api.OwnerDAO;
import com.sbrf.dao.model.Account;
import com.sbrf.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class Application {
    //class for testing DB

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        OwnerDAO ownerDAO = applicationContext.getBean(OwnerDAO.class);
//        ownerDAO.create(new Owner("Petr", "", "Vasnetsov", 1));
//        AccountDAO accountDAO = applicationContext.getBean(AccountDAO.class);
//        accountDAO.create(new Account(123456789012345L, BigDecimal.ZERO, 2));
        AccountService accountService = applicationContext.getBean(AccountService.class);
        long id = 2 /*accountService.addAccount(new Account(92837053L, 2))*/;
        Account account = accountService.findById(id);
        System.out.println(accountService.checkMoney(account));
        accountService.putMoney(account, new BigDecimal(100));
        System.out.println(accountService.checkMoney(account));
//        account = accountService.findById(id);
        accountService.withdrawMoney(account, new BigDecimal(50));
        System.out.println(accountService.checkMoney(account));


    }
}
