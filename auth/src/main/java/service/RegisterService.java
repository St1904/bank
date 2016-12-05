package service;

import dao.model.User;

public interface RegisterService {
    boolean checkLoginIsNotUsed(String login);
    long addUser(User user);
}
