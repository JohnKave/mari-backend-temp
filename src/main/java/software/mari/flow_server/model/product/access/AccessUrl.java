package software.mari.flow_server.model.product.access;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import software.mari.flow_server.model.product.Product;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "access_url")
public class AccessUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accessURL_id;

    @Column(name = "access_url", nullable = false)
    private String access_url;

    @ManyToOne
    @JoinColumn(name = "platform_id", nullable = false)
    private Platform platform;
}
