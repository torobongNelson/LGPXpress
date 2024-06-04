package org.smartapplication.dtos.request.Order;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemRequest {

    private String itemName;
    private double amountInKg;
    private long numberOfItems;
}
