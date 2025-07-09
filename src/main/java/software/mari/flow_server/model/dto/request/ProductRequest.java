package software.mari.flow_server.model.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String groupName;

    @NotBlank
    private String description;

    @NotBlank
    private String logo;

    @NotNull
    private List<Long> categoryIds;

}
