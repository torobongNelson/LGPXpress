package org.smartapplication.repositories;

import org.smartapplication.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Vendor findByRegNo(String regNo);

}
