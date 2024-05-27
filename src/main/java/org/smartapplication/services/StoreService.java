package org.smartapplication.services;

import org.smartapplication.exceptions.StoreNotFoundException;
import org.smartapplication.exceptions.VendorNotFoundException;
import org.smartapplication.model.Store;

public interface StoreService {
   Store viewStore(String storeId) throws StoreNotFoundException; //for the vendor, admin and customer

   void addProductToStore(Long productId, Long vendorId) throws VendorNotFoundException; // for the vendor
   void removeProductFromStore(Long productId, Long vendorId); // for the vendor

}