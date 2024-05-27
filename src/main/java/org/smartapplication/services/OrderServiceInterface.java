package org.smartapplication.services;

import org.smartapplication.dtos.request.Order.CreateOrderRequest;
import org.smartapplication.dtos.response.Order.CreateOrderResponse;
import org.smartapplication.exceptions.CustomerNotFoundException;
import org.smartapplication.exceptions.ProductNotFoundException;
import org.smartapplication.model.Order;

public interface OrderServiceInterface {

    CreateOrderResponse createOrder(CreateOrderRequest request) throws ProductNotFoundException, CustomerNotFoundException;
    Order findBy(Long id);
}
