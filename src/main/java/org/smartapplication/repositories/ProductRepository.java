package org.smartapplication.repositories;

import org.smartapplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByVendorId(Long vendorId);

    Product findFirstByVendorId(Long vendorId);
}
