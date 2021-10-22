package by.bstu.security.application;

import by.bstu.security.jwtSecurity.jwt.JwtTokenProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableJpaRepositories()
@EntityScan()
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
