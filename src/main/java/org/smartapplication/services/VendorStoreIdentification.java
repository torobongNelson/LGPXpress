package org.smartapplication.services;

import org.smartapplication.exceptions.VendorNotFoundException;
import org.smartapplication.model.VendorStoreId;

public interface VendorStoreIdentification {

   VendorStoreId generateAndSaveVendorStoreId(Long vendorId) throws VendorNotFoundException;
}
