package org.smartapplication.repositories;

import org.smartapplication.model.VendorStoreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VendorStoreIdRepository extends JpaRepository<VendorStoreId, Long> {
   @Query("SELECT v.storeId FROM VendorStoreId v WHERE v.vendor.id = :vendorId")
   String findStoreIdByVendorId(@Param("vendorId") Long vendorId);
}
