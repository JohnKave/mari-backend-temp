package software.mari.flow_server.model.product.highlight;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.mari.flow_server.model.product.Product;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "product_highlight")
public class ProductHighlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productHighLight_id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "url", nullable = false,columnDefinition = "TEXT")
    private String url;

    @Column(name = "file_type", nullable = false)
    private String file_type;




}
