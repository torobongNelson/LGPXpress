package org.smartapplication.repositories;

import org.smartapplication.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<Order, Long> {
}
