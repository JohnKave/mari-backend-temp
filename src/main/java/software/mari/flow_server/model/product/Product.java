package software.mari.flow_server.model.product;

import jakarta.persistence.*;
import jdk.jfr.Category;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.mari.flow_server.model.User;
import software.mari.flow_server.model.product.highlight.ProductHighlight;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "productCategory_id", nullable = false)
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "productRating_id", nullable = false)
    private ProductRating productRating;

    @Column(name = "name", nullable = false)
    private String product_name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String product_description;

    @Column(name = "product_logo", nullable = false, columnDefinition = "TEXT")
    private String product_logo;

    @Column(name = "create_at", nullable = false)
    private Timestamp create_at;

    @Column(name = "update_at", nullable = false)
    private Timestamp update_at;

}
