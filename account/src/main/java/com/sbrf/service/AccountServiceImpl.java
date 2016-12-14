package com.sbrf.service;

import com.sbrf.dao.api.AccountDAO;
import com.sbrf.dao.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountServiceImpl implements AccountService {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void putMoney(Account account, BigDecimal money) {
        Account account1 = findById(account.getId());
        accountDAO.updateMoney(account1, account1.getMoney().add(money));
    }

    @Override
    public void withdrawMoney(Account account, BigDecimal money) {
        Account account1 = findById(account.getId());
        accountDAO.updateMoney(account1, account1.getMoney().subtract(money));
    }

    @Override
    public BigDecimal checkMoney(Account account) {
        Account account1 = findById(account.getId());
        return account1.getMoney();
    }

    @Override
    public long addAccount(Account account) {
        return accountDAO.create(account);
    }

    public Account findById(long id) {
        return accountDAO.read(id);
    }
}
