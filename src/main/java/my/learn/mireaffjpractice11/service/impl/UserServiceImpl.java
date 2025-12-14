package my.learn.mireaffjpractice11.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice11.entity.User;
import my.learn.mireaffjpractice11.exception.ConflictException;
import my.learn.mireaffjpractice11.repository.UserRepository;
import my.learn.mireaffjpractice11.service.UserService;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User save(User user) {
        User saved;
        try {
            saved = userRepository.save(user);
        } catch (Exception e) {
            throw new ConflictException("User could not be saved");
        }
        return saved;
    }
}
