package software.mari.flow_server.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.mari.flow_server.model.user.User;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "productCategory_id", nullable = false)
    private ProductCategory productCategory;

    @Column(name = "name", nullable = false)
    private String productName;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "product_logo", nullable = false, columnDefinition = "TEXT")
    private String productLogo;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;


}
