package org.smartapplication.dtos.response.Vendor;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class VendorProductResponse {
    private  Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer quantity;
    private Boolean isAvailable;
    private ProductCategory productCategory;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
