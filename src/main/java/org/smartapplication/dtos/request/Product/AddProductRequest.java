package org.smartapplication.dtos.request.Product;

import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Enums.ProductCategory;

import java.math.BigDecimal;

@Getter
@Setter
public class AddProductRequest {
    private String name;
    private BigDecimal price;
    private String description;
    private Integer quantity;
    private ProductCategory productCategory;
}
