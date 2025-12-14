package my.learn.mireaffjpractice11.repository;

import my.learn.mireaffjpractice11.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
