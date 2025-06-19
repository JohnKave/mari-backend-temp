package software.mari.flow_server.model.product;

import jakarta.persistence.*;
import software.mari.flow_server.model.User;

public class Product_comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productComment_id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
