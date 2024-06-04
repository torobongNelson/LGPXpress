package org.smartapplication.repositories;

import org.smartapplication.model.Order;
import org.smartapplication.model.OrderItems;
import org.smartapplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItems, Long> {
    void deleteAllByOrder(Order order);

    Optional<OrderItems> findByOrderAndProduct(Order order, Product product);

    void deleteByOrderId(Long id);
}
