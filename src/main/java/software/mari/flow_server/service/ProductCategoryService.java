package software.mari.flow_server.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import software.mari.flow_server.exception.NotFoundException;
import software.mari.flow_server.model.dto.request.ProductCategoryRequest;
import software.mari.flow_server.model.dto.response.ProductCategoryResponse;
import software.mari.flow_server.model.product.ProductCategory;
import software.mari.flow_server.repository.ProductCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ModelMapper modelMapper;

    // Get all
    public List<ProductCategoryResponse> getAllCategories() {
        return productCategoryRepository.findAll()
                .stream()
                .map(productCategory -> modelMapper.map(productCategory, ProductCategoryResponse.class))
                .toList();
    }

    // Get by id
    public ProductCategoryResponse getCategoryById(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category Not Found"));

        return modelMapper.map(productCategory, ProductCategoryResponse.class);
    }

    // Create
    public ProductCategoryResponse createCategory(ProductCategoryRequest request) {
        ProductCategory productCategory = ProductCategory.builder()
                .categoryName(request.getName())
                .categoryDescription(request.getDescription())
                .build();
        productCategoryRepository.save(productCategory);
        return modelMapper.map(productCategory, ProductCategoryResponse.class);
    }

    //update
    public ProductCategoryResponse updateCategory(Long id, ProductCategoryRequest request) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product category does not exist!"));
        if (request.getName() != null) {
            productCategory.setCategoryName(request.getName());
        }
        if (request.getDescription() != null) {
            productCategory.setCategoryDescription(request.getDescription());
        }
        ProductCategory updatedProductCategory = productCategoryRepository.save(productCategory);
        return modelMapper.map(updatedProductCategory, ProductCategoryResponse.class);
    }

    // Delete
    public void deleteCategory(Long id) {
        if (!productCategoryRepository.existsById(id)) {
            throw new NotFoundException("Category does not exist!");
        }
        productCategoryRepository.deleteById(id);
    }

}
