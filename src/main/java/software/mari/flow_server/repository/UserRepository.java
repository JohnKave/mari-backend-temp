package software.mari.flow_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.mari.flow_server.model.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByMail(String mail);
    boolean existsByMail(String mail);
}
