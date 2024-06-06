package org.smartapplication.dtos.response.Order;

import lombok.Getter;
import lombok.Setter;
// import org.smartapplication.dtos.response.Product.ProductResponse;

@Getter
@Setter
public class StoreDTO {
    private Long id;
    private String storeId;
    private Long vendorId;
    private Long productId;
    // private VendorResponse vendor;
    // private ProductResponse product;
}
