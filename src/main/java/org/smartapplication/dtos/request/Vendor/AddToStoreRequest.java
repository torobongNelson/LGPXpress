package org.smartapplication.dtos.request.Vendor;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToStoreRequest {
   private Long productId;
   private Long vendorId;
}
