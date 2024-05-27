package org.smartapplication.dtos.request.Order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CreateOrderRequest {
    private List<Long> items;
    private String deliveryAddress;
    private String phoneNumber;
    private long cartId;
}
