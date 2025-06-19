package software.mari.flow_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.mari.flow_server.model.product.Product_comment;

public interface ProductCommentRepository extends JpaRepository<Product_comment, String> {
}
