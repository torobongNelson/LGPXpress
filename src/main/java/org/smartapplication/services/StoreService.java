package org.smartapplication.services;

import org.smartapplication.dtos.response.Product.AddToStoreResponse;
import org.smartapplication.dtos.response.Product.ProductResponse;
import org.smartapplication.dtos.response.Vendor.StoreDTO;
import org.smartapplication.exceptions.ProductAlreadyAddedToStoreException;
import org.smartapplication.exceptions.ProductNotFoundException;
import org.smartapplication.exceptions.StoreNotFoundException;
import org.smartapplication.exceptions.VendorNotFoundException;
import org.smartapplication.model.Store;

import java.util.List;

public interface StoreService {
    Store viewStore(String storeId) throws StoreNotFoundException; //for the vendor, admin and customer

    public List<Store> getAllProductsByVendorId(Long vendorId);

    public List<ProductResponse> getProductsByVendorId(Long vendorId);
    public List<StoreDTO> getDistinctStoresByStoreId(String storeId);
    public List<StoreDTO> getDistinctStoresByVendorId(Long vendorId);

    public List<StoreDTO> getUniqueStores();

    public AddToStoreResponse addProductToStore(Long productId, Long vendorId) throws VendorNotFoundException, ProductNotFoundException, ProductAlreadyAddedToStoreException;
    void removeProductFromStore(Long productId, Long vendorId); // for the vendor

}
