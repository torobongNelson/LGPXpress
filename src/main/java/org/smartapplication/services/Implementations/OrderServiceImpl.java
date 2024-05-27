package org.smartapplication.services.Implementations;

import org.smartapplication.dtos.request.Order.CreateOrderRequest;
import org.smartapplication.dtos.response.Order.CreateOrderResponse;
import org.smartapplication.exceptions.CustomerNotFoundException;
import org.smartapplication.exceptions.ProductNotFoundException;
import org.smartapplication.model.Order;
import org.smartapplication.services.OrderServiceInterface;

public class OrderServiceImpl implements OrderServiceInterface {
    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) throws ProductNotFoundException, CustomerNotFoundException {
        return null;
    }

    @Override
    public Order findBy(Long id) {
        return null;
    }


}
