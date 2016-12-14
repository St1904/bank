package com.sbrf.service;

import com.sbrf.dao.model.Account;

import java.math.BigDecimal;

public interface AccountService {
    void putMoney(Account account, BigDecimal money);
    void withdrawMoney(Account account, BigDecimal money);
    BigDecimal checkMoney(Account account);
    long addAccount(Account account);
    Account findById(long id);
}
