package software.mari.flow_server.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="platform")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long platformId;

    @Column(name = "name", nullable = false)
    private String platformName;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
