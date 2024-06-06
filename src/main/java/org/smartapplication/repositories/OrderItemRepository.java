package org.smartapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItems, Long> {
    void deleteAllByOrder(Order order);
}
