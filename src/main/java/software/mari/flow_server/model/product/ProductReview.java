package software.mari.flow_server.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.mari.flow_server.model.User;

@Entity
@Table(name = "product_review")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productReviewId;

    @Min(0)
    @Max(5)
    @Column(name = "product_rating", nullable = false)
    private Integer productRating;

    @Column(name = "product_comment", nullable = false, columnDefinition = "TEXT")
    private String productComment;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
