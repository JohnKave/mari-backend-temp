package software.mari.flow_server.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long productId;
    private String productName;
    private String productGroupName;
    private String productDescription;
    private String productLogo;
    private LocalDateTime createAt;

    private List<ProductCategoryResponse> categories;
    private UserResponse user;

}
