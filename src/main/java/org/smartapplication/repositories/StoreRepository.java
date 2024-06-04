package org.smartapplication.repositories;

import org.smartapplication.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
//   Boolean existsByStoreId(String storeId);

   Optional<Store> findByStoreId(String storeId);

   Boolean existsStoreIdByVendorId(Long vendorId, String storeId, Long productId);

   List<Long> findProductsByVendorId(Long vendorId);

   List<Store> findDistinctByStoreId(String storeId);

   List<Store> findDistinctbyVendorId(Long vendorId);

   List<Store> findUniqueStores();

   Boolean existsByVendorIdAndStoreIdAndProductId(Long vendorId, String storeId, Long productId);
}
