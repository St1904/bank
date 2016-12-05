package service;

import dao.api.UserDAO;
import dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterServiceImpl implements RegisterService {
    private final UserDAO userDAO;

    @Autowired
    public RegisterServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean checkLoginIsNotUsed(String login) {
        return !userDAO.checkByLogin(login);
    }

    @Override
    public long addUser(User user) {
        long id = 0;
        if (checkLoginIsNotUsed(user.getLogin())) {
            id = userDAO.create(user);
        }
        return id;
    }
}
