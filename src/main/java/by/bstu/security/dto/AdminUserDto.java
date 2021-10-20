package by.bstu.security.dto;

import by.bstu.security.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String login;
    private String password;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setLogin(user.getLogin());
        adminUserDto.setPassword(user.getPassword());
        return adminUserDto;
    }

}
