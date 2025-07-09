package software.mari.flow_server.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import software.mari.flow_server.exception.NotFoundException;
import software.mari.flow_server.model.dto.request.ProductRequest;
import software.mari.flow_server.model.dto.response.ProductCategoryResponse;
import software.mari.flow_server.model.dto.response.ProductResponse;
import software.mari.flow_server.model.product.Product;
import software.mari.flow_server.model.product.ProductCategory;
import software.mari.flow_server.model.user.User;
import software.mari.flow_server.repository.ProductCategoryRepository;
import software.mari.flow_server.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ModelMapper modelMapper;

    // Get product by product id
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product Not Found!"));
        return modelMapper.map(product, ProductResponse.class);
    }

    // Get all products


    // Create product
    public ProductResponse createProduct(ProductRequest request, User user) {

        List<ProductCategory> categories = productCategoryRepository.findAllById(request.getCategoryIds());

        if (categories.size() != request.getCategoryIds().size()) {
            List<Long> foundIds = categories.stream()
                    .map(ProductCategory::getProductCategoryId)
                    .toList();

            List<Long> missingIds = request.getCategoryIds().stream()
                    .filter(id -> !foundIds.contains(id))
                    .toList();

            throw new NotFoundException("Categories not found: " + missingIds);
        }


        Product product = Product.builder()
                .user(user)
                .categories(new HashSet<>(categories))
                .productName(request.getName())
                .productGroupName(request.getGroupName())
                .productDescription(request.getDescription())
                .productLogo(request.getLogo())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        productRepository.save(product);

        ProductResponse response = modelMapper.map(product, ProductResponse.class);
        response.setCategories(
                categories.stream()
                        .map(cat -> modelMapper.map(cat, ProductCategoryResponse.class))
                        .toList()
        );

        return response;
    }

}
