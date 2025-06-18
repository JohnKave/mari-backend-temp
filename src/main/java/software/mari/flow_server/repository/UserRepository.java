package software.mari.flow_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.mari.flow_server.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
