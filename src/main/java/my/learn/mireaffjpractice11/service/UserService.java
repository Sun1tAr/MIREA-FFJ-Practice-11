package my.learn.mireaffjpractice11.service;

import my.learn.mireaffjpractice11.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUser(Long id);


}
