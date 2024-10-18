package net.springboot.rest_api_mysql.repository;
import net.springboot.rest_api_mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {

}
