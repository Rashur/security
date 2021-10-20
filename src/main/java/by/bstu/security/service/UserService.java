package by.bstu.security.service;

import by.bstu.security.model.User;

public interface UserService {

    User saveUser(User user);

    User findByLogin(String login);

    User findByLoginAndPassword(String login,String password);
}
