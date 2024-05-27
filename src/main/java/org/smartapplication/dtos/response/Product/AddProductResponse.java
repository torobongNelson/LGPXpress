package org.smartapplication.dtos.response.Product;

import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Enums.ProductCategory;

import java.math.BigDecimal;

@Getter
@Setter
public class AddProductResponse {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer quantity;
    private ProductCategory productCategory;
    private Long vendorId;
}
