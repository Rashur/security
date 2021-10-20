package by.bstu.security.rest;

import by.bstu.security.model.User;
import by.bstu.security.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/security/",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping(value = "/register/")
    public ResponseEntity<User> registerUser(@RequestBody User user) {

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userServiceImpl.saveUser(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<User> authUser(@RequestBody User user) {

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User authUser = userServiceImpl.findByLoginAndPassword(user.getLogin(), user.getPassword());

        if(authUser == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //here the code with jwt

        return new ResponseEntity<>(authUser, HttpStatus.OK);
    }
}
