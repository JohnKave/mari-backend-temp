package software.mari.flow_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.mari.flow_server.model.product.ProductRating;

public interface ProductRatingRepository extends JpaRepository<ProductRating, String> {
}
