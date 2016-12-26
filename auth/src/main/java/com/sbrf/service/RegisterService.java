package com.sbrf.service;

import com.sbrf.dao.model.User;

public interface RegisterService {
    boolean checkLoginIsNotUsed(String login);
    User readByLogin(String login);
    long addUser(User user);
}
