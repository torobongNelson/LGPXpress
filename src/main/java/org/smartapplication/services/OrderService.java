package org.smartapplication.services;

import org.smartapplication.dtos.response.Order.CancelOrderResponse;
import org.smartapplication.exceptions.OrderNotFoundException;
import org.smartapplication.model.Order;

import java.math.BigDecimal;

public interface OrderService {
    Order findBy(Long id);
    Order placeOrder(Order order);
    Order updateorder(Long orderId, Order updateOrder) throws OrderNotFoundException;
    CancelOrderResponse cancelOrder(Long orderId);
    Order makePayment(Long orderId, BigDecimal amount);
    Order trackOrder(Long orderId);
}
