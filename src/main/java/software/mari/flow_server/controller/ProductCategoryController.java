package software.mari.flow_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.mari.flow_server.model.dto.request.ProductCategoryRequest;
import software.mari.flow_server.model.dto.response.ProductCategoryResponse;
import software.mari.flow_server.model.product.ProductCategory;
import software.mari.flow_server.service.ProductCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    // Get all Categories
    @GetMapping
    public ResponseEntity<List<ProductCategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(productCategoryService.getAllCategories());
    }

    // Get one Category
    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryResponse> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryService.getCategoryById(id));
    }

    // Create Category
    @PostMapping
    public ResponseEntity<ProductCategoryResponse> createCategory(@RequestBody ProductCategoryRequest request) {
        return ResponseEntity.ok(productCategoryService.createCategory(request));
    }

    //Update Category
    @PatchMapping("/{id}")
    public ResponseEntity<ProductCategoryResponse> updateCategory(@PathVariable Long id, @RequestBody ProductCategoryRequest request) {
        return ResponseEntity.ok(productCategoryService.updateCategory(id, request));
    }

    // Delete Category
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        productCategoryService.deleteCategory(id);
        return ResponseEntity.ok("Product Category with an id of " + id + " is successfully removed!");
    }



}
