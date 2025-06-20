package software.mari.flow_server.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "access_url")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccessUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accessUrlId;

    @Column(name = "access_url", nullable = false)
    private String accessUrl;

    @ManyToOne
    @JoinColumn(name = "platform_id", nullable = false)
    private Platform platform;
}
