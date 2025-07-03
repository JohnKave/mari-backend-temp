package software.mari.flow_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.mari.flow_server.model.product.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
}
