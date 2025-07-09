package software.mari.flow_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import software.mari.flow_server.model.dto.request.ProductRequest;
import software.mari.flow_server.model.dto.response.ProductResponse;
import software.mari.flow_server.model.product.Product;
import software.mari.flow_server.model.user.User;
import software.mari.flow_server.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getProducts() {
        return "These are the products";
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @RequestBody ProductRequest request,
            @AuthenticationPrincipal User user // Injects the authenticated user entity
            ) {
        return ResponseEntity.ok(productService.createProduct(request, user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailResponse> getProductDetail(Long id) {

    }

}
