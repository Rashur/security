package by.bstu.security.service;

import by.bstu.security.model.User;
import by.bstu.security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        log.info("IN UserServiceImpl saveUser {}",user);
        return userRepository.save(user);
    }

    public User findByLogin(String login) {
        User user = userRepository.findByLogin(login);
        log.info("IN UserServiceImpl findByLogin {},{}",login,user);
        return user;
    }

    public User findByLoginAndPassword(String login, String password) {
        User user = userRepository.findByLoginAndPassword(login, password);
        if(user != null) {
            if(bCryptPasswordEncoder.matches(password, user.getPassword())){
                return user;
            }
        }
        log.info("IN UserServiceImpl findByLoginAndPassword {}, {}, {}",login,password,user);
        return null;
    }
}
