package com.sbrf.dao.api;

import com.sbrf.dao.model.Account;

public class AccountDAO implements GenericDAO<Account> {
    @Override
    public long create(Account account) {
        return 0;
    }

    @Override
    public Account read(long id) {
        return null;
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public void delete(Account account) {

    }
}
