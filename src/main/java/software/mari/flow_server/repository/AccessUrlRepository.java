package software.mari.flow_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.mari.flow_server.model.product.AccessUrl;

public interface AccessUrlRepository extends JpaRepository<AccessUrl, Long> {
}
