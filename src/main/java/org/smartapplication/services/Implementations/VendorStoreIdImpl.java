package org.smartapplication.services.Implementations;

import org.smartapplication.exceptions.VendorNotFoundException;
import org.smartapplication.model.VendorStoreId;
import org.smartapplication.repositories.VendorRepository;
import org.smartapplication.repositories.VendorStoreIdRepository;
import org.smartapplication.services.VendorStoreIdentification;
import org.springframework.stereotype.Service;

import static org.smartapplication.Utils.StoreIdGenerator.generateStoreId;

@Service
public class VendorStoreIdImpl implements VendorStoreIdentification {

   private final VendorStoreIdRepository vendorStoreIdRepository;
   private final VendorRepository vendorRepository;

   public VendorStoreIdImpl(VendorStoreIdRepository vendorStoreIdRepository, VendorRepository vendorRepository) {
      this.vendorStoreIdRepository = vendorStoreIdRepository;
      this.vendorRepository = vendorRepository;
   }

   /**
    * Generates a store Id for a given vendor and saves it.
    * @param vendorId
    * @return the VendorStoreId object
    */
   @Override
   public VendorStoreId generateAndSaveVendorStoreId(Long vendorId) throws VendorNotFoundException {
      var vendor = vendorRepository.findById(vendorId)
                        .orElseThrow(() -> new VendorNotFoundException("vendor not found"));

      String storeId = generateStoreId();

      var vendorStoreId = new VendorStoreId();
      vendorStoreId.setStoreId(storeId);
      vendorStoreId.setVendor(vendor);

      return this.vendorStoreIdRepository.save(vendorStoreId);
   }
}
