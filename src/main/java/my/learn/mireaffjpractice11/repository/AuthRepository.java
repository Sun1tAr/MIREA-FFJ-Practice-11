package my.learn.mireaffjpractice11.repository;

import my.learn.mireaffjpractice11.entity.UserAuth;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<UserAuth, Long> {

    UserAuth findByUsername(String username);

}
