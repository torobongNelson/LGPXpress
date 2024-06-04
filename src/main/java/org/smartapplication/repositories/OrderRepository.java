package org.smartapplication.repositories;

import org.smartapplication.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    boolean existsByCustomerIdAndDeliveryAddressAndPhoneNumberAndIsPaidFalse(Long customerId, String deliveryAddress, String phoneNumber);
}
