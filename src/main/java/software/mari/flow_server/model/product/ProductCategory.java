package software.mari.flow_server.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productCategoryId;

    @Column(name = "name", nullable = false, length = 50)
    private String categoryName;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String categoryDescription;

}
