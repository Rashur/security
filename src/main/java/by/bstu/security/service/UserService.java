package by.bstu.security.service;

import by.bstu.security.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByLogin(String login);

    User findByLoginAndPassword(String login,String password);

    User findById(Long id);

    void delete(Long id);
}
