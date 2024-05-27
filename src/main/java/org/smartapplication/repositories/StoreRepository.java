package org.smartapplication.repositories;

import org.smartapplication.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
   Boolean existsByStoreId(String storeId);

   Optional<Store> findByStoreId(String storeId);
}
